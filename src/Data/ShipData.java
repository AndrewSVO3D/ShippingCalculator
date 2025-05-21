package Data;

import java.util.Scanner;

public class ShipData {

    // Instance Variables
    private double packageLength;
    private double packageWidth;
    private double packageHeight;

    // Constructor
    public ShipData() {
    }

    // Getters and Setters
    public double getPackageLength() {
        return packageLength;
    }

    public void setPackageLength(double packageLength) {
        this.packageLength = packageLength;
    }

    public double getPackageWidth() {
        return packageWidth;
    }

    public void setPackageWidth(double packageWidth) {
        this.packageWidth = packageWidth;
    }

    public double getPackageHeight() {
        return packageHeight;
    }

    public void setPackageHeight(double packageHeight) {
        this.packageHeight = packageHeight;
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
    public double shipWeight() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease enter package weight (lbs): ");
        double packageWeight = input.nextDouble();
        System.out.println("Weight: " + packageWeight + " lbs");
        return packageWeight;
    }

    // Method to calculate shipping rate
    public double shipRate(double volume, double weight) {
        final double flatRate = 0.25;
        final double perPoundRate = 0.75;
        double shipRate = flatRate + ((volume + (weight * perPoundRate))/2);
        System.out.printf("\nYour price to ship will be: $%.2f%n", shipRate);
        return shipRate;
    }
}
