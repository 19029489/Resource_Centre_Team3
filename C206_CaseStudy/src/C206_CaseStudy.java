public class C206_CaseStudy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean noRepeat = false;
		
		// User Dummy
		User dummy1 = new User("member","Member","member@member.com", "member");
		User dummy2 = new User("admin","Admin","admin@admin.com", "admin");
		User dummy3 = new User("dummy3","Member","d3@hotmail.com", "pass3");
		
		UserDB.addUser(dummy1);
		UserDB.addUser(dummy2);
		UserDB.addUser(dummy3);
		
		
		int option = 0;
		while(noRepeat == false) {
			boolean noRepeatLogged = false;
			C206_CaseStudy.userMenu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
				// Login to an account
				String email = Helper.readString("Enter email > ");
				String password = Helper.readString("Enter password > ");
				boolean loginCheck = UserDB.login(email, password);
				
				if(loginCheck == true) {
					for(User users : UserDB.userList) {
						
						if(users.getEmail().equals(email) && users.getRole().equals("Member")) {
							// If logged in as a Member, display Member menu
							
							while(noRepeatLogged == false) {
								C206_CaseStudy.loggedInMenuMember();
								int memOption = Helper.readInt("Enter an option > ");
								
								if(memOption == 1) {
									// View all users
									C206_CaseStudy.setHeader("USER LIST");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									
									System.out.println(output);
									
								}else if(memOption == 2) {
									// Search user
									C206_CaseStudy.setHeader("SEARCH USER");
									String sMail = Helper.readString("Enter email > ");
									System.out.println(String.format("%-30s %-20s %-10s %-5s", "EMAIL", "USERNAME","ROLE", "BLOCKED"));
									UserDB.searchUser(sMail);
									
								}else if(memOption == 3) {
									// Update account
									C206_CaseStudy.setHeader("UPDATE ACCOUNT");
									String nName = Helper.readString("Enter new name > ");
									String nPassword = Helper.readString("Enter new password > ");
									System.out.println(UserDB.updateUser(users.getEmail(), nName, nPassword));
								
								}else if(memOption == 4) {
									// Log out
									System.out.println("Logged out, you have.");
									noRepeatLogged = true;
								}
							}
						
						}else if(users.getEmail().equals(email) && users.getRole().equals("Admin")) {
							// If logged in as an Admin, display Admin menu
							
							while(noRepeatLogged == false) {
								C206_CaseStudy.loggedInMenuAdmin();
								int adminOption = Helper.readInt("Enter an option > ");
								
								if(adminOption == 1) {
									// View all users
									C206_CaseStudy.setHeader("USER LIST");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									
									System.out.println(output);
								}else if(adminOption == 2) {
									// Search user
									C206_CaseStudy.setHeader("SEARCH USER");
									String sMail = Helper.readString("Enter email > ");
									System.out.println(String.format("%-30s %-20s %-10s %-5s", "EMAIL", "USERNAME","ROLE", "BLOCKED"));
									UserDB.searchUser(sMail);
								}else if(adminOption == 3) {
									// Update account
									C206_CaseStudy.setHeader("UPDATE ACCOUNT");
									String nName = Helper.readString("Enter new name > ");
									String nPassword = Helper.readString("Enter new password > ");
									System.out.println(UserDB.updateUser(users.getEmail(), nName, nPassword));
									
								}else if(adminOption == 4) {
									// Block a user
									C206_CaseStudy.setHeader("BLOCK USER");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									System.out.println(output);
									
									String bMail = Helper.readString("Enter email to block > ");
									
									boolean blockCheck = false;
									while(blockCheck == false) {
										String block = Helper.readString("Block or Unblock? > ");
										if(block.equalsIgnoreCase("block")) {
											UserDB.block(users, bMail, true);
											blockCheck = true;
										}else if(block.equalsIgnoreCase("unblock")){
											UserDB.block(users, bMail, false);
											blockCheck = true;
										}
									}
									
								}else if(adminOption == 5) {
									// Delete user
									C206_CaseStudy.setHeader("DELETE USER");
									String output = String.format("%-30s %-20s %-10s %-5s\n", "EMAIL", "USERNAME","ROLE", "BLOCKED");
									output += UserDB.viewAllUser();
									System.out.println(output);
									
									String dMail = Helper.readString("Enter email to delete > ");
									if(!users.getEmail().equals(dMail)) {
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
				C206_CaseStudy.userRegister();
				//UserDB.addUser(user);
			}else if(option == 3) {
				System.out.println("Fare thee well!");
				noRepeat=true;
			}else {
				System.out.println("Invalid option.");
			}
		}
	}
	
	public static void userMenu() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS)");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}
	
	public static void loggedInMenuMember() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS) - Member Menu");
		System.out.println("1. View all users");
		System.out.println("2. Search user");
		System.out.println("3. Update account");
		System.out.println("4. Log out");
		Helper.line(80, "-");
	}
	
	public static void loggedInMenuAdmin() {
		C206_CaseStudy.setHeader("Campus Online Auction Shop (COAS) - Admin Menu");
		System.out.println("1. View all users");
		System.out.println("2. Search user");
		System.out.println("3. Update account");
		System.out.println("4. Block a user");
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
			role = Helper.readString("Enter your role (Member/Admin) > ");
			if(role.equals("Member") || role.equals("Admin")) {
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
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}


