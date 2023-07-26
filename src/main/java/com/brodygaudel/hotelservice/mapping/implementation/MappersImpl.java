package com.brodygaudel.hotelservice.mapping.implementation;

import com.brodygaudel.hotelservice.dto.ReservationDTO;
import com.brodygaudel.hotelservice.entities.Reservation;
import com.brodygaudel.hotelservice.mapping.Mappers;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappersImpl implements Mappers {

    /**
     * Converts a ReservationDTO object to a Reservation object.
     *
     * @param reservationDTO The ReservationDTO to be converted.
     * @return The corresponding Reservation object.
     */
    @Override
    public Reservation fromReservationDTO(@NotNull ReservationDTO reservationDTO) {
        return Reservation.builder()
                .id(reservationDTO.id())
                .title(reservationDTO.title())
                .price(reservationDTO.price())
                .status(reservationDTO.status())
                .build();
    }

    /**
     * Converts a Reservation object to a ReservationDTO object.
     *
     * @param reservation The Reservation to be converted.
     * @return The corresponding ReservationDTO object.
     */
    @Override
    public ReservationDTO fromReservation(@NotNull Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                reservation.getTitle(),
                reservation.getPrice(),
                reservation.getStatus()
        );
    }

    /**
     * Converts a list of Reservation objects to a list of ReservationDTO objects.
     *
     * @param reservations The list of Reservation objects to be converted.
     * @return The corresponding list of ReservationDTO objects.
     */
    @Override
    public List<ReservationDTO> fromListOfReservations(@NotNull List<Reservation> reservations) {
        return reservations.stream().map(this::fromReservation).toList();
    }
}
