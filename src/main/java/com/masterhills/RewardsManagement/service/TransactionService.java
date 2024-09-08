package com.masterhills.RewardsManagement.service;

import com.masterhills.RewardsManagement.model.Credentials;
import com.masterhills.RewardsManagement.model.Customer;
import com.masterhills.RewardsManagement.model.Transaction;
import com.masterhills.RewardsManagement.repository.CredentialRepository;
import com.masterhills.RewardsManagement.repository.CustomerRepository;
import com.masterhills.RewardsManagement.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;

    private final CustomerRepository customerRepository;

    private final JwtUtil jwtUtil;

    public TransactionService(TransactionRepository transactionRepository, CredentialRepository credentialRepository, CustomerRepository customerRepository, JwtUtil jwtUtil) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
        this.jwtUtil = jwtUtil;
    }

    public String makeTransaction(Transaction transaction){
        Long userId = jwtUtil.getUserIdFromJwt();
        Customer user = customerRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Transaction transaction1 = new Transaction();
        transaction1.setAmount(transaction.getAmount());
        transaction1.setDescription(transaction.getDescription());
        transaction1.setCustomer(user);
        transaction1 = transactionRepository.save(transaction1);

        return "transaction saved";
    }

    public Transaction history(String uuid){
        Optional<Transaction> transaction = transactionRepository.findByUuid(uuid);

        if (transaction.isEmpty()) {
            throw new RuntimeException("No transaction found with UUID: " + uuid);
        }
        return transaction.get();
    }

}
