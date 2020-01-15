package currencyconverterapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.genting.ram.entity.ExchangeCurrencyResultVO;
import com.genting.ram.starter.CurrencyConversionBootStarter;


@SpringBootTest(classes=CurrencyConversionBootStarter.class)
@ComponentScan({ "com.genting.ram.starter", "com.genting.ram.endpoints", "com.genting.ram.entity",
		"com.genting.ram.dao", "com.genting.ram.config" })
public class CurrencyExchangeServiceTest {

	@Test
	public void getCurrentExchangeAmountTest(){
	 assertEquals(1,1);
	 
	 RestTemplate restTemplate = new RestTemplate();
     
	    final String baseUrl = "http://localhost:8080/currency/convertion/from/usd/to/sgd/10";
	    URI uri;
		try {
			uri = new URI(baseUrl);
			 ResponseEntity<ExchangeCurrencyResultVO> result = restTemplate.getForEntity(uri, ExchangeCurrencyResultVO.class);
		     assertEquals(200, result.getStatusCodeValue());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
