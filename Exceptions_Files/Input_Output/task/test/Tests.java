import exceptions.InvalidContactNameException;
import exceptions.InvalidCountryCodeException;
import exceptions.InvalidPhoneNumberException;
import exceptions.PhoneManagerException;
import org.junit.Assert;
import org.junit.Test;
import phoneBook.*;

import java.io.File;
import java.io.IOException;

public class Tests {

    @Test
    public void contactEquals() {
        //create and instantiate a contact
        IContact contact = null, contact2 = null, contact3 = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
            contact2 = new Contact("John", "Doe", "984736437");
            contact3 = new Contact("John", "Doe", "984736434");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly instantiating a contact");
        }

        IInternationalContact ic = null, ic2 = null, ic3 = null;
        try {
            ic = new InternationalContact("John", "Doe", "987634756", "0034", "Somecountry");
            ic2 = new InternationalContact("John", "Doe", "987634756", "0034", "Somecountry");
            ic3 = new InternationalContact("John", "Doe", "987634456", "0034", "Somecountry");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        Assert.assertNotEquals("Comparing a contact to null should be false", null, contact);
        Assert.assertNotEquals("Comparing a contact to other type of object should be false", "other type", contact);
        Assert.assertEquals("Comparing the contact to other contact with same values should be true", contact, contact2);
        Assert.assertEquals("Comparing the contact to itself be true", contact, contact);
        Assert.assertNotEquals("Comparing a contact to different contact should be false", contact, contact3);

        Assert.assertNotEquals("Comparing a contact to an international contact should be false", contact, ic);
        Assert.assertNotEquals("Comparing an international contact to null should be false", null, ic);
        Assert.assertNotEquals("Comparing an international contact to other object should be false", "", ic);
        Assert.assertEquals("Comparing the contact to other contact with same values should be true", ic, ic2);
        Assert.assertNotEquals("Comparing a contact to different contact should be false", ic, ic3);
        Assert.assertEquals("Comparing the international contact to itself be true", ic, ic);
    }

    @Test
    public void testJSONBackup() {
        //create and instantiate a contact
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly instantiating a contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic = null;
        try {
            ic = new InternationalContact("John", "Doe", "987634756", "0034", "Somecountry");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic2 = null;
        try {
            ic2 = new InternationalContact("John", "Doee", "987634757", "0034", "Somecountryy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic3 = null;
        try {
            ic3 = new InternationalContact("John", "Doeee", "987134757", "0034", "Somecountryyy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic4 = null;
        try {
            ic4 = new InternationalContact("Johnn", "Doeee", "987134711", "0034", "Somecountryyy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and add some contacts to manager
        IPhoneManager pm = new PhoneManager();

        try {
            pm.addContact(contact);
        } catch (PhoneManagerException e) {
            Assert.fail("Exception thrown when correctly adding a contact");
        }

        try {
            pm.addContact(ic);
            pm.addContact(ic2);
            pm.addContact(ic3);
            pm.addContact(ic4);
        } catch (PhoneManagerException e) {
            Assert.fail("Exception thrown when correctly adding a contact");
        }

        try {
            pm.backup("contacts.json");
        } catch (IOException e) {
            Assert.fail("Exception thrown when creating a file with valid contacts");
        }

        File tmp = new File("contacts.json");
        Assert.assertTrue("File was not created", tmp.exists());

    }

    @Test
    public void testJSONRestore() {
        //create and instantiate a contact
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly instantiating a contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic = null;
        try {
            ic = new InternationalContact("John", "Doe", "987634756", "0034", "Somecountry");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic2 = null;
        try {
            ic2 = new InternationalContact("John", "Doee", "987634757", "0034", "Somecountryy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic3 = null;
        try {
            ic3 = new InternationalContact("John", "Doeee", "987134757", "0034", "Somecountryyy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic4 = null;
        try {
            ic4 = new InternationalContact("Johnn", "Doeee", "987134711", "0034", "Somecountryyy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and add some contacts to manager
        IPhoneManager pm = new PhoneManager();

        try {
            pm.addContact(contact);
        } catch (PhoneManagerException e) {
            Assert.fail("Exception thrown when correctly adding a contact");
        }

        try {
            pm.addContact(ic);
            pm.addContact(ic2);
            pm.addContact(ic3);
            pm.addContact(ic4);
        } catch (PhoneManagerException e) {
            Assert.fail("Exception thrown when correctly adding a contact");
        }

        try {
            pm.backup("contacts.json");
        } catch (IOException e) {
            Assert.fail("Exception thrown when creating a file with valid contacts");
        }

        File tmp = new File("contacts.json");
        Assert.assertTrue("File was not created", tmp.exists());

        try {
            pm.recover("contacts.json");
        } catch (IOException | ClassNotFoundException e) {
            Assert.fail("Exception thrown when recovering a file with valid contacts");
        }

    }

    @Test
    public void testAllJSON() {
        //create and instantiate a contact
        IContact contact = null;
        try {
            contact = new Contact("John", "Doe", "984736437");
        } catch (InvalidContactNameException | InvalidPhoneNumberException e) {
            Assert.fail("Exception thrown when correctly instantiating a contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic = null;
        try {
            ic = new InternationalContact("John", "Doe", "987634756", "0034", "Somecountry");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic2 = null;
        try {
            ic2 = new InternationalContact("John", "Doee", "987634757", "0034", "Somecountryy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic3 = null;
        try {
            ic3 = new InternationalContact("John", "Doeee", "987134757", "0034", "Somecountryyy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and instantiate a international contact
        IInternationalContact ic4 = null;
        try {
            ic4 = new InternationalContact("Johnn", "Doeee", "987134711", "0034", "Somecountryyy");
        } catch (InvalidContactNameException | InvalidPhoneNumberException | InvalidCountryCodeException e) {
            Assert.fail("Exception thrown when correctly instantiating an international contact");
        }

        //create and add some contacts to manager
        IPhoneManager pm = new PhoneManager();

        try {
            pm.addContact(contact);
        } catch (PhoneManagerException e) {
            Assert.fail("Exception thrown when correctly adding a contact");
        }

        try {
            pm.addContact(ic);
            pm.addContact(ic2);
            pm.addContact(ic3);
            pm.addContact(ic4);
        } catch (PhoneManagerException e) {
            Assert.fail("Exception thrown when correctly adding a contact");
        }

        try {
            pm.backup("contacts.json");
        } catch (IOException e) {
            Assert.fail("Exception thrown when creating a file with valid contacts");
        }

        File tmp = new File("contacts.json");
        Assert.assertTrue("File was not created", tmp.exists());


        IPhoneManager pm2 = new PhoneManager();
        try {
            pm2.recover("contacts.json");
        } catch (IOException | ClassNotFoundException e) {
            Assert.fail("Exception thrown when recovering a file with valid contacts");
        }

        try {
            Assert.assertEquals("backup is not getting the same results or equals in contact is not implemented", contact, pm2.getContact(contact.getPhoneNumber()));
            Assert.assertEquals("backup is not getting the same results or equals in contact is not implemented", ic, pm2.getContact(ic.getPhoneNumber()));
            Assert.assertEquals("backup is not getting the same results or equals in contact is not implemented", ic2, pm2.getContact(ic2.getPhoneNumber()));
            Assert.assertEquals("backup is not getting the same results or equals in contact is not implemented", ic3, pm2.getContact(ic3.getPhoneNumber()));
            Assert.assertEquals("backup is not getting the same results or equals in contact is not implemented", ic4, pm2.getContact(ic4.getPhoneNumber()));
        } catch (PhoneManagerException e) {
            Assert.fail("backup is not working properly or equals in contact is not implemented");
        }

    }

}