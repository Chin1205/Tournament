package com.sevensevengsi.Tournament.RecordSystem.authentication;

import com.sevensevengsi.Tournament.RecordSystem.model.User;
import com.sevensevengsi.Tournament.RecordSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Bad credentials!!");

        return new MyUserPrincipal(user);
    }
}
