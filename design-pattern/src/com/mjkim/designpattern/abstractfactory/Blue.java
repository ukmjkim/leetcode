package com.mjkim.designpattern.abstractfactory;

public class Blue implements Color {
	@Override
	public void fill() {
		System.out.println("Blue::fill()");
	}
}
