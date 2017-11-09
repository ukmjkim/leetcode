package com.mjkim.designpattern.decorator2;

public class SecureEmailDecorator extends EmailDecorator {
	private String content;

	public SecureEmailDecorator(IEmail basicEmail) {
		originalEmail = basicEmail;
	}

	@Override
	public String getContents() {
		content = encrypt(originalEmail.getContents());
		return content;
	}

	private String encrypt(String message) {
		String encryptedMessage = "encrypted:" + message;
		return encryptedMessage;
	}
}
