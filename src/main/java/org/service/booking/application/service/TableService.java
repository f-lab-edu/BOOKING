package org.service.booking.application.service;

import org.service.booking.application.port.in.CreateTableCommand;
import org.service.booking.application.port.in.CreateTableUseCase;
import org.service.booking.domain.model.Table;
import org.service.booking.domain.repository.TableRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class TableService implements CreateTableUseCase {
    private final TableRepositoryPort tableRepositoryPort;

    public TableService(TableRepositoryPort tableRepositoryPort) {
        this.tableRepositoryPort = tableRepositoryPort;
    }

    @Override
    public Table createTable(CreateTableCommand command) {
        Table table = new Table(
                null, 
                command.getRestaurantId(), 
                command.getTableNumber(), 
                command.getCapacity(), 
                command.getIsAvailable()
        );
        
        return tableRepositoryPort.save(table);
    }
}
