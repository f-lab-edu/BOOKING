package org.service.booking.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.booking.domain.model.Restaurant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private LocalTime openTime;

    private LocalTime closeTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TableEntity> tables = new ArrayList<>();

    public static RestaurantEntity fromDomain(Restaurant domain) {
        RestaurantEntity entity = new RestaurantEntity();
        entity.setName(domain.getName());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setOpenTime(domain.getOpenTime());
        entity.setCloseTime(domain.getCloseTime());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());
        return entity;
    }

    public Restaurant toDomain() {
        return new Restaurant(
                this.id,
                this.name,
                this.address,
                this.phone,
                this.openTime,
                this.closeTime,
                this.createdAt,
                this.updatedAt
        );
    }
}