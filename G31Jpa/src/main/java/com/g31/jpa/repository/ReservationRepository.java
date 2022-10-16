package com.g31.jpa.repository;

import com.g31.jpa.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Camilo Torres C
 */

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
}
