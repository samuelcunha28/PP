package HumanResources;

import exceptions.HRException;
import hr.IAddress;
import hr.IDriver;
import hr.LicenseType;
import java.time.LocalDate;
import transport.DriverStatus;
import Exceptions.*;
import java.util.Arrays;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Driver extends Person implements IDriver {

    /**
     * The driver starting position date.
     */
    private LocalDate startingPosition;

    /**
     * The driver status (default = free).
     */
    private DriverStatus status = DriverStatus.FREE;

    /**
     * The number of licenses.
     */
    private int numberOfLicenses;

    /**
     * The driver LicenseType.
     */
    private LicenseType[] licenses;

    /**
     * Constructor of Driver.
     *
     * @param id The driver id.
     * @param address The driver address.
     * @param name The driver name.
     * @param birthDate The driver birthDate.
     * @param startingPosition The driver startingPosition.
     * @param status The driver status
     */
    public Driver(String id, IAddress address, String name, LocalDate birthDate, LocalDate startingPosition, DriverStatus status) {
        super(id, address, name, birthDate);
        this.startingPosition = startingPosition;
        this.status = status;
        this.numberOfLicenses = 0;
        this.licenses = new LicenseType[5];
    }

    /**
     * Getter for starting position date.
     *
     * @return The starting position date.
     */
    @Override
    public LocalDate getStartingPositionDate() {
        return startingPosition;
    }

    /**
     * Adds a license to the driver.
     *
     * @param lt The license type to be added.
     * @return True if inserted, false otherwise.
     * @throws HRException if licenseType is null && DriverStatus is different
     * from free.
     */
    @Override
    public boolean addLicense(LicenseType lt) throws HRException {
        if (this.status != DriverStatus.FREE) {
            throw new HRExceptionImpl("The driver status is assigned");
        }
        if (lt == null) {
            throw new HRExceptionImpl("The driver license is null");
        }

        if (this.licenses.length == this.numberOfLicenses) {
            LicenseType[] clone = this.licenses;
            this.licenses = new LicenseType[this.licenses.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.licenses[i] = clone[i];
            }
        }

        this.licenses[this.numberOfLicenses] = lt;
        this.numberOfLicenses++;

        return true;
    }

    /**
     * Removes a license from the driver.
     *
     * @param lt The license type to be removed.
     * @return True if removed, false otherwise.
     * @throws HRException if licenseType is null && DriverStatus is different
     * from free.
     */
    @Override
    public boolean removeLicense(LicenseType lt) throws HRException {
        if (this.status != DriverStatus.FREE) {
            throw new HRExceptionImpl("The driver status is assigned");
        }
        if (lt == null) {
            throw new HRExceptionImpl("The driver license is null");
        }

        for (int i = 0; i < this.numberOfLicenses; ++i) {
            if (this.licenses[i].equals(lt)) {
                for (; i < this.numberOfLicenses - 1; i++) {
                    this.licenses[i] = this.licenses[i + 1];
                }
                this.licenses[i] = null;
                this.numberOfLicenses--;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the driver has a specific license type.
     *
     * @param lt The license type to be checked.
     * @return True if exists, false otherwise.
     */
    @Override
    public boolean haveLicense(LicenseType lt) {
        int i;
        if (numberOfLicenses == 0) {
            return false;
        }

        for (i = 0; i < this.numberOfLicenses; ++i) {
            if (lt.equals(this.licenses[i])) {
                return true;

            }
        }
        return false;
    }

    /**
     * Getter for driver status.
     *
     * @return The driver status.
     */
    @Override
    public DriverStatus getStatus() {
        return status;
    }

    /**
     * Setter for driver status.
     *
     * @param ds The driver status.
     */
    @Override
    public void setStatus(DriverStatus ds) {
        this.status = ds;
    }

    /**
     * Compares two Driving licenses.
     *
     * @param obj object to be compared
     * @return true if obj is equal to the driver license type.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Driver other = (Driver) obj;
        if (!Arrays.deepEquals(this.licenses, other.licenses)) {
            return false;
        }
        return true;
    }

    /**
     * To String method representing the Driver.
     *
     * @return String with all the information about the driver.
     */
    @Override
    public String toString() {
        return super.toString() + "\nStartingPosition: " + startingPosition
                + "\nStatus: " + status + "\nNumber of Licenses: " + numberOfLicenses
                + "\nLicenses: " + Arrays.toString(licenses);
    }
}
