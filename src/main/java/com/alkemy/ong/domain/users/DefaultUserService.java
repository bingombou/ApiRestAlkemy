package com.alkemy.ong.domain.users;

import com.alkemy.ong.domain.exceptions.DomainException;
import com.alkemy.ong.web.security.DefaultUserDetails;
import com.alkemy.ong.web.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    public DefaultUserService(UserRepository userRepository, RoleRepository roleRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
    }

    public List<UserModel> getUsers(){
        return userRepository.getUsers();
    }

    public UserModel updateUser(UserModel userModel) {
        Optional<UserModel> user = userRepository.getUserById(userModel.getIdUser());
        if (user.isEmpty()) {
            throw  new DomainException("User not found with id: " + userModel.getIdUser());
        }
        return userRepository.updateUser(userModel);
    }

    public UserModel registerUserAccount(UserModel userModel){
        Optional<UserModel> user = userRepository.findUserByEmail(userModel.getEmail());
        if(user.isPresent()){
            throw new DomainException("There is an account with that email address: " + userModel.getEmail());
        }
        return userRepository.registerUserAccount(userModel);
    }

    public void deleteUser(long idUser) {
        Optional<UserModel> user = userRepository.getUserById(idUser);
        if (user.isEmpty()) {
            throw new DomainException("User not found with id: " + idUser);
        }else userRepository.deleteUser(idUser);
    }

    public UserModel loginUser(UserModel userModel){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userModel.getEmail(), userModel.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        DefaultUserDetails userDetails = (DefaultUserDetails) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        RoleModel roleModel = roleRepository.findByName(roles.get(0));
        UserModel user = new UserModel(
                                        userDetails.getFirstName()+"---->"+"JWT: "+jwt,
                                        userDetails.getLastName(),
                                        userDetails.getEmail(),
                                        userDetails.getPassword(),
                                        roleModel
                                        );
        return user;
    }
}