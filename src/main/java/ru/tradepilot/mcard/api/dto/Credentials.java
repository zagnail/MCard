package ru.tradepilot.mcard.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Credentials {
//    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{size.userdto.email}")
    private String email;
//    @ValidPassword
    private String password;

    public Credentials() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
