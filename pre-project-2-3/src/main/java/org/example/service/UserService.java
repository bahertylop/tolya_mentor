package org.example.service;

import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getUsers();

    Optional<UserDto> getUserById(Long id);

    void addNewUser(CreateUserDto createUserDto);

    void deleteUser(Long id);

    void updateUser(UserDto user);
}
