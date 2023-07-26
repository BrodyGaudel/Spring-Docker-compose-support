package com.brodygaudel.hotelservice.repositories;

import com.brodygaudel.hotelservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository to manage Reservation entities.
 * The ReservationRepository interface provides the necessary methods to interact with
 * the database and perform CRUD (Create, Read, Update, Delete) operations on Reservation entities.
 * It serves as a data access layer, allowing the application to interact with the underlying database
 * and perform various operations related to reservations.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

