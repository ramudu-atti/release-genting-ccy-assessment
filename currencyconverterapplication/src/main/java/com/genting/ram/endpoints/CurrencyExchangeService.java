package com.genting.ram.endpoints;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.genting.ram.dao.ExchangeCurrencyDao;
import com.genting.ram.entity.ExchangeCurrency;
import com.genting.ram.entity.ExchangeCurrencyResultVO;

@Path("/currency")
@Service
public class CurrencyExchangeService {

	@Autowired
	private ExchangeCurrencyDao exchangeCurrencyDao;

	@GET
	@Produces("application/json")
	@Path("/convertion/from/{basecurrency}/to/{targetcurrency}/{quanity}")
	public Response getCurrentExchangeAmount(@PathParam("basecurrency") String baseCurrency,
			@PathParam("quanity") String baseQuantiy, @PathParam("targetcurrency") String targetCurrency) {

		ExchangeCurrencyResultVO resultVo = new ExchangeCurrencyResultVO();

		try {

			BigDecimal quanity = new BigDecimal(baseQuantiy);

			resultVo.setBaseCurrency(baseCurrency);
			resultVo.setBaseQuantity(quanity);
			resultVo.setTargetCurrency(targetCurrency);

			ExchangeCurrency exchangeCcyRate = exchangeCurrencyDao.getExchangeRate(baseCurrency, targetCurrency);
			if (exchangeCcyRate==null || exchangeCcyRate.getConvertionRate() ==null) {
				
				return Response.status(Status.NO_CONTENT).build();
			}
			
			resultVo.setConvertionRate(exchangeCcyRate.getConvertionRate());

			BigDecimal convertedAmount = quanity.multiply(exchangeCcyRate.getConvertionRate());
			resultVo.setConvertedAmount(applyRoundingAndReturnAmount(convertedAmount));
			resultVo.setTimeStamp(LocalDateTime.now());
			return Response.status(Status.OK).entity(resultVo).build();
		} catch (NumberFormatException nfe) {
			// throw new InvalidExchangeQuantityException();
			return Response.status(Status.NO_CONTENT).entity("INVALID EXCHANGE QUANTITY").build();
		}

	}

	/**
	 * applying rounding logic which is fixed but need to consider so many
	 * factors based on countries and currencies in currency amounts to apply
	 * rounding logic
	 * 
	 * @param convertedAmount
	 * @return
	 */
	public BigDecimal applyRoundingAndReturnAmount(BigDecimal convertedAmount) {
		return convertedAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	@GET
	@Produces("application/json")
	@Path("/convertion/getrates/{basecurrency}")
	public Response getCurrentExchangeRates(@PathParam("basecurrency") String baseCurrency) {
		List<ExchangeCurrency> rates = exchangeCurrencyDao.getAllCurrencyExchanges(baseCurrency);
		return Response.status(Status.OK).entity(rates).build();
	}

}
