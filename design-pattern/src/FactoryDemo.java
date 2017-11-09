interface Shape {
	void draw();
}

class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing a circle");
	}
}

class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing a rectangle");
	}
}

class ShapeFactory {
	public Shape getShape(String type) {
		if ("CIRCLE".equalsIgnoreCase(type)) {
			return new Circle();
		}
		if ("SQUARE".equalsIgnoreCase(type)) {
			return new Square();
		}

		return null;
	}
}

public class FactoryDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		Shape shape2 = shapeFactory.getShape("SQUARE");
		shape2.draw();
	}
}
