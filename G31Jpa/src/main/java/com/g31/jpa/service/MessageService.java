package com.g31.jpa.service;

import com.g31.jpa.entity.Message;
import com.g31.jpa.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo Torres C
 */

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    public List<Message> getMessage() {
        return messageRepository.findAll();
    }

    public Message insertMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message getMessageById(Long id){
            return messageRepository.findById(id).get();
    }

    public void deleteMessage(Long id){
       messageRepository.deleteById(id);               
    }
    
    public Message updateMessage(Message message){

        if (message.getIdMessage()!=null){

            Optional<Message> opcional = messageRepository.findById(message.getIdMessage());
            
            if (!opcional.isEmpty()){
                Message messageBD = opcional.get();
                messageBD.setMessageText(message.getMessageText());
                messageBD.setClient(message.getClient());
                messageBD.setGame(message.getGame());
                
                return messageRepository.save(messageBD);
            }else{
                return message;
            }
        }
        return message; 
    }
}
