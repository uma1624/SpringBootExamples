package com.aus.controller;


import com.aus.entity.Role;
import com.aus.entity.RoleToUserForm;
import com.aus.entity.User;
import com.aus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public  String welcome(){
          return "Welcome to SpringBoot Security";
    }

   @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User u =userService.saveUser(user);
        return new ResponseEntity<User> (u, HttpStatus.CREATED);
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveUser(@RequestBody Role role){
        Role r = userService.saveRole(role);
        return new ResponseEntity<Role> (r, HttpStatus.CREATED);
    }
    @PutMapping("/role/addtouser")
    public ResponseEntity<?> addRoletoUser(@RequestBody RoleToUserForm form){
        userService.addRoletoUser(form.getUsername(),form.getRolename());
        return ResponseEntity.ok().build();
    }
 @GetMapping("/getAllUsers")
 public   ResponseEntity<List<User>> getAllUsers(){
       List<User> userList =userService.getUsers();
     //return ResponseEntity.ok().body(userList);
     return  new ResponseEntity<List<User>>(userList,HttpStatus.OK);
 }

    @GetMapping("/getUser/{username}")
    public   ResponseEntity<User> getAllUsers(@PathVariable String username){
        User user =userService.getUser(username);
        //return ResponseEntity.ok().body(userList);
        return  new ResponseEntity<User>(user,HttpStatus.OK);
    }

}
