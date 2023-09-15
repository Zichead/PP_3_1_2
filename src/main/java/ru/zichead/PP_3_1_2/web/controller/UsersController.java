package ru.zichead.PP_3_1_2.web.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zichead.PP_3_1_2.web.model.User;
import ru.zichead.PP_3_1_2.web.service.UserService;

@Controller
public class UsersController {

    private static final String REDIRECT = "redirect:/users";
    final UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String helloPage () {
        return "hello";
    }

    @GetMapping("/users")
    public String allUsers (Model model) {
        model.addAttribute("user", userService.getUserList());
        return "index";
    }

    @GetMapping("/users/{id}")
    public String show (@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.findUserToID(id));
        return "show";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "new";
        }
        userService.add(user);
        return REDIRECT;
    }
    @GetMapping("/users/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserToID(id));
        return "edit";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return REDIRECT;
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return REDIRECT;
    }
}
