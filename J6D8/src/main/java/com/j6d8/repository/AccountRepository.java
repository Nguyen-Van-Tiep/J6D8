package com.j6d8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j6d8.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
