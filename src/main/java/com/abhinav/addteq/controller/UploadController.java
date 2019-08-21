package com.abhinav.addteq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.addteq.model.User;
import com.abhinav.addteq.model.UserData;
import com.abhinav.addteq.repository.UserDataRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
public class UploadController {
	
	@Autowired
    private UserDataRepository userDataRepository;
	
	@GetMapping("/allUsers")
    public List<UserData> getAllUsers() {
        return userDataRepository.findAll();
    }
	
	@PostMapping("/users/save")
    public List<UserData> createUsers(@Valid @RequestBody List<UserData> users) {
    	List<UserData> createdUsers = new ArrayList<UserData>();
    	
    	for (UserData user : users) {
    		UserData createdUser = userDataRepository.save(user);
    		createdUsers.add(createdUser);
    	}
        return createdUsers;
    }

    @GetMapping("/users")
    public List<User> getUsers() throws Exception {
    	
    	List<User> users = new ArrayList<User>();

    	BufferedReader br = new BufferedReader(new FileReader("/home/test/user.txt"));
    	try {
    		String line;
        	
            while ((line = br.readLine()) != null) {
                 users.add(new User(line));
            }
            
    	} catch (IOException e) {
            e.printStackTrace();
        } finally {
    	    br.close();
    	}

        return users;
    }

}