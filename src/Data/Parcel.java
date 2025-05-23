package Data;

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

    @Override
    public String toString() {
        return "\n----------------------------------\n" +
                "Shipper: " + shipper.getFirstName() + " " + shipper.getLastName() + "\n" +
                "Shipper Email: " + shipper.getEmail() + "\n" +
                "Shipper Address: " + shipperAddress + "\n\n" +
                "Recipient: " + recipient.getFirstName() + " " + recipient.getLastName() + "\n" +
                "Recipient Email: " + recipient.getEmail() + "\n" +
                "Recipient Address: " + recipientAddress + "\n\n" +
                "Package Dimensions (LxWxH): " + shippingDetails.getPackageLength() + " x " +
                shippingDetails.getPackageWidth() + " x " + shippingDetails.getPackageHeight() + "\n" +
                "Package Weight: " + shippingDetails.getPackageWeight() + " lbs\n" +
                "Tracking Number: " + shippingDetails.getTracking() + "\n\n" +
                "Thank you for choosing ParcelStar* for your package!";
    }


}
