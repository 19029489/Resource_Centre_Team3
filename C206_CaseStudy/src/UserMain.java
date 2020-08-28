// Created by Haziq at 28/8/2020
public class UserMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean noRepeat = false;
		
		// User Dummy
		User dummy1 = new User("buyer","Buyer","buyer@buyer.com", "member");
		User dummy2 = new User("admin","Admin","admin@admin.com", "admin");
		User dummy3 = new User("seller","Seller","seller@seller.com", "seller");
		
		UserDB.addUser(dummy1);
		UserDB.addUser(dummy2);
		UserDB.addUser(dummy3);
		
		
		int option = 0;
		while(noRepeat == false) {
			boolean noRepeatLogged = false;
			userMenu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
				// Login to an account
				String email = Helper.readString("Enter email > ");
				String password = Helper.readString("Enter password > ");
				boolean loginCheck = UserDB.login(email, password);
				
				
				// For now, Buyer and Seller menu are exactly the same as they can't be linked to anything here. Once combined, there will be other functions.
				if(loginCheck == true) {
					for(int i = 0; i < UserDB.userList.size(); i++) {
						 
						if(UserDB.userList.get(i).getEmail().equals(email) && UserDB.userList.get(i).getRole().equalsIgnoreCase("Seller")) {
							// If logged in as a Seller, display Seller menu
							
							while(noRepeatLogged == false) {
								loggedInMenuSeller();
								int memOption = Helper.readInt("Enter an option > ");
								
								if(memOption == 1) {
									// View all users
									setHeader("USER LIST");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									
									System.out.println(output);
									
								}else if(memOption == 2) {
									// Search user
									setHeader("SEARCH USER");
									String sMail = Helper.readString("Enter email > ");
									System.out.println(String.format("%-30s %-20s %-10s %-5s", "EMAIL", "USERNAME","ROLE", "BLOCKED"));
									UserDB.searchUser(sMail);
									
								}else if(memOption == 3) {
									// Update account
									setHeader("UPDATE ACCOUNT");
									String nName = Helper.readString("Enter new name > ");
									String nPassword = Helper.readString("Enter new password > ");
									System.out.println(UserDB.updateUser(UserDB.userList.get(i).getEmail(), nName, nPassword));
								
								}else if(memOption == 4) {
									// Log out
									System.out.println("Logged out, you have.");
									noRepeatLogged = true;
								}
							}
						
						}else if(UserDB.userList.get(i).getEmail().equals(email) && UserDB.userList.get(i).getRole().equalsIgnoreCase("Buyer")) {
							// If logged in as a Buyer, display Buyer menu
							
							while(noRepeatLogged == false) {
								loggedInMenuBuyer();
								int memOption = Helper.readInt("Enter an option > ");
								
								if(memOption == 1) {
									// View all users
									setHeader("USER LIST");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									
									System.out.println(output);
									
								}else if(memOption == 2) {
									// Search user
									setHeader("SEARCH USER");
									String sMail = Helper.readString("Enter email > ");
									System.out.println(String.format("%-30s %-20s %-10s %-5s", "EMAIL", "USERNAME","ROLE", "BLOCKED"));
									UserDB.searchUser(sMail);
									
								}else if(memOption == 3) {
									// Update account
									setHeader("UPDATE ACCOUNT");
									String nName = Helper.readString("Enter new name > ");
									String nPassword = Helper.readString("Enter new password > ");
									System.out.println(UserDB.updateUser(UserDB.userList.get(i).getEmail(), nName, nPassword));
								
								}else if(memOption == 4) {
									// Log out
									System.out.println("Logged out, you have.");
									noRepeatLogged = true;
								}
							}
						}else if(UserDB.userList.get(i).getEmail().equals(email) && UserDB.userList.get(i).getRole().equalsIgnoreCase("Admin")) {
							// If logged in as an Admin, display Admin menu
							
							while(noRepeatLogged == false) {
								loggedInMenuAdmin();
								int adminOption = Helper.readInt("Enter an option > ");
								
								if(adminOption == 1) {
									// View all users
									setHeader("USER LIST");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									
									System.out.println(output);
								}else if(adminOption == 2) {
									// Search user
									setHeader("SEARCH USER");
									String sMail = Helper.readString("Enter email > ");
									System.out.println(String.format("%-30s %-20s %-10s %-5s", "EMAIL", "USERNAME","ROLE", "BLOCKED"));
									UserDB.searchUser(sMail);
								}else if(adminOption == 3) {
									// Update account
									setHeader("UPDATE ACCOUNT");
									String nName = Helper.readString("Enter new name > ");
									String nPassword = Helper.readString("Enter new password > ");
									System.out.println(UserDB.updateUser(UserDB.userList.get(i).getEmail(), nName, nPassword));
									
								}else if(adminOption == 4) {
									// Block a user
									setHeader("BLOCK/UNBLOCK USER");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									System.out.println(output);
									
									String bMail = Helper.readString("Enter email to block/unblock > ");
									
									boolean blockCheck = false;
									while(blockCheck == false) {
										String block = Helper.readString("Block or Unblock? > ");
										if(block.equalsIgnoreCase("block")) {
											UserDB.block(UserDB.userList.get(i), bMail, true);
											blockCheck = true;
										}else if(block.equalsIgnoreCase("unblock")){
											UserDB.block(UserDB.userList.get(i), bMail, false);
											blockCheck = true;
										}
									}
									
								}else if(adminOption == 5) {
									// Delete user
									setHeader("DELETE USER");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									System.out.println(output);
									
									String dMail = Helper.readString("Enter email to delete > ");
									if(!UserDB.userList.get(i).getEmail().equals(dMail)) {
										UserDB.delUser(dMail);
									}else {
										System.out.println("You cannot delete your own account.");
									}
									
								}else if(adminOption == 6) {
									// Log out
									System.out.println("Logged out, you have.");
									noRepeatLogged = true;
								}
							}
							
							
						}
					}
				}
				
			}else if(option == 2) {
				// Register an account
				userRegister();
				//UserDB.addUser(user);
			}else if(option == 3) {
				System.out.println("Fare thee well!");
				noRepeat=true;
			}else {
				System.out.println("Invalid option.");
			}
		}
	}
	
	/* METHODS FOR USER - START */
	
	public static void userMenu() {
		setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}
	
	public static void loggedInMenuSeller() {
		setHeader("Campus Online Auction Shop (COAS) - Seller Menu");
		System.out.println("1. View all users");
		System.out.println("2. Search user");
		System.out.println("3. Update account");
		System.out.println("4. Log out");
		Helper.line(80, "-");
	}
	
	public static void loggedInMenuBuyer() {
		setHeader("Campus Online Auction Shop (COAS) - Buyer Menu");
		System.out.println("1. View all users");
		System.out.println("2. Search user");
		System.out.println("3. Update account");
		System.out.println("4. Log out");
		Helper.line(80, "-");
	}
	
	public static void loggedInMenuAdmin() {
		setHeader("Campus Online Auction Shop (COAS) - Admin Menu");
		System.out.println("1. View all users");
		System.out.println("2. Search user");
		System.out.println("3. Update account");
		System.out.println("4. Block/Unblock a user");
		System.out.println("5. Delete a user");
		System.out.println("6. Log out");
		Helper.line(80, "-");
	}
	
	public static void userRegister() {
		String email = Helper.readString("Enter email > ");
		String username = Helper.readString("Enter username > ");
		
		boolean roleCheck = false;
		String role = "";
		
		while(roleCheck == false) {
			role = Helper.readString("Enter your role (Buyer/Seller/Admin) > ");
			if(role.equals("Seller") || role.equals("Buyer") || role.equals("Admin")) {
				roleCheck = true;
			}
		}
		
		String password = Helper.readString("Enter your desired password > ");
		
		User user = new User(username, role, email, password);

		if(UserDB.userList.size() < 5) {
			UserDB.addUser(user);
			System.out.println("Registration successful.");
		}else {
			
			System.out.println("Max users reached.");
		}
			
		
		//return user;
		
	}
	
	/* METHODS FOR USER - END */
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}


