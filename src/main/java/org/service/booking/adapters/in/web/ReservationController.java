package org.service.booking.adapters.in.web;

import lombok.Getter;
import org.service.booking.application.service.ReservationService;
import org.service.booking.domain.model.Reservation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RequestMapping("/api/restaurants/{restaurantId}/tables/{tableId}/reservations")
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation createReservation(
            @PathVariable Long restaurantId,
            @PathVariable Long tableId,
            @RequestBody ReservationCreateRequest request
    ) {
        return reservationService.createReservation(restaurantId, tableId, request.getStartTime(), request.getEndTime());
    }
}

@Getter
class ReservationCreateRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;
}