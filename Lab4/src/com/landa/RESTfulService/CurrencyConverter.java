package com.landa.RESTfulService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.landa.model.Currency;

@Path("currencyConverter")
public class CurrencyConverter {

	public String version = "1.0";
	

	
	/*------------------------Code Block Number 1-----------------------*/
	@GET
	@Path("version")
	public String version()
	{
		return "The current version is " +version;
	}
	
	private static List<Currency> currencyList = new ArrayList<Currency>();
	
	private  static void initializeCurrencies()
	{
		currencyList.add(new Currency(1,"Dollar","USA", 1800));
		currencyList.add(new Currency(2,"Euro","EU",2000));
		currencyList.add(new Currency(3,"Yen","Japan",1945));
	}
	
	@GET
	@Path("currency/{id}")
	public String getCurrency(@PathParam("id") int id){
		
		CurrencyConverter.initializeCurrencies();
		String currency = "";
		Boolean found = false;
		for( Currency curr : currencyList){
			if(curr.getID() == id ) {
				currency = curr.getName();
				found = true;
			}
		}
		if (found){return currency;}
		else{return "Error: currency not found";}
		
	}
	
	@GET
	@Path("conversion/{source}/{destination}/{amount}")
	public double convert(@PathParam("source") String source,
							@PathParam("destination") String destination,
							@PathParam("amount") double amount){
		double result = 1;
		if(source.equals("E")){
			if(destination.equals("D")){
				result = amount * 1.085165 ;
			}
			if(destination.equals("Y")){
				result = amount * 127.771694;
			}
		}
		if(source.equals("D")){
			if(destination.equals("E")){
				result = amount * 0.921518847 ;
			}
			if(destination.equals("Y")){
				result = amount * 117.744024;
			}
		}
		if(source.equals("Y")){
			if(destination.equals("E")){
				result = amount * 0.00782645957 ;
			}
			if(destination.equals("D")){
				result = amount * 0.008493;
			}
		}
		return result;
		
	}
	
	@GET
	@Path("currencies")
	@Produces(MediaType.TEXT_XML)
	public List<Currency> getCurrenciesXML(@QueryParam("sortedYN") String sortedYN){
		
		CurrencyConverter.initializeCurrencies();
		if(sortedYN == "Y" ){
			Collections.sort(currencyList);
		}
		return currencyList;
	}
	
	@GET
	@Path("currencies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Currency> getCurrenciesJSON(@QueryParam("sortedYN") String sortedYN){
		
		CurrencyConverter.initializeCurrencies();
		if(sortedYN == "Y" ){
			Collections.sort(currencyList);
		}
		return currencyList;
	}
	
			
}
