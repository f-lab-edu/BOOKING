package org.service.booking.adapters.out.persistence;

import lombok.RequiredArgsConstructor;
import org.service.booking.domain.model.Table;
import org.service.booking.domain.repository.TableRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TableRepositoryAdapter implements TableRepositoryPort {

    private final JpaTableRepository jpaTableRepository;
    
    @Override
    public Table save(Table table) {
        TableEntity entity = TableEntity.fromDomain(table);
        TableEntity saved = jpaTableRepository.save(entity);
        return saved.toDomain();
    }

    @Override
    public Optional<Table> findById(Long id) {
        return jpaTableRepository.findById(id)
                .map(TableEntity::toDomain);
    }
}