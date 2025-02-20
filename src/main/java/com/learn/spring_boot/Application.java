package com.learn.spring_boot;

import java.util.Arrays;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context){
		return args -> {
			System.out.println("Let's Inspect the beans provided by Spring boot");

			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);

			for(String beanName : beanNames){
				System.out.println(beanName);
			}
		};
	}

	@Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}
