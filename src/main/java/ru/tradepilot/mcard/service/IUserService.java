package ru.tradepilot.mcard.service;

import ru.tradepilot.mcard.api.dto.UserDto;
import ru.tradepilot.mcard.api.error.UserAlreadyExistException;
import ru.tradepilot.mcard.persistence.model.User;

import java.util.List;

public interface IUserService {
    User register(UserDto accountDto) throws UserAlreadyExistException;

    User getUserByEmail(String email);

    User getUserByID(long id);

    List<String> getUsersFromSessionRegistry();
}
