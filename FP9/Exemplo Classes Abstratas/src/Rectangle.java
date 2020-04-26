class Rectangle extends TwoDShape {
    // construtor default de Rectangle
    Rectangle() {
        super();
    }

    // construtor de Rectangle
    Rectangle(double w, double h) {
        // chamar construtor da superclasse
        super(w, h, "rectangle");
    }

    // construtor para quadrado
    Rectangle(double w) {
        // chamar construtor da superclasse
        super(w, "rectangle");
    }

    boolean isSquare() {
        if (getWidth() == getHeight()) return true;
        return false;
    }

    double area() {
        return getWidth() * getHeight();
    }
}
