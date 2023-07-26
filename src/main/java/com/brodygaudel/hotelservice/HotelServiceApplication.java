package com.brodygaudel.hotelservice;

import com.brodygaudel.hotelservice.entities.Reservation;
import com.brodygaudel.hotelservice.enums.ReservationStatus;
import com.brodygaudel.hotelservice.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ReservationRepository repository){
        return args -> {
            repository.save(Reservation.builder()
                            .status(ReservationStatus.CREATED)
                            .price(1500.99)
                            .title("RESERVATION I ").build()
            );

            repository.save(Reservation.builder()
                    .status(ReservationStatus.CONFORMED)
                    .price(3000.99)
                    .title("RESERVATION II ").build()
            );

            repository.save(Reservation.builder()
                    .status(ReservationStatus.PENDING)
                    .price(4500.99)
                    .title("RESERVATION III").build()
            );

            repository.save(Reservation.builder()
                    .status(ReservationStatus.CANCELED)
                    .price(750.99)
                    .title("RESERVATION IV").build()
            );
        };
    }

}
