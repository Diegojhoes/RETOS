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
import web.app.motos1.entities.Motorbike;
import web.app.motos1.entities.MotorbikeCrud;

/**
 *
 * @author HP
 */
@Repository
public class MotorbikeRepository {
    @Autowired
    private MotorbikeCrud motorbikeCrudRepository;
    
    public List<Motorbike> getAll() {return (List<Motorbike>) motorbikeCrudRepository.findAll();};
    
    public Optional<Motorbike> getMotorbike(int id) {return motorbikeCrudRepository.findById(id);};
    
    public Motorbike save(Motorbike motorbike) {return motorbikeCrudRepository.save(motorbike);};
    
    public void delete(Motorbike motorbike) {motorbikeCrudRepository.delete(motorbike);}
    }
