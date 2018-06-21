package com.QA.personal.project.springbootangularcrudapplication;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class CustomerAccountController {
	private CustomerAccountRepository repository;

    public CustomerAccountController(CustomerAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-customers")
    @CrossOrigin(origins = "http://localhost:4200")
    public String allCustomers() {
        return new Gson().toJson(repository.findAll());
    }
    
    @GetMapping("/find-customer/{accountID}")
    @ResponseBody
    public String findIndividualCustomer(@PathVariable long accountID){
    	return new Gson().toJson(repository.findById(accountID));
    }
    
    @PostMapping("/add")
    @ResponseBody
    public String createCustomer(@RequestBody String customerJson){
    	repository.save(new Gson().fromJson(customerJson, CustomerAccount.class));
    	return "\"message\" : \"Create successful\"";
    }
    
    @PutMapping("/update")
    @ResponseBody
    public String updateCustomer(@RequestBody String customerJson) {
    	CustomerAccount customerFromJson = new Gson().fromJson(customerJson, CustomerAccount.class);
    	CustomerAccount customerFromDB = repository.findById(customerFromJson.getID()).get();
    	customerFromDB.setAccountNo(customerFromJson.getAccountNo());
    	customerFromDB.setFirstName(customerFromJson.getFirstName());
    	customerFromDB.setLastName(customerFromJson.getLastName());
    	repository.save(customerFromDB);
    	return "\"message\" : \"Update successful\"";
    }
    
    @DeleteMapping(value="/delete-customer/{accountID}")
    @ResponseBody
    public String returnRequestBody(@PathVariable long accountID, @RequestBody String JSON){
    	repository.deleteById(accountID);
    	return "\"message\" : \"Delete successful\"";
    }
}
