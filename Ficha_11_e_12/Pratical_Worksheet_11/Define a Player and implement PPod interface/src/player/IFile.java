package player;

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

    /**
     * Indicates whether some other object is "equal to" this one, that is, if
     * the other object is an instance of <code>File</code> and all its asttributes
     * are the same as this object
     *
     * @param obj The reference object with which to compare
     * @return <code>true</code>if this object is "the same" as the
     * <code>obj</code>, <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object obj);
}
