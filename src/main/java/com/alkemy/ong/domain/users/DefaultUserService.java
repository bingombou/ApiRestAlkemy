package com.alkemy.ong.domain.users;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getUsers(){
        return userRepository.getUsers();
    }
}