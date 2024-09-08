package com.masterhills.RewardsManagement.controller;

import com.masterhills.RewardsManagement.message.ResponseMessage;
import com.masterhills.RewardsManagement.model.Customer;
import com.masterhills.RewardsManagement.model.Transaction;
import com.masterhills.RewardsManagement.service.CustomerService;
import com.masterhills.RewardsManagement.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rewards")
public class Controller {

    private final CustomerService customerService;

    private final TransactionService transactionService;

    public Controller(CustomerService customerService, TransactionService transactionService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }

    @PostMapping("/createuser")
    public ResponseEntity<ResponseMessage> createCustomer(
            @RequestBody Customer customer
    ) {
        String message = "";

        try {

            customerService.registerCustomer(customer);

            message = "Account created successfuly";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Account was not created";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/balance/{uuid}")
    public Customer balance(@PathVariable("uuid") String uuid) {
        return customerService.balance(uuid);
    }


    @PostMapping("/maketransact")
    public ResponseEntity<ResponseMessage> makeTransact(
            @RequestBody Transaction transaction
    ) {
        String message = "";

        try {

            transactionService.makeTransaction(transaction);

            message = "Transaction successfull";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Error in transaction";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/history/{uuid}")
    public Transaction history(@PathVariable("uuid") String uuid) {
        return transactionService.history(uuid);
    }

}
