package jpchallenge.maxi;

import java.util.ArrayList;

/*
A Bank is interested in implementing a system that can value an investment portfolio.
Their portfolios can be made up of stocks, bonds and cash in US Dollars and Euros.
The prices for each of these instruments is determined by a separate pricing system which you will need to interact with 
(no need to implement this system, you can assume a valid price is always available).
Please use an object oriented language of your choice to implement a system that allows the Bank to:

1) Build up the portfolio from their transaction history (buy and sell transactions where a certain number of each instrument
    can be bought or sold on a given date)

2) Calculate the current value of the portfolio either in US Dollars or in Euros.  The value of each instrument held is simply 
   the amount currently held multiplied by the current price.

3) Calculate the profit and loss of each of the investments in the portfolio assuming it can be calculated simply by:
	PnL = current holding * (current price - purchase price)

4) No "short" positions are to be allowed in the system


Notes:
* You DO NOT need to implement a UI for this system.
* You can assume that the transaction history data is already given to you (you do not need to write code to load it from a file, database or similar source).
* All the rules the company requires are given above.  There are no other rules to apply.
 
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Create stocks and add to list
		ArrayList<Stock> listStocks = new ArrayList<Stock>();
		
		Stock stock1 = new Stock("AAPL");
		stock1.setUnits(5);
		stock1.setCurrentPrice(20.5);
		stock1.setOpenPrice(16);
		
		Stock stock2 = new Stock("NIO");
		stock2.setUnits(2.5);
		stock2.setCurrentPrice(30);
		stock2.setOpenPrice(20);
		
		Stock stock3 = new Stock("NTDOY");
		stock3.setUnits(3);
		stock3.setCurrentPrice(50);
		stock3.setOpenPrice(60);
		
		listStocks.add(stock1);
		listStocks.add(stock2);
		listStocks.add(stock3);
		
		// Create bonds and add to list
		ArrayList<Bond> listBonds = new ArrayList<Bond>();
		
		Bond bond1 = new Bond("ARARGE320622");
		bond1.setNominal(100);
		bond1.setOpenPrice(10);
		bond1.setMarketPrice(11);
		
		listBonds.add(bond1);
		
		
		// Create Customer
		Customer customer1 = new Customer("MRX");
		

		// Create Portfolio
		Portfolio portfolio1 = new Portfolio("portfolio1",customer1,listStocks,listBonds, 50);
		
		portfolio1.showPortfolio();
		System.out.println("-------------------------");
		portfolio1.calculateCurrentValuePortfolio();
		System.out.println("-------------------------");
		portfolio1.calculatePnL();
		
	}
	
}
