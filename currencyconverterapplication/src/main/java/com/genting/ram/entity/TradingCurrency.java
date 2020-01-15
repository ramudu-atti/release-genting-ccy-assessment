package com.genting.ram.entity;

import java.math.BigDecimal;

public interface TradingCurrency {

	public BigDecimal getExchangeRate(Currency baseCurrency);

	public BigDecimal getExchangedAmount(BigDecimal currencyQuanity,BigDecimal exchangeRate);

}
