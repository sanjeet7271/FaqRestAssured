package com.nagp.createuserpojo;

public class CreateUser {
	CreateUserBody user;
	
	public CreateUser(CreateUserBody user) {
		this.user=user;
		
	}
	public CreateUserBody getUser() {
		return user;
	}

	public void setUser(CreateUserBody user) {
		this.user = user;
	}
	

}
