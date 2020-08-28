
public class CategoryMain {
	
	public static void main(String[] args) {
		
		Category cat1 = new Category("Foods");
		Category cat2 = new Category("Stationary");
		Category cat3 = new Category("Books");
		
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		CategoryDB.addCategory(cat3);		
		
		categoryMenu();
		int optionCategory = 0;
		optionCategory = Helper.readInt("Enter an option > ");
		
		while (optionCategory != 4) {
			
			if (optionCategory == 1) {
				
			}
			
			else if (optionCategory == 2) {
				
			}
			
			else if (optionCategory == 3) {
				
			}
		}
		
		
		
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void categoryMenu() {
		setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. Login");
		System.out.println("2. View All Category");
		System.out.println("3. Search Category");
		System.out.println("4. Quit");
		Helper.line(80, "=");
	}
	
	public static void userMenu() {
		setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. Admin");
		System.out.println("2. Seller");
		System.out.println("3. Buyer");
		System.out.println("4. Return");
		Helper.line(80, "=");
	}
	
	public static void categoryMenuSeller() {
		setHeader("Campus Online Auction Shop (COAS) - Seller Menu");
		System.out.println("1. View all category");
		System.out.println("2. Search category");
		System.out.println("3. Update category");
		System.out.println("4. Logout");
		Helper.line(80, "-");
	}
	
	public static void categoryMenuBuyer() {
		setHeader("Campus Online Auction Shop (COAS) - Buyer Menu");
		System.out.println("1. View all category");
		System.out.println("2. Search category");
		System.out.println("4. Logout");
		Helper.line(80, "-");
	}
	
	public static void categoryMenuAdmin() {
		setHeader("Campus Online Auction Shop (COAS) - Admin Menu");
		System.out.println("1. View all category");
		System.out.println("2. Search category");
		System.out.println("3. Update category");
		System.out.println("4. Delete category");
		System.out.println("5. Category report");
		System.out.println("6. Logout");
		Helper.line(80, "-");
	}
	
	public static void categoryReport() {
		setHeader("Campus Online Auction Shop (COAS) - Admin Menu");
		System.out.println("1. January 2020");
		System.out.println("2. February 2020");
		System.out.println("3. March 2020");
		System.out.println("4. April 2020");
		System.out.println("5. May 2020");
		System.out.println("6. June 2020");
		System.out.println("7. July 2020");
		System.out.println("8. Logout");
		Helper.line(80, "-");
	}
		


}


