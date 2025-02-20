package org.example.service;

import lombok.AllArgsConstructor;
import org.eclipse.jetty.http.HttpStatus;
import org.example.dto.UserDto;
import org.example.model.User;
import org.example.repository.UserRepository;

import java.util.Optional;

@AllArgsConstructor
public class AccountService {

    private final UserRepository userRepository;

    public HttpStatus.Code signUp(UserDto userDto) {
        if (userDto == null || userDto.getLogin() == null || userDto.getPassword() == null) {
            return HttpStatus.Code.BAD_REQUEST;
        }

        boolean saved = userRepository.saveUser(
                User.builder()
                        .login(userDto.getLogin())
                        .password(userDto.getPassword())
                .build());
        if (saved) {
            return HttpStatus.Code.OK;
        }
        return HttpStatus.Code.BAD_REQUEST;
    }

    public HttpStatus.Code signIn(UserDto userDto) {
        if (userDto == null || userDto.getLogin() == null || userDto.getPassword() == null) {
            return HttpStatus.Code.BAD_REQUEST;
        }

        Optional<User> registeredUser = userRepository.getUser(userDto.getLogin());
        if (registeredUser.isPresent()) {
            if (registeredUser.get().getPassword().equals(userDto.getPassword())) {
                return HttpStatus.Code.OK;
            }
        }
        return HttpStatus.Code.UNAUTHORIZED;
    }
}
