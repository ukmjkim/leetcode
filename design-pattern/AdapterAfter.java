interface IShape {
	void draw(int x1, int y1, int x2, int y2);
}

class LineComponent {
	public void draw(int x1, int y1, int x2, int y2) {
		System.out.printf("Line from point A(%d:%d), to point B(%d:%d)\n", x1, y1, x2, y2);
	}
}

class RectangleComponent {
	public void draw(int x1, int y1, int width, int height) {
		System.out.printf("Rectangle with coordinate left-down point (%d:%d), width (%d) , height(%d)\n", x1, y1, width,
				height);
	}
}

class LineAdapter implements IShape {
	private LineComponent adaptee;

	public LineAdapter(LineComponent line) {
		this.adaptee = line;
	}

	@Override
	public void draw(int x1, int y1, int x2, int y2) {
		adaptee.draw(x1, y1, x2, y2);
	}
}

class RectangleAdapter implements IShape {
	private RectangleComponent adaptee;

	public RectangleAdapter(RectangleComponent rectangle) {
		this.adaptee = rectangle;
	}

	@Override
	public void draw(int x1, int y1, int x2, int y2) {
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);
		adaptee.draw(x, y, width, height);
	}
}

public class AdapterAfter {
	public static void main(String[] args) {
		IShape[] shapes = { new RectangleAdapter(new RectangleComponent()), new LineAdapter(new LineComponent()) };

		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;

		for (IShape shape : shapes) {
			shape.draw(x1, y1, x2, y2);
		}
	}
}
