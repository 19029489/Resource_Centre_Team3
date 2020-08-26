// Created by Haziq at 24/8/2020
import java.util.ArrayList;

public class UserDB extends User{
	
	public static ArrayList<User> userList = new ArrayList<User>();
	
	public UserDB(String a, String b, String c, String d){
		super(a, b, c,d);
	}
	
	public static void addUser(User a) {
		
		if(userList.size() <= 4) {
			userList.add(a);
		}
		
	}
	
	/* VIEW ALL USERS */
	
	public static String viewAllUser() {
		
		String allUsers = "";
		if(!userList.isEmpty()) {
			for(int i = 0; i < userList.size(); i++) {
				allUsers += String.format("%-30s %-20s %-10s %-5s\n", userList.get(i).getEmail(), userList.get(i).getUsername(), userList.get(i).getRole(), showAvailability(userList.get(i).isBlocked()));
			}
		}else {
			
			allUsers += "There are no users available.";
		}
		
		return allUsers;

	}
	
	/* DELETE USER */
	
	public static void delUser(String email) {
		
		boolean check = false;
			for(int i = 0; i<userList.size(); i++) {
				if(userList.get(i).getEmail().equals(email)) {
					userList.remove(i);
					check = true;
				}
				
			}
		if(check == false) {
			System.out.println("Email does not exist.");
		}else {
			System.out.println("Account successfully deleted.");
		}

	}
	
	/* SEARCH USER */
	
	public static boolean searchUser(String email) {
		
		boolean check = false;
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getEmail().equals(email)) {
				System.out.println(String.format("%-30s %-20s %-10s %-5s\n", userList.get(i).getEmail(), userList.get(i).getUsername(), userList.get(i).getRole(), showAvailability(userList.get(i).isBlocked())));
				check = true;
				
			}
			
		}
		
		if(check == false) {
			System.out.println("No user with that email exists.");
		}
		
		return check;
	
	}
	

	/* LOGIN */
	
	public static boolean login(String email, String password) {
		boolean check = false;
		
		String msg="";
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).isBlocked() == true) {
				msg = "This user is currently blocked. Please contact your local admin.";
			}else if(userList.get(i).getEmail().equalsIgnoreCase(email) && userList.get(i).getPassword().equals(password)) {
				check = true;
				msg = "Login successful.";
			}
			
		}
		
		if(check == false && msg.equals("")) {
			msg = "Login failed.";
		}
		
		System.out.println(msg);
		return check;
		
	}
	
	/*UPDATE USER*/
	
	public static String updateUser(String email, String name, String pWord) {
		
		String msg = "";
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getEmail().equals(email)) {
				if(!name.equals(userList.get(i).getUsername()) && !pWord.equals(userList.get(i).getPassword())) {
					userList.get(i).setUsername(name);
					userList.get(i).setPassword(pWord);
					msg = "Update successful.";
				}else {
					msg = "Please do not use the same username and password.";
				}
			}
		}
		
		return msg;
		
		
	}
	
	/* BLOCK USER */
	
	public static boolean block(User admin, String memEmail, boolean block){
		boolean status = false;
		
		if(admin.getRole().equals("Admin")) {
			for(int i = 0; i<userList.size(); i++) {
				if(userList.get(i).getEmail().equals(memEmail) && !memEmail.equals(admin.getEmail())) {
					userList.get(i).setBlocked(block);
					status = true;
				}
			}
		}
		
		return status;
	}
	
	/* Show availability */
	
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
}
