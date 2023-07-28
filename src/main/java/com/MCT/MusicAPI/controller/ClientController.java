package com.MCT.MusicAPI.controller;

import com.MCT.MusicAPI.DTO.ClientDTO;
import com.MCT.MusicAPI.DTO.MusicDto;
import com.MCT.MusicAPI.model.Music;
import com.MCT.MusicAPI.service.ClientService;
import com.MCT.MusicAPI.service.MusicService;
import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final MusicService musicService;

    @PostMapping("/SaveClient")
    public ResponseEntity<String> saveUser(@Valid @RequestBody ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);
    }
    @PostMapping("/createClientWithAdminPrevilages")
    public ResponseEntity<String> adminCreation(@Valid @RequestBody ClientDTO clientDTO){
        return clientService.createAdmin(clientDTO);
    }

    @PostMapping("/AddTheSong")
    public ResponseEntity<String> addSongs(@Valid @RequestBody MusicDto musicDto, @RequestParam String userName) {
        boolean clientRoleValidation = clientService.validateClientRole(userName);
        if (clientRoleValidation) {
            return musicService.addMusic(musicDto);
        }
        return new ResponseEntity<>("You don't have the access", HttpStatus.FORBIDDEN);
    }
    @PutMapping("/updateTheSong")
    public ResponseEntity<String> updateTheSong(@RequestBody MusicDto musicDto,@RequestParam String userName,@RequestParam String musicName){
     boolean clientValidation = clientService.validateClientRole(userName);
     if(clientValidation){
         return musicService.updateMusic(musicDto,musicName);
     }
     return new ResponseEntity<>("You Don't have the access",HttpStatus.FORBIDDEN);
    }
    @DeleteMapping("/deleteTheSong")
    public ResponseEntity<String> deleteTheSong(@RequestParam String MusicName,String userName){
        boolean clientValidation = clientService.validateClientRole(userName);
        if(clientValidation){
            return musicService.deleteTheMusic(MusicName);
        }
        return new ResponseEntity<>("You Dont have the access",HttpStatus.FORBIDDEN);
    }
    @GetMapping("/getAllSongs")
    public ResponseEntity<List<Music>> getAllMusic(){
        return new ResponseEntity<>(musicService.getAllMusic(),HttpStatus.OK);
    }
    @PostMapping("/CrudToPlayList")
    public ResponseEntity<String> addSongToPlayList(@RequestParam String musicName,@RequestParam String userName){
        return new ResponseEntity<>(musicService.addSongToUserList(musicName,userName),HttpStatus.OK);
    }
    @PostMapping("/showPlayListOfUser")
    public ResponseEntity<List<Music>> showPlayList(@RequestParam String userName){
        return new ResponseEntity<>(clientService.getClientPlayList(userName),HttpStatus.ACCEPTED);
    }



}
