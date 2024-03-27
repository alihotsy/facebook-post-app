package com.mycompany.facebookpost.service;

import com.mycompany.facebookpost.entity.User;
import com.mycompany.facebookpost.exception.UserBadRequestException;
import com.mycompany.facebookpost.exception.UserNotFoundException;
import com.mycompany.facebookpost.repository.UserJpaRepository;
import com.mycompany.facebookpost.utils.AuthCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserJpaRepository userJpaRepository;

    public User register(User user) {
        Optional<User> userFoundByEmail = userJpaRepository.findByEmail(user.getEmail());

        if(userFoundByEmail.isPresent()) {
            throw new UserBadRequestException("Email already exists");
        }
        /*TODO: Encriptar password. Y devolver JWT*/
        return userJpaRepository.save(user);
    }

    public User login(AuthCredentials credentials) {
        /*TODO: devolver JWT*/
        return userJpaRepository.findByEmail(credentials.getEmail())
                .map(userFound -> !userFound.getPassword().equals(credentials.getPassword())
                        ? null
                        : userFound).orElseThrow(() -> new UserNotFoundException("Email o password invalids"));
    }


}
