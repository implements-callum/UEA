package com.Greedy;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}
