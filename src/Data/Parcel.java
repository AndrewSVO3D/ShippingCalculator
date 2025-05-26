package Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parcel {

    private ContactInformation shipper;
    private ContactInformation recipient;
    private Address shipperAddress;
    private Address recipientAddress;
    private ShipData shippingDetails;

    public Parcel(ContactInformation shipper, ContactInformation recipient,
                  Address shipperAddress, Address recipientAddress,
                  ShipData shippingDetails) {
        this.shipper = shipper;
        this.recipient = recipient;
        this.shipperAddress = shipperAddress;
        this.recipientAddress = recipientAddress;
        this.shippingDetails = shippingDetails;
    }

    public ShipData getShippingDetails() {
        return shippingDetails;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' h:mm a");
        return
                "\n\nShipper: " + shipper.getFirstName() + " " + shipper.getLastName() + "\n" +
                        "Shipper Email: " + shipper.getEmail() + "\n" +
                        "Shipper Address: " + shipperAddress + "\n\n" +
                        "Recipient: " + recipient.getFirstName() + " " + recipient.getLastName() + "\n" +
                        "Recipient Email: " + recipient.getEmail() + "\n" +
                        "Recipient Address: " + recipientAddress + "\n\n" +
                        "Package Dimensions (LxWxH): " + shippingDetails.getPackageLength() + " x " +
                        shippingDetails.getPackageWidth() + " x " + shippingDetails.getPackageHeight() + "\n" +
                        "Package Contents: " + shippingDetails.getDescription() + "\n" +
                        "Package Weight: " + shippingDetails.getPackageWeight() + " lbs\n" +
                        "Shipping Speed: " + shippingDetails.getShipSpeedName() + "\n" +
                        "Tracking Number: " + shippingDetails.getTracking() + "\n\n" +
                        "Order Created: " + shippingDetails.getOrderDateTime().format(formatter) + "\n" +
                        "Estimated Delivery: " + shippingDetails.getEstimatedArrivalTime().format(formatter) +
                        "\n\n\nThank you for choosing ParcelStar* for your package!\n";
    }
}
