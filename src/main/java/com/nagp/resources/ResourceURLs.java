package com.nagp.resources;

import com.nagp.config.ConfigReader;

/**
 * 
 * @author sanjeetpandit
 *
 */
public class ResourceURLs extends ConfigReader {

	private String getbaseURI;
	private String getActivity;
	private String followActivity;
	private String unfollowActivity;
	private String deleteActivity;
	private String getComments;
	private String getHideQuote;
	private String getAddQuote;
	private String getUser;

	public ResourceURLs() {
		setConfig();
	}

	/**
	 * @utility to read configuration property
	 */

	public void setConfig() {

		this.getbaseURI = prop.getProperty("URL");
		this.getActivity = prop.getProperty("getactivity");
		this.followActivity = prop.getProperty("follow");
		this.unfollowActivity= prop.getProperty("unfollow");
		this.deleteActivity=prop.getProperty("deleteactivity");
		this.getComments = prop.getProperty("comments");
		this.getHideQuote = prop.getProperty("hidequote");
		this.getAddQuote=prop.getProperty("addquote");
		this.getUser=prop.getProperty("user");

	}

	/**
	 * 
	 * @return Base URI
	 * 
	 */
	public String getBaseURI() {
		String baseURI = this.getbaseURI;
		return baseURI;
	}

	/**
	 * 
	 * @return resource URL for users
	 * 
	 */
	/* Resources for List */
	public String getResourceforActivity() {
		String getActivity = this.getActivity;
		return getActivity;
	}
	
	/**
	 * 
	 * @return resource URL for users
	 * 
	 */
	/* Resources for List */
	public String getFollowActivity() {
		String followActivity = this.followActivity;
		return followActivity;
	}

	/**
	 * 
	 * @return resource URL for users
	 * 
	 */
	/* Resources for List */
	public String getUnfollowActivity() {
		String unfollowActivity = this.unfollowActivity;
		return unfollowActivity;
	}

	/**
	 * 
	 * @return resource URL for users
	 * 
	 */
	/* Resources for List */
	public String deleteActivity() {
		String deleteActivity = this.deleteActivity;
		return deleteActivity;
	}

	/**
	 * 
	 * @return resource URL for comments
	 * 
	 */
	public String getResourceforComments() {
		String comments = this.getComments;
		return comments;
	}
	
	/**
	 * 
	 * @return resource URL for Hide Quote
	 * 
	 */
	public String getResourceforHideQuote() {
		String hideQuote = this.getHideQuote;
		return hideQuote;
	}
	/**
	 * 
	 * @return resource URL for Hide Quote
	 * 
	 */
	public String getResourceforAddQuote() {
		String addQuote = this.getAddQuote;
		return addQuote;
	}
	public String getResourceforGetUser() {
		String getUser = this.getUser;
		return getUser;
	}

}
