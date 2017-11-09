class Line {
	public void draw(int x1, int y1, int x2, int y2) {
		System.out.printf("Line from point A(%d:%d), to point B(%d:%d)\n", x1, y1, x2, y2);
	}
}

class Rectangle {
	public void draw(int x1, int y1, int width, int height) {
		System.out.printf("Rectangle with coordinate left-down point (%d:%d), width (%d) , height(%d)\n", x1, y1, width,
				height);
	}
}

public class AdapterBefore {
	public static void main(String[] args) {
		Object[] shapes = { new Line(), new Rectangle() };

		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;
		int width = 40, height = 40;

		for (Object shape : shapes) {
			if (shape instanceof Line) {
				((Line) shape).draw(x1, y1, x2, y2);
			} else if (shape instanceof Rectangle) {
				((Rectangle) shape).draw(x2, y2, width, height);
			}
		}
	}
}