package com.brodygaudel.hotelservice.entities;

import com.brodygaudel.hotelservice.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a reservation entity.
 * This class models a reservation, containing information such as its unique identifier,
 * title, price, and status. It is used as an entity to map data from the database and is
 * part of the persistence layer in the application.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    /**
     * The unique identifier of the reservation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title or name associated with the reservation.
     */
    private String title;

    /**
     * The price or cost of the reservation.
     */
    private double price;

    /**
     * The status of the reservation, indicating its current state (e.g., confirmed, canceled, etc.).
     */
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}

