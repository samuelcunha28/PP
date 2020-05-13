public class ShapeManagement {
    private final int MAXSHAPES = 20;
    private Shape[] listshape = new Shape[MAXSHAPES];
    private int count = 0;

    // metodo para adicionar shapes
    public void addShape(Shape shape) {
        if (count < MAXSHAPES) {
            listshape[count] = shape;
            count += 1;
        } else {
            System.out.println("MAX Shapes");
        }
    }

    /*
    // metodo para adicionar shapes de forma + correta (so deixa adicionar se a area e o perimetro forem diferentes)
    public void addShape2(Shape shape) {
        boolean duplicated = false;
        Shape[] temp = new Shape[this.listshape.length + 1];

        for (int i = 0; i < this.count; i++) {
            if (shape.getArea() == this.listshape[i].getArea() || shape.getPerimeter() == this.listshape[i].getPerimeter()) {
                duplicated = true;
            }
        }
        if (this.count >= 0 && find(shape) == null && duplicated == false) {
            this.listshape[this.count] = shape;
            this.count++;
        }
    }
     */

    // metodo para encontrar shapes
    public Shape find(Shape shape) {
        Shape resp = null;
        for (int i = 0; i < this.count; i++) {
            if (shape.equals(this.listshape[i].toString())) {
                resp = this.listshape[i];
            }
        }
        return resp;
    }

    // metodo para remover um objeto (shape)
    public Shape removeObject(int position) {
        if (position < listshape.length && position != -1) {
            if (listshape[position] == null) {
                System.out.println("Objeto não existe");
                return null;
            } else {
                Object delete = listshape[position];
                listshape[position] = null;
                for (int i = position; i < (count - 1); i++) {
                    listshape[i] = listshape[i + 1];
                }
                count -= 1;
                listshape[count] = null;
                return (Shape) delete;
            }
        } else {
            System.out.println("Posição Inexistente");
            return null;
        }
    }

    /**
     * Metodo que substitui um objeto no array por um novo recebido Retorna true
     * se a operação foi um sucesso/false se falhou
     * @param position
     * @param shape
     * @return shape
     */
    protected boolean setObject(int position, Shape shape) {
        if (position < listshape.length) {
            if (listshape[position] == null) {
                System.out.println("Não existe nenhum objeto nesta postição.");
                return false;
            } else {
                listshape[position] = shape;
                return true;
            }

        } else {
            System.out.println("Posição Inexistente");
            return false;
        }

    }

    public String imprimir() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listshape[i] instanceof Circle) {
                Circle circle = (Circle) this.listshape[i];
                resp += circle.printCircle(); // imprime circulos
            } else if (this.listshape[i] instanceof Square) {
                Square square = (Square) this.listshape[i];
                resp += square.printSquare(); // imprime quadrados
            } else if (this.listshape[i] instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) this.listshape[i];
                resp += rectangle.printRectangle(); // imprime retangulos
            } else {
                resp += this.listshape[i].toString(); // imprime default (shape normal)
            }
            resp += "\n";
        }
        return resp;
    }

    // imprime circulos
    public String imprimirCircle() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listshape[i] instanceof Circle) {
                Circle circle = (Circle) this.listshape[i];
                resp += circle.printCircle();
            }
        }
        return resp;
    }

    // imprime quadrados
    public String imprimirSquare() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listshape[i] instanceof Square) {
                Square square = (Square) this.listshape[i];
                resp += square.printSquare();
            }
        }
        return resp;
    }

    // imprime retangulos
    public String imprimirRectangle() {
        String resp = "";
        for (int i = 0; i < this.count; i++) {
            if (this.listshape[i] instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) this.listshape[i];
                resp += rectangle.printRectangle();
            }
        }
        return resp;
    }

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += "Figura " + (i + 1) + " : " + "\n" + listshape[i].toString() + "\n";
        }
        return text;
    }
}
