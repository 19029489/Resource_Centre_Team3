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
				allUsers += String.format("Username: %s\nRole: %s\nEmail: %s\n", userList.get(i).getUsername(), userList.get(i).getRole(), userList.get(i).getEmail());
			}
		}else {
			
			allUsers += "There are no users available.";
		}
		
		return allUsers;

	}
	
	/* DELETE USER */
	
	public static void delUser(String name) {
		
		boolean check = false;
			for(int i = 0; i<userList.size(); i++) {
				if(userList.get(i).getUsername().equals(name)) {
					userList.remove(i);
					check = true;
				}
				
				
			}
		
		
		if(check == false) {
			System.out.println("Username does not exist.");
		}

	}
	
	/* SEARCH USER */
	
	public static boolean searchUser(String email) {
		
		boolean check = false;
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getEmail().equals(email)) {
				System.out.println(String.format("Username: %s\nRole: %s\nEmail: %s", userList.get(i).getUsername(), userList.get(i).getRole(), userList.get(i).getEmail()));
				check = true;
				
			}
			
		}
		
		if(check == false) {
			System.out.println("No user with that email exists.");
			return false;
		}else {
			return true;
		}
	
	}
	

	/* LOGIN */
	
	public static boolean login(String email, String password) {
		boolean check = false;
		
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getEmail().equalsIgnoreCase(email) && userList.get(i).getPassword().equals(password)) {
				check = true;
			}
			
		}
		
		return check;
		
	}
	
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
			}else {
				msg = "No user with that email";
			}	
		}
		
		return msg;
		
		
	}
	
	public static boolean block(String email, boolean block){
		boolean status = false;
		
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getEmail().equals(email) & userList.get(i).getRole().equals("Admin")) {
				userList.get(i).setBlocked(block);
				status = true;
			}
		}
		return status;
	}
	
}
