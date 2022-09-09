package com.maazouz.bankgrpcservice.repository;

import com.maazouz.bankgrpcservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
