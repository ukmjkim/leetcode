package com.mjkim.designpattern.abstractfactory;

public class ShapeFactory extends AbstractFactory {
	@Override
	public Color getColor(String colorType) {
		return null;
	}

	@Override
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
}
