package org.service.booking.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.service.booking.adapters.in.web.dto.ReservationCreateRequest;
import org.service.booking.adapters.in.web.dto.ReservationResponse;
import org.service.booking.application.port.in.CreateReservationCommand;
import org.service.booking.application.port.in.CreateReservationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/tables/{tableId}/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final CreateReservationUseCase createReservationUseCase;

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(
            @PathVariable Long restaurantId,
            @PathVariable Long tableId,
            @RequestBody ReservationCreateRequest request
    ) {
        CreateReservationCommand command = CreateReservationCommand.builder()
                .restaurantId(restaurantId)
                .tableId(tableId)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .customerName(request.getCustomerName())
                .customerPhone(request.getCustomerPhone())
                .build();

        var createdReservation = createReservationUseCase.createReservation(command);

        return ResponseEntity.ok(ReservationResponse.fromDomain(createdReservation));
    }
}
