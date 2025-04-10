package org.service.booking.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.booking.domain.model.Slot;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@jakarta.persistence.Table(name = "slots")
public class SlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private TableEntity table;
    
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @Enumerated(EnumType.STRING)
    private Slot.SlotStatus status;

    public Slot toDomain() {
        return new Slot(
                id,
                table.getId(),
                startTime,
                status
        );
    }

    public SlotEntity fromDomain(Slot slot) {
        SlotEntity entity = new SlotEntity();
        entity.setId(slot.getId());
        entity.setStartTime(slot.getStartTime());
        entity.setStatus(slot.getStatus());
        return entity;
    }
}
