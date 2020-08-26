package Transport;

import transport.IPosition;
import exceptions.PositionException;
import Exceptions.PositionExceptionImpl;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Position implements IPosition {

    /**
     * The Coordinate x.
     */
    private int x;

    /**
     * The Coordinate y.
     */
    private int y;

    /**
     * The Coordinate z.
     */
    private int z;

    /**
     * Constructor of Position.
     *
     * @param x The Coordinate x.
     * @param y The Coordinate y.
     * @param z The Coordinate z.
     * @throws PositionException if the coordinate is invalid
     */
    public Position(int x, int y, int z) throws PositionException {
        if (x >= 0) {
            this.x = x;
        } else {
            throw new PositionExceptionImpl("The value for x is invalid");
        }

        if (y >= 0) {
            this.y = y;
        } else {
            throw new PositionExceptionImpl("The value for y is invalid");
        }

        if (z >= 0) {
            this.z = z;
        } else {
            throw new PositionExceptionImpl("The value for z is invalid");
        }
    }

    /**
     * Getter for coordinate x.
     *
     * @return The coordinate x.
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Setter for coordinate x.
     *
     * @param i Cartesian coordinate x.
     * @throws PositionException if the value of the coordinate is lower than 0
     */
    @Override
    public void setX(int i) throws PositionException {
        if (i < 0) {
            throw new PositionExceptionImpl("The value for x is invalid");
        }
        this.x = i;
    }

    /**
     * Getter for coordinate y
     *
     * @return The coordinate y
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Setter for coordinate y.
     *
     * @param i Cartesian coordinate y.
     * @throws PositionException if the value of the coordinate is lower than 0
     */
    @Override
    public void setY(int i) throws PositionException {
        if (i < 0) {
            throw new PositionExceptionImpl("The value for y is invalid");
        }
        this.y = i;
    }

    /**
     * Getter for coordinate z
     *
     * @return The coordinate z 
     */
    @Override
    public int getZ() {
        return this.z;
    }

    /**
     * Setter for coordinate z.
     *
     * @param i Cartesian coordinate z.
     * @throws PositionException if the value of the coordinate is lower than 0
     */
    @Override
    public void setZ(int i) throws PositionException {
        if (i < 0) {
            throw new PositionExceptionImpl("The value for z is invalid");
        }
        this.z = i;
    }

    /**
     * To String method representing the Position.
     * @return String with all the information about the position.
     */
    @Override
    public String toString() {
        return "Position: " + "\nX: " + x + "\nY: " + y + "\nZ: " + z;
    }
}
