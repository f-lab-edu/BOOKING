package org.service.booking.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
public class Restaurant {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private LocalTime openTime;
    private LocalTime closeTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}