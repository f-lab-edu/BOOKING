package org.service.booking.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSlotRepository extends JpaRepository<SlotEntity, Long> {
}
