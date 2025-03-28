package org.service.booking.adapters.out.persistence;

import lombok.RequiredArgsConstructor;
import org.service.booking.domain.model.Reservation;
import org.service.booking.domain.repository.ReservationRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryAdapter implements ReservationRepositoryPort {

    private final JpaReservationRepository jpaReservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        ReservationEntity entity = ReservationEntity.fromDomain(reservation);
        ReservationEntity saved = jpaReservationRepository.save(entity);
        return saved.toDomain();
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return jpaReservationRepository.findById(id)
                .map(ReservationEntity::toDomain);
    }
}