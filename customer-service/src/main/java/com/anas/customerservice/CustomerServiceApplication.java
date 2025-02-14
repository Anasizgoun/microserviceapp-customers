package com.anas.customerservice;

// import com.anas.customerservice.config.CustomerConfigParams;
import com.anas.customerservice.entities.Customer;
import com.anas.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository ) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("anas").email("anas@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("anas1").email("anas1@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("anas2").email("anas2@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c -> {
                System.out.println("======================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("=======================");
            });
        };
    }
}
