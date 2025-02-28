package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.SignUpRequest;
import org.example.service.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String startSignUp() {
        return "signup";
    }

    @PostMapping
    public String sigUpUser(@ModelAttribute @Validated SignUpRequest signUpRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "signup";
        }
        signUpService.signUpUser(signUpRequest);
        return "redirect:/login";
    }
}
