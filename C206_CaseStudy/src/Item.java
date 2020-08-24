
//Created by Qayyum
public class Item {
	private String assetTag;
	private String item;
	private String description;
	private double minPrice;
	private String startDate;
	private String endDate;
	private double bidIncrement; 


	public Item(String assetTag, String item, String description, double minPrice, String startDate, String endDate, double bidIncrement) {
		this.assetTag = assetTag;
		this.description = description;
		this.item = item;
		this.minPrice = minPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bidIncrement = bidIncrement;
	
	}

	public String getAssetTag() {
		return assetTag;
	}
	
	public String item() {
		return item;
	}

	public String getDescription() {
		return description;
	}
	
	public double minPrice() {
		return minPrice;
	}

	public String startDate() {
		return startDate;
	}

	public String endDate() {
		return endDate;
	}

	public double bidIncrement() {
		return bidIncrement;
	}

	
}