
public class Deal {
	
	private String dealID;
	private String itemName;
	private String buyerEmail;
	private String sellerEmail;
	private double dealPrice;
	private String closeDate;

	public Deal(String dealID, String itemName, String buyerEmail, String sellerEmail, double dealPrice,String closeDate) {
		this.dealID = dealID;
		this.itemName = itemName;
		this.buyerEmail = buyerEmail;
		this.sellerEmail = sellerEmail;
		this.dealPrice = dealPrice;
		this.closeDate = closeDate;
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

	@Override
	public String toString() {
		return "Deal [dealID=" + dealID + ", itemName=" + itemName + ", buyerEmail=" + buyerEmail + ", sellerEmail="
				+ sellerEmail + ", dealPrice=" + dealPrice + ", closeDate=" + closeDate + "]";
	}
	
	
}
