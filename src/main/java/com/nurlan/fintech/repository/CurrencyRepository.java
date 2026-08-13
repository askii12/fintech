package com.nurlan.fintech.repository;

import com.nurlan.fintech.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
}