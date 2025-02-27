package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;
import org.example.model.Role;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("allRoles", Role.ROLES.values());
        return "users";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute @Validated CreateUserDto createUserDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return getAllUsers(model);
        }
        userService.addNewUser(createUserDto);
        return "redirect:/admin/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @PostMapping(path = "/update")
    public String updateUser(@ModelAttribute @Validated UserDto updatedUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return getAllUsers(model);
        }
        userService.updateUser(updatedUser);
        return "redirect:/admin/users";
    }
}
