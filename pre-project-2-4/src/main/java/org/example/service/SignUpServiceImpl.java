package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CreateUserDto;
import org.example.dto.request.SignUpRequest;
import org.example.model.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserService userService;

    @Override
    public void signUpUser(SignUpRequest request) {
        Set<Role.ROLES> roles = new HashSet<>();
        roles.add(Role.ROLES.ROLE_USER);

        CreateUserDto createUserDto = CreateUserDto.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .age(request.getAge())
                .roles(roles)
                .build();
        userService.addNewUser(createUserDto);
    }
}
