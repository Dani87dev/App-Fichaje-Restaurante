package com.fichaje.timerecord.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JpaTimeRecordRepository extends JpaRepository<TimeRecordEntity, Long> {

    // Spring genera: SELECT * FROM time_records WHERE user_id = ?
    List<TimeRecordEntity> findByUserId(Long userId);

    // Spring genera: SELECT * FROM time_records WHERE user_id = ? AND date = ?
    List<TimeRecordEntity> findByUserIdAndDate(Long userId, LocalDate date);
}