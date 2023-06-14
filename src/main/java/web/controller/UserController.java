package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;


import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User>userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "index";
    }

    @GetMapping("/search")
    public String getUserById(@RequestParam (required = false) Long id, Model model) {
        User user = userService.findById(id);
        if(user == null) {
            return  "redirect:/";
        }
        model.addAttribute("user", user);
        return "search";
    }

    @GetMapping("/new")
    public String showCreateUserFrom(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserFrom(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PatchMapping("/edit/{id}")
    public String updateUserSubmit(@PathVariable Long id, @ModelAttribute User user) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserSubmit(@PathVariable Long id) {
        User byId = userService.findById(id);
        userService.delete(byId);
        return "redirect:/";
    }
}
