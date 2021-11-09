/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.motos1.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.app.motos1.entities.Reservation;
import web.app.motos1.entities.ReservationCrud;


/**
 *
 * @author HP
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrud reservationCrudRepository;
    
    public List<Reservation> getAll() {return (List<Reservation>) reservationCrudRepository.findAll();};
    
    public Optional<Reservation> getReservation(int id) {return reservationCrudRepository.findById(id);};
    
    public Reservation save(Reservation reservation) {return reservationCrudRepository.save(reservation);};
    
    public void delete(Reservation reservation) {reservationCrudRepository.delete(reservation);}
    }