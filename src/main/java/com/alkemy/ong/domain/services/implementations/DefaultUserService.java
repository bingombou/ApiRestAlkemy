package com.alkemy.ong.domain.services.implementations;
import com.alkemy.ong.database.repositories.UserRepository;
import com.alkemy.ong.domain.services.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        
        this.userRepository = userRepository;
    }
}