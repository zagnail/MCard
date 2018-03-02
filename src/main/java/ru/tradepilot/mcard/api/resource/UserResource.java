package ru.tradepilot.mcard.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Message> registerUserAccount(@RequestBody @Valid UserDto accountDto) throws UserAlreadyExistException {
        User registered = userService.register(accountDto);

        Message message = new Message("Registration is success: ", "user.register.success");

        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
