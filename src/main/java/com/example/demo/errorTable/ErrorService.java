package com.example.demo.errorTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    @Autowired
    private ErrorRepository errorRepo;

    public String errorFound(Integer i){
        return errorRepo.getById(i).getErrorDescription();
    }

}
