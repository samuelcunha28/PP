import exceptions.InvalidContactNameException;
import exceptions.InvalidPhoneNumberException;
import phoneBook.Contact;
import phoneBook.IContact;

public class Task {

    public static void main(String[] args) {

        Contact contact1 = new Contact("Samuel", "Cunha", "919173267");
        System.out.println(contact1);

    }

}