package com.genting.ram.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.genting.ram.entity.ExchangeCurrency;

@Repository
public interface ExchangeCurrencyDao extends CrudRepository<ExchangeCurrency,Integer>{

	public ExchangeCurrency getExchangeRate(String baseCurrency, String targetCurrency);

	public List<ExchangeCurrency> getAllCurrencyExchanges(String baseCurrency);

}
