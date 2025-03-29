package org.service.booking.application.service;

import org.service.booking.application.exception.BusinessException;
import org.service.booking.application.exception.ResourceNotFoundException;
import org.service.booking.application.port.in.CreateReservationCommand;
import org.service.booking.application.port.in.CreateReservationUseCase;
import org.service.booking.domain.model.Reservation;
import org.service.booking.domain.model.Table;
import org.service.booking.domain.repository.ReservationRepositoryPort;
import org.service.booking.domain.repository.RestaurantRepositoryPort;
import org.service.booking.domain.repository.TableRepositoryPort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ReservationService implements CreateReservationUseCase {
    private final TableRepositoryPort tableRepositoryPort;
    private final ReservationRepositoryPort reservationRepositoryPort;

    public ReservationService(
            TableRepositoryPort tableRepositoryPort,
            ReservationRepositoryPort reservationRepositoryPort
    ) {
        this.tableRepositoryPort = tableRepositoryPort;
        this.reservationRepositoryPort = reservationRepositoryPort;
    }

    @Override
    public Reservation createReservation(CreateReservationCommand command) {
        var table = tableRepositoryPort.findById(command.getTableId())
                .orElseThrow(() -> new ResourceNotFoundException("Table not found with id: " + command.getTableId()));

        validateTableAvailability(table, command.getStartTime(), command.getEndTime());

        Reservation reservation = new Reservation(
                null,
                LocalDateTime.now(),
                command.getCustomerName(),
                command.getCustomerPhone(),
                command.getTableId(), 
                command.getStartTime(), 
                command.getEndTime(), 
                "CREATED"
        );
        
        return reservationRepositoryPort.save(reservation);
    }
    
    private void validateTableAvailability(Table table, LocalDateTime startTime, LocalDateTime endTime) {
        if (!table.getIsAvailable()) {
            throw new BusinessException("Table is not available");
        }

        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new BusinessException("Start time must be before end time");
        }

        if (startTime.isBefore(LocalDateTime.now())) {
            throw new BusinessException("Reservation cannot be made for past times");
        }
    }
}
