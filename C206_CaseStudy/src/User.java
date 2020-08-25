// Created by Haziq at 24/8/2020

public class User {
	private String username;
	private String role;
	private String email;
	private String password;
	private boolean isBlocked;
	
	public User(String a, String b, String c, String d){
		username = a;
		role = b;
		email = c;
		password = c;
		isBlocked = false;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String a) {
		username = a;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String a) {
		role = a;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String a) {
		email = a;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String a) {
		password = a;
	}
	

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean a) {
		if(role.equals("Admin")) {
			isBlocked = a;
		}
		
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", role=" + role + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
