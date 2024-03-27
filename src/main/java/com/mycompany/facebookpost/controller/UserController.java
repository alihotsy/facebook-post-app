package com.mycompany.facebookpost.controller;

import com.mycompany.facebookpost.entity.User;
import com.mycompany.facebookpost.repository.UserJpaRepository;
import com.mycompany.facebookpost.service.UserService;
import com.mycompany.facebookpost.utils.UserUpdatingFields;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    /*TODO: Ocultar el password del usuario. También encriptarlo.*/
    private final UserService userService;
    @GetMapping("/get-all")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getActiveUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Integer id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateUserById(
            @PathVariable("userId") Integer id,
            @Validated(UserUpdatingFields.class) @RequestBody User user
    ) {
        return new ResponseEntity<>(userService.updateUserById(id,user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUserByEmail(@PathVariable("userUd") Integer id) {
        return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
    }
}
