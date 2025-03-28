package org.service.booking.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Long id;
    private LocalDateTime reservationTime;
    private String customerName;
    private String customerPhone;
    
    private Long tableId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    
    public Reservation(Long id, Long tableId, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.id = id;
        this.tableId = tableId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }
}