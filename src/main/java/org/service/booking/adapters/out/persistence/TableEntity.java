package org.service.booking.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.booking.domain.model.Table;
// import java.util.Set;

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
    private Boolean isAvailable;
    
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    // @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<SlotEntity> slots; // Comment out related field
    
    public Table toDomain() {
        return new Table(
            this.id,
            this.restaurant != null ? this.restaurant.getId() : null,
            this.tableNumber,
            this.capacity,
            this.isAvailable
        );
    }
    
    public static TableEntity fromDomain(Table table) {
        TableEntity entity = new TableEntity();
        entity.setId(table.getId());
        entity.setTableNumber(table.getTableNumber());
        entity.setCapacity(table.getCapacity());
        entity.setIsAvailable(table.getIsAvailable());
        
        if (table.getRestaurantId() != null) {
            RestaurantEntity restaurantEntity = new RestaurantEntity();
            restaurantEntity.setId(table.getRestaurantId());
            entity.setRestaurant(restaurantEntity);
        }
        
        return entity;
    }
}