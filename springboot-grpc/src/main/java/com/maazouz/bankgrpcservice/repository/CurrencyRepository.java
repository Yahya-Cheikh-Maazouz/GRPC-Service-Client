package com.maazouz.bankgrpcservice.repository;

import com.maazouz.bankgrpcservice.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    Currency findByName(String name);
}
