package org.service.booking.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    private Long id;
    private Long restaurantId;
    private Integer tableNumber;
    private Integer capacity;
    private Boolean isAvailable;
}
