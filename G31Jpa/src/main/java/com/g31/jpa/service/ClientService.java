package com.g31.jpa.service;

import com.g31.jpa.entity.Client;
import com.g31.jpa.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo Torres C
 */

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    public Client insertClient(Client client) {
        return clientRepository.save(client);
    }
    
    public void deleteClient(Long id){
       clientRepository.deleteById(id);               
    }
    
    public Client updateClient(Client client){
    if (client.getIdClient()!=null){

            Optional<Client> opcional =  clientRepository.findById(client.getIdClient());
            
            if (opcional.isEmpty()) return client;
            else{
               Client clientDB = opcional.get();
               
               clientDB.setAge(client.getAge());
               clientDB.setEmail(client.getEmail());
               clientDB.setName(client.getName());
               clientDB.setPassword(client.getPassword());
               
               return clientRepository.save(clientDB);
            }

    }
    return client;
    }
}
