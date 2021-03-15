package com.nagp.quotes;

public class Quote {
	QuoteBody quote;

	public Quote(QuoteBody quote) {
		this.quote=quote;
	}

	public QuoteBody getQuote() {
		return quote;
	}

	public void setQuote(QuoteBody quote) {
		this.quote = quote;
	}
	
}
