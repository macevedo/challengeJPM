package jpchallenge.maxi;

public class Bond {
	
	private String ISIN;
	private int nominal;
	private double openPrice;
	private double marketPrice;
	
	public Bond(String ISIN) {
		this.ISIN = ISIN;
	}
	
	public String getISIN() {
		return ISIN;
	}
	
	public void setISIN(String isin) {
		this.ISIN = isin;
	}

	public int getNominal() {
		return nominal;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

}
