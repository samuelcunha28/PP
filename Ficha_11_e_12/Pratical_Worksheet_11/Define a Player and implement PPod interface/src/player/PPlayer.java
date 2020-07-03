package player;

import player.exceptions.InvalidFileException;
import player.exceptions.InvalidPlayerStateException;

public class PPlayer implements PPod {

    /*
    ToDo:
- Add instance variables
- Add default constructor
- Add interface methdos
*/
    private final int MAX = 20;
    private double memory = 100;
    private File files[] = new File[MAX];
    private double filledmemory = 0;
    private int filecount = 0;
    private int currentTrack;


    public PPlayer(double memory) {
        this.memory = memory;
    }

    public PPlayer() {

    }


    @Override
    public void addFile(IFile file) throws InvalidPlayerStateException, InvalidFileException {
        if (file == null) {
            throw new InvalidFileException("Ficheiro nulo!");
        }
        if (filledmemory + file.getSizeKB() > memory) {
            throw new InvalidPlayerStateException("A memoria esta cheia!");
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                filecount++;
                filledmemory = filledmemory + files[i].getSizeKB();
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
    public File deleteFile(int index) throws ArrayIndexOutOfBoundsException {
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
        return files[index] ;
    }

    /**
     * Metodo para reproduzir um ficheiro do Pod.PPod
     * @param index index do ficheiro a ser reproduzido
     * @throws InvalidFileException lancada a excecao caso o ficheiro nao seja suportado
     * @throws NullPointerException lancada a excecao caso a posicao esteja vazia
     * @throws ArrayIndexOutOfBoundsException lancada a excecao caso o indice seja invalido
     */
    @Override
    public void playTrack(int index) throws InvalidFileException, NullPointerException, ArrayIndexOutOfBoundsException {
        if (index < MAX && index >= 0) {
            if (files[index] == null) {
                throw  new NullPointerException("A posicao esta vazia");
            }
            if (files[index].getExtension() != "mp3") {
                throw new InvalidFileException("Ficheiro nao suportado");
            }
            if (index >= files.length || index < 0) {
                throw new ArrayIndexOutOfBoundsException("Index invalido");
            }
            if (files[index].getExtension().equals("mp3")) {
                System.out.println(files[index].toString());
                currentTrack = index;
            }
        }
    }

    /**
     * Metodo que tenta reproduzir a faixa seguinte
     */
    @Override
    public int nextTrack() {
        int next;
        for (int i = currentTrack; i < MAX; i++) {
            try {
                next = currentTrack + 1;
                playTrack(next);
                return 1;
            } catch (InvalidFileException e) {
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
        return 1;
    }

    /**
     * Metodo que tenta reproduzir a faixa anterior
     */
    @Override
    public int previousTrack() {
        int previous;
        for (int i = currentTrack; i >= 0; i--) {
            try {
                previous = currentTrack - 1;
                playTrack(previous);
                return 1;
            } catch (InvalidFileException e) {
                System.out.println(e.getMessage());
                currentTrack--;
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        return 1;
    }
}
