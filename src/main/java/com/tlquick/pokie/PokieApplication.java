package com.tlquick.pokie;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping("/")
@RestController
public class PokieApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PokieApplication.class, args);
	
		Pokie pokie = context.getBean(Pokie.class);
		System.out.println(pokie.toString());
	}	
}
