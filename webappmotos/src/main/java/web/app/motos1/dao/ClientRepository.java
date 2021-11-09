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
import web.app.motos1.entities.Client;
import web.app.motos1.entities.ClientCrud;


/**
 *
 * @author HP
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrud clientCrudRepository;
    
    public List<Client> getAll() {return (List<Client>) clientCrudRepository.findAll();};
    
    public Optional<Client> getClient(int id) {return clientCrudRepository.findById(id);};
    
    public Client save(Client client) {return clientCrudRepository.save(client);};
    
    public void delete(Client client) {clientCrudRepository.delete(client);}
    }