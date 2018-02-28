package ru.tradepilot.mcard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tradepilot.mcard.persistence.dao.UserRepository;
import ru.tradepilot.mcard.persistence.model.User;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // == create initial user
        createUserIfNotFound("test@test.com", "password");
    }

    @Transactional
    private final User createUserIfNotFound(final String email, final String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setPassword(password);
        }

        user = userRepository.save(user);

        return user;
    }
}
