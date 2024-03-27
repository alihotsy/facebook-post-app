package com.mycompany.facebookpost.repository;

import com.mycompany.facebookpost.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
    List<User> findUsersByIsActive(boolean isActive);
    Optional<User> findUserByUserIdAndIsActive(Integer id, boolean isActive);

}
