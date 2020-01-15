package com.genting.ram.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.genting.ram.endpoints.CurrencyExchangeService;

@Component
public class ResourceConfigApp extends ResourceConfig{
	
	
	 public ResourceConfigApp() 
	    {
	        register(CurrencyExchangeService.class);
	    }
	
}
