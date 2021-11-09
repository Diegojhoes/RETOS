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
import web.app.motos1.dao.AdminRepository;
import web.app.motos1.entities.Admin;
import web.app.motos1.entities.AdminCrud;



/**
 *
 * @author HP
 */
@Service
@SpringBootApplication(scanBasePackages = "web.app.motos1.dao")
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll() {return (List<Admin>) adminRepository.getAll();};
    
    public Optional<Admin> getAdmin(int id) {return adminRepository.getAdmin(id);};
    
    public Admin save(Admin admin) {
        if(admin.getId()==null){
            return adminRepository.save(admin);
            
        }else{
            Optional<Admin> co = adminRepository.getAdmin(admin.getId());
            if(co.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
    }
  }   
    
    public Admin update (Admin admin){
        if(admin.getId() != null){
            Optional<Admin> e = adminRepository.getAdmin(admin.getId());
            if(!e.isEmpty()){
                if (admin.getName() != null){
                    e.get().setName(admin.getName());
                }
                if (admin.getEmail() != null){
                    e.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null){
                    e.get().setPassword(admin.getPassword());
                }
                adminRepository.save(e.get());
                return e.get();
            }
            else{
                return admin;
            }
        }
        else{
            return admin;
        }
    }
    
    public boolean deleteAdmin (int id){
        
        /*Optional<Admin> admin=adminRepository.getAdmin(id);
        if(admin.isEmpty()){
            return false;
        }else{
            adminRepository.delete(admin.get());
            return true;
        }*/
        Boolean aBoolean = getAdmin(id).map(
            admin->{
                adminRepository.delete(admin);
                return true;
            }).orElse(false);
        return aBoolean;
    }
}

