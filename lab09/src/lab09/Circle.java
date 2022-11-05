package lab09;


public class Circle {
   private double radius;
   private String color;

   public Circle() {
      this.radius = 1.0;
      this.color = "red";
      System.out.println("Construced a Circle with Circle()"); 
   }
   public Circle(double radius) {
      this.radius = radius;
      this.color = "red";
      System.out.println("Construced a Circle with Circle(radius)"); 
   }
   public Circle(double radius, String color) {
      this.radius = radius;
      this.color = color;
      System.out.println("Construced a Circle with Circle(radius, color)");  
   }

   public double getRadius() {
      return this.radius;
   }
   public String getColor() {
      return this.color;
   }
   public void setRadius(double radius) {
      this.radius = radius;
   }
   public void setColor(String color) {
      this.color = color;
   }
   public String toString() {
      return "Circle[radius=" + radius + ",color=" + color + "]";
   }

   public double getArea() {
      return radius * radius * Math.PI;
   }
}
