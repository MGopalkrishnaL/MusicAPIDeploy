package com.MCT.MusicAPI.Repository;

import com.MCT.MusicAPI.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients,String> {
    boolean existsByUserName(String name);

    Clients findByUserName(String userName);
}
