package com.authentication.service;

import com.authentication.controller.dto.SignUpRequest;

import com.authentication.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.springbootdockermavenjibplugin.dto.RequestDto;
import com.springbootdockermavenjibplugin.models.Request;
import com.springbootdockermavenjibplugin.models.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Optional<User> signup(SignUpRequest request) {

        String hashedPassword = passwordEncoder.encode(request.getPassword());

            User user = User.builder()
                    .name(request.getName())
                    .password(request.getPassword())
                    .build();

            User savedRequest = repository.save(user);

            return Optional.of(savedRequest);
        }

    @Override
    public UserDetails loadUserByUsername(String name) {
        List<User> users = repository.findAll().stream().filter(u ->u.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if(users!=null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(users.get(0).getName())
                    .password(users.get(0).getPassword())
                    .build();
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username("")
                .password("")
                .build();
    }
    @Transactional
    public Optional<User> findUser(SignUpRequest request) {
    List<User> users = repository.findAll();
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        for(User user: users) {
            User auUser = User.builder()
                    .name(request.getName())
                    .password(hashedPassword)
                    .build();
            if(auUser.getName().equals(request.getName())){
                Optional.of(auUser);
            }
        }
        return Optional.of(null);
    }
}

