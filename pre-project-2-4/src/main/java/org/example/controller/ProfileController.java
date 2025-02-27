package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.dto.request.UpdateUserInfoRequest;
import org.example.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public String getProfile(HttpServletRequest request, Model model) {
        Optional<UserDto> userOp = profileService.getUserInfo(request);
        userOp.ifPresent(userDto -> model.addAttribute("user", userDto));
        return "profile";
    }

    @PostMapping("/delete")
    public String deleteAccount(HttpServletRequest request) {
        profileService.deleteProfile(request);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUserInfo(HttpServletRequest request, UpdateUserInfoRequest updateInfo) {
        profileService.updateUserInfo(request, updateInfo);
        return "redirect:/profile";
    }
}
