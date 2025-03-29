package org.service.booking.application.port.in;

import org.service.booking.domain.model.Table;

public interface CreateTableUseCase {
    Table createTable(CreateTableCommand command);
}
