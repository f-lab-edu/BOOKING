package org.service.booking.adapters.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.service.booking.domain.model.Table;

@Getter
@AllArgsConstructor
@Builder
public class TableResponse {
    private Long id;
    private Long restaurantId;
    private Integer capacity;
    private Boolean isAvailable;
    private Integer tableNumber;
    
    public static TableResponse fromDomain(Table table) {
        return TableResponse.builder()
                .id(table.getId())
                .restaurantId(table.getRestaurantId())
                .capacity(table.getCapacity())
                .isAvailable(table.getIsAvailable())
                .tableNumber(table.getTableNumber())
                .build();
    }
}
