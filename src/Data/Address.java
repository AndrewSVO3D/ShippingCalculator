package Data;

public class Address {

    // Shipping Address
    private String BldgNum;
    private String StreetName;
    private String City;
    private String State;
    private String ZipCode;

    public Address(String BldgNum, String StreetName, String City, String State, String ZipCode) {

    }

    @Override
    public String toString() {
        return "Address: "+getBldgNum()+" "+getStreetName()+", "+getCity()+", "+getState()+" "+getZipCode();
    }

    public String getBldgNum() {
        return BldgNum;
    }

    public void setBldgNum(String bldgNum) {
        BldgNum = bldgNum;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }
}
