package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String getProfile(HttpServletRequest request, Model model) {
        Optional<UserDto> userOp = userService.getUserInfo(request);
        userOp.ifPresent(userDto -> model.addAttribute("user", userDto));
        return "profile";
    }
}
