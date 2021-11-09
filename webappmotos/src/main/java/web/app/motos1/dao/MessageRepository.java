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
import web.app.motos1.entities.Message;
import web.app.motos1.entities.MessageCrud;


/**
 *
 * @author HP
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrud messageCrudRepository;
    
    public List<Message> getAll() {return (List<Message>) messageCrudRepository.findAll();};
    
    public Optional<Message> getMessage(int id) {return messageCrudRepository.findById(id);};
    
    public Message save(Message message) {return messageCrudRepository.save(message);};
    
    public void delete(Message message) {messageCrudRepository.delete(message);}
    }