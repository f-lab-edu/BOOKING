package org.service.booking.application.service;

import org.service.booking.domain.model.Reservation;
import org.service.booking.domain.model.Restaurant;
import org.service.booking.domain.model.Table;
import org.service.booking.domain.repository.ReservationRepositoryPort;
import org.service.booking.domain.repository.RestaurantRepositoryPort;
import org.service.booking.domain.repository.TableRepositoryPort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ReservationService {
    private final RestaurantRepositoryPort restaurantRepositoryPort;
    private final TableRepositoryPort tableRepositoryPort;
    private final ReservationRepositoryPort reservationRepositoryPort;

    public ReservationService(
            RestaurantRepositoryPort restaurantRepositoryPort,
            TableRepositoryPort tableRepositoryPort,
            ReservationRepositoryPort reservationRepositoryPort
    ) {
        this.restaurantRepositoryPort = restaurantRepositoryPort;
        this.tableRepositoryPort = tableRepositoryPort;
        this.reservationRepositoryPort = reservationRepositoryPort;
    }

    public Reservation createReservation(Long restaurantId, Long tableId, LocalDateTime startTime, LocalDateTime endTime) {
        Reservation reservation = new Reservation(null, tableId, startTime, endTime, "CREATED");
        return reservationRepositoryPort.save(reservation);
    }
}