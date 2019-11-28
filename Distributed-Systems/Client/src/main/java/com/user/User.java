package com.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	// Client information 
	int userId;
	String userName;
	String email;
	String password;
	
	// User Password from Client
	private String hashedPassword;
	private String salt;

	public User() {

	}

	// For user information
	public User(int userId, String userName, String email, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;

	}
	
	// For log in screen
	public User(int userId, String userName, String email, String hashedPassword, String salt) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
	}

	// Generating getters and setters
	// Adding @JsonProperties to Getters
	@JsonProperty
	public int getUserId() {
		return userId;
	}

	@JsonProperty
	public String getUserName() {
		return userName;
	}

	@JsonProperty
	public String getEmail() {
		return email;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public String getHashedPassword() {
		return hashedPassword;
	}

	@JsonProperty
	public String getSalt() {
		return salt;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	// Displaying the information 
	@Override
	public String toString() {
		return "CLient{" + "ID Number" + userId + " Name: '" + userName + '\'' + " Email: '" + email + '\''
				+ " Password:'" + password + '\'' + " hashedPassword: " + hashedPassword + " salt: " + salt;
	}
}
