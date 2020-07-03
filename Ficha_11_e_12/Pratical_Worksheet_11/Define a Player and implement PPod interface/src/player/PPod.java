package player;

import player.exceptions.InvalidFileException;
import player.exceptions.InvalidPlayerStateException;

public interface PPod {

    /**
     * Add a new <code>File</code> to the player
     *
     * @param file The {@link File file} to add
     * @throws InvalidFileException        Exception thrown when the {@link File file} is null or size is invalid
     * @throws InvalidPlayerStateException Exception thrown when the {@link File file} when the maximum number of files is achieved or memory is full
     */
    void addFile(IFile file) throws InvalidPlayerStateException, InvalidFileException;

    /**
     * Deletes a {@link File file} given its position in the player list
     *
     * @param index the index of the {@link File file}
     * @return The deleted {@link File file}
     * @throws ArrayIndexOutOfBoundsException Exception thrown when index is not valid
     */
    IFile deleteFile(int index) throws ArrayIndexOutOfBoundsException;

    /**
     * Play a given track given its index
     *
     * @param index the position of the {@link File file} in the track list
     * @throws ArrayIndexOutOfBoundsException Exception thrown when index is not valid
     * @throws InvalidFileException           Exception thrown when the file extension is not valid
     */
    void playTrack(int index) throws ArrayIndexOutOfBoundsException, InvalidFileException;

    /**
     * Plays the next valid track. If it is in last track then the player should return to inicial position.
     *
     * @return the index of the next valid track
     */
    int nextTrack();

    /**
     * Plays the valid previous track. If it is in first track then the player should return to last file position.
     *
     * @return the index of the previous valid track
     */
    int previousTrack();

}
