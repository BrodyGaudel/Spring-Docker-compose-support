package com.brodygaudel.hotelservice.web;

import com.brodygaudel.hotelservice.dto.ReservationDTO;
import com.brodygaudel.hotelservice.exceptions.ReservationNotFoundException;
import com.brodygaudel.hotelservice.services.ReservationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing reservations.
 * This class serves as the REST controller to handle various HTTP requests related to managing reservations.
 * It provides endpoints for performing CRUD (Create, Read, Update, Delete) operations on reservations,
 * allowing clients to interact with the reservation service through HTTP requests.
 */
@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    private final ReservationService service;

    /**
     * Constructs a new ReservationRestController with the specified ReservationService.
     *
     * @param service The ReservationService used to manage reservations.
     */
    public ReservationRestController(ReservationService service) {
        this.service = service;
    }

    /**
     * Retrieves a list of all reservations.
     *
     * @return A list of ReservationDTO representing all available reservations.
     */
    @GetMapping("/list")
    public List<ReservationDTO> findAll(){
        return service.findAll();
    }

    /**
     * Retrieves a reservation by its identifier.
     *
     * @param id The identifier of the reservation to retrieve.
     * @return The ReservationDTO corresponding to the specified identifier.
     * @throws ReservationNotFoundException If the reservation with the given identifier is not found.
     */
    @GetMapping("/get/{id}")
    public ReservationDTO findById(@PathVariable Long id) throws ReservationNotFoundException{
        return service.findById(id);
    }

    /**
     * Saves a new reservation.
     *
     * @param reservationDTO The ReservationDTO representing the new reservation to be saved.
     * @return The saved ReservationDTO with updated information, including the generated identifier.
     */
    @PostMapping("/save")
    public ReservationDTO save(@RequestBody ReservationDTO reservationDTO){
        return service.save(reservationDTO);
    }

    /**
     * Updates an existing reservation.
     *
     * @param id             The identifier of the reservation to update.
     * @param reservationDTO The ReservationDTO containing the new reservation information.
     * @return The updated ReservationDTO.
     * @throws ReservationNotFoundException If the reservation with the given identifier is not found.
     */
    @PutMapping("/update/{id}")
    public ReservationDTO update(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) throws ReservationNotFoundException{
        return service.update(id, reservationDTO);
    }

    /**
     * Deletes a reservation by its identifier.
     *
     * @param id The identifier of the reservation to delete.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    /**
     * Deletes all existing reservations.
     */
    @DeleteMapping("/clear")
    public void deleteAll(){
        service.deleteAll();
    }

    /**
     * Exception handler for handling exceptions thrown by this controller.
     *
     * @param exception The Exception to be handled.
     * @return A ResponseEntity with an error message and HTTP status code indicating an internal server error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(@NotNull Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
