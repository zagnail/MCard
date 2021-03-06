package ru.tradepilot.mcard.api.error.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tradepilot.mcard.api.dto.Message;
import ru.tradepilot.mcard.api.error.UserAlreadyExistException;

@ControllerAdvice
public class UserAlreadyExistExceptionHandler {
    private Log log = LogFactory.getLog(getClass());

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseBody
    public Message handleUserAlreadyExistException(UserAlreadyExistException e) {
        log.debug("Email already exist");
        return new Message(e.getMessage(), "user.email.exist");
    }
}
