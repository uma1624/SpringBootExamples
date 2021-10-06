package com.aus.service;



import com.aus.entity.Role;
import com.aus.entity.User;
import com.aus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    public User saveUser(User user);
    public Role saveRole(Role role);
    void  addRoletoUser(String username,String rolename);
    User getUser(String username);
    List<User> getUsers();


}
