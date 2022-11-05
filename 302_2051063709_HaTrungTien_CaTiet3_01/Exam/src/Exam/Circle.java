package Exam;

public class Circle {
	private double radius = 1;
	private String color = "red";
	@Override
	public String toString() {
		return "Circle with radius= " + radius + ", and color = " + color;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Circle(double radius, String color) {
		super();
		this.radius = radius;
		this.color = color;
	}
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getArea() {
		return this.radius*this.radius * Math.PI;
	}
}
