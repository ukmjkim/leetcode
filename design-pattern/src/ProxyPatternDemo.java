interface Image {
	void display();
}

class RealImage implements Image {
	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.printf("Displaying: %s\n", fileName);
	}

	private void loadFromDisk(String fileName) {
		System.out.printf("Loading: %s\n", fileName);
	}
}

class ProxyImage implements Image {
	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}

		realImage.display();
	}
}

public class ProxyPatternDemo {
	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

		image.display();

		System.out.println();
		System.out.println();

		image.display();
	}
}