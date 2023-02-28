package com.cesarvizentini.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firtName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email is valid
        // todo: check if email not taken
        // todo: check if fraudters
        restTemplate.getForObject(
                url:"http://localhot:8081/api/v1/fraud-check/{customerId}",

        )
        customerRepository.save(customer);
        // todo: send notification
    }
}
