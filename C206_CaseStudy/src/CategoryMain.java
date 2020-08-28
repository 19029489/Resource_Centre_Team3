
public class CategoryMain {
	
	public static void main(String[] args) {
		
		Category cat1 = new Category("Foods");
		Category cat2 = new Category("Stationary");
		Category cat3 = new Category("Books");
		
		CategoryDB.addCategory(cat1);
		CategoryDB.addCategory(cat2);
		CategoryDB.addCategory(cat3);		
		

//			Login to an account
			userMenu();
			int optionUser = 0;
			optionUser = Helper.readInt("Enter an option > ");
			
			while (optionUser != 4) {
				if (optionUser == 1) {
//					Administrator
					categoryMenuAdmin();
					int optionAdmin = 0;
					optionAdmin = Helper.readInt("Enter an option > ");
					while (optionAdmin != 6) {
						if (optionAdmin == 1) {
//							View all category
							viewAllCategory();
						}
						else if (optionAdmin == 2) {
//							Search category
							setHeader("Search Catergory");
							String searchOption = Helper.readString("Enter the name of category > ");
							CategoryDB.searchCategoryDB(searchOption);
						}
						else if (optionAdmin == 3) {
//							Update category
							setHeader("Update Catergory");
							String updateOption = Helper.readString("Enter the name of category > ");
							String newOption = Helper.readString("Enter the new name of category > ");
							CategoryDB.updateCategory(updateOption, newOption);
						}
						else if (optionAdmin == 4) {
//							Delete category
							setHeader("Delete Catergory");
							String deleteOption = Helper.readString("Enter the name of category > ");
							CategoryDB.delCategory(deleteOption);								
						}
						else if (optionAdmin == 5) {
//							Category report
							categoryReport();
						}
						optionAdmin = Helper.readInt("Enter an option > ");
					}
				}
				
				else if (optionUser == 2) {
//					Seller
					categoryMenuSeller();
					int optionSeller = 0;
					optionSeller = Helper.readInt("Enter an option > ");
					while (optionSeller != 3) {
						if (optionSeller == 1) {
//							View all category
							viewAllCategory();
						}
						else if (optionSeller == 2) {
//							Search category
							setHeader("Search Catergory");
							String searchOption = Helper.readString("Enter the name of category > ");
							CategoryDB.searchCategoryDB(searchOption);
						}
					}
				}
				
				else if (optionUser == 3) {
//					Buyer
					categoryMenuBuyer();
					int optionBuyer = 0;
					optionBuyer = Helper.readInt("Enter an option > ");
					while (optionBuyer != 3) {
						if (optionBuyer == 1) {
//							View all category
							viewAllCategory();
						}
						else if (optionBuyer == 2) {
//							Search category
							setHeader("Search Catergory");
							String searchOption = Helper.readString("Enter the name of category > ");
							CategoryDB.searchCategoryDB(searchOption);
						}
					}
				}
			}
		}
		

		
		
		
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void userMenu() {
		setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. Administrator");
		System.out.println("2. Seller");
		System.out.println("3. Buyer");
		System.out.println("4. Return");
		Helper.line(80, "=");
	}
	
	public static void categoryMenuAdmin() {
		setHeader("Campus Online Auction Shop (COAS) - Administrator Menu");
		System.out.println("1. View all category");
		System.out.println("2. Search category");
		System.out.println("3. Update category");
		System.out.println("4. Delete category");
		System.out.println("5. Category report");
		System.out.println("6. Logout");
		Helper.line(80, "-");
	}
	
	public static void categoryMenuSeller() {
		setHeader("Campus Online Auction Shop (COAS) - Seller Menu");
		System.out.println("1. View all category");
		System.out.println("2. Search category");
		System.out.println("3. Logout");
		Helper.line(80, "-");
	}
	
	public static void categoryMenuBuyer() {
		setHeader("Campus Online Auction Shop (COAS) - Buyer Menu");
		System.out.println("1. View all category");
		System.out.println("2. Search category");
		System.out.println("3. Logout");
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
		System.out.println("9. Return");
		Helper.line(80, "-");
	}
	
	public static void viewAllCategory() {
		setHeader("Catergory List");
		CategoryDB.viewAllCategory();
	}



}


