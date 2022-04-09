package com.project.pet.store.controllers;

import com.project.pet.store.entities.User;
import com.project.pet.store.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class UserController {
    UserService userService;



    @PostMapping("/question")
    public String addQuestion(@ModelAttribute User user){
        userService.saveOrUpdate(user);
        return "redirect:/home";
    }

}
