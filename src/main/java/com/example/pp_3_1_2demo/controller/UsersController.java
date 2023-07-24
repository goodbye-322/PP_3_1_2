package com.example.pp_3_1_2demo.controller;


import com.example.pp_3_1_2demo.model.User;
import com.example.pp_3_1_2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/users")
@Controller
public class UsersController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getAllUsers(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @PostMapping("")
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("userUpdate") User user, @PathVariable("id") long id) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}