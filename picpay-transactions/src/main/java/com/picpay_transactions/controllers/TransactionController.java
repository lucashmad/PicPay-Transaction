package com.picpay_transactions.controllers;

import com.picpay_transactions.domain.transaction.Transaction;
import com.picpay_transactions.dtos.TransactionDTO;
import com.picpay_transactions.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionData) throws Exception {
        Transaction newTransaction = this.service.createTransaction(transactionData);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
