package com.picpay_transactions.dtos;

import com.picpay_transactions.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, String email, BigDecimal balance, String password, UserType type) {
}
