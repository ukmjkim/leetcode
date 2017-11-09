package com.mjkim.designpattern.abstractfactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if ("SHAPE".equalsIgnoreCase(choice)) {
			return new ShapeFactory();
		}
		if ("COLOR".equalsIgnoreCase(choice)) {
			return new ColorFactory();
		}

		return null;
	}

	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();

		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		Color color1 = colorFactory.getColor("RED");
		color1.fill();

	}
}
