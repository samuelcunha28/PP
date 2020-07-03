package phoneBook;

import exceptions.InvalidContactNameException;
import exceptions.InvalidPhoneNumberException;

public class Contact implements IContact {

//ToDo:
//Add variables
//Add methods

    private String firstName;
    private String secondName;
    private String phoneNumber;

    public Contact(String firstName, String secondName, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) throws InvalidContactNameException {

    }

    @Override
    public String getLastName() {
        return secondName;
    }

    @Override
    public void setLastName(String lastName) throws InvalidContactNameException {

    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {

    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
