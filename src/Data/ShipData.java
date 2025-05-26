package Data;

import OrderManager.MyExceptions;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShipData {

    private double packageLength;
    private double packageWidth;
    private double packageHeight;
    private double packageWeight;
    private String tracking;
    private String description;
    private boolean fragile;
    private int shippingSpeed;
    private LocalDateTime orderDateTime;
    private LocalDateTime estimatedArrivalTime;
    private Double shipCost;

    public ShipData(double packageLength, double packageWidth, double packageHeight, double packageWeight, String tracking, boolean fragile, int shippingSpeed, String description, LocalDateTime orderDateTime, LocalDateTime estimatedArrivalTime) {
        this.packageLength = packageLength;
        this.packageWidth = packageWidth;
        this.packageHeight = packageHeight;
        this.packageWeight = packageWeight;
        this.tracking = tracking;
        this.fragile = fragile;
        this.description = description;
        this.shippingSpeed = shippingSpeed;
        this.orderDateTime = orderDateTime;
        this.estimatedArrivalTime = generateEstimatedArrivalTime(shippingSpeed, orderDateTime);
    }

    public ShipData() {
        this.tracking = generateTrackingNumber();
    }

    public String shipRate(double volume, double weight, String fragile) throws MyExceptions {
        double standardRate = (volume * 0.05) + (weight * 0.1);
        double fragileUpcharge = 5.00;
        double totalCost;

        if (fragile.equalsIgnoreCase("Y")) {
            totalCost = standardRate + fragileUpcharge;
        } else if (fragile.equalsIgnoreCase("N")) {
            totalCost = standardRate;
        } else {
            throw new MyExceptions("Invalid input for fragile: must be 'Y' or 'N'");
        }

        this.shipCost = totalCost;
        return String.format("$%.2f", totalCost);
    }



    private String generateTrackingNumber() {
        String prefix = "PS*";
        int totalLength = 20;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(prefix);

        for (int i = 0; i < totalLength - prefix.length(); i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

    private String printTrackingNumber(String tracking) {
        System.out.println(tracking);
        return tracking;
    }

    public String isFragile() {
        String word = "";
        if (fragile = true) {
            word = "Yes";
        } else {
            word = "No";
        }
        return word;
    }

    public LocalDateTime generateEstimatedArrivalTime(int shippingSpeed, LocalDateTime orderTime) {
        Random random = new Random();
        int daysToAdd;

        if (shippingSpeed == 1) {
            daysToAdd = random.nextInt(4, 7);
        } else if (shippingSpeed == 2) {
            daysToAdd = random.nextInt(3, 5);
        } else {
            daysToAdd = random.nextInt(1, 3);
        }
        return orderTime.plusDays(daysToAdd);
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' h:mm a");
        String orderTime = orderDateTime != null ? orderDateTime.format(formatter) : "N/A";
        return "\n\nOrder Placed: " + orderTime +
                "\nEstimated Arrival: " + getEstimatedArrivalTime().format(formatter) +
                "\nPackage Dimensions: L:" + packageLength + " x W:" + packageWidth + " x H:" + packageHeight +
                "\nShipping Cost: " + shipCost +
                "\nPackage Contents: " + description +
                "\nPackage Weight: " + packageWeight +
                "\nShipping Speed: " + shippingSpeed +
                "\nFragile: " + isFragile() + "\n";

    }

    public String getShipSpeedName() {
        if (shippingSpeed == 1) {
            return "EcoShip*";
        } else if (shippingSpeed == 2) {
            return "FastShip*";
        } else {
            return "ExpressShip*";
        }
    }

    public long setEstimatedArrivalTime(LocalDateTime orderTime, int speedChoice) {
        return 0;
    }

    public void setDescription(String description) throws MyExceptions {
        if (description.length() <= 35) {
            this.description = description;
        } else {
            throw new MyExceptions("Description must be 35 characters or less.");
        }
    }


    public double shipVolume(double length, double width, double height) {
        return length * width * height;
    }

    public double printVolume(double volume) {
        return volume;
    }

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

    public double getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(double packageWeight) {
        this.packageWeight = packageWeight;
    }

    public int getShippingSpeed() {
        return shippingSpeed;
    }

    public void setShippingSpeed(int shipSpeed) {
        this.shippingSpeed = shipSpeed;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking() {
        this.tracking = generateTrackingNumber();
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public LocalDateTime getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public String getDescription() {
        return description;
    }
}
