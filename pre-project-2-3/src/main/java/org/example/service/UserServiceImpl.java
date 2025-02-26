package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CreateUserDto;
import org.example.model.User;
import org.example.dto.UserDto;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
        if (createUserDto == null || (createUserDto.getEmail() != null && userRepository.getUserByEmail(createUserDto.getEmail()) != null)) {
            User us = userRepository.getUserByEmail(createUserDto.getEmail());
            return;
        }

        userRepository.save(User.builder()
                        .name(createUserDto.getName())
                        .email(createUserDto.getEmail())
                        .age(createUserDto.getAge())
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
                        .age(user.getAge())
                        .build());
    }
}
