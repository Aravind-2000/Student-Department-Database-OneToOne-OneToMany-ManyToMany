package com.example.demo.component;

import com.example.demo.entity.BankAccount;
import com.example.demo.repository.BankRepository;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class bankComponent extends StdConverter<String, BankAccount> {

    @Autowired
    private BankRepository bankRepo;

    @Override
    public BankAccount convert(String id) {
        return bankRepo.findById(Long.valueOf(id)).get();
    }
}
