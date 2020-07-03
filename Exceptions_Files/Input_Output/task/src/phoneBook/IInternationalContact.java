package phoneBook;

import exceptions.InvalidContactNameException;
import exceptions.InvalidCountryCodeException;

public interface IInternationalContact extends IContact {

    /**
     * Getter for the {@link IInternationalContact internationalContact} <code>countryCode</code>
     *
     * @return {@link IInternationalContact internationalContact} <code>countryCode</code>
     */
    String getCountryCode();

    /**
     * Setter for the {@link IInternationalContact internationalContact} <code>countryCode</code>
     *
     * @param countryCode the country code of the {@link IInternationalContact internationalContact}
     * @throws InvalidCountryCodeException thrown when country code is not valid
     */
    void setCountryCode(String countryCode) throws InvalidCountryCodeException;

    /**
     * Getter for the {@link IInternationalContact internationalContact} <code>countryName</code>
     *
     * @return {@link IInternationalContact internationalContact} <code>countryName</code>
     */
    String getCountryName();

    /**
     * Setter for the {@link IInternationalContact internationalContact} <code>countryName</code>
     *
     * @param countryName the country name of the {@link IInternationalContact internationalContact}
     * @throws InvalidContactNameException thrown when country name is not valid
     */
    void setCountryName(String countryName) throws InvalidContactNameException;

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
