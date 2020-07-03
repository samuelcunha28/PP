import exceptions.InvalidContactNameException;
import exceptions.InvalidPhoneNumberException;
import org.junit.Assert;
import org.junit.Test;
import phoneBook.Contact;
import phoneBook.IContact;

public class Tests {

    @Test
    public void createValidContact() {
        try {
            IContact c = new Contact("John", "Doe", "984736437");
            Assert.assertEquals("First name is not set properly", "John", c.getFirstName());
            Assert.assertEquals("Last name is not set properly", "Doe", c.getLastName());
            Assert.assertEquals("Phone number is not set properly", "984736437", c.getPhoneNumber());

            String ts = c.toString();
            Assert.assertTrue("toString is not including first name", ts.contains(c.getFirstName()));
            Assert.assertTrue("toString is not including last name", ts.contains(c.getLastName()));
            Assert.assertTrue("toString is not including phone number", ts.contains(c.getPhoneNumber()));

        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Creating a valid contact should not throw an exception");
        }
    }

    //----- TESTS FOR CONSTRUCTOR-------
    @Test
    public void createContactInvalidFirstNameNull() {
        try {
            new Contact(null, "Doe", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with null first name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidFirstNameEmpty() {
        try {
            new Contact("", "Doe", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with empty first name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidFirstNameFirstChar() {
        try {
            new Contact("john", "Doe", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with invalid first char of first name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidFirstNameMiddleChar() {
        try {
            new Contact("JOhn", "Doe", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with invalid middle char of first name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidFirstNameTwoWords() {
        try {
            new Contact("John ", "Doe", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with two words for first name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidLastNameNull() {
        try {
            new Contact("John", null, "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with null last name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidLastNameEmpty() {
        try {
            new Contact("John", "", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with empty last name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidLastNameFirstChar() {
        try {
            new Contact("John", "doe", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with invalid first char of last name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidLastNameMiddleChar() {
        try {
            new Contact("John", "DOe", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with invalid middle char of last name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidLastNameTwoWords() {
        try {
            new Contact("John", "Doe ", "984736437");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException ignored) {

        } catch (InvalidPhoneNumberException e) {
            Assert.fail("Creating a contact with two words for last name should throw an InvalidContactNameException");
        }
    }

    @Test
    public void createContactInvalidPhoneDigits() {
        try {
            new Contact("John", "Doe", "98473643");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException invalidContactNameExcpetion) {
            Assert.fail("Creating a contact with less than 9 digits should throw an InvalidContactNameException");
        } catch (InvalidPhoneNumberException ignored) {

        }
    }

    @Test
    public void createContactInvalidPhoneDigits2() {
        try {
            new Contact("John", "Doe", "9847364333");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException invalidContactNameExcpetion) {
            Assert.fail("Creating a contact with more than 9 digits should throw an InvalidContactNameException");
        } catch (InvalidPhoneNumberException ignored) {

        }
    }

    @Test
    public void createContactInvalidPhoneDigitsEmpty() {
        try {
            new Contact("John", "Doe", "");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException invalidContactNameExcpetion) {
            Assert.fail("Creating a contact with empty phone number should throw an InvalidContactNameException");
        } catch (InvalidPhoneNumberException ignored) {

        }
    }

    @Test
    public void createContactInvalidPhoneDigitsNull() {
        try {
            new Contact("John", "Doe", "");
            Assert.fail("An exception should be thrown when creating a contact with invalid parameters");
        } catch (InvalidContactNameException invalidContactNameExcpetion) {
            Assert.fail("Creating a contact with null phone number should throw an InvalidContactNameException");
        } catch (InvalidPhoneNumberException ignored) {

        }
    }

    //----TEST FOR SETTERS----

    @Test
    public void setContactInvalidFirstNameNull() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setFirstName(null);
            Assert.fail("Setting a contact with null first name should throw an InvalidContactNameException");
        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidFirstNameEmpty() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setFirstName("");
            Assert.fail("Setting a contact with empty first name should throw an InvalidContactNameException");
        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidFirstNameFirstChar() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setFirstName("john");
            Assert.fail("Setting a contact with invalid first char of first name should throw an InvalidContactNameException");

        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidFirstNameMiddleChar() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setFirstName("JOhn");
            Assert.fail("Setting a contact with invalid middle char of first name should throw an InvalidContactNameException");

        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidFirstNameTwoWords() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setFirstName("John ");
            Assert.fail("Setting a contact with two words for first name should throw an InvalidContactNameException");

        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidLastNameNull() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setLastName(null);
            Assert.fail("Setting a contact with null last name should throw an InvalidContactNameException");

        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidLastNameEmpty() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setLastName("");
            Assert.fail("Setting a contact with empty last name should throw an InvalidContactNameException");

        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidLastNameFirstChar() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setLastName("doe");
            Assert.fail("Setting a contact with invalid first char of last name should throw an InvalidContactNameException");

        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidLastNameMiddleChar() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setLastName("DOe");
            Assert.fail("Setting a contact with invalid middle char of last name should throw an InvalidContactNameException");

        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidLastNameTwoWords() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setLastName("Doe ");
            Assert.fail("Setting a contact with two words for last name should throw an InvalidContactNameException");

        } catch (InvalidContactNameException ignored) {

        }
    }

    @Test
    public void setContactInvalidPhoneDigits() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setPhoneNumber("123");
            Assert.fail("Setting a contact with less than 9 digits should throw an InvalidContactNameException");
        } catch (InvalidPhoneNumberException ignored) {

        }
    }

    @Test
    public void setContactInvalidPhoneDigits2() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setPhoneNumber("8347683463674");
            Assert.fail("Setting a contact with more than 9 digits should throw an InvalidContactNameException");
        } catch (InvalidPhoneNumberException ignored) {

        }
    }

    @Test
    public void setContactInvalidPhoneDigitsEmpty() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setPhoneNumber("");
            Assert.fail("Setting a contact with empty phone number should throw an InvalidContactNameException");
        } catch (InvalidPhoneNumberException ignored) {

        }
    }

    @Test
    public void setContactInvalidPhoneDigitsNull() {
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly creating a contact");
        }

        try {
            contact.setPhoneNumber(null);
            Assert.fail("Setting a contact with null phone number should throw an InvalidContactNameException");
        } catch (InvalidPhoneNumberException ignored) {

        }
    }


}