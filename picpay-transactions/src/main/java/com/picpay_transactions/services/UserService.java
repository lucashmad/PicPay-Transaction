package com.picpay_transactions.services;

import com.picpay_transactions.domain.user.User;
import com.picpay_transactions.domain.user.UserType;
import com.picpay_transactions.dtos.UserDTO;
import com.picpay_transactions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("User type not authorization to transaction");
        }
        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("No balance");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("User not exist"));
    }

    public User createUser(UserDTO dataUser){
        User userNew = new User(dataUser);
        this.saverUser(userNew);
        return userNew;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public void saverUser(User user){
        this.repository.save(user);
    }
}
