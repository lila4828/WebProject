package com.example.webproject.service.impl;

import com.example.webproject.entity.Loan;
import com.example.webproject.repository.LoanRepository;
import com.example.webproject.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan getLoan(Long id) {
        Optional<Loan> loan = loanRepository.findById(id);
        if(loan.isPresent()) {
            return loan.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Loan saveLoan(Loan loan) {
        Loan saveLoan = loanRepository.save(loan);
        System.out.println(saveLoan);
        return saveLoan;
    }

    @Override
    public Loan extendLoan(Long id) {
        Optional<Loan> oldLoan = loanRepository.findById(id);
        Loan newLoan;
        if(oldLoan.isPresent()) {
            newLoan = oldLoan.get();
            newLoan.setNumberExtensions(oldLoan.get().getNumberExtensions()+1);
        } else {
            throw new EntityNotFoundException();
        }
        return newLoan;
    }

    @Override
    public Loan returnLoan(Long id, Date date) {
        Optional<Loan> oldLoan = loanRepository.findById(id);
        Loan newLoan;
        if(oldLoan.isPresent()) {
            newLoan = oldLoan.get();
            newLoan.setReturnDate(date);
        } else {
            throw new EntityNotFoundException();
        }
        return newLoan;
    }
}
