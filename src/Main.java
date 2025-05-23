/*

Name: Andrew Goldman
Date: 4/20/25

This program creates a simulated shipping software able to handle and store customer information, calculate shipping expense for customer and provide tracking information.

 */


import Data.*;
import OrderManager.ShipManager;

import java.util.Scanner;

public class Main {

    private static void menu() {
        System.out.println("\nWelcome to ParcelStar* Shipping Service." + "\n1) Ship a Package" + "\n2) Enter a tracking number" + "\n0) Exit " + "\n\nPlease enter a menu option > ");
    }

    private static void printShipSpeedMenu() {
        System.out.println("Select shipping speed: \n" + "1 - EcoShip* (Standard)\n" + "2 - FastShip* (2-Day) (+$10)\n" + "3 - ExpressShip* (Overnight) (+$20)");
    }

    private static ContactInformation collectContactInfo(Scanner scan, String role) throws MyExceptions {
        System.out.println("\nPlease enter " + role + "'s first name: ");
        String firstName = scan.nextLine();

        System.out.println("Please enter " + role + "'s last name:");
        String lastName = scan.nextLine();

        System.out.println("Please enter " + role + "'s email address:");
        String email = scan.nextLine();

        return new ContactInformation(firstName, lastName, email);
    }

    private static Address collectAddress(Scanner scan, String role) throws MyExceptions {
        System.out.println("\nPlease enter " + role + " address details:");

        System.out.print("Building Number: ");
        String bldgNum = scan.nextLine();

        System.out.print("Street Name: ");
        String street = scan.nextLine();

        System.out.print("City: ");
        String city = scan.nextLine();

        System.out.print("State: ");
        String state = scan.nextLine();

        System.out.print("Zip Code: ");
        String zip = scan.nextLine();
        System.out.println();

        return new Address(bldgNum, street, city, state, zip);
    }

    private static ShipData collectShipData(Scanner scan) throws MyExceptions {
        ShipData shipCalculation = new ShipData();

        // get dimensions
        System.out.println("\nEnter parcel height:");
        double height = scan.nextDouble();

        System.out.println("Enter parcel width:");
        double width = scan.nextDouble();

        System.out.println("Enter parcel length:");
        double length = scan.nextDouble();

        System.out.println("Enter parcel weight:");
        double weight = scan.nextDouble();
        scan.nextLine(); // clear buffer

        // fragile input validation
        String fragile;
        while (true) {
            System.out.println("Is this package fragile? Add insurance for $5.00 (Y/N):");
            fragile = scan.nextLine().trim().toUpperCase();
            if (fragile.equals("Y") || fragile.equals("N")) break;
            System.out.println("Invalid input. Please enter Y or N.");
        }

        // shipping speed input validation
        printShipSpeedMenu();
        int speedChoice;
        while (true) {
            if (scan.hasNextInt()) {
                speedChoice = scan.nextInt();
                scan.nextLine();
                if (speedChoice >= 1 && speedChoice <= 3) break;
            } else {
                scan.next();
            }
            System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }

        String speedName = switch (speedChoice) {
            case 1 -> "EcoShip*";
            case 2 -> "FastShip*";
            case 3 -> "ExpressShip*";
            default -> "EcoShip*";
        };
        double speedCharge = switch (speedChoice) {
            case 2 -> 10.0;
            case 3 -> 20.0;
            default -> 0.0;
        };

        shipCalculation.setPackageHeight(height);
        shipCalculation.setPackageWidth(width);
        shipCalculation.setPackageLength(length);
        shipCalculation.setPackageWeight(weight);
        shipCalculation.setShippingSpeed(speedName);

        double volume = shipCalculation.shipVolume(length, width, height);
        double rate = shipCalculation.shipRate(volume, weight, fragile) + speedCharge;

        System.out.printf("Total shipping cost with %s: $%.2f%n", speedName, rate);

        shipCalculation.setTracking();
        return shipCalculation;
    }


    public static void main(String[] args) throws MyExceptions {
        Scanner scan = new Scanner(System.in);
        ShipManager shipmentManager = new ShipManager(); // now uses ArrayList
        int menu;

        while (true) {
            menu();
            menu = scan.nextInt();
            scan.nextLine(); // Clear buffer

            if (menu == 1) {
                ContactInformation sender = collectContactInfo(scan, "sender");
                Address returnAddress = collectAddress(scan, "return");

                System.out.println(sender + "\nReturn " + returnAddress);
                System.out.println("\n----------------------------------");

                ContactInformation recipient = collectContactInfo(scan, "recipient");
                Address shipAddress = collectAddress(scan, "shipping");

                System.out.println(recipient + "\n" + shipAddress);
                System.out.println("\n----------------------------------");

                ShipData shipCalculation = collectShipData(scan);
                Parcel parcel = new Parcel(sender, recipient, returnAddress, shipAddress, shipCalculation);

                shipmentManager.addShipment(shipCalculation); // add to list
                System.out.println(parcel);

            } else if (menu == 2) {
                System.out.print("Enter a tracking number: ");
                String tracking = scan.nextLine();
                ShipData result = shipmentManager.findByTracking(tracking);

                if (result != null) {
                    System.out.println("Shipment found:\n" + result);
                } else {
                    System.out.println("No shipment found with that tracking number.");
                }

            } else if (menu == 0) {
                System.out.println("\nThank you for using ParcelStar*. Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scan.close();
    }
}