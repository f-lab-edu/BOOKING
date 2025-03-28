package org.service.booking.domain.repository;

import org.service.booking.domain.model.Reservation;
import java.util.Optional;

public interface ReservationRepositoryPort {
    Reservation save(Reservation reservation);
    Optional<Reservation> findById(Long id);
}