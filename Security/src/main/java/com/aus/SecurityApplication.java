package com.aus;

import com.aus.entity.Role;
import com.aus.entity.User;
import com.aus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {

		SpringApplication.run(SecurityApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> {
          userService.saveRole(new Role(null,"ROLE_ADMIN"));
          userService.saveRole(new Role(null,"ROLE_USER"));
          userService.saveRole(new Role(null,"ROLE_MANAGER"));

			userService.saveUser(new User(null,"umasankar","uma","umapwd",new ArrayList<>()));
			userService.saveUser(new User(null,"phani","phani","umapwd",new ArrayList<>()));
			userService.saveUser(new User(null,"sankar","sankar","umapwd",new ArrayList<>()));

			userService.addRoletoUser("uma","ROLE_ADMIN");
			userService.addRoletoUser("phani","ROLE_MANAGER");
			userService.addRoletoUser("sankar","ROLE_USER");

		};
	}

}
