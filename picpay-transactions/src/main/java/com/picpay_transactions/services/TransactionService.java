package com.picpay_transactions.services;

import com.picpay_transactions.domain.transaction.Transaction;
import com.picpay_transactions.domain.user.User;
import com.picpay_transactions.dtos.TransactionDTO;
import com.picpay_transactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    public TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;


    public Transaction createTransaction(TransactionDTO transactionData) throws Exception {
        User sender = this.userService.findUserById(transactionData.senderId());
        User receiver = this.userService.findUserById(transactionData.receiverId());

        userService.validateTransaction(sender, transactionData.value());

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transactionData.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimeTransaction(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transactionData.value()));
        receiver.setBalance(receiver.getBalance().add(transactionData.value()));

        this.repository.save(newTransaction);
        this.userService.saverUser(sender);
        this.userService.saverUser(receiver);

        return newTransaction;
    }

}

