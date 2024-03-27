package com.mycompany.facebookpost.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mycompany.facebookpost.utils.UserCreationFields;
import com.mycompany.facebookpost.utils.UserUpdatingFields;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "_user")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotNull(message = "name field is required", groups = {UserCreationFields.class, UserUpdatingFields.class})
    @Size(min = 3,message = "name field should have 3 characters as minimum",groups = {UserCreationFields.class, UserUpdatingFields.class})
    private String name;

    @NotNull(message = "email field is required", groups = {UserCreationFields.class})
    @Pattern(regexp = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$", message = "Email format not valid", groups = {UserCreationFields.class})
    private String email;

    @NotNull(message = "password field is required",groups = {UserCreationFields.class, UserUpdatingFields.class})
    @Size(min = 6, max = 15, message = "Password must have 6 characters as minimum and less or equal than 15",groups = {UserCreationFields.class, UserUpdatingFields.class})
    private String password;

    private String avatar;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonManagedReference
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Post> posts = new HashSet<>();

}
