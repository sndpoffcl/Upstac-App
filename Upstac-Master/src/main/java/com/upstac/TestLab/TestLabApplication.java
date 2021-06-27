package com.upstac.TestLab;

import com.upstac.TestLab.async.producer.MessageProducer;
import com.upstac.TestLab.model.TestBooking;
import com.upstac.TestLab.service.TestService;
import com.upstac.TestLab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class TestLabApplication {

	@Autowired
	TestService testService;

	@Autowired
	UserService userService;

	@Autowired
	MessageProducer messageProducer;

	public static void main(String[] args) {
		SpringApplication.run(TestLabApplication.class, args);
		System.out.println("Running");
	}

	@PostConstruct
	private void init(){
		testService.addInitialTests();
		userService.addInitialUsers();
	}

}
