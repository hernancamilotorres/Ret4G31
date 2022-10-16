package com.g31.jpa.service;

import com.g31.jpa.entity.Reservation;
import com.g31.jpa.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo Torres C
 */

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservation() {
        return reservationRepository.findAll();
    }

    public Reservation insertReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    
    public Reservation getReservationById(Long id){
            return reservationRepository.findById(id).get();
    }
    public void deleteReservation(Long id){
       reservationRepository.deleteById(id);               
    }
    
    public Reservation updateReservation(Reservation reservation){
        if (reservation.getIdReservation()!=null){

            Optional<Reservation> opcional = reservationRepository.findById(reservation.getIdReservation());
            
            if (!opcional.isEmpty()){
                //logica
                Reservation reservationBD = opcional.get();
                reservationBD.setClient(reservation.getClient());
                reservationBD.setGame(reservation.getGame());
                reservationBD.setStartDate(reservation.getStartDate());
                reservationBD.setDevolutionDate(reservation.getDevolutionDate());
                reservationBD.setStatus(reservation.getStatus());
                
                return reservationRepository.save(reservationBD);
            }else{
                return reservation;
            }
        }
        return reservation;
    }
}
