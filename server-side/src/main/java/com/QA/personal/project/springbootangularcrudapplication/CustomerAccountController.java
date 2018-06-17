package com.QA.personal.project.springbootangularcrudapplication;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAccountController {
	private CustomerAccountRepository repository;

    public CustomerAccountController(CustomerAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-customers")
    public Collection<CustomerAccount> coolCars() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

}
