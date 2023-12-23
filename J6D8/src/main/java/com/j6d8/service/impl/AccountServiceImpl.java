package com.j6d8.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6d8.entity.Account;
import com.j6d8.repository.AccountRepository;
import com.j6d8.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository adao;

    @Override
    public Account finById(String username) {
        return adao.findById(username).get();
    }
}
