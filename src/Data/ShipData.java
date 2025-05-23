package Data;

import java.util.Random;

public class ShipData {

    private double packageLength;
    private double packageWidth;
    private double packageHeight;
    private double packageWeight;
    private String tracking;

    private boolean fragile;
    private String shippingSpeed;


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

    public String getTracking() {
        return tracking;
    }

    public void setTracking() {
        this.tracking = generateTrackingNumber();
    }

    public double shipVolume(double length, double width, double height) {
        return length * width * height;
    }

    public double printVolume(double volume) {
        return volume;
    }

    // double rate = (volume * 0.05) + (weight * 0.1);
    public double shipRate(double volume, double weight, String fragile) throws MyExceptions {
        double standardRate = (volume * 0.05) + (weight * 0.1);
        double fragileUpcharge = 5.00;
        if (fragile.equalsIgnoreCase("Y")) {
            return standardRate + fragileUpcharge;
        } else if (fragile.equalsIgnoreCase("N")) {
            return standardRate;
        } else {
            throw new MyExceptions("Invalid input for fragile: must be 'Y' or 'N'");
        }
    }

    private String generateTrackingNumber() {
        String prefix = "PS";
        int totalLength = 20;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(prefix);

        for (int i = 0; i < totalLength - prefix.length(); i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Dimensions (LxWxH): " + packageLength + " x " + packageWidth + " x " + packageHeight + "\n" +
                "Weight: " + packageWeight + " lbs\n" +
                "Tracking Number: " + tracking;
    }

    public void setShippingSpeed(String shippingSpeed) {
        this.shippingSpeed = shippingSpeed;
    }
}
