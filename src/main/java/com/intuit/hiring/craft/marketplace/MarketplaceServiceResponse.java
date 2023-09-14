package com.intuit.hiring.craft.marketplace;

public class MarketplaceServiceResponse {
	private String statusCode;
	
	public MarketplaceServiceResponse(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
