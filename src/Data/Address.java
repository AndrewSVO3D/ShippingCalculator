package Data;

import OrderManager.MyExceptions;

public class Address {

    private String bldgNum;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;

    public Address(String bldgNum, String streetName, String city, String state, String zipCode) throws MyExceptions {
        setBldgNum(bldgNum);
        setStreetName(streetName);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
    }

    @Override
    public String toString() {
        return "Address: " + bldgNum + " " + streetName + ", " + city + ", " + state + " " + zipCode;
    }

    public String getBldgNum() {
        return bldgNum;
    }

    public void setBldgNum(String num) {
        this.bldgNum = num;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) throws MyExceptions {
        if (zipCode == null || zipCode.length() != 5) {
            throw new MyExceptions("ERROR: Zip code must be 5 digits.");
        }
        this.zipCode = zipCode;
    }
}
