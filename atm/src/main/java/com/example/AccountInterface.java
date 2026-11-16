package com.example;

import java.math.BigDecimal;


public interface AccountInterface {
    Boolean deposit(BigDecimal amount, String currency);
    Boolean withdraw(BigDecimal amount,String currency);
    void showStatus();
}
