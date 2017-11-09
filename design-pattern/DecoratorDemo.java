public class DecoratorDemo {
	public static void main(String[] args) {
		Email email = new Email("This email is for test");
		IEmail decoratedEmail = new SecureEmailDecorator(new ExternalEmailDecorator(email));
		System.out.println(decoratedEmail.getContents());
	}
}

interface IEmail {
	String getContents();
}

class Email implements IEmail {
	private String content;

	public Email(String content) {
		this.content = content;
	}

	@Override
	public String getContents() {
		return this.content;
	}
}

abstract class EmailDecorator implements IEmail {
	IEmail originalEmail;
}

class ExternalEmailDecorator extends EmailDecorator {
	private String content;

	public ExternalEmailDecorator(IEmail email) {
		this.originalEmail = email;
	}

	@Override
	public String getContents() {
		content = addCompanyInfo(originalEmail.getContents());
		return content;
	}

	private String addCompanyInfo(String original) {
		return original + "\n" + "Thank you for using our service";
	}
}

class SecureEmailDecorator extends EmailDecorator {
	private String content;

	public SecureEmailDecorator(IEmail email) {
		this.originalEmail = email;
	}

	@Override
	public String getContents() {
		content = encryptContent(originalEmail.getContents());
		return content;
	}

	private String encryptContent(String original) {
		return "encrynting start\n" + original + "\nencrynting end";
	}
}
