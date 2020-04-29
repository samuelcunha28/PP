public class Square extends Shape {
    // variaveis de instancia de square
    private double width = 1.0;

    // construtor default de Square
    public Square() {
    }

    // construtor com boolean
    public Square(boolean filled) {
        super(filled);
    }

    // construtor com String e boolean
    public Square(String color, boolean filled) {
        super(color, filled);
    }

    // construtor com String, boolean e double
    public Square(String color, boolean filled, double width) {
        super(color, filled);
        this.width = width;
    }

    // construtor com boolean e double
    public Square(boolean filled, double width) {
        super(filled);
        this.width = width;
    }

    // GETTERS E SETTERS
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    double getArea() {
        return width * width;
    }

    @Override
    double getPerimeter() {
        return 4 * width;
    }

    @Override
    public String toString() {
        String text = "Largura : " + width + "\n"
                + "Area do quadrado: " + getArea() + "\n"
                + "Perimetro do quadrado : " + getPerimeter() + "\n";
        return text;
    }

    public String printSquare() {
        return super.toString();
    }
}
