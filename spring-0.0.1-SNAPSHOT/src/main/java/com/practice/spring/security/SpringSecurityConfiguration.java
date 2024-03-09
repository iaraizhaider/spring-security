package com.practice.spring.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	private UserDetails createUser(String name, String password, Function <String, String> encoder, String... roles) {
		return User.builder()
				.passwordEncoder(encoder)
				.username(name)
				.password(password)
				.roles(roles)
				.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		
		Function <String, String> myEncoder = input -> encoder().encode(input);
		UserDetails user1 = createUser("a","1", myEncoder, "ADMIN", "USER");
		UserDetails user2 = createUser("b","2", myEncoder, "ADMIN", "USER");
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
