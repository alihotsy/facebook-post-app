package com.mycompany.facebookpost.controller;

import com.mycompany.facebookpost.entity.User;
import com.mycompany.facebookpost.service.AuthService;
import com.mycompany.facebookpost.utils.AuthCredentials;
import com.mycompany.facebookpost.utils.UserCreationFields;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthService authService;
    /*TODO: Type Will be AuthResponse, Generate JWT*/
    @Validated
    @PostMapping("/register")
    public ResponseEntity<User> userRegister(@RequestBody @Validated(UserCreationFields.class) User user) {
        return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody AuthCredentials credentials) {
        return new ResponseEntity<>(authService.login(credentials), HttpStatus.OK);
    }

}
