package com.QA.personal.project.springbootangularcrudapplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
	
}
