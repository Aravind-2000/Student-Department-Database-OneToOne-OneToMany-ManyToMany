package com.example.demo.errorTable;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Error {

    @Id
    private int errorId;
    private String errorDescription;

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}

