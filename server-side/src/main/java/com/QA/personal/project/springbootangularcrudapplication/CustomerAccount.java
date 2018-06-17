package com.QA.personal.project.springbootangularcrudapplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccount {
	@Id @GeneratedValue
	private long id;
	private @NonNull String firstName;
	private @NonNull String lastName;
	private @NonNull String accountNo;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	
}
