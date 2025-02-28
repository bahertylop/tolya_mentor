package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.dto.request.UpdateUserInfoRequest;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserService userService;

    public Optional<UserDto> getUserInfo(HttpServletRequest request) {
        Authentication authentication = (Authentication) request.getUserPrincipal();
        return Optional.of(UserDto.from((User) authentication.getPrincipal()));
    }

    public void deleteProfile(HttpServletRequest request) {
        Optional<UserDto> userDto = getUserInfo(request);
        if (!userDto.isPresent()) {
            return;
        }
        userService.deleteUser(userDto.get().getId());
    }

    public void updateUserInfo(HttpServletRequest request, UpdateUserInfoRequest updateInfo) {
        Optional<UserDto> userDtoOp = getUserInfo(request);

        if (userDtoOp.isPresent()) {
            UserDto userDto = userDtoOp.get();
            userDto.setPassword(updateInfo.getPassword());
            userDto.setName(updateInfo.getName());
            userDto.setAge(updateInfo.getAge());
            userService.updateUser(userDto);
        }

    }
}
