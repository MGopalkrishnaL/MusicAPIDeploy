package com.MCT.MusicAPI.Repository;

import com.MCT.MusicAPI.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Music findByName(String musicName);

    boolean existsByName(String musicName);
}
