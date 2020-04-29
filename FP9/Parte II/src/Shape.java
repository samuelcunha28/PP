abstract class Shape {
    // variaveis de intancia de shape
    private String color = "red";
    private boolean filled;

    // contrutor default de shape
    public Shape() {
    }

    // construtor com string, boolean
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // construtor com boolean
    public Shape(boolean filled) {
        this.filled = filled;
    }

    // GETTERS E SETTERS
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // metodo abstrato para obter a área
    abstract double getArea();

    // metodo abstrato para obter o perimetro
    abstract double getPerimeter();

    // metodo toString para imprimir
    public String toString() {
        String text = "Cor : " + color + "\n"
                + "Preenchido : " + filled + "\n";
        return text;
    }
}
