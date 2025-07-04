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

    private Long restaurantId;
    private Long tableId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ReservationStatus status;

    public enum ReservationStatus {
        BOOKED,
        CANCELLED,
        RESERVED,
        COMPLETED,
    }
}