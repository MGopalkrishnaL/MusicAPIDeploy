package com.MCT.MusicAPI.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    @NotBlank(message = "Username is required")
    @Pattern(regexp = "^[a-zA-Z@.]+$", message = "Username can only contain letters, '@' and '.'")
    private String userName;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should be at least 6 characters long")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$", message = "Password must contain at least one letter, one number, and one special character")
    private String password;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain letters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^(?:[A-Za-z0-9._%+-]+@(?:gmail\\.com|yahoo\\.com|duckduckgo\\.com))$", message = "Email must be a valid Gmail, Yahoo, or DuckDuckGo address")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Invalid phone number format. Use international format with '+' sign.")
    private String phoneNumber;

}
