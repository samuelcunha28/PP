package player;

import player.comparators.AscendingDurationComparator;
import player.exceptions.InvalidFileException;
import player.exceptions.InvalidPlayerStateException;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class PPlayer implements PPod, IPPodSerializable {

    /**
     * Number of global failures while adding files
     */
    public static int globalFailures = 0;



    @Override
    public void backup(String path) throws IOException {

    }

    @Override
    public void recover(String path) throws IOException, ClassNotFoundException {

    }

    @Override
    public void addFile(IFile file) throws InvalidPlayerStateException, InvalidFileException {

    }

    @Override
    public IFile deleteFile(int index) throws ArrayIndexOutOfBoundsException {
        return null;
    }

    @Override
    public void playTrack(int index) throws ArrayIndexOutOfBoundsException, InvalidFileException {

    }

    @Override
    public int nextTrack() {
        return 0;
    }

    @Override
    public int previousTrack() {
        return 0;
    }

    @Override
    public String list() {
        return null;
    }

    @Override
    public void shufflePlay() {

    }

}
