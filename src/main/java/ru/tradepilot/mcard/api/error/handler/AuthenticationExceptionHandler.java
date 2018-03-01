package ru.tradepilot.mcard.api.error.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.tradepilot.mcard.api.dto.Message;

@ControllerAdvice
public class AuthenticationExceptionHandler {
    private Log log = LogFactory.getLog(getClass());

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Message handleAuthenticationException(AuthenticationException e) {
        log.debug("Incorrect login");
        return new Message(e.getMessage(), "login.error.badLogin");
    }
}
