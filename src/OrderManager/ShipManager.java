package OrderManager;

import Data.ShipData;

import java.util.ArrayList;
import java.util.List;

public class ShipManager {
    private List<ShipData> shipments;

    public ShipManager() {
        shipments = new ArrayList<>();
    }

    public void addShipment(ShipData data) {
        shipments.add(data);
    }

    public void printAllTracking() {
        for (ShipData s : shipments) {
            System.out.println("Tracking: " + s.getTracking());
        }
    }

    public ShipData findByTracking(String trackingNumber) {
        for (ShipData s : shipments) {
            if (s.getTracking().equalsIgnoreCase(trackingNumber)) {
                return s;
            }
        }
        return null;
    }
}
