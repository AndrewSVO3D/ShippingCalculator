package Data;

import java.util.Scanner;

public class ShipData extends Exception {

    // Instance Variables
    private double packageLength;
    private double packageWidth;
    private double packageHeight;
    private double packageWeight;

    // Constructor
    public ShipData() {
    }

    // Getters and Setters
    public double getPackageLength() {
        return packageLength;
    }

    public void setPackageLength(double packageLength) throws MyExceptions {
        if (packageLength <= 0) {
            throw new MyExceptions("ERROR: Package length cannot be zero or negative.");
        } else {
            this.packageLength = packageLength;
        }
    }

    public double getPackageWidth() {
        return packageWidth;
    }

    public void setPackageWidth(double packageWidth) throws MyExceptions {
        if (packageWidth <= 0) {
            throw new MyExceptions("ERROR: Package width cannot be zero or negative.");
        } else {
            this.packageWidth = packageWidth;
        }
    }

    public double getPackageHeight() throws MyExceptions {
        if (packageHeight <= 0) {
            throw new MyExceptions("ERROR: Package height cannot be zero or negative.");
        } else {
            return packageHeight;
        }
    }

    public void setPackageHeight(double packageHeight) {
        if (packageHeight <= 0) {
            System.out.println("ERROR: Package height cannot be zero or negative.");
        } else {
            this.packageHeight = packageHeight;
        }
    }

    // Method to calculate package volume
    public double shipVolume(double length, double width, double height) {
        return packageLength * packageWidth * packageHeight;
    }

    // Method to print volume description
    public String printVolume(double volume) {
        return String.format("Dimensions: %.2f in. x %.2f in. x %.2f in. = %.2f in³",
                packageLength, packageWidth, packageHeight, volume);
    }

    // Method to prompt and return package weight
    public double shipWeight() throws MyExceptions{
        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease enter package weight (lbs): ");
        double packageWeight = input.nextDouble();
        if (packageWeight <= 0) {
            throw new MyExceptions("ERROR: Package weight cannot be zero or negative.");
        } else {
            this.packageWeight = packageWeight;
            System.out.println("Weight: " + packageWeight + " lbs");
        }
        return packageWeight;
    }
    // Method to calculate shipping rate
    public double shipRate(double volume, double weight) {
        final double flatRate = 0.25;
        final double perPoundRate = 0.75;
        double shipRate = flatRate + ((volume + (weight * perPoundRate)) / 2);
        System.out.printf("\nYour price to ship will be: $%.2f%n", shipRate);
        return shipRate;
    }
}
