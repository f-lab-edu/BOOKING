package org.service.booking.application.port.in;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateTableCommand {
    Long restaurantId;
    Integer capacity;
    Boolean isAvailable;
    Integer tableNumber;
}
