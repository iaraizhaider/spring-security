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
	
	
	
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		
		Function <String, String> myEncoder = input -> encoder().encode(input);
		UserDetails user = User.builder()
				.passwordEncoder(myEncoder)
				.username("iaraizhaider")
				.password("b")
				.roles("USER", "ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
