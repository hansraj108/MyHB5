package com.hr.net;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hr.net.entity.Gender;
import com.hr.net.entity.User;
import com.hr.net.entity.UserProfile;
import com.hr.net.repository.UserProfileRepository;
import com.hr.net.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("hans");
		user.setEmail("email@gmail.com");
		
		UserProfile up = new UserProfile();
		up.setAddress("nvs");
		up.setGender(Gender.MALE);
		up.setBirthOfDate(LocalDate.of(1988, 8, 10));
		up.setPhoneNumber("9878978978");
		
		user.setUserProfile(up);
		up.setUser(user);
		
		userRepository.save(user);
		
		
	}

}
