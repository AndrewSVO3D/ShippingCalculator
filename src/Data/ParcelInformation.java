package Data;

public class ParcelInformation {

    // Fields
    private String firstName;
    private String lastName;
    private String email;

    private String bldgNum;
    private String returnStreetName;
    private String returnCity;
    private String returnState;
    private String returnZipCode;

    private String shipBldgNum;
    private String shipStreetName;
    private String shipCity;
    private String shipState;
    private String shipZipCode;

    // Constructors
    public ParcelInformation() {
    }

    public ParcelInformation(String firstName, String lastName, String email,
                             String bldgNum, String shipStreetName, String returnCity,
                             String returnState, String returnZipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bldgNum = bldgNum;
        this.shipStreetName = shipStreetName;
        this.returnCity = returnCity;
        this.returnState = returnState;
        this.returnZipCode = returnZipCode;
    }

    // Business Methods
    public void getOutboundParcelDetails() {
        System.out.println("Name: " + firstName + " " + lastName +
                "\nReturn Address: " + bldgNum + " " + returnStreetName + ", " +
                returnCity + ", " + returnState + " " + returnZipCode);
    }

    public void getInboundParcelDetails() {
        System.out.println("Ship Address: " + shipBldgNum + " " + shipStreetName + ", " +
                shipCity + ", " + shipState + " " + shipZipCode);
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBldgNum() {
        return bldgNum;
    }

    public void setBldgNum(String bldgNum) {
        this.bldgNum = bldgNum;
    }

    public String getReturnStreetName() {
        return returnStreetName;
    }

    public void setReturnStreetName(String returnStreetName) {
        this.returnStreetName = returnStreetName;
    }

    public String getReturnCity() {
        return returnCity;
    }

    public void setReturnCity(String returnCity) {
        this.returnCity = returnCity;
    }

    public String getReturnState() {
        return returnState;
    }

    public void setReturnState(String returnState) {
        this.returnState = returnState;
    }

    public String getReturnZipCode() {
        return returnZipCode;
    }

    public void setReturnZipCode(String returnZipCode) {
        this.returnZipCode = returnZipCode;
    }

    public String getShipBldgNum() {
        return shipBldgNum;
    }

    public void setShipBldgNum(String shipBldgNum) {
        this.shipBldgNum = shipBldgNum;
    }

    public String getShipStreetName() {
        return shipStreetName;
    }

    public void setShipStreetName(String shipStreetName) {
        this.shipStreetName = shipStreetName;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public String getShipZipCode() {
        return shipZipCode;
    }

    public void setShipZipCode(String shipZipCode) {
        this.shipZipCode = shipZipCode;
    }
}
