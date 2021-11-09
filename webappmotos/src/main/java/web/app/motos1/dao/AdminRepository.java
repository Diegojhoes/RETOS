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
import web.app.motos1.entities.Admin;
import web.app.motos1.entities.AdminCrud;


/**
 *
 * @author HP
 */
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrud adminCrudRepository;
    
    public List<Admin> getAll() {return (List<Admin>) adminCrudRepository.findAll();};
    
    public Optional<Admin> getAdmin(int id) {return adminCrudRepository.findById(id);};
    
    public Admin save(Admin admin) {return adminCrudRepository.save(admin);};
    
    public void delete(Admin admin) {adminCrudRepository.delete(admin);}
    }