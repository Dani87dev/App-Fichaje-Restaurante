package com.fichaje.timerecord.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeRecord {

    private Long id;
    private Long userId;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;
    private LocalDate date;


    // Para fichar entrada (clockOut todavía no existe)
    public TimeRecord(Long id, Long userId, LocalDateTime clockIn, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.clockIn = clockIn;
        this.clockOut = null;
        this.date = date;
    }

    // Para recuperar de BBDD (ya tiene clockOut)
    public TimeRecord(Long id, Long userId, LocalDateTime clockIn, LocalDateTime clockOut, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getClockIn() {
        return clockIn;
    }

    public LocalDateTime getClockOut() {
        return clockOut;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setClockOut(LocalDateTime clockOut) {
        if (clockOut != null && clockOut.isBefore(clockIn)) {
            throw new IllegalArgumentException("Clock-out cannot be before clock-in.");
        }
        this.clockOut = clockOut;
    }

}
