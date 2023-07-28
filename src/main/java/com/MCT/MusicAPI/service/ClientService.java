package com.MCT.MusicAPI.service;

import com.MCT.MusicAPI.DTO.ClientDTO;
import com.MCT.MusicAPI.Repository.ClientRepository;
import com.MCT.MusicAPI.model.Clients;
import com.MCT.MusicAPI.model.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ResponseEntity<String> saveClient(ClientDTO client) {
        Clients clients = new Clients();
        if (clientRepository.existsByUserName(client.getName())) {
            return new ResponseEntity<>("user Name Has already exist", HttpStatus.BAD_REQUEST);
        }
        clients.setEmail(client.getEmail());
        clients.setName(client.getName());
        clients.setPhoneNumber(client.getPhoneNumber());
        clients.setPassword(clients.getPassword());
        clients.setRole("User");
        clients.setUserName(clients.getUserName());
        clientRepository.save(clients);
        return new ResponseEntity<>("Client has been saved the successfully",HttpStatus.CREATED);
    }


    public boolean validateClientRole(String userName) {
        if(clientRepository.existsByUserName(userName)) {
            Clients clients = clientRepository.findByUserName(userName);
            return clients.getRole().equals("Admin");
        }
        return false;
    }

    public List<Music> getClientPlayList(String userName) {
        Clients clients = clientRepository.findByUserName(userName);
        return clients.getMusicList();
    }

    public ResponseEntity<String> createAdmin(ClientDTO client) {
        Clients clients = new Clients();
        if (clientRepository.existsByUserName(client.getName())) {
            return new ResponseEntity<>("Admin Name Has already exist", HttpStatus.BAD_REQUEST);
        }
        clients.setEmail(client.getEmail());
        clients.setName(client.getName());
        clients.setPhoneNumber(client.getPhoneNumber());
        clients.setPassword(clients.getPassword());
        clients.setRole("Admin");
        clients.setUserName(clients.getUserName());
        clientRepository.save(clients);
        return new ResponseEntity<>("Client has been saved the successfully with Admin previlages",HttpStatus.CREATED);

    }
}
