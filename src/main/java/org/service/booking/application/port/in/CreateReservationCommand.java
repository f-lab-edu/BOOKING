package org.service.booking.application.port.in;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CreateReservationCommand {
    Long restaurantId;
    Long tableId;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String customerName;
    String customerPhone;
}
