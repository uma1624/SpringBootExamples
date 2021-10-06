package com.aus.service;

import com.aus.entity.Role;
import com.aus.entity.User;
import com.aus.repository.RoleRepository;
import com.aus.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        log.debug("Save user");
        Role role = (Role) user.getRoles();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.debug("Save Role");
        return roleRepository.save(role);
    }

    @Override
    public void addRoletoUser(String username, String rolename) {
          User user = userRepository.findByUsername(username);
          Role role = roleRepository.findByName(rolename);
        log.debug("add RoletoUser");
          user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.debug("add get User");
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.debug("add get All Users");
        return userRepository.findAll();
    }
}
