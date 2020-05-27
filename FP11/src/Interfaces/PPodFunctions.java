package Interfaces;

import Exceptions.FullMemoryException;
import Exceptions.NonSupportedException;
import Pod.File;

public interface PPodFunctions {

    /**
     * Metodo para adicionar ficheiros
     * @param file
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     * @throws FullMemoryException
     */
    public void addFile(File file) throws NullPointerException, IndexOutOfBoundsException, FullMemoryException;

    /**
     * Metodo para remover ficheiros
     * @param index
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public void delete(int index)throws ArrayIndexOutOfBoundsException, NullPointerException;

    /**
     * Metodo de escolher a musica
     * @param index
     * @throws NonSupportedException
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public void playTrack(int index) throws NonSupportedException, ArrayIndexOutOfBoundsException, NullPointerException;

    /**
     * Metodo de escolher a musica seguinte
     */
    public void nextTrack();

    /**
     * metodo de escolher a musica anterior
     */
    public void previousTrack();
}
