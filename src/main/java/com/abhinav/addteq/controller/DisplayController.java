package com.abhinav.addteq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.abhinav.addteq.model.UserData;
import com.abhinav.addteq.repository.UserDataRepository;

@Controller
public class DisplayController {
	@Autowired
    private UserDataRepository userDataRepository;
	
	@GetMapping("/")
    public String showAllUsers(Model model) {
        List<UserData> allUsers =  userDataRepository.findAll();
        model.addAttribute("allUsers", allUsers);
        
        return "displayUsers";
    }
}
