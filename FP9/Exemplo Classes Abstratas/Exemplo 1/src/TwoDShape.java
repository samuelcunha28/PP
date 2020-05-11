abstract class TwoDShape {
    // variaveis de instancia de TwoDShape
    private double width;
    private double height;
    private String name;

    // construtor default de TwoDShape
    TwoDShape() {
        width = height = 0.0;
        name = "null";
    }

    // construtor parametrizado
    TwoDShape(double w, double h, String n) {
        width = w;
        height = h;
        name = n;
    }

    // construtor com largura e altura iguais
    TwoDShape(double x, String n) {
        width = height = x;
        name = n;
    }

    // GETTERS E SETTERS
    double getWidth() {
        return width;
    }

    void setWidth(double w) {
        width = w;
    }

    double getHeight() {
        return height;
    }

    void setHeight(double h) {
        height = h;
    }

    String getName() {
        return name;
    }

    void showDim() {
        System.out.println("Width and height are " + width + " and " + height);
    }

    // Agora area() é abstrata
    abstract double area();
}
