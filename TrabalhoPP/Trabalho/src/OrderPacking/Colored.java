package OrderPacking;

import order.packing.Color;
import order.packing.IColored;

/**
 *
 * @author samue
 */
public class Colored implements IColored {

    // variaveis de instancia
    private Color color;
    private Color colorEdge;

    public Colored() {
    }

    /**
     * Construtor de Colored
     * @param color cor (String)
     * @param colorEdge cor das bordas (String)
     */
    public Colored(Color color, Color colorEdge) {
        this.color = color;
        this.colorEdge = colorEdge;
    }
    
    /**
     * Metodo para obter a cor
     * @return cor do tipo Color
     */
    @Override
    public Color getColor() {
        return this.color;
    }
    
    /**
     * Metodo para atribuir a cor
     * @param color cor a atribuir
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Metodo para obter a cor das bordas
     * @return cor das bordas do tipo ColorEdge
     */
    @Override
    public Color getColorEdge() {
        return this.colorEdge;
    }

    /**
     * Metodo para atribuit a cor das bordas
     * @param colorEdge cor das bordas a atribuir
     */
    @Override
    public void setColorEdge(Color colorEdge) {
        this.color = colorEdge;
    }
    
    /**
     * Metodo toString para imprimir os atributos da classe
     * @return text a imprimir
     */
     @Override
    public String toString() {
        String text = "Color : " + color + "\n"
                + "Color Edge : " + colorEdge + "\n";
        return text;
    }
}