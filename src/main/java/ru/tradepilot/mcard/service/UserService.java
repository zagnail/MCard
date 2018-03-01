package ru.tradepilot.mcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tradepilot.mcard.api.dto.UserDto;
import ru.tradepilot.mcard.api.error.UserAlreadyExistException;
import ru.tradepilot.mcard.persistence.dao.UserRepository;
import ru.tradepilot.mcard.persistence.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public User register(UserDto accountDto) throws UserAlreadyExistException {
        if (userEmailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("User already exist");
        }

        User user = new User();
        user.setEmail(accountDto.getEmail());
        user.setPassword(accountDto.getPassword());

        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByID(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<String> getUsersFromSessionRegistry() {
        return sessionRegistry.getAllPrincipals().stream()
                .filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    private boolean userEmailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
