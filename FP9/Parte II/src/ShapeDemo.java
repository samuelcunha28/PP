import java.util.Calendar;
import java.util.Date;

public class ShapeDemo {

    public static void main(String[] args) {
        Circle shape1 = new Circle("Blue", true, 2.0);
        // Imprimir diretamente a shape 1
        // System.out.println(shape1);

        Square shape2 = new Square("Purple", false, 5);
        // Imprimir diretamente a shape 2
        // System.out.println(shape2);

        Rectangle shape3 = new Rectangle("White", true, 3);
        // Imprimir diretamente a shape 3
        // System.out.println(shape3);

        // adicionar shapes ao array
        ShapeManagement list = new ShapeManagement();
        list.addShape(shape1);
        list.addShape(shape2);
        list.addShape(shape3);

        // editar shape
        list.setObject(1, shape1);

        // remover objetos do array
        // list.removeObject(0); // vai remover shape1 porque está na posicao 0 do array

        // Listar as shapes todas atraves de ShapeManagement através do método toString
        // System.out.println(list.toString());

        // Imprimir todas as shapes através de metodo especifico em ShapeManagement
        System.out.println(list.imprimir());

        // Imprimir somente circulos
        // System.out.println(list.imprimirCircle());

        // Imprimir somente quadrados
        // System.out.println(list.imprimirSquare());

        // Imprimir somente retangulos
        // System.out.println(list.imprimirRectangle());
    }
}
