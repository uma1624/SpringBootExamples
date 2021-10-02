package com.aus;

import com.aus.entity.User;
import com.aus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringbootJwtApplication {
	@Autowired
    UserRepository userRepository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(1, "uma", "uma", "uma@gmail.com"),
				new User(2, "user1", "pwd1", "user1@gmail.com"),
				new User(3, "user2", "pwd2", "user2@gmail.com"),
				new User(4, "user3", "pwd3", "user3@gmail.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtApplication.class, args);
	}

}
