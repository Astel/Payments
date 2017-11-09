package com.epam.lab.payments.controllers;

import com.epam.lab.payments.dao.BankAccountRepository;
import com.epam.lab.payments.dao.CreditCardRepository;
import com.epam.lab.payments.dao.OrderRepository;
import com.epam.lab.payments.dao.UserRepository;
import com.epam.lab.payments.domain.BankAccountEntity;
import com.epam.lab.payments.domain.CreditCardEntity;
import com.epam.lab.payments.domain.OrderEntity;
import com.epam.lab.payments.domain.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class MainRestController {
    private final UserRepository userRepository;
    private final CreditCardRepository creditCardRepository;
    private final OrderRepository orderRepository;
    private final BankAccountRepository bankAccountRepository;

    MainRestController(UserRepository userEntityRepository, CreditCardRepository creditCardRepository, OrderRepository orderRepository, BankAccountRepository bankAccountRepository) {
        this.userRepository = userEntityRepository;
        this.creditCardRepository = creditCardRepository;
        this.orderRepository = orderRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable(value = "id") Integer userId) {
        UserEntity userEntity = userRepository.findOne(userId);
        if(userEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userEntity);
    }

    /*@GetMapping("user/{id}/cards")
    public List<CreditCardEntity> getCardsByUserId(@PathVariable(value = "id") Integer userId) {
        return creditCardRepository.findByUserId(userId);
    }*/

    @GetMapping("/cards")
    public List<CreditCardEntity> getAllCards() {
        return creditCardRepository.findAll();
    }


    @GetMapping("/orders")
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/bankAccounts")
    public List<BankAccountEntity> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

}