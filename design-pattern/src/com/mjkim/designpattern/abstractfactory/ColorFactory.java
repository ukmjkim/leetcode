package com.mjkim.designpattern.abstractfactory;

public class ColorFactory extends AbstractFactory {
	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	public Color getColor(String colorType) {
		if ("RED".equalsIgnoreCase(colorType)) {
			return new Red();
		}
		if ("GREEN".equalsIgnoreCase(colorType)) {
			return new Green();
		}
		if ("BLUE".equalsIgnoreCase(colorType)) {
			return new Blue();
		}
		return null;
	}
}
