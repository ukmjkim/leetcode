package com.mjkim.designpattern.decorator2;

public class EmailSender {
	public void sendEmail(IEmail email) {
		IEmail decoratedEmail = new SecureEmailDecorator(new ExternalEmailDecorator(email));
		System.out.println(decoratedEmail.getContents());
	}

	public static void main(String[] args) {
		Email email = new Email("This email is for test");
		EmailSender sender = new EmailSender();
		sender.sendEmail(email);
	}
}
