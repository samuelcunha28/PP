package phoneBook;

import exceptions.PhoneManagerException;

import java.io.IOException;

public interface IPhoneManager {

    /**
     * Add a {@link IContact contact} to the {@link IPhoneManager manager} <code>contactList</code>
     *
     * @param contact the {@link IContact contact} to add
     * @throws PhoneManagerException thrown when contact is invalid
     */
    void addContact(IContact contact) throws PhoneManagerException;

    /**
     * Remove a {@link IContact contact} from the {@link IPhoneManager manager} <code>contactList</code>
     *
     * @param phoneNumber the phone number of the {@link IContact contact} to remove
     * @return the removed {@link IContact contact}
     * @throws PhoneManagerException thrown when phone number is invalid or is not found or contact list is empty
     */
    IContact removeContact(String phoneNumber) throws PhoneManagerException;

    /**
     * Get a {@link IContact contact} from the {@link IPhoneManager manager}
     *
     * @param phoneNumber the phone number of the {@link IContact contact} to search for
     * @return {@link IContact contact}
     * @throws PhoneManagerException thrown when phone number is invalid or is not found or contact list is empty
     */
    IContact getContact(String phoneNumber) throws PhoneManagerException;

    /**
     * Get a textual representation of all {@link IInternationalContact internationalContact} considering a given {@link IContact contact} <code>firstName</code>
     *
     * @param name the {@link IContact contact} <code>firstName</code>
     * @return textual representation of all {@link IInternationalContact internationalContact} that respects the search criteria
     * @throws PhoneManagerException thrown when name is invalid or contact list is empty
     */
    String getForeignContactAsText(String name) throws PhoneManagerException;

    ;

    /**
     * Creates a backup json file with the stored files
     *
     * @param path The path to create the file
     * @throws IOException Exception thrown when it is not possible to use the file
     */
    public void backup(String path) throws IOException;

    /**
     * Recovers data from an existing json file
     *
     * @param path The path to the backup file
     * @throws IOException            Exception thrown when it is not possible to use the file
     * @throws ClassNotFoundException Exception thrown when could not convert to defined object
     */
    public void recover(String path) throws IOException, ClassNotFoundException;

}
