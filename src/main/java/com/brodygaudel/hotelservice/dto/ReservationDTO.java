package com.brodygaudel.hotelservice.dto;

import com.brodygaudel.hotelservice.enums.ReservationStatus;

/**
 * A data transfer object (DTO) representing a reservation.
 * This record encapsulates the information related to a reservation, including its unique identifier,
 * title, price, and status. It is used for transferring reservation data between different layers of
 * the application and does not contain any business logic.
 *
 * @param id     The unique identifier of the reservation.
 * @param title  The title or name associated with the reservation.
 * @param price  The price or cost of the reservation.
 * @param status The status of the reservation, indicating its current state (e.g., confirmed, canceled, etc.).
 */
public record ReservationDTO(Long id, String title, double price, ReservationStatus status) { }

