package com.brodygaudel.hotelservice.mapping;

import com.brodygaudel.hotelservice.dto.ReservationDTO;
import com.brodygaudel.hotelservice.entities.Reservation;

import java.util.List;

/**
 * This interface provides mapping methods to convert between Reservation and ReservationDTO objects.
 */
public interface Mappers {

    /**
     * Converts a ReservationDTO object to a Reservation object.
     *
     * @param reservationDTO The ReservationDTO to be converted.
     * @return The corresponding Reservation object.
     */
    Reservation fromReservationDTO(ReservationDTO reservationDTO);

    /**
     * Converts a Reservation object to a ReservationDTO object.
     *
     * @param reservation The Reservation to be converted.
     * @return The corresponding ReservationDTO object.
     */
    ReservationDTO fromReservation(Reservation reservation);

    /**
     * Converts a list of Reservation objects to a list of ReservationDTO objects.
     *
     * @param reservations The list of Reservation objects to be converted.
     * @return The corresponding list of ReservationDTO objects.
     */
    List<ReservationDTO> fromListOfReservations(List<Reservation> reservations);
}

