class Triangle extends TwoDShape {
    // variaveis de instancia de Triangle
    private String style;

    // construtor default de Triangle
    Triangle() {
        super();
        style = "null";
    }

    // construtor para Triangle
    Triangle(String s, double w, double h) {
        super(w, h, "triagle");
        style = s;
    }

    // construtor para um Triangle isosceles
    Triangle(double x) {
        // chamar construtor da superclasse
        super(x, "triangle");
        style = "isosceles";
    }

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}
