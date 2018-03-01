package ru.tradepilot.mcard.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tradepilot.mcard.api.dto.Message;
import ru.tradepilot.mcard.api.dto.UserDto;
import ru.tradepilot.mcard.api.error.UserAlreadyExistException;
import ru.tradepilot.mcard.persistence.model.User;
import ru.tradepilot.mcard.service.IUserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public Message registerUserAccount(@RequestBody @Valid UserDto accountDto) throws UserAlreadyExistException {
        User registered = userService.register(accountDto);

        return new Message("Registration is success: " + registered.getEmail(), "user.register.success");
    }
}
