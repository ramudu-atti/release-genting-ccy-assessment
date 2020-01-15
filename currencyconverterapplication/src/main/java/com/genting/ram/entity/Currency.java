package com.genting.ram.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CURRENCY")
public class Currency implements TradingCurrency,Serializable {

	@Id
	private Integer id;
	
	@Column(name="name",length=3,nullable=false,unique=true)
	private String name;
	
	@OneToMany(mappedBy="currency")
	private List<ExchangeCurrency> exchangeCurrnecyList;
	
	
	public Currency(){
		
	}

	public Currency(Integer id, String name) {
	this.id=id;
	this.name=name;
	}

	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/**
 * return default convertion rate for the same currency
 * @param baseCurrency
 * @return
 */
	public  BigDecimal getExchangeRate(Currency baseCurrency){
		return new BigDecimal("1.0");
		
	}

	public  BigDecimal getExchangedAmount(BigDecimal currencyQuanity,BigDecimal exchangeRate){
		return currencyQuanity.multiply(exchangeRate);
		
	}

	public List<ExchangeCurrency> getExchangeCurrnecyList() {
		return exchangeCurrnecyList;
	}

	public void setExchangeCurrnecyList(List<ExchangeCurrency> exchangeCurrnecyList) {
		this.exchangeCurrnecyList = exchangeCurrnecyList;
	}
}
