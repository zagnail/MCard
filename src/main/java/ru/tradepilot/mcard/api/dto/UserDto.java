package ru.tradepilot.mcard.api.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
    @NotNull
    @Size(min = 1, message = "{size.userdto.email}")
    private String email;

    @NotNull
    @Size(min = 1)
    private String password;

    private String token;

    private boolean authenticated;

    public UserDto() {
    }

    public UserDto(String email, String token, boolean authenticated) {
        this.email = email;
        this.token = token;
        this.authenticated = authenticated;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}
