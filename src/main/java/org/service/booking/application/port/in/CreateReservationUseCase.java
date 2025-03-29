package org.service.booking.application.port.in;

import org.service.booking.domain.model.Reservation;

public interface CreateReservationUseCase {
    Reservation createReservation(CreateReservationCommand command);
}
