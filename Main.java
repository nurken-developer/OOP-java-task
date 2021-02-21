package com.company;

public class Main {

    public static void main(String[] args) {

        Shape s1 = new Circle(5.5, "red", false); // Upcast Circle to Shape
        System.out.println(s1); // which version?
        System.out.println(s1.getArea()); // which version?
        System.out.println(s1.getPerimeter()); // which version?
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        System.out.println(((Circle) s1).getRadius());
        Circle c1 = (Circle)s1; // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());
        Shape s2 = new Shape() {
            @Override
            public double getArea() {
                return this.getArea();
            }

            @Override
            public double getPerimeter() {
                return this.getPerimeter();
            }

            @Override
            public double getSide() {
                return this.getSide();
            }
        };
        Shape s3 = new Rectangle(1.0, 2.0, "red", false); // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        System.out.println(((Rectangle) s3).getLength());
        Rectangle r1 = (Rectangle)s3; // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());
        Shape s4 = new Square(6.6); // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        System.out.println(((Square) s4).getSide());
// Take note that we downcast Shape s4 to Rectangle,
// which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        System.out.println(r2.getSide());
        System.out.println(r2.getLength());
// Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());

    }

    abstract static class Shape{
        protected String color = "red";
        protected boolean filled = true;

        Shape(){}

        Shape(String color, boolean filled){
            this.color = color;
            this.filled = filled;
        }

        public String getColor(){
            return this.color;
        }

        public void setColor(String color){
            this.color = color;
        }

        public boolean isFilled(){
            return this.filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        public abstract double getArea();
        public abstract double getPerimeter();

        public String toString(){
            return "Shape[color="+this.color+", filled="+this.filled+"]";
        }

        public abstract double getSide();
    }

    static class Circle extends Shape{
        protected double radius = 1.0;

        Circle(){}

        Circle(double radius){
            this.radius = radius;
        }

        Circle(double radius, String color, boolean filled){
            this.radius = radius;
            this.color = color;
            this.filled = filled;
        }

        public double getRadius(){
            return this.radius;
        }

        public void setRadius(double radius){
            this.radius = radius;
        }

        public double getArea(){
            return Math.PI * this.radius * this.radius;
        }

        public double getPerimeter(){
            return 2 * Math.PI * this.radius;
        }

        public String toString(){
            return "Circle[Shape[color="+this.color+", filled="+this.filled+"], radius="+this.radius+"]";
        }

        @Override
        public double getSide() {
            return this.getSide();
        }
    }

    static class Rectangle extends Shape{
        protected double width = 1.0;
        protected double length = 1.0;

        Rectangle(){}

        Rectangle(double width, double length){
            this.width = width;
            this.length = length;
        }

        Rectangle(double width, double length, String color, boolean filled){
            this.width = width;
            this.length = length;
            this.color = color;
            this.filled = filled;
        }

        public double getWidth(){
            return this.width;
        }

        public void setWidth(double width){
            this.width = width;
        }

        public double getLength(){
            return this.length;
        }

        public void setLength(double length){
            this.length = length;
        }

        public double getArea(){
            return getLength() * getWidth();
        }

        public double getPerimeter(){
            return 2 * (getWidth() + getLength());
        }

        public String toString(){
            return "Rectangle[Shape[color="+this.color+", filled="+this.filled+"], width="+this.width+", length="+this.length+"]]";
        }

        @Override
        public double getSide() {
            return this.getArea();
        }
    }

    static class Square extends Rectangle{
        Square(){}

        Square(double side){
            this.width = side;
            this.length = side;
        }

        Square(double side, String color, boolean filled){
            this.width = side;
            this.length = side;
            this.color = color;
            this.filled = filled;
        }

        public double getSide(){
            return this.width;
        }

        public void setSide(double side){
            this.width = side;
            this.length = side;
        }
        public void setWidth(double width) {
            this.width = width;
        }
        public double getWidth(){
            return this.width;
        }
        public String toString(){
            return "Square[rectangle[Shape[color="+this.color+", filled="+this.filled+"], width="+this.width+", length="+this.length+"]]]";
        }
    }
}
