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

    public BankAccount getAccountById(Long bankId){
        return bankRepo.getById(bankId);
    }

    public String updateAccountDetails(Long bandId, BankAccount account){
        BankAccount ba = bankRepo.getById(bandId);

        if(account.getBankName() != null){
            ba.setBankName(account.getBankName());
        }
        if(account.getBankBranch() != null){
            ba.setBankBranch(account.getBankBranch());
        }
        if(account.getAccountNumber() != null){
            ba.setAccountNumber(account.getAccountNumber());
        }
        if(account.getAccountHolderName() != null){
            ba.setAccountHolderName(account.getAccountHolderName());
        }
        if(account.getIfscNumber() != null){
            ba.setIfscNumber(account.getIfscNumber());
        }
        if(account.getAccountType() != null){
            ba.setAccountType(account.getAccountType());
        }
        bankRepo.save(ba);
        return "Bank Details updated Successfully";
    }
}
