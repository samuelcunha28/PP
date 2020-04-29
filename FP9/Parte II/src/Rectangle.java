public class Rectangle extends Square {
    // variaveis de instancia de rectangle
    private double height = 1.0;

    // construtor default de Rectangle
    public Rectangle() {
    }

    // construtor com boolean
    public Rectangle(boolean filled) {
        super(filled);
    }

    // construtor com string e boolean
    public Rectangle(String color, boolean filled) {
        super(color, filled);
    }

    // construtor com boolean e double
    public Rectangle(boolean filled, double width) {
        super(filled, width);
    }

    // construtor com String, boolean e double
    public Rectangle(String color, boolean filled, double width) {
        super(color, filled, width);
    }

    // GETTERS E SETTERS
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    double getArea() {
        return getWidth() * this.height;
    }

    @Override
    double getPerimeter() {
        return 2 * getWidth() + 2 * this.height;
    }

    @Override
    public String toString() {
        String text = "Altura : " + height + "\n"
                + "Area do retângulo: " + getArea() + "\n"
                + "Perimetro do retângulo: " + getPerimeter() + "\n";
        return text;
    }

    public String printRectangle() {
        return super.toString();
    }
}
