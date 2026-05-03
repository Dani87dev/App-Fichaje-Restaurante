package com.fichaje.timerecord.infrastructure.persistence;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "time_records")
public class TimeRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDateTime clockIn;

    // Pot ser null perquè quan fitxes entrada, encara no has fitxat sortida
    private LocalDateTime clockOut;

    @Column(nullable = false)
    private LocalDate date;

    public TimeRecordEntity() {}

    public TimeRecordEntity(Long id, Long userId, LocalDateTime clockIn,
                            LocalDateTime clockOut, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.date = date;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public LocalDateTime getClockIn() { return clockIn; }
    public LocalDateTime getClockOut() { return clockOut; }
    public LocalDate getDate() { return date; }
}