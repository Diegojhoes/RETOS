/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.motos1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import web.app.motos1.dao.ReservationRepository;
import web.app.motos1.entities.Reservation;
import web.app.motos1.entities.ReservationCrud;



/**
 *
 * @author HP
 */
@Service
@SpringBootApplication(scanBasePackages = "web.app.motos1.dao")
public class ReservationService {
    @Autowired
    private ReservationRepository reservationCrudRepository;
    
    public List<Reservation> getAll() {return (List<Reservation>) reservationCrudRepository.getAll();};
    
    public Optional<Reservation> getReservation(int id) {return reservationCrudRepository.getReservation(id);};
    
    public Reservation save(Reservation reservation) {
        if(reservation.getIdReservation()==null){
            return reservationCrudRepository.save(reservation);
            
        }else{
            Optional<Reservation> co = reservationCrudRepository.getReservation(reservation.getIdReservation());
            if(co.isEmpty()){
                return reservationCrudRepository.save(reservation);
            }else{
                return reservation;
            }
    }
  }
    
    public Reservation update (Reservation reservation){
        if(reservation.getIdReservation() != null){
            Optional<Reservation> e = reservationCrudRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){
                if (reservation.getStartDate()!= null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!= null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getStatus()!= null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationCrudRepository.save(e.get());
                return e.get();
            }
            else{
                return reservation;
            }
        }
        else{
            return reservation;
        }
    }
    
    public boolean deleteReservation (int id){
        
        /*Optional<Admin> admin=adminRepository.getAdmin(id);
        if(admin.isEmpty()){
            return false;
        }else{
            adminRepository.delete(admin.get());
            return true;
        }*/
        Boolean aBoolean = getReservation(id).map(
            reservation->{
                reservationCrudRepository.delete(reservation);
                return true;
            }).orElse(false);
        return aBoolean;
    }
}
    
