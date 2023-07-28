package com.MCT.MusicAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Clients {
    @Id
    @Column(unique = true)
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    @OneToMany
    @JsonIgnore
    private List<Music> musicList;

}
