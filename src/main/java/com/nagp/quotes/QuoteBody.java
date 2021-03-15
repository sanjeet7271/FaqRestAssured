package com.nagp.quotes;

public class QuoteBody {
	String author;
	String body;

	public QuoteBody(String author, String body) {
		this.author=author;
		this.body=body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
