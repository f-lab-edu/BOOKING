package org.service.booking.adapters.in.web;

import org.service.booking.domain.model.Restaurant;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RestaurantRegistrationRequest {
    private String name;
    private String address;
    private String phone;
    private LocalTime openTime;
    private LocalTime closeTime;

    public Restaurant toDomain() {
        return new Restaurant(
                null,
                name,
                address,
                phone,
                openTime,
                closeTime,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
