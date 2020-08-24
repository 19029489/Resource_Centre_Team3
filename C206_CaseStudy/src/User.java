// Created by Haziq at 24/8/2020

public class User {
	private String username;
	private String role;
	private String email;
	private String password;
	
	public User(String a, String b, String c, String d){
		username = a;
		role = b;
		email = c;
		password = c;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", role=" + role + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
