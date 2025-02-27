package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;
import org.example.model.User;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id).map(UserDto::from);
    }

    @Override
    public void addNewUser(CreateUserDto createUserDto) {
        if (createUserDto == null || (createUserDto.getEmail() != null && userRepository.getUserByEmail(createUserDto.getEmail()).isPresent())) {
            return;
        }

        userRepository.save(User.builder()
                        .name(createUserDto.getName())
                        .email(createUserDto.getEmail())
                        .password(passwordEncoder.encode(createUserDto.getPassword()))
                        .age(createUserDto.getAge())
                        .roles(roleRepository.findByRoleIn(createUserDto.getRoles()))
                        .build());
    }


    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return;
        }
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(UserDto user) {
        if (user == null || user.getId() == null || !userRepository.existsById(user.getId())) {
            return;
        }

        userRepository.save(User.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .age(user.getAge())
                        .roles(roleRepository.findByRoleIn(user.getRoles()))
                        .build());
    }

    @Override
    public Optional<UserDto> getUserInfo(HttpServletRequest request) {
        Authentication authentication = (Authentication) request.getUserPrincipal();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        Optional<User> userOp = userRepository.getUserByEmail(email);
        return userOp.map(UserDto::from);
    }
}
