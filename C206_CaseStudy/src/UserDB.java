// Created by Haziq at 24/8/2020
import java.util.ArrayList;

public class UserDB extends User{
	
	public static ArrayList<User> userList = new ArrayList<User>();
	
	public UserDB(String a, String b, String c, String d){
		super(a, b, c,d);
	}
	
	public static void addUser(User a) {
		
		userList.add(a);
	}
	
	public static void viewAllUser() {
		
		if(!userList.isEmpty()) {
			for(int i = 0; i < userList.size(); i++) {
				System.out.println(String.format("Username: %s\nRole: %s\nEmail: %s\n\n", userList.get(i).getUsername(), userList.get(i).getRole(), userList.get(i).getEmail()));
			}
		}else {
			System.out.println("There are no users available.");
		}

	}
	
	public static void delUser(String name) {
		
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getUsername().equals(name)) {
				userList.remove(i);
			}
		}
	}
	
	
}
