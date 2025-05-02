package org.service.booking.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.booking.domain.model.Reservation;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime reservationTime;
    private String customerName;
    private String customerPhone;
    
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    @Enumerated(EnumType.STRING)
    private Reservation.ReservationStatus status;

    private Long restaurantId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private TableEntity table;
    
    public Reservation toDomain() {
        return new Reservation(
            this.id,
            this.reservationTime,
            this.customerName,
            this.customerPhone,
            this.restaurantId,
            this.table != null ? this.table.getId() : null,
            this.startTime,
            this.endTime,
            this.status
        );
    }
    
    public static ReservationEntity fromDomain(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setId(reservation.getId());
        entity.setReservationTime(reservation.getReservationTime());
        entity.setCustomerName(reservation.getCustomerName());
        entity.setCustomerPhone(reservation.getCustomerPhone());
        entity.setRestaurantId(reservation.getRestaurantId());
        
        if (reservation.getTableId() != null) {
            TableEntity tableEntity = new TableEntity();
            tableEntity.setId(reservation.getTableId());
            entity.setTable(tableEntity);
        }
        
        entity.setStartTime(reservation.getStartTime());
        entity.setEndTime(reservation.getEndTime());
        entity.setStatus(reservation.getStatus());
        
        return entity;
    }
}