package com.talan.pfemanager.controller;

import com.talan.pfemanager.dto.UserDTO;
import com.talan.pfemanager.service.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private  UserService userService;
    
    @PostMapping("/register")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }
    
    @GetMapping("/users")
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("user/{id}")
    public UserDTO getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @DeleteMapping("user/delete/{id}")
    public void deleteUser(@PathVariable int id) {
    	userService.deleteUser(id);
    }
    
    @DeleteMapping("user/delete")
    public void deleteAllUsers() {
    	userService.deleteAllUsers();
    }

    @PutMapping("user/update/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO updatedUser) throws Exception {
    	return userService.updateUser(id, updatedUser);
    }

}
