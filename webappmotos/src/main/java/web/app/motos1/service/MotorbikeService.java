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
import web.app.motos1.dao.MotorbikeRepository;
import web.app.motos1.entities.Motorbike;
import web.app.motos1.entities.MotorbikeCrud;

/**
 *
 * @author HP
 */
@Service
@SpringBootApplication(scanBasePackages = "web.app.motos1.dao")
public class MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    
    public List<Motorbike> getAll() {return (List<Motorbike>) motorbikeRepository.getAll();};
    
    public Optional<Motorbike> getMotorbike(int id) {return motorbikeRepository.getMotorbike(id);};
    
    public Motorbike save(Motorbike motorbike) {
        if(motorbike.getId()==null){
            return motorbikeRepository.save(motorbike);
            
        }else{
            Optional<Motorbike> co = motorbikeRepository.getMotorbike(motorbike.getId());
            if(co.isEmpty()){
                return motorbikeRepository.save(motorbike);
            }else{
                return motorbike;
            }
    }
  }   
    
    public Motorbike update (Motorbike motorbike){
        if(motorbike.getId() != null){
            Optional<Motorbike> e = motorbikeRepository.getMotorbike(motorbike.getId());
            if(!e.isEmpty()){
                if (motorbike.getBrand()!= null){
                    e.get().setBrand(motorbike.getBrand());
                }
                if (motorbike.getDescription()!= null){
                    e.get().setDescription(motorbike.getDescription());
                }
                if (motorbike.getName()!= null){
                    e.get().setName(motorbike.getName());
                }
                if (motorbike.getYear()!= null){
                    e.get().setYear(motorbike.getYear());
                }
                if (motorbike.getCategory()!= null){
                    e.get().setCategory(motorbike.getCategory());
                }
                motorbikeRepository.save(e.get());
                return e.get();
            }
            else{
                return motorbike;
            }
        }
        else{
            return motorbike;
        }
    }
    
    public boolean deleteMotorbike (int id){
        
        /*Optional<Admin> admin=adminRepository.getAdmin(id);
        if(admin.isEmpty()){
            return false;
        }else{
            adminRepository.delete(admin.get());
            return true;
        }*/
        Boolean aBoolean = getMotorbike(id).map(
            motorbike->{
                motorbikeRepository.delete(motorbike);
                return true;
            }).orElse(false);
        return aBoolean;
    }
}
