interface Button {
	void paint();
}

class MacOSButton implements Button {
	@Override
	public void paint() {
		System.out.println("You have created MacOSButton");
	}
}

class WindowsButton implements Button {
	@Override
	public void paint() {
		System.out.println("You have created WindowsButton");
	}
}

interface CheckBox {
	void paint();
}

class MacOSCheckBox implements CheckBox {
	@Override
	public void paint() {
		System.out.println("You have created MacOSCheckBox");
	}
}

class WindowsCheckBox implements CheckBox {
	@Override
	public void paint() {
		System.out.println("You have created WindowsCheckBox");
	}
}


interface GUIFactory {
	abstract Button createButton();

	abstract CheckBox createCheckBox();
}

class MacOSFactory implements GUIFactory {
	@Override
	public Button createButton() {
		return new MacOSButton();
	}

	@Override
	public CheckBox createCheckBox() {
		return new MacOSCheckBox();
	}
}

class WindowsFactory implements GUIFactory {
	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public CheckBox createCheckBox() {
		return new WindowsCheckBox();
	}
}

class Application {
	private Button button;
	private CheckBox checkbox;

	public Application(GUIFactory factory) {
		this.button = factory.createButton();
		this.checkbox = factory.createCheckBox();
	}

	public void paint() {
		this.button.paint();
		this.checkbox.paint();
	}
}

public class AbstractFactoryDemo {
	public static void main(String[] args) {

		String osName = System.getProperty("os.name").toLowerCase();

		GUIFactory factory;
		if (osName.contains("mac")) {
			factory = new MacOSFactory();
		} else {
			factory = new WindowsFactory();

		}
		Application application = new Application(factory);
		application.paint();
	}
}