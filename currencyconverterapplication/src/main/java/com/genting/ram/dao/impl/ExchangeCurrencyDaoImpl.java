package com.genting.ram.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.genting.ram.dao.ExchangeCurrencyDao;
import com.genting.ram.entity.ExchangeCurrency;

public class ExchangeCurrencyDaoImpl implements ExchangeCurrencyDao {

	public ExchangeCurrencyDaoImpl() {

	}

	@Autowired
	private EntityManager entityManager;

	public long count() {
		return 0;
	}

	public void delete(ExchangeCurrency arg0) {

	}

	public void deleteAll() {

	}

	public void deleteAll(Iterable<? extends ExchangeCurrency> arg0) {

	}

	public void deleteById(Integer arg0) {

	}

	public boolean existsById(Integer arg0) {
		return false;
	}

	public Iterable<ExchangeCurrency> findAll() {
		return null;
	}

	public Iterable<ExchangeCurrency> findAllById(Iterable<Integer> arg0) {
		return null;
	}

	public Optional<ExchangeCurrency> findById(Integer arg0) {
		return null;
	}

	public <S extends ExchangeCurrency> S save(S arg0) {
		return null;
	}

	public <S extends ExchangeCurrency> Iterable<S> saveAll(Iterable<S> arg0) {
		return null;
	}

	/**
	 * Method used to get the current currency conversion rate available in the
	 * system
	 * 
	 * @param baseCurrency
	 * @param targetCurrency
	 * @return
	 */
	public ExchangeCurrency getExchangeRate(String baseCurrency, String targetCurrency) {

		String queryStr = "Select exchange "
				+ "from ExchangeCurrency exchange join exchange.currency cur on cur.name=exchange.baseCurrency "
				+ "where exchange.baseCurrency=:baseccy and exchange.targetCurrency=:targetccy";
		
			Query query = entityManager.createQuery(queryStr);
		query.setParameter("baseccy", baseCurrency.toUpperCase());
		query.setParameter("targetccy", targetCurrency.toUpperCase());
		
		ExchangeCurrency resultVo;
		List<ExchangeCurrency> resultList=(List<ExchangeCurrency> )query.getResultList();
		if(resultList.size()>0)
				 resultVo = resultList.get(0);		
			return new ExchangeCurrency();
	
	}

	/**
	 * Method used to get the all currency conversion rates available in the
	 * system
	 * 
	 * @param baseCurrency
	 * @return
	 */
	public List<ExchangeCurrency> getAllCurrencyExchanges(String baseCurrency) {
		return null;
	}
}
