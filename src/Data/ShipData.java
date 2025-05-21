package Data;

import java.util.Scanner;

public class ShipData {
    public ShipData() {
    }
    public double shipVolume(double packageLength, double packageWidth, double packageHeight){
        final double pckgVol = packageLength*packageWidth*packageHeight;
        String msg = "dimensions: "+packageLength+"in. x "+packageWidth+"in. x "+packageHeight+"in."+" = "+pckgVol+" in.";
        System.out.println(msg);
        return pckgVol;
    }
    public double shipWeight() {
        System.out.println("\nPlease enter package weight: ");
        Scanner input = new Scanner(System.in);
        double packageWeight = input.nextDouble();
        System.out.println(packageWeight + "lbs");
        return packageWeight;
    }
    public Double shipRate(double pckgVol, double pckgWeight){
        final double flatRate = 0.25;
        final double perPoundRate = 0.75;
        double shipRate = flatRate+pckgVol+(pckgWeight*perPoundRate);
        System.out.printf("\nYour price to ship will be: $%.2f",shipRate+"\n");
        return shipRate;
    }

    double packageLength;

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

    double packageWidth;
    double packageHeight;

}
