package com.example.security;

import com.example.security.model.user;
import com.example.security.repository.IUserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class SecurityApplicationTests {

    @Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private IUserRepo userRepo;

	@Test
	void CreateUser() {
		user user1 = new user();
		user1.setIdUser(2);
		user1.setPassword(encoder.encode("123"));
		user1.setName("camilo");
		user user2 = userRepo.save(user1);
		assert(user2.getPassword().equalsIgnoreCase(user1.getPassword()));
	}

}
