package org.service.booking.adapters.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.service.booking.domain.model.Reservation;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ReservationResponse {
    private Long id;
    private Long tableId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Reservation.ReservationStatus status;
    
    public static ReservationResponse fromDomain(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .tableId(reservation.getTableId())
                .startTime(reservation.getStartTime())
                .endTime(reservation.getEndTime())
                .status(reservation.getStatus())
                .build();
    }
}
