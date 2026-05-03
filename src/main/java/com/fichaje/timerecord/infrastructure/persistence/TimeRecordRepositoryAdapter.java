package com.fichaje.timerecord.infrastructure.persistence;

import com.fichaje.timerecord.domain.model.TimeRecord;
import com.fichaje.timerecord.domain.port.TimeRecordRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TimeRecordRepositoryAdapter implements TimeRecordRepository {

    private final JpaTimeRecordRepository jpaRepo;

    public TimeRecordRepositoryAdapter(JpaTimeRecordRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public TimeRecord save(TimeRecord record) {
        TimeRecordEntity entity = toEntity(record);
        TimeRecordEntity saved = jpaRepo.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<TimeRecord> findById(Long id) {
        return jpaRepo.findById(id).map(this::toDomain);
    }

    @Override
    public List<TimeRecord> findByUserId(Long userId) {
        return jpaRepo.findByUserId(userId).stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public List<TimeRecord> findByUserIdAndDate(long userId, LocalDate date) {
        return jpaRepo.findByUserIdAndDate(userId, date).stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public List<TimeRecord> findAll() {
        return jpaRepo.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    // --- Conversió ---

    private TimeRecordEntity toEntity(TimeRecord record) {
        return new TimeRecordEntity(
                record.getId(),
                record.getUserId(),
                record.getClockIn(),
                record.getClockOut(),
                record.getDate()
        );
    }

    private TimeRecord toDomain(TimeRecordEntity entity) {
        return new TimeRecord(
                entity.getId(),
                entity.getUserId(),
                entity.getClockIn(),
                entity.getClockOut(),
                entity.getDate()
        );
    }
}