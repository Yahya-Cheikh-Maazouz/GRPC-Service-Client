package com.maazouz.grpcclientservice.web;

import net.devh.boot.grpc.client.inject.GrpcClient;
import com.maazouz.bankgrpcservice.grpc.stub.Bank;
import com.maazouz.bankgrpcservice.grpc.stub.BankServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestAPI {
    @GrpcClient("bank")
    private BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub;
    @GetMapping("/convert")
    public ConvertResponseDTO convert(
            @RequestParam String currencyFrom,
            @RequestParam String currencyTo,
            @RequestParam double amount){
        Bank.ConvertCurrencyRequest currencyRequest= Bank.ConvertCurrencyRequest.newBuilder()
                .setAmount(amount)
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .build();
        Bank.ConvertCurrencyResponse convertCurrencyResponse = bankServiceBlockingStub.convertCurrency(currencyRequest);
        ConvertResponseDTO convertResponseDTO=new ConvertResponseDTO(
                convertCurrencyResponse.getCurrencyFrom(),
                convertCurrencyResponse.getCurrencyTo(),
                convertCurrencyResponse.getAmount(),
                convertCurrencyResponse.getConversionResult()
        );
        return convertResponseDTO;
    }
}

record ConvertResponseDTO(String from, String to, double amount, double result){}

