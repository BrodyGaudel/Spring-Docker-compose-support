package com.brodygaudel.hotelservice.services;

import com.brodygaudel.hotelservice.dto.ReservationDTO;
import com.brodygaudel.hotelservice.exceptions.ReservationNotFoundException;

import java.util.List;

/**
 * This interface defines the available operations for managing reservations.
 */
public interface ReservationService {

    /**
     * Retrieve all existing reservations.
     *
     * @return A list of ReservationDTO representing all available reservations.
     */
    List<ReservationDTO> findAll();

    /**
     * Retrieve a reservation by its identifier.
     *
     * @param id The identifier of the reservation to retrieve.
     * @return The ReservationDTO corresponding to the specified identifier, or null if it doesn't exist.
     * @throws ReservationNotFoundException raises this exception fi Reservation not found
     */
    ReservationDTO findById(Long id) throws ReservationNotFoundException;

    /**
     * Save a new reservation.
     *
     * @param reservationDTO The ReservationDTO representing the new reservation to be saved.
     * @return The saved ReservationDTO with updated information, including the generated identifier.
     */
    ReservationDTO save(ReservationDTO reservationDTO);

    /**
     * Update an existing reservation.
     *
     * @param id             The identifier of the reservation to update.
     * @param reservationDTO The ReservationDTO containing the new reservation information.
     * @return The updated ReservationDTO.
     * @throws ReservationNotFoundException raises this exception fi Reservation not found
     */
    ReservationDTO update(Long id, ReservationDTO reservationDTO) throws ReservationNotFoundException;

    /**
     * Delete a reservation by its identifier.
     *
     * @param id The identifier of the reservation to delete.
     */
    void deleteById(Long id);

    /**
     * Delete all existing reservations.
     */
    void deleteAll();
}

