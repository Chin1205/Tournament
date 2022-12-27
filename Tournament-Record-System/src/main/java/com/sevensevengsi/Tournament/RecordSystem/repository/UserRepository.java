package com.sevensevengsi.Tournament.RecordSystem.repository;

import com.sevensevengsi.Tournament.RecordSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

}
