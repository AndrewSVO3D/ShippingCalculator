import Data.CustomerInformation;
import Data.ParcelInformation;
import Data.ShipData;

import java.util.Scanner;

public class Main extends ShipData {
    private static void menu() {
        System.out.println("\nWelcome to ParcelStar* International Shipping Service.\n\n"
                + "Please get started by entering your personal details: ");
    }

    public static void main(String[] args) {
        menu();
        Scanner scan = new Scanner(System.in);

        // CUSTOMER DETAILS
        System.out.println("\nPlease enter your first name: ");
        String firstName = scan.next();
        System.out.println("Please enter your last name:");
        String lastName = scan.next();
        System.out.println("Please enter your email address:");
        String email = scan.next();

        CustomerInformation customerInformation = new CustomerInformation(firstName, lastName, email);
        customerInformation.setFirstName(firstName);
        customerInformation.setLastName(lastName);
        customerInformation.setEmail(email);

        customerInformation.getDetails();

        System.out.println("\nPlease enter address details: " +
                "\nBuilding Number: ");
        String num = scan.next();
        scan.nextLine();
        System.out.println("Please enter street name: ");
        String street = scan.nextLine();
        System.out.println();
        System.out.println("Please enter city name: ");
        String city = scan.next();
        System.out.println("Please enter state" );
        String state = scan.next();
        System.out.println("Please enter zip code: ");
        String zip = scan.next();

        // CREATE PACKAGE DATA
        ParcelInformation parcelInformation = new ParcelInformation();
        parcelInformation.setBldgNum(num);
        parcelInformation.setReturnStreetName(street);
        parcelInformation.setReturnCity(city);
        parcelInformation.setReturnState(state);
        parcelInformation.setReturnZipCode(zip);

        System.out.println("----------------------------------");


        // CREATE RECIPIENT
        System.out.println("\nPlease enter the parcel details for recipient: ");

        System.out.println("\nPlease enter recipient's first name: ");
        String firstName2 = scan.next();

        System.out.println("Please enter recipient's last name:");
        String lastName2 = scan.next();

        System.out.println("Please enter your recipient's email:");
        String email2 = scan.next();

        System.out.println("\nPlease enter building number: ");
        String num2 = scan.next();
        scan.nextLine();

        System.out.println("Please enter street name: ");
        String street2 = scan.nextLine();

        System.out.println("Please enter city name: ");
        String city2 = scan.next();

        System.out.println("Please enter state" );
        String state2 = scan.next();

        System.out.println("Please enter zip code: ");
        String zip2 = scan.next();

        parcelInformation.setFirstName(firstName2);
        parcelInformation.setLastName(lastName2);
        parcelInformation.setEmail(email2);
        parcelInformation.setShipBldgNum(num2);
        parcelInformation.setShipStreetName(street2);
        parcelInformation.setShipCity(city2);
        parcelInformation.setShipState(state2);
        parcelInformation.setShipZipCode(zip2);

        System.out.println("\n----------------------------------");

        customerInformation.getDetails();
        System.out.println();
        parcelInformation.getOutboundParcelDetails();
        System.out.println("");
        parcelInformation.getInboundParcelDetails();

    }


    /*
       // Parcel Information
        Data.ShipData newPackage = new Data.ShipData();


        double length = scan.nextDouble();
        double width = scan.nextDouble();
        double height = scan.nextDouble();

        final double dimensions = newPackage.shipVolume(length, width, height); // Dimensions of package
        final double weight = newPackage.shipWeight();
        final double shipRate = newPackage.shipRate(dimensions, weight);
     */
}