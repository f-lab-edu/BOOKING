package org.service.booking.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
