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
import web.app.motos1.dao.MessageRepository;
import web.app.motos1.entities.Message;
import web.app.motos1.entities.MessageCrud;



/**
 *
 * @author HP
 */
@Service
@SpringBootApplication(scanBasePackages = "web.app.motos1.dao")
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll() {return (List<Message>) messageRepository.getAll();};
    
    public Optional<Message> getMessage(int id) {return messageRepository.getMessage(id);};
    
    public Message save(Message message) {
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
            
        }else{
            Optional<Message> co = messageRepository.getMessage(message.getIdMessage());
            if(co.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
    }
  }   
    
    public Message update (Message message){
        if(message.getIdMessage() != null){
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if (message.getMessageText() != null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            }
            else{
                return message;
            }
        }
        else{
            return message;
        }
    }
    
    public boolean deleteMessage (int id){
        
        /*Optional<Admin> admin=adminRepository.getAdmin(id);
        if(admin.isEmpty()){
            return false;
        }else{
            adminRepository.delete(admin.get());
            return true;
        }*/
        Boolean aBoolean = getMessage(id).map(
            message->{
                messageRepository.delete(message);
                return true;
            }).orElse(false);
        return aBoolean;
    }
}
