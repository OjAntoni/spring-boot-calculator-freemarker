package com.example.bootcalculator.controller;

import com.example.bootcalculator.entity.User;
import com.example.bootcalculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping("/reg")
    public ModelAndView regGet(ModelAndView modelAndView){
        modelAndView.addObject("newUser", new User());
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @GetMapping("/auth")
    public ModelAndView authGet(ModelAndView modelAndView){
        modelAndView.setViewName("auth");
        modelAndView.addObject("newUser", new User());
        return modelAndView;
    }

    @PostMapping("/reg")
    public ModelAndView regPost(@Valid @ModelAttribute(name = "newUser") User user, BindingResult bindingResult, ModelAndView modelAndView){
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("reg");
            return modelAndView;
        }
        userService.save(user);
        modelAndView.setViewName("auth");
        return modelAndView;
    }

    @PostMapping("/auth")
    public ModelAndView authPost(@ModelAttribute(name = "newUser") User user, ModelAndView modelAndView, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        User user1 = userService.get(username);
        if(user1==null || !user1.getPassword().equals(password)){
            modelAndView.addObject("newUser", user);
            modelAndView.setViewName("auth");
        } else {
            session.setAttribute("user", userService.get(username));
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
