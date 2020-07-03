package player;

import java.util.Objects;

/**
 * <h1> Classe utilizada para armazenar a informação relativa a um ficheiro {@link File} </h1>
 *
 * <h2>
 * ESTG - Escola Superior de Tecnologia e Gestão <br>
 * IPP - Instituto Politécnico do Porto <br>
 * PP - Paradigmas da Programação <br>
 * </h2>
 *
 * <h3>
 * LEI - Licenciatura em Engenharia Informática <br>
 * LSIRC - Licenciatura em Segurança Informática e Redes de Computadores <br>
 * </h3>
 */
public class File implements IFile {

    private String name;
    private String extension;
    private int sizeKb;
    private int durationSecs;

    public File() {
    }

    public File(String name, String extension, int sizeKb, int durationSecs) {
        this.name = name;
        this.extension = extension;
        this.sizeKb = sizeKb;
        this.durationSecs = durationSecs;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getExtension() {
        return extension;
    }

    @Override
    public int getSizeKB() {
        return sizeKb;
    }

    @Override
    public int getDurationSecs() {
        return durationSecs;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                ", sizeKb=" + sizeKb +
                ", durationSecs=" + durationSecs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return sizeKb == file.sizeKb &&
                durationSecs == file.durationSecs &&
                name.equals(file.name) &&
                extension.equals(file.extension);
    }

}
