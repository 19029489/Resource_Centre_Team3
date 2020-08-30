//Created by Huai Yu 24/8/2020
public class Deal {
	
	private String dealID;
	private String itemName;
	private String buyerEmail;
	private String sellerEmail;
	private double dealPrice;
	private String closeDate;
	private char validation;
	private String cancel;

	

	public Deal(String dealID, String itemName, String buyerEmail, String sellerEmail, double dealPrice,String closeDate) {
		this.dealID = dealID;
		this.itemName = itemName;
		this.buyerEmail = buyerEmail;
		this.sellerEmail = sellerEmail;
		this.dealPrice = dealPrice;
		this.closeDate = closeDate;
	}
	
	public Deal(String dealID, String itemName, String buyerEmail, String sellerEmail, double dealPrice,String closeDate, char validation) {
		this.dealID = dealID;
		this.itemName = itemName;
		this.buyerEmail = buyerEmail;
		this.sellerEmail = sellerEmail;
		this.dealPrice = dealPrice;
		this.closeDate = closeDate;
		this.validation = validation;
	}

	
	
	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public String getDealID() {
		return dealID;
	}

	public void setDealID(String dealID) {
		this.dealID = dealID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public double getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	
	public char getValidation() {
		return validation;
	}
	
	public void setValidation(char validation) {
		this.validation = validation;
	}
	
	@Override
	public String toString() {
		String dealMade = String.format("%-15s %-20s %-20s %-20s %-20.2f %-20s", dealID, itemName, sellerEmail, buyerEmail, dealPrice, closeDate);
		return dealMade;
	}
	
	
	
}
