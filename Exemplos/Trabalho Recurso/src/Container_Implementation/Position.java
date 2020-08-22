package Container_Implementation;

import Exceptions.PositionException2;
import order.exceptions.PositionException;
import order.packing.IPosition;

/**
 * This class implements {@link IPosition}.
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
public class Position implements IPosition {

    /**
     * Cartesian coordinate x.
     */
    private int x;

    /**
     * Cartesian coordinate y.
     */
    private int y;

    /**
     * Cartesian coordinate z.
     */
    private int z;

    /**
     * Creates an instance of <code>Position</code>
     *
     * @param x Cartesian coordinate x.
     * @param y Cartesian coordinate y.
     * @param z Cartesian coordinate z.
     * @throws order.exceptions.PositionException if any coordinate is invalid.
     */
    public Position(int x, int z, int y) throws PositionException {
        if (x >= 0) {
            this.x = x;
        } else {
            throw new PositionException2("Invalid \"x\" value");
        }

        if (y >= 0) {
            this.y = y;
        } else {
            throw new PositionException2("Invalid \"y\" value");
        }

        if (z >= 0) {
            this.z = z;
        } else {
            throw new PositionException2("Invalid \"z\" value");
        }

    }

    /**
     * Gets the attribute {@link Position#x x}.
     *
     * @return The {@link Position#x x}.
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Gets the attribute {@link Position#y y}.
     *
     * @return The {@link Position#y y}.
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Gets the attribute {@link Position#z z}.
     *
     * @return The {@link Position#z z}.
     */
    @Override
    public int getZ() {
        return this.z;
    }

    /**
     * Sets the attribute {@link Position#x x}.
     *
     * @param i Position that Cartesian coordinate x is to be set.
     * @throws order.exceptions.PositionException if x coordinate is lower than
     * 0.
     */
    @Override
    public void setX(int i) throws PositionException {
        if (i < 0) {
            throw new PositionException2("Invalid \"x\" position");
        }
        this.x = i;

    }

    /**
     * Sets the attribute {@link Position#y y}.
     *
     * @param i Position that Cartesian coordinate y is to be set.
     * @throws order.exceptions.PositionException if y coordinate is lower than
     * 0.
     */
    @Override
    public void setY(int i) throws PositionException {
        if (i < 0) {
            throw new PositionException2("Invalid \"y\" position");
        }
        this.y = i;

    }

    /**
     * Sets the attribute {@link Position#z z}.
     *
     * @param i Position that Cartesian coordinate z is to be set.
     * @throws order.exceptions.PositionException if z coordinate is lower than
     * 0.
     */
    @Override
    public void setZ(int i) throws PositionException {
        if (i < 0) {
            throw new PositionException2("Invalid \"z\" position");
        }
        this.z = i;

    }

    /**
     * Returns a string representation of {@link Position}.
     *
     * @return String with every information about {@link Position}.
     */
    @Override
    public String toString() {
        return "Position: " + "x: " + x + ", y: " + y + ", z: " + z;
    }
}
