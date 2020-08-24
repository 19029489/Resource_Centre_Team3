import java.util.ArrayList;

public class Bid {

	private String bidId;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double bidPrice;
	
	public Bid (String bidId, String itemName, String sellerEmail, String buyerEmail, double bidPrice){
		this.bidId = bidId;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.bidPrice = bidPrice;
	}
	
	public String getBidId() {
		return bidId;
	}
	
	public void setbidId(String bidId) {
		this.bidId = bidId;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getSellerEmail() {
		return sellerEmail;
	}
	
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	
	public String getBuyerEmail() {
		return buyerEmail;
	}
	
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	
	public double getBidPrice() {
		return bidPrice;
	}
	
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	

}
