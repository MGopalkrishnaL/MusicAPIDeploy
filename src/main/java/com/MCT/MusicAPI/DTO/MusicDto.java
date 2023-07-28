package com.MCT.MusicAPI.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto {
    @NotEmpty
    @Size(min = 6, message = "Song name must have a minimum length of 6 characters")
    private String songName;

    @NotEmpty
    @Size(min = 6, message = "Artist name must have a minimum length of 6 characters")
    private String artistName;

    @NotNull(message = "Song duration cannot be null")
    private double songDuration;

    @NotEmpty(message = "Genre cannot be empty")
    private String genre;
}
