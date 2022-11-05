package Exam;

public class Cylinder extends Circle{
	private double height = 1;

	public Cylinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cylinder(double radius, String color) {
		super(radius, color);
		// TODO Auto-generated constructor stub
	}

	public Cylinder(double radius, String color, double height) {
		super(radius, color);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public double getVolume() {
		return getArea()*this.height;
	}

	@Override
	public String toString() {
		return "Cylinder with radius = " + getRadius() + " which is a subclass of " + "Circle with radius = " + getRadius() + ", and color = " + getColor();
	}
}
