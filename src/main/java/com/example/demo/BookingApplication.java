package com.example.demo;

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookingApplication {
	@Autowired
	HotelRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

}
