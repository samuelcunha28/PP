package Pod;

import Exceptions.FullMemoryException;
import Exceptions.NonSupportedException;
import Interfaces.PPodFunctions;
import java.io.*;

public class PPod implements PPodFunctions {
    /**
     * variaveis de instancia de Pod.PPod
     */
    private final int MAX = 20;
    private double memory = 100;
    private File files[] = new File[MAX];
    private double filledmemory = 0;
    private int filecount = 0;
    private int currentTrack;
    // private Shuffle.metodo metodo;

    /**
     * Construtor default de Pod.PPod
     */
    public PPod() {
        this.files = null;
        this.filledmemory = 0;
        this.filecount = 0;
        this.currentTrack = 0;
    }

    public PPod(double memory) {
        this.memory = memory;
    }

    /**
     * Construtor de Pod.PPod
     * @param files ficheiros que estao contidos no Pod.PPod
     * @param filledmemory memoria que esta preenchida
     * @param filecount numero de ficheiros que estao contidos no Pod.PPod
     * @param currentTrack ficheiro atual a ser reproduzido no Pod.PPod
     */
    public PPod(File[] files, double filledmemory, int filecount, int currentTrack) {
        this.files = files;
        this.filledmemory = filledmemory;
        this.filecount = filecount;
        this.currentTrack = currentTrack;
    }

    /**
     * Metodo para adicionar ficheiros ao Pod.PPod
     * @param file ficheiro a ser adicionado
     * @throws NullPointerException lançada excecao caso o ficheiro seja nulo
     * @throws IndexOutOfBoundsException lançada excecao caso o numero maximo de ficheiros for ultrapassado
     * @throws FullMemoryException lancada excecao caso a memoria esteja cheia
     */
    @Override
    public void addFile(File file) throws NullPointerException, IndexOutOfBoundsException, FullMemoryException {
        if (file == null) {
            throw new NullPointerException("Ficheiro nulo!");
        }
        if (filledmemory + file.getSize() > memory) {
            throw new FullMemoryException("A memoria esta cheia!");
        }
        if (filecount > files.length) {
            throw new IndexOutOfBoundsException("Numero de ficheiro maximo ultrapassado!");
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                filecount++;
                filledmemory = filledmemory + files[i].getSize();
                return;
            }
        }
    }

    /**
     * Metodo que elimina um ficheiro do Pod.PPod
     * @param index indice a ser eliminado
     * @throws ArrayIndexOutOfBoundsException lancada a excecao caso o index seja invalido
     * @throws NullPointerException lancada a excecao caso a posicao esteja vazia
     */
    @Override
    public void delete(int index) throws ArrayIndexOutOfBoundsException, NullPointerException {
        if (index > files.length) {
            throw new ArrayIndexOutOfBoundsException("Index invalido!");
        }
        if (files[index] == null) {
            throw new NullPointerException("A posicao esta vazia!");
        }
        files[index] = null;
        for (int i = index; i < (filecount - 1); i++) {
            files[i] = files[i + 1];
            files[filecount] = null;
        }
    }

    /**
     * Metodo para reproduzir um ficheiro do Pod.PPod
     * @param index index do ficheiro a ser reproduzido
     * @throws NonSupportedException lancada a excecao caso o ficheiro nao seja suportado
     * @throws NullPointerException lancada a excecao caso a posicao esteja vazia
     * @throws ArrayIndexOutOfBoundsException lancada a excecao caso o indice seja invalido
     */
    @Override
    public void playTrack(int index) throws NonSupportedException, NullPointerException, ArrayIndexOutOfBoundsException {
        if (index < MAX && index >= 0) {
            if (files[index] == null) {
                throw  new NullPointerException("A posicao esta vazia");
            }
            if (files[index].getExtention() != "mp3") {
                throw new NonSupportedException("Ficheiro nao suportado");
            }
            if (index >= files.length || index < 0) {
                throw new ArrayIndexOutOfBoundsException("Index invalido");
            }
            if (files[index].getExtention().equals("mp3")) {
                System.out.println(files[index].toString());
                currentTrack = index;
            }
        }
    }

    /**
     * Metodo que tenta reproduzir a faixa seguinte
     */
    @Override
    public void nextTrack() {
        int next;
        for (int i = currentTrack; i < MAX; i++) {
            try {
                next = currentTrack + 1;
                playTrack(next);
                return;
            } catch (NonSupportedException e) {
                System.out.println(e.getMessage());
                currentTrack++;
                continue;
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    /**
     * Metodo que tenta reproduzir a faixa anterior
     */
    @Override
    public void previousTrack() {
        int previous;
        for (int i = currentTrack; i >= 0; i--) {
            try {
                previous = currentTrack - 1;
                playTrack(previous);
                return;
            } catch (NonSupportedException e) {
                System.out.println(e.getMessage());
                currentTrack--;
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}