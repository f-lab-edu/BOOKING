package org.service.booking.domain.repository;

import org.service.booking.domain.model.Table;
import java.util.Optional;

public interface TableRepositoryPort {
    Table save(Table table);
    Optional<Table> findById(Long id);
}