package com.genting.ram.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ExchangeCurrencyResultVO {

	private String baseCurrency;
	private String targetCurrency;
	private BigDecimal baseQuantity;
	private BigDecimal convertedAmount;
	private BigDecimal convertionRate;
	private LocalDateTime timeStamp;
	
	
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public BigDecimal getBaseQuantity() {
		return baseQuantity;
	}
	public void setBaseQuantity(BigDecimal baseQuantity) {
		this.baseQuantity = baseQuantity;
	}
	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public BigDecimal getConvertionRate() {
		return convertionRate;
	}
	public void setConvertionRate(BigDecimal convertionRate) {
		this.convertionRate = convertionRate;
	}
	
}
