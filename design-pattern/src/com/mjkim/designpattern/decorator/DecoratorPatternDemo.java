package com.mjkim.designpattern.decorator;

public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Shape rectangle = new Rectangle();
		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		Shape redCircle = new RedShapeDecorator(new Circle());

		rectangle.draw();
		redRectangle.draw();
		redCircle.draw();
	}
}
