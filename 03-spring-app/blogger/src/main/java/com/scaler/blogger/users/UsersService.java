package com.scaler.blogger.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class UsersService {
    private UsersRepository usersRepository;
    private ModelMapper modelMapper;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * signup user
     *
     * @param user
     * @return
     */
    public UserDTO.LoginUserResponse signupUser(UserDTO.CreateUserRequest user) {
        UserEntity savedUser = usersRepository.save(modelMapper.map(user, UserEntity.class));
        UserDTO.LoginUserResponse response = modelMapper.map(savedUser, UserDTO.LoginUserResponse.class);
        response.setToken("token"); // TODO: generate token for logged in users
        return response;
    }

    /**
     * login user
     */
    public UserDTO.LoginUserResponse loginUser(UserDTO.LoginUserRequest user) {

        UserEntity userEntity = usersRepository.findByUsername(user.getUsername()).orElseThrow(
                () -> new UserNotFoundException(user.getUsername())
        );

        // TODO: match password using hashing
        if (userEntity.getPassword().equals(user.getPassword())) {
            UserDTO.LoginUserResponse response = modelMapper.map(userEntity, UserDTO.LoginUserResponse.class);
            response.setToken("token"); // TODO: generate token for logged in users
            return response;
        } else {
            throw new UserAuthenticationException();
        }
    }


    static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String username) {
            super("No such user found with username: " + username);
        }
    }

    static class UserAuthenticationException extends SecurityException {
        public UserAuthenticationException() {
            super("Authentication Failed");
        }
    }
}
