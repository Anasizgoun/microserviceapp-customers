package com.anas.billing.feign;

import lombok.Getter;
import com.anas.billing.model.Customer;
import com.anas.billing.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();

}