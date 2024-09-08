package com.masterhills.RewardsManagement.service;

import com.masterhills.RewardsManagement.model.Credentials;
import com.masterhills.RewardsManagement.model.Customer;
import com.masterhills.RewardsManagement.repository.CredentialRepository;
import com.masterhills.RewardsManagement.repository.CustomerRepository;
import com.masterhills.RewardsManagement.utility.UUIDGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerService {

    private final CredentialRepository credentialRepository;

    private final CustomerRepository customerRepository;

    private final JwtUtil jwtUtil;

    public CustomerService(CredentialRepository credentialRepository, CustomerRepository customerRepository, JwtUtil jwtUtil) {
        this.credentialRepository = credentialRepository;
        this.customerRepository = customerRepository;
        this.jwtUtil = jwtUtil;
    }

    public String registerCustomer(Customer customer){
        Long userId = jwtUtil.getUserIdFromJwt();
        Credentials user = credentialRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Customer customer1 = new Customer();

        customer1.setCredential(user);
        customer1.setUuid(customer.getUuid());
        customer1.setCurrent_balance(customer.getCurrent_balance());
        customer1.setTotal_cashback(customer.getTotal_cashback());
        customer1 = customerRepository.save(customer1);
        return "customer created";
    }

    public Customer balance(String uuid){

        Optional<Customer> customer = customerRepository.findByUuid(uuid);

        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not found with UUID: " + uuid);
        }

        return customer.get();
    }


}
