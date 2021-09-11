package com.alkemy.ong.domain.users;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getUsers(){
        return userRepository.getUsers();
    }

    public void deleteUser(long idUser) {
        Optional<UserModel> user = userRepository.getById(idUser);
        if (user.isEmpty()) {
            throw new DomainException("User not found with id: " + idUser);

        }else userRepository.deleteUser(idUser);
    }
}