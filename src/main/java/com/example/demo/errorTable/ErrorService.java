package com.example.demo.errorTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    @Autowired
    private ErrorRepository errorRepo;

    public String dataNotFound(){
        return errorRepo.getById(401).getErrorDescription();
    }

    public String dataAlreadyPresent(){
        return errorRepo.getById(410).getErrorDescription();
    }
}
