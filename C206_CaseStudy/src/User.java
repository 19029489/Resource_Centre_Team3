// Created by Haziq at 24/8/2020

public class User {
	private String username;
	private String role;
	private String email;
	private String password;
	
	public User(String a, String b, String c, String d){
		a = username;
		b = role;
		c = email;
		d = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String a) {
		a = username;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String a) {
		a = role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String a) {
		a = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String a) {
		a = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", role=" + role + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
