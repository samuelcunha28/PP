package phoneBook;

import exceptions.InvalidContactNameException;
import exceptions.InvalidPhoneNumberException;

public interface IContact {

    /**
     * Getter for the {@link IContact contact} <code>firstName</code>
     *
     * @return {@link IContact contact} <code>firstName</code>
     */
    String getFirstName();

    /**
     * Setter for the {@link IContact contact} <code>firstName</code>
     *
     * @param firstName the first name of the {@link IContact contact}
     * @throws InvalidContactNameException thrown when first name is not valid
     */
    void setFirstName(String firstName) throws InvalidContactNameException;

    /**
     * Getter for the {@link IContact contact} <code>lastName</code>
     *
     * @return {@link IContact contact} <code>lastName</code>
     */
    String getLastName();

    /**
     * Setter for the {@link IContact contact} <code>lastName</code>
     *
     * @param lastName the last name of the {@link IContact contact}
     * @throws InvalidContactNameException thrown when last name is not valid
     */
    void setLastName(String lastName) throws InvalidContactNameException;

    /**
     * Getter for the {@link IContact contact} <code>phoneNumber</code>
     *
     * @return {@link IContact contact} <code>phoneNumber</code>
     */
    String getPhoneNumber();

    /**
     * Setter for the {@link IContact contact} <code>phoneNumber</code>
     *
     * @param phoneNumber the phone number of the {@link IContact contact}
     * @throws InvalidPhoneNumberException thrown when phone number is not valid
     */
    void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException;

    /**
     * Returns a string representation of the object. In general, the toString
     * method returns a string that "textually represents" this object. The
     * result should be a concise but informative representation that is easy
     * for a person to read
     *
     * @return A string representation of the object
     */
    @Override
    String toString();

}
