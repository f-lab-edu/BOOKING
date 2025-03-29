package org.service.booking.adapters.in.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class TableCreateRequest {
    @NotNull
    @Min(1)
    private Integer capacity;
    
    @NotNull
    private Boolean available;
    
    private Integer tableNumber;
}
