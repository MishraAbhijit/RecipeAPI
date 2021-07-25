package com.recipeapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "response")

public class Response {

	@JacksonXmlProperty(localName = "ActCode")
	private String actCode;

	@JacksonXmlProperty(localName = "ErrorCode")
	private String errorCode;

	@JacksonXmlProperty(localName = "ErrorMessage")
	private String errorMessage;

	public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "Response [ActCode=" + actCode + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

	
}
