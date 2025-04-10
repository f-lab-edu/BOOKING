package org.service.booking.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.booking.domain.model.Table;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@jakarta.persistence.Table(name = "restaurant_tables")
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer tableNumber;
    private Integer capacity;
    
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SlotEntity> slots;
    
    public Table toDomain() {
        return new Table(
            id,
            restaurant != null ? restaurant.getId() : null,
            tableNumber,
            capacity,
            true
        );
    }
    
    public static TableEntity fromDomain(Table table) {
        TableEntity entity = new TableEntity();
        entity.setTableNumber(table.getTableNumber());
        entity.setCapacity(table.getCapacity());
        return entity;
    }
}