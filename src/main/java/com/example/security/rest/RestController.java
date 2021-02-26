package com.example.security.rest;

import com.example.security.model.user;
import com.example.security.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/jpa")
public class RestController {

    @Autowired
    private IUserService userService;


    //list users
    @GetMapping(path = {"/list"})
    public List<user> list(){
        return userService.list();
    }

    //add users
    @PostMapping(path = {"/add"})
    public String addUser(@RequestBody user user){
        if(userService.addUser(user)) return "user add successfully";
        return "there was a problem when was add user";
    }

    //update users
    @PostMapping(path = {"/update"})
    public String modify(@RequestBody user user){
        if(userService.updateUser(user)) return "user updated successfully";
        else return "there was a problem when was update user";
    }

    //delete users
    @PostMapping(path = {"delete"})
    public String delete(@RequestParam ("idUser") int id){
        if(userService.delete(id)) return "user delete successfully";
        else return "there was a problem when was deleted user";
    }

}
