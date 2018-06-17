package com.QA.personal.project.springbootangularcrudapplication;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAngularCrudApplication {
	 private int accountNo = 1000;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAngularCrudApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(CustomerAccountRepository repository) {
        return args -> {
        	
            Stream.of("Daniel", "John", "James").forEach(firstName -> {
            	Stream.of ("Smith", "Jones", "Neesham").forEach(secondName -> {
            		CustomerAccount customerAccount = new CustomerAccount();
            		customerAccount.setFirstName(firstName);
            		customerAccount.setLastName(secondName);
            		customerAccount.setAccountNo(Integer.toString(accountNo));
            		accountNo++;
            		repository.save(customerAccount);
            	});
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
