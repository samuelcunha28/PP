public class Circle extends Shape {
    // variaveis de instancia de circle
    private double radius = 1.0;

    // contrutor default de circle
    public Circle() {
    }

    // construtor com boolean e double
    public Circle(boolean filled, double radius) {
        super(filled);
        this.radius = radius;
    }

    // construtor com String, boolean e double
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    // construtor com String e boolean
    public Circle(String color, boolean filled) {
        super(color, filled);
    }

    // GETTERS E SETTERS
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // metodo toString para imprimir
    @Override
    public String toString() {
        System.out.print(super.toString());
        String text = "Raio : " + radius + "\n"
                + "Area do circulo: " + getArea() + "\n"
                + "Perimetro do circulo : " + getPerimeter() + "\n";
        return text;
    }

    public String printCircle() {
        return super.toString();
    }

}
