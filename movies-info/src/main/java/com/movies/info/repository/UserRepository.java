package com.movies.info.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.movies.info.entity.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    @Nullable
    User findUserByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username, String email);
}
