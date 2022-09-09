package com.maazouz.bankgrpcservice.mappers;

import com.maazouz.bankgrpcservice.entities.Account;
import com.maazouz.bankgrpcservice.enums.AccountStatus;
import com.maazouz.bankgrpcservice.enums.AccountType;
import com.maazouz.bankgrpcservice.grpc.stub.Bank;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public Bank.BankAccount fromBankCount(Account account){
        Bank.BankAccount bankAccount= Bank.BankAccount.newBuilder()
                .setAccountId(account.getId())
                .setBalance(account.getBalance())
                .setCreatedAt(account.getCreateAt())
                .setType(Bank.AccountType.valueOf(account.getType().toString()))
                .setState(Bank.AccountState.valueOf(account.getStatus().toString()))
                .build();
        return bankAccount;
    }
    public Account fromGrpcAccount(Bank.BankAccount bankAccount){
        Account account=new Account();
        account.setId(bankAccount.getAccountId());
        account.setBalance(bankAccount.getBalance());
        account.setCreateAt(bankAccount.getCreatedAt());
        account.setType(AccountType.valueOf(bankAccount.getType().toString()));
        account.setStatus(AccountStatus.valueOf(bankAccount.getState().toString()));
        return account;
    }
}
