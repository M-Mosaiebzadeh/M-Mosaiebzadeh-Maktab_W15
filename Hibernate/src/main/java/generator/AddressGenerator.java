package generator;

import entities.Address;

public class AddressGenerator {
    public static Address createAddress(String number, String state, String city, String postalAddress, String postalCode) {
        return new Address(number,state,city,postalAddress,postalCode);
    }
    public static Address createAddress(String number, String state) {
        Address address = new Address();
        address.setNumber(number);
        address.setState(state);
        return address;
    }
    public static Address createAddress(String number, String state, String city) {
        Address address = new Address();
        address.setNumber(number);
        address.setState(state);
        address.setCity(city);
        return address;
    }
    public static Address createAddress(String number, String state, String city, String postalAddress) {
        Address address = new Address();
        address.setNumber(number);
        address.setState(state);
        address.setCity(city);
        address.setPostalAddress(postalAddress);
        return address;
    }

}
