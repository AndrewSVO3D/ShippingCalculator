// Created by Andrew G. on 5/20/2018

import Data.Address;
import Data.ContactInformation;
import Data.MyExceptions;
import Data.ShipData;
import java.util.Scanner;

public class Main extends ShipData {
    private static void menu() {
        System.out.println("\nWelcome to ParcelStar* Shipping Service."
                + "\n1) Ship a Package" +
                "\n2) Enter a tracking number" +
                "\n0) Exit "
                +"\n\n Please enter a menu option > "
        );
    }
  public static void main(String[] args) throws Exception {
      int menu = 0; // Menu
      Scanner scan = new Scanner(System.in);
      while (true) {
          menu();
          menu = scan.nextInt();

          menu();
          if (menu == 1) {

              // CUSTOMER DETAILS
              System.out.println("\nPlease enter your first name: ");
              String firstName = scan.next();
              System.out.println("Please enter your last name:");
              String lastName = scan.next();
              System.out.println("Please enter your email address:");
              String email = scan.next();
              scan.nextLine(); // Consuming input from scanner

              ContactInformation sender = new ContactInformation(firstName, lastName, email);
              sender.setFirstName(firstName);
              sender.setLastName(lastName);
              sender.setEmail(email);

              System.out.println("\nPlease enter address details: " + "\nBuilding Number: ");
              String num = scan.nextLine();

                System.out.println("Please enter street name: ");
                String street = scan.nextLine();

               System.out.println("Please enter city name: ");
                String city = scan.nextLine();

              System.out.println("Please enter state: ");
              String state = scan.nextLine();

              System.out.println("Please enter zip code: ");
              String zip = scan.nextLine();

               Address returnAddress = new Address(num, street, city, state, zip);
               returnAddress.setBldgNum(num);
               returnAddress.setStreetName(street);
               returnAddress.setCity(city);
               returnAddress.setState(state);
               returnAddress.setZipCode(zip);

               String printContact = sender.toString();
               String printReturnAddress = returnAddress.toString();
               System.out.println(printContact + "\nReturn " + printReturnAddress);

               System.out.println("\n----------------------------------");

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
                String city2 = scan.nextLine();

                System.out.println("Please enter state");
                String state2 = scan.nextLine();

                System.out.println("Please enter zip code: ");
                String zip2 = scan.next();

                ContactInformation recipient = new ContactInformation(firstName, lastName, email);
                Address shipAddress = new Address(num, street, city, state, zip);
                shipAddress.setBldgNum(num2);
                shipAddress.setStreetName(street2);
                shipAddress.setCity(city2);
                shipAddress.setState(state2);
                shipAddress.setZipCode(zip2);
                recipient.setFirstName(firstName2);
                recipient.setLastName(lastName2);
                recipient.setEmail(email2);

                String printRecipient = recipient.toString();
                String printShipAddress = shipAddress.toString();
                System.out.println(printRecipient + "\n" + printShipAddress);


                System.out.println("\n----------------------------------");

                // CALCULATE PARCEL PRICING
                ShipData newParcel = new ShipData();
                System.out.println("\nPlease enter parcel height: ");
                double height = scan.nextDouble();

                System.out.println("Please enter parcel width: ");
                double width = scan.nextDouble();
                System.out.println("Please enter parcel length");
                double length = scan.nextDouble();
                newParcel.setPackageHeight(height);
                newParcel.setPackageWidth(width);
                newParcel.setPackageLength(length);

                double volume = newParcel.shipVolume(length, width, height);
                String printVolume = newParcel.printVolume(volume);
                System.out.println(printVolume);
                newParcel.shipRate(volume, newParcel.shipWeight());

            } else if (menu == 2) {
                System.out.println("Please enter tracking number for package: ");
                String tracking = scan.next();

            } else if (menu == 0) {
                System.out.println("\n\n");
                break;
            }
        }
    }
}