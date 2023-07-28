package com.MCT.MusicAPI.service;

import com.MCT.MusicAPI.DTO.MusicDto;
import com.MCT.MusicAPI.Repository.ClientRepository;
import com.MCT.MusicAPI.Repository.IMusicRepository;
import com.MCT.MusicAPI.model.Clients;
import com.MCT.MusicAPI.model.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final IMusicRepository musicRepository;
    private final ClientRepository clientRepository;

    public ResponseEntity<String> addMusic(MusicDto musicDto) {
        Music music = new Music();
        music.setName(musicDto.getSongName());
        music.setDuration(musicDto.getSongDuration());
        music.setArtists(musicDto.getArtistName());
        music.setGenre(musicDto.getGenre());
        musicRepository.save(music);
        return new ResponseEntity<>("Song added successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateMusic(MusicDto musicDto, String musicName) {
        Music music = musicRepository.findByName(musicName);
        music.setMusicId(music.getMusicId());
        music.setName(musicDto.getSongName());
        music.setDuration(musicDto.getSongDuration());
        music.setGenre(musicDto.getGenre());
        music.setArtists(musicDto.getArtistName());
        musicRepository.save(music);
        return new ResponseEntity<>("music has been updated", HttpStatus.ACCEPTED);
    }


    public ResponseEntity<String> deleteTheMusic(String musicName) {
        Music music = musicRepository.findByName(musicName);
        musicRepository.delete(music);
        return new ResponseEntity<>("Music Has been deleted successfully", HttpStatus.OK);
    }

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public String addSongToUserList(String musicName, String userName) {
        Clients clients = clientRepository.findByUserName(userName);
        if (musicRepository.existsByName(musicName)) {
            Music music = musicRepository.findByName(musicName);
            List<Music> musicList = clients.getMusicList();
            if (musicList.contains(music)) {
                musicList.remove(music);
                clients.setMusicList(musicList);
                clientRepository.save(clients);
                return "music has been removed from the playList";
            } else {
                musicList.add(music);
                clients.setMusicList(musicList);
                clientRepository.save(clients);
                return "music has been added to the playlist";
            }
        }
        return "song has not found with the name" + musicName;
    }
}
