package Container_Implementation;

import Exceptions.BoxException2;
import order.exceptions.BoxException;
import order.packing.IBox;

/**
 * This class implements {@link IBox}.
 *
 * Nome: José Pedro Fernandes 
 * Número: 8190239 
 * Turma: LEI T4
 *
 * Nome: Hugo Maia Alves
 * Número: 8160521
 * Turma: LEIT2
 * 
 */
public class Box implements IBox {

    /**
     * The Box's length.
     */
    private int length;

    /**
     * The Box's depth.
     */
    private int depth;

    /**
     * The Box's height.
     */
    private int height;

    /**
     * The Box's volume.
     */
    private int volume;

    /**
     * Creates an instance of <code>Box</code>
     *
     * @param depth The Box's depth.
     * @param height The Box's height.
     * @param length The Box's length.
     * @throws order.exceptions.BoxException if any parameter is less or equal to 0.
     */
    public Box(int length, int depth, int height) throws BoxException {
        if (depth <= 0) {
            throw new BoxException2("Invalid \"depth\" value");
        }

        if (length <= 0) {
            throw new BoxException2("Invalid \"length\" value");
        }

        if (height <= 0) {
            throw new BoxException2("Invalid \"height\" value");
        }

        this.depth = depth;

        this.height = height;

        this.length = length;

        this.volume = depth * height * length;
    }

    /**
     * Getter of the attribute {@link Box#depth depth}.
     *
     * @return The {@link Box#depth depth}.
     */
    @Override
    public int getDepth() {
        return this.depth;
    }

    /**
     * Getter of the attribute {@link Box#height height}.
     *
     * @return The {@link Box#height height}.
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Getter of the attribute {@link Box#length length}.
     *
     * @return The {@link Box#length length}.
     */
    @Override
    public int getLenght() {
        return this.length;
    }

    /**
     * Getter of the attribute {@link Box#volume volume}.
     *
     * @return The {@link Box#volume volume}.
     */
    @Override
    public int getVolume() {
        return this.volume;
    }

    /**
     * Returns a string representation of {@link Box box}.
     *
     * @return String with every information about {@link Box box}.
     */
    @Override
    public String toString() {
        return "Depth: " + depth + "\nHeight: " + height + "\nLength: " + length + "\nVolume: " + volume;
    }
}
