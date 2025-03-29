package org.service.booking.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.service.booking.adapters.in.web.dto.TableCreateRequest;
import org.service.booking.adapters.in.web.dto.TableResponse;
import org.service.booking.application.port.in.CreateTableCommand;
import org.service.booking.application.port.in.CreateTableUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/tables")
@RequiredArgsConstructor
public class TableController {
    private final CreateTableUseCase createTableUseCase;

    @PostMapping
    public ResponseEntity<TableResponse> createTable(
            @PathVariable Long restaurantId, 
            @RequestBody TableCreateRequest request
    ) {
        CreateTableCommand command = CreateTableCommand.builder()
                .restaurantId(restaurantId)
                .capacity(request.getCapacity())
                .isAvailable(request.getAvailable())
                .tableNumber(request.getTableNumber())
                .build();

        var createdTable = createTableUseCase.createTable(command);

        return ResponseEntity.ok(TableResponse.fromDomain(createdTable));
    }
}
