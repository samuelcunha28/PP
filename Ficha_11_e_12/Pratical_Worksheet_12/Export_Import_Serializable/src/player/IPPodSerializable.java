package player;

import java.io.IOException;

public interface IPPodSerializable {

    /**
     * Creates a backup file with the stored files
     *
     * @param path The path to create the file
     * @throws IOException Exception thrown when it is not possible to use the file
     */
    public void backup(String path) throws IOException;

    /**
     * Recovers data from a existing file
     *
     * @param path The path to the backup file
     * @throws IOException            Exception thrown when it is not possible to use the file
     * @throws ClassNotFoundException Exception thrown when could not convert to defined object
     */
    public void recover(String path) throws IOException, ClassNotFoundException;
}
