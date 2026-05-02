package com.fichaje.timerecord.domain.port;

import com.fichaje.timerecord.domain.model.TimeRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimeRecordRepository {

    TimeRecord save(TimeRecord timeRecord);
    Optional<TimeRecord> findById(Long id);
    List<TimeRecord> findByUserId(Long userId);
    List<TimeRecord> findByUserIdAndDate(long userID, LocalDate date);
    List<TimeRecord> findAll();
}
