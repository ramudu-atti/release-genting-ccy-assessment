package com.genting.ram.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "exchange_currency")
public class ExchangeCurrency implements Serializable {

	

	public ExchangeCurrency() {

	}

	@ManyToOne
	@JoinColumn(name = "id")
	private Currency currency;
	
	@Id
	private Long exchangeCcyId;
	

	@Column
	private String baseCurrency;
	@Column
	private String targetCurrency;
	
	@Column(name="units")
	private Integer units;
	
	@Column(name="convertion_rate",scale=9, precision=32)
	private BigDecimal convertionRate;
	
	
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Long getExchangeCcyId() {
		return exchangeCcyId;
	}

	public void setExchangeCcyId(Long exchangeCcyId) {
		this.exchangeCcyId = exchangeCcyId;
	}

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

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public BigDecimal getConvertionRate() {
		return convertionRate;
	}

	public void setConvertionRate(BigDecimal convertionRate) {
		this.convertionRate = convertionRate;
	}

	
}
