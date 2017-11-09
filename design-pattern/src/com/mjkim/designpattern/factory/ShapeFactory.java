package com.mjkim.designpattern.factory;

public class ShapeFactory {
	public Shape getShape(String shapeType) {
		if ("CIRCLE".equalsIgnoreCase(shapeType)) {
			return new Circle();
		}
		if ("RECTANGLE".equalsIgnoreCase(shapeType)) {
			return new Rectangle();
		}
		if ("SQUARE".equalsIgnoreCase(shapeType)) {
			return new Square();
		}
		return null;
	}

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();

	}
}
