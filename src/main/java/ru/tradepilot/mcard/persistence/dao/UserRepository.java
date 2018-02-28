package ru.tradepilot.mcard.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tradepilot.mcard.persistence.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
