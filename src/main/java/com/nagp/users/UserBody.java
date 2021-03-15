package com.nagp.users;

public class UserBody {
	private String login;
	private String email;
	private String password;
	private String twitter_username;
	private String facebook_username;
	private String pic; 

	
	public UserBody(String login, String email, String password, String twitter_username, String facebook_username, String pic) {
		this.login=login;
		this.email=email;
		this.password=password;
		this.twitter_username=twitter_username;
		this.facebook_username=facebook_username;
		this.pic=pic;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTwitter_username() {
		return twitter_username;
	}
	public void setTwitter_username(String twitter_username) {
		this.twitter_username = twitter_username;
	}
	public String getFacebook_username() {
		return facebook_username;
	}
	public void setFacebook_username(String facebook_username) {
		this.facebook_username = facebook_username;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}

}
