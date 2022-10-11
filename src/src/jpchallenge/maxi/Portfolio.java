package jpchallenge.maxi;

import java.util.ArrayList;
import java.util.Iterator;

public class Portfolio {
	
	private String name;
	private ArrayList<Stock> stocks;
	private ArrayList<Bond> bonds;
	private Customer customer;
	private double currentPortfolioValue;
	private double cash;
	
	public Portfolio(String name,Customer customer, ArrayList<Stock> stocks, ArrayList<Bond> bonds, double cash){
		
		this.name = name;
		this.customer = customer;	
		this.stocks = stocks;
		this.bonds = bonds;
		this.cash = cash;
	}
	
	
	public void showPortfolio() {
		System.out.println("Portfolio: "+name);
		System.out.println("Customer: "+customer.getName());
		
		System.out.println("Stocks: ");
		Iterator<Stock> iterstocks = stocks.iterator();
		while (iterstocks.hasNext())
			System.out.println("    "+iterstocks.next().getName());
		
		System.out.println("Bonds: ");
		Iterator<Bond> iterbonds = bonds.iterator();
		while (iterbonds.hasNext())
			System.out.println("    "+iterbonds.next().getISIN());
		
		System.out.println("Cash: ");
		System.out.println("    "+cash +" usd");
	}

	
	public void calculateCurrentValuePortfolio() {
		
		double currentValueStocks = 0;
		double currentValueBonds = 0;
		Stock Currentstock = null;
		Bond Currentbond = null;
		Iterator<Stock> iterstocks = stocks.iterator();
		
		while (iterstocks.hasNext()) {
			 	  Currentstock = iterstocks.next();
			 	 currentValueStocks = currentValueStocks + (Currentstock.getCurrentPrice() * Currentstock.getUnits());
		}
		System.out.println("Current stocks value: "+ currentValueStocks+" usd");
		
		Iterator<Bond> iterbond = bonds.iterator();
		while (iterbond.hasNext()) {
			 	  Currentbond = iterbond.next();
			 	 currentValueBonds = currentValueBonds + (Currentbond.getMarketPrice() * Currentbond.getNominal());
		}
		
		System.out.println("Current bonds value: "+ currentValueBonds+" usd");
		System.out.println("Current cash :" + cash+ " usd");
	
		currentPortfolioValue = currentValueStocks + currentValueBonds + cash;
		System.out.println("Current Portfolio value: "+ currentPortfolioValue+" usd");

	}
	
	
	public void calculatePnL() {
		
		Stock Currentstock = null;
		Bond Currentbond = null;
		double pnl;
		double totalStocksPnl = 0;
		double totalBondsPnl = 0;
		double totalPortfolioPnL = 0;
		
		Iterator<Stock> iterstocks = stocks.iterator();
		while (iterstocks.hasNext()) {
			 	  Currentstock = iterstocks.next();
				  pnl = Currentstock.getUnits() * (Currentstock.getCurrentPrice() - Currentstock.getOpenPrice());
				  System.out.println("Pnl for "+ Currentstock.getName() + "= "+pnl);
				  totalStocksPnl = pnl + totalStocksPnl;
		}
		System.out.println("Stocks PnL : "+totalStocksPnl+ " usd");
		System.out.println("-----------");
		
		Iterator<Bond> iterbonds = bonds.iterator();
		while (iterbonds.hasNext()) {
				  Currentbond = iterbonds.next();
				  pnl = Currentbond.getNominal() * (Currentbond.getMarketPrice() -  Currentbond.getOpenPrice());
				  System.out.println("Pnl for "+ Currentbond.getISIN() + "= "+pnl);
				  totalBondsPnl = totalBondsPnl  + pnl;
		}
		System.out.println("Bonds PnL : "+totalBondsPnl+ " usd");
		System.out.println("-----------");
		
		totalPortfolioPnL = totalStocksPnl + totalBondsPnl;
		
		System.out.println("Total Portfolio PnL: "+ totalPortfolioPnL+" usd");
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public ArrayList<Stock> getStocks() {
		return stocks;
	}


	public void setStocks(ArrayList<Stock> stocks) {
		this.stocks = stocks;
	}

	public ArrayList<Bond> getBonds() {
		return bonds;
	}

	public void setBonds(ArrayList<Bond> bonds) {
		this.bonds = bonds;
	}

	public double getCurrentPortfolioValue() {
		return currentPortfolioValue;
	}

	public void setCurrentPortfolioValue(double currentValue) {
		this.currentPortfolioValue = currentValue;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

}
