/*

Name: Andrew Goldman
Date: 4/20/25

This program creates a simulated shipping software able to handle and store customer information, calculate shipping expense for customer and provide tracking information.

 */


import Data.*;
import OrderManager.MyExceptions;
import OrderManager.ShipManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void menu() {
        System.out.println("\nWelcome to ParcelStar* Shipping Service.");
        System.out.println("1) Ship a Package");
        System.out.println("2) Enter a tracking number");
        System.out.println("0) Exit");
        System.out.print("\nPlease enter a menu option > ");
    }

    private static void printShipSpeedMenu() {
        System.out.println("Select shipping speed: ");
        System.out.println("1 - EcoShip* (Standard)");
        System.out.println("2 - FastShip* (2-Day) (+$10)");
        System.out.println("3 - ExpressShip* (Overnight) (+$20)");
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
        System.out.println("Enter parcel height:");
        double height = scan.nextDouble();

        System.out.println("Enter parcel width:");
        double width = scan.nextDouble();

        System.out.println("Enter parcel length:");
        double length = scan.nextDouble();

        System.out.println("Enter parcel weight:");
        double weight = scan.nextDouble();

        System.out.println("Package Contents (provide a brief description for label, max 35 characters:");
        scan.nextLine();
        String description = scan.nextLine();

        String fragile;
        while (true) {
            System.out.println("Is this package fragile? Add insurance for $5.00 (Y/N):");
            fragile = scan.nextLine().trim().toUpperCase();
            if (fragile.equals("Y") || fragile.equals("N")) break;
            System.out.println("Invalid input. Please enter Y or N.");
        }

        printShipSpeedMenu();
        int speedChoice;
        while (true) {
            if (scan.hasNextInt()) {
                speedChoice = scan.nextInt();
                scan.nextLine(); // clear buffer
                if (speedChoice >= 1 && speedChoice <= 3) break;
            } else {
                scan.next(); // discard invalid input
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

        LocalDateTime orderTime = LocalDateTime.now();
        shipCalculation.setOrderDateTime(orderTime);
        shipCalculation.setDescription(description);
        LocalDateTime arrivalTime = shipCalculation.generateEstimatedArrivalTime(speedChoice, orderTime);
        shipCalculation.setEstimatedArrivalTime(orderTime, speedChoice);
        shipCalculation.setPackageHeight(height);
        shipCalculation.setPackageWidth(width);
        shipCalculation.setPackageLength(length);
        shipCalculation.setPackageWeight(weight);
        shipCalculation.setShippingSpeed(speedChoice);

        double volume = shipCalculation.shipVolume(length, width, height);
        String costString = shipCalculation.shipRate(volume, weight, fragile); // sets shipCost internally

        System.out.printf("Total shipping cost with %s: %s%n", speedName, costString);

        return shipCalculation;
    }


    public static void main(String[] args) throws MyExceptions {

        Scanner scan = new Scanner(System.in);
        ShipManager shipmentManager = new ShipManager();
        List<Parcel> parcels = new ArrayList<>();

        // Predefined packages
        LocalDateTime shipTime = LocalDateTime.now();
        LocalDateTime arrivalTime = shipTime.plusDays(3).plusHours(8);
        parcels.add(new Parcel(
                new ContactInformation("Amelia", "Earhart", "amelia@aviators.org"),
                new ContactInformation("Charles", "Lindbergh", "charles.flyer@atlanticmail.com"),
                new Address("33", "Runway Drive", "Atchison", "KS", "66002"),
                new Address("99", "Spirit Street", "St. Louis", "MO", "63101"),
                new ShipData(3.5, 2.0, 4.0, 1.5, "PS*AIR", true, 3, "Air Time Snacks", shipTime, arrivalTime)
        ));

        parcels.add(new Parcel(
                new ContactInformation("Amelia", "Earhart", "amelia@aviators.org"),
                new ContactInformation("Charles", "Lindbergh", "charles.flyer@atlanticmail.com"),
                new Address("33", "Runway Drive", "Atchison", "KS", "66002"),
                new Address("99", "Spirit Street", "St. Louis", "MO", "63101"),
                new ShipData(3.5, 2.0, 4.0, 1.5, "PS*AIR", true, 2, "Air Time Snacks", shipTime, arrivalTime)
        ));

        parcels.add(new Parcel(
                new ContactInformation("Amelia", "Earhart", "amelia@aviators.org"),
                new ContactInformation("Charles", "Lindbergh", "charles.flyer@atlanticmail.com"),
                new Address("33", "Runway Drive", "Atchison", "KS", "66002"),
                new Address("99", "Spirit Street", "St. Louis", "MO", "63101"),
                new ShipData(3.5, 2.0, 4.0, 1.5, "PS*AIR", true, 1, "Air Time Snacks", shipTime, arrivalTime)
        ));
        for (Parcel p : parcels) {
            shipmentManager.addShipment(p.getShippingDetails());
        }

        int menu;

        while (true) {
            menu();

            if (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
                continue;
            }

            menu = scan.nextInt();
            scan.nextLine(); // clear leftover newline

            if (menu == 1) {
                ContactInformation sender = collectContactInfo(scan, "sender");
                Address returnAddress = collectAddress(scan, "return");

                ContactInformation recipient = collectContactInfo(scan, "recipient");
                Address shipAddress = collectAddress(scan, "shipping");

                ShipData shipCalculation = collectShipData(scan);
                Parcel parcel = new Parcel(sender, recipient, returnAddress, shipAddress, shipCalculation);

                shipmentManager.addShipment(shipCalculation);
                parcels.add(parcel);
                System.out.println("\nThank you for choosing ParcelStar* for your package!");
                System.out.println(parcel);

            } else if (menu == 2) {
                System.out.print("Enter a tracking number: ");
                String tracking = scan.nextLine().trim();

                ShipData result = shipmentManager.findByTracking(tracking);

                if (result != null) {
                    System.out.println("\nShipment found ✓\n");

                    boolean foundParcel = false;
                    for (Parcel p : parcels) {
                        if (p.getShippingDetails().getTracking().equals(result.getTracking())) {
                            System.out.println("Full parcel details:\n" + p);
                            foundParcel = true;
                            break;
                        }
                    }

                    if (!foundParcel) {
                        System.out.println("Parcel details not found for this tracking number.");
                    }

                } else {
                    System.out.println("No shipment found with that tracking number.");
                }

            } else if (menu == 0) {
                for (Parcel p : parcels) {
                    shipmentManager.printAllTracking();
                }
                System.out.println("Exiting... Thank you for using ParcelStar*!");
                break;
            } else if (menu == 3) {
                for (ShipData shipments : shipmentManager.getShipments()) {
                    System.out.println(shipments);
                }
            } else {
                System.out.println("Invalid option. Please choose 0, 1, or 2.");
            }
        }
    }
}
