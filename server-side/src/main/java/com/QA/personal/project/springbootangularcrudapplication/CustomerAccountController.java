package com.QA.personal.project.springbootangularcrudapplication;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAccountController {
	private CustomerAccountRepository repository;

    public CustomerAccountController(CustomerAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-customers")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<CustomerAccount> coolCars() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
    
    @RequestMapping(value="/method2/{accountID}", method=RequestMethod.POST)
    @ResponseBody
    public String returnURLParam(@PathVariable String accountID){
    	return accountID;
    }
    
    
    @RequestMapping(value="/method3/{accountID}", method=RequestMethod.POST)
    @ResponseBody
    public String returnRequestBody(@PathVariable String accountID, @RequestBody String JSON){
    	return accountID + JSON;
    }
}
