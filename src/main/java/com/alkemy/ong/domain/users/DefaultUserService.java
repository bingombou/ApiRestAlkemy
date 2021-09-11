package com.alkemy.ong.domain.users;
import com.alkemy.ong.domain.exceptions.DomainException;
import com.alkemy.ong.web.dto.UserDto;
import com.alkemy.ong.web.dto.UserRegisterDto;
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

    public UserDto updateUser(long idUser, UserDto userDto) {
        Optional<UserModel> user = userRepository.getById(idUser);
        if (user.isEmpty()) {
            throw  new DomainException("User not found with id: " + idUser);
        }
        return userRepository.updateUser(idUser, userDto);
    }

    public UserRegisterDto registerUserAccount(UserRegisterDto user){
        if(emailExists(user.getEmail())){
            throw new DomainException("There is an account with that email address: " + user.getEmail());
        }

        return userRepository.registerUserAccount(user);
    }

    public boolean emailExists(String email){
        return userRepository.findUserByEmail(email);
    }

    public void deleteUser(long idUser) {
        Optional<UserModel> user = userRepository.getById(idUser);
        if (user.isEmpty()) {
            throw new DomainException("User not found with id: " + idUser);

        }else userRepository.deleteUser(idUser);
    }
}