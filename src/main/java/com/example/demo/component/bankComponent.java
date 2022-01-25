package com.example.demo.component;

import com.example.demo.entity.BankAccount;
import com.example.demo.repository.BankRepository;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class bankComponent extends StdConverter<Long, BankAccount> {

    @Autowired
    private BankRepository bankRepo;

    @Override
    public BankAccount convert(Long id) {
        return bankRepo.findById(id).get();
    }
}
