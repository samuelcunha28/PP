package Transport;
import transport.IBox;
import exceptions.BoxException;
import Exceptions.BoxExceptionImpl;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Box implements IBox {

    /**
     * The Box depth.
     */
    private int depth;
    
    /**
     * The Box height.
     */
    private int height;
    
    /**
     * The Box length.
     */
    private int length;
    
    /**
     * The Box volume.
     */
    private int volume;

    public Box(int depth, int height, int length, int volume) throws BoxException {
        if (depth >= 0) {
            this.depth = depth;
        } else {
            throw new BoxExceptionImpl("The value for depth is invalid");
        }
        
        if (height >= 0) {
            this.height = height;
        } else {
            throw new BoxExceptionImpl("The value for height is invalid");
        }
        
        if (length >= 0) {
            this.length = length;
        } else {
            throw new BoxExceptionImpl("The value for length is invalid");
        }
        
        this.depth = depth;
        this.height = height;
        this.length = length;
        this.volume = depth * height * length;
    }
    
    /**
     * Getter for depth.
     * @return The box depth.
     */
    @Override
    public int getDepth() {
        return this.depth;
    }
    
    /**
     * Getter for height.
     * @return The box height. 
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Getter for length.
     * @return The box length.
     */
    @Override
    public int getLength() {
        return this.length;
    }
    
    /**
     * Getter for volume
     * @return The box volume
     */
    @Override
    public int getVolume() {
        return this.volume;
    }
    
    /**
     * To String method representing the Box.
     * @return String with all the information about the box.
     */
    @Override
    public String toString() {
        return "Depth: " + depth + "\nHeight: " + height + "\nLength: " + length 
                + "\nVolume: " + volume;
    }
}