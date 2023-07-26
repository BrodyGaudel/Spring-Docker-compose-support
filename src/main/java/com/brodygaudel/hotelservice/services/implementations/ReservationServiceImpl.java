package com.brodygaudel.hotelservice.services.implementations;

import com.brodygaudel.hotelservice.dto.ReservationDTO;
import com.brodygaudel.hotelservice.entities.Reservation;
import com.brodygaudel.hotelservice.exceptions.ReservationNotFoundException;
import com.brodygaudel.hotelservice.mapping.Mappers;
import com.brodygaudel.hotelservice.repositories.ReservationRepository;
import com.brodygaudel.hotelservice.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class implements reservation service interface
 */
@Service
@Slf4j
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final Mappers mappers;

    public ReservationServiceImpl(ReservationRepository repository, Mappers mappers) {
        this.repository = repository;
        this.mappers = mappers;
    }

    /**
     * Retrieve all existing reservations.
     *
     * @return A list of ReservationDTO representing all available reservations.
     */
    @Override
    public List<ReservationDTO> findAll() {
        log.info("In method findAll()");
        List<Reservation> reservations = repository.findAll();
        log.info("all reservations returned");
        return mappers.fromListOfReservations(reservations);
    }

    /**
     * Retrieve a reservation by its identifier.
     *
     * @param id The identifier of the reservation to retrieve.
     * @return The ReservationDTO corresponding to the specified identifier, or null if it doesn't exist.
     * @throws ReservationNotFoundException raises this exception fi Reservation not found
     */
    @Override
    public ReservationDTO findById(Long id) throws ReservationNotFoundException {
        log.info("In method findById()");
        Reservation reservation = repository.findById(id)
                .orElseThrow( () -> new ReservationNotFoundException("reservation not found"));
        log.info("reservation found");
        return mappers.fromReservation(reservation);
    }

    /**
     * Save a new reservation.
     *
     * @param reservationDTO The ReservationDTO representing the new reservation to be saved.
     * @return The saved ReservationDTO with updated information, including the generated identifier.
     */
    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) {
        log.info("In method save()");
        Reservation reservation = mappers.fromReservationDTO(reservationDTO);
        Reservation savedReservation = repository.save(reservation);
        log.info("reservation saved");
        return mappers.fromReservation(savedReservation);
    }

    /**
     * Update an existing reservation.
     *
     * @param id             The identifier of the reservation to update.
     * @param reservationDTO The ReservationDTO containing the new reservation information.
     * @return The updated ReservationDTO.
     * @throws ReservationNotFoundException raises this exception fi Reservation not found
     */
    @Override
    public ReservationDTO update(Long id, ReservationDTO reservationDTO) throws ReservationNotFoundException {
        log.info("In method update()");
        Reservation reservation = repository.findById(id)
                .orElseThrow( () -> new ReservationNotFoundException("reservation not found"));
        Reservation reservationToUpdate = mappers.fromReservationDTO(reservationDTO);
        reservationToUpdate.setId(reservation.getId());
        Reservation updatedReservation = repository.save(reservationToUpdate);
        log.info("reservation updated");
        return mappers.fromReservation(updatedReservation);
    }

    /**
     * Delete a reservation by its identifier.
     *
     * @param id The identifier of the reservation to delete.
     */
    @Override
    public void deleteById(Long id) {
        log.info("In method deleteById()");
        repository.deleteById(id);
        log.info("reservation deleted");
    }

    /**
     * Delete all existing reservations.
     */
    @Override
    public void deleteAll() {
        log.info("In method deleteAll()");
        repository.deleteAll();
        log.info("all reservation deleted");
    }
}
