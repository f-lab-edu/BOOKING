package org.service.booking.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Slot {
    private Long id;
    private Long tableId;
    private LocalDateTime startTime;
    private SlotStatus status;

    public enum SlotStatus {
        AVAILABLE,
        RESERVED,
        CANCELLED,
        COMPLETED,
    }
}
