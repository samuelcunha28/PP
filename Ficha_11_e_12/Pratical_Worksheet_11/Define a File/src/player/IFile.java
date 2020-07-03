package player;

/**
 * <h2>
 * Escola Superior de Tecnologia e Gestão (ESTG)<br>
 * Politécnico do Porto (PP)<br>
 * Licenciatura em Engenharia Informática (LEI)<br>
 * Licenciatura em Segurança Informática em Redes de Computadores (LSIRC)<br>
 * Paradigmas de Programação (PP)<br>
 * 2019 / 2020<br>
 * </h2>
 * <p>
 * Main file to solve ficha 11
 * </p>
 */
public interface IFile {

    /**
     * Gets the attribute name
     *
     * @return The file name
     */
    public String getName();

    /**
     * Gets the attribute  extension
     *
     * @return The file extension
     */
    public String getExtension();

    /**
     * Gets the attribute sizeKB
     *
     * @return The size in KB
     */
    public int getSizeKB();

    /**
     * Gets the attribute  durationSecs
     *
     * @return The file duration in seconds
     */
    public int getDurationSecs();

    /**
     * Returns a string representation of the object. In general, the toString
     * method returns a string that "textually represents" this object. The
     * result should be a concise but informative representation that is easy
     * for a person to read
     *
     * @return A string representation of the object
     */
    @Override
    public String toString();
}
