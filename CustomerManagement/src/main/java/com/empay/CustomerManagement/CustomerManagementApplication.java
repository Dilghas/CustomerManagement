package com.empay.CustomerManagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={"com.empay.*"})

@EntityScan(basePackages={"com.empay.*"})
@EnableJpaRepositories(basePackages = {"com.empay.*"})

public class CustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
/*		ApplicationContext ctx=SpringApplication.run(CustomerManagementApplication.class, args);

		CustomerManagementService ss=ctx.getBean(CustomerManagementService.class);

		ss.getCustomerManagement(35); */
	}

}
