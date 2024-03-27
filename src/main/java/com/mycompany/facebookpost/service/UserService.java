package com.mycompany.facebookpost.service;

import com.mycompany.facebookpost.entity.User;
import com.mycompany.facebookpost.exception.UserNotFoundException;
import com.mycompany.facebookpost.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJpaRepository userJpaRepository;
    public List<User> getActiveUsers() {
        return userJpaRepository.findUsersByIsActive(true);
    }

    /*TODO: El admin puede ver todos los usuarios sin importar el estado*/
    public List<User> getAllUsers() {
        return userJpaRepository.findAll();
    }
    public User findUserById(Integer id) {

        return userJpaRepository.findUserByUserIdAndIsActive(id,true).orElseThrow(
                () -> new UserNotFoundException("User not found with that ID value")
        );
    }

    public User updateUserById(Integer id, User fields) { /*Email is not updated*/
        /*TODO: validar que la imagen, tenga el formato adecuado*/
        return userJpaRepository.findUserByUserIdAndIsActive(id,true)
                .map(userFound -> {
                    userFound.setName(fields.getName());
                    userFound.setPassword(fields.getPassword());
                    userFound.setAvatar(fields.getAvatar());
                    userFound.setUpdatedAt(LocalDateTime.now());
                    return userJpaRepository.save(userFound);
                }).orElseThrow(() -> new UserNotFoundException("User not found with that ID"));
    }

    public User deleteUserById(Integer id) {
        return userJpaRepository.findUserByUserIdAndIsActive(id,true)
                .map(userFound -> {
                    userFound.setIsActive(false);
                    return userJpaRepository.save(userFound);
                }).orElseThrow(() -> new UserNotFoundException("User not found with that ID"));
    }

}
