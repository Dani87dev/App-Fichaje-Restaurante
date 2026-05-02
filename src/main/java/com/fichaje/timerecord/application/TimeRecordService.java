package com.fichaje.timerecord.application;

import com.fichaje.timerecord.domain.model.TimeRecord;
import com.fichaje.timerecord.domain.port.TimeRecordRepository;
import com.fichaje.user.domain.port.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TimeRecordService {

    private final TimeRecordRepository timeRecordRepo;
    private final UserRepository userRepo;

    public TimeRecordService(TimeRecordRepository timeRecordRepo, UserRepository userRepo) {
        this.timeRecordRepo = timeRecordRepo;
        this.userRepo = userRepo;
    }

    public TimeRecord clockIn(Long userId) {
        userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        LocalDateTime now = LocalDateTime.now();
        TimeRecord record = new TimeRecord(null, userId, now, LocalDate.now());
        return timeRecordRepo.save(record);
    }

    public TimeRecord clockOut(Long recordId) {
        TimeRecord record = timeRecordRepo.findById(recordId)
                .orElseThrow(() -> new RuntimeException("TimeRecord not found with id: " + recordId));

        record.setClockOut(LocalDateTime.now());
        return timeRecordRepo.save(record);
    }

    public List<TimeRecord> getByUserId(Long userId) {
        return timeRecordRepo.findByUserId(userId);
    }

    public List<TimeRecord> getByUserIdAndDate(Long userId, LocalDate date) {
        return timeRecordRepo.findByUserIdAndDate(userId, date);
    }

    public List<TimeRecord> getAll() {
        return timeRecordRepo.findAll();
    }
}