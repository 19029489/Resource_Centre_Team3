public class C206_CaseStudy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/* METHODS FOR USER - START */
	
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
	
	/* METHODS FOR USER - END */
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}


