package com.example.demo.service;


import com.example.demo.entity.BankAccount;
import com.example.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService{

    @Autowired
    private BankRepository bankRepo;

    public List<BankAccount> getAllAccounts(){
        return bankRepo.findAll();
    }

    public String addAccount(BankAccount account){
        bankRepo.save(account);
        return "Account Added";
    }

    public Optional<BankAccount> getAccountById(Long bankId){
        return bankRepo.findById(bankId);
    }
}
