package ru.tradepilot.mcard.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.tradepilot.mcard.api.dto.Credentials;
import ru.tradepilot.mcard.api.dto.UserDto;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/session")
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.POST)
    public UserDto login(@RequestBody Credentials credentials, HttpSession httpSession) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(authentication));

        UserDto user = new UserDto(credentials.getEmail(), httpSession.getId(), true);
        httpSession.setAttribute("user", user);

        return user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public UserDto session(HttpSession session) {
        return (UserDto) session.getAttribute("user");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
