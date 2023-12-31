package com.MCT.MusicAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer musicId;

    @Column(name = "name")
    private String name;

    @Column(name = "artist")
    private String artists;

    @Column(name = "duration")
    private double duration;

    @Column(name = "genre")
    private String genre;
}
