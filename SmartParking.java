import java.util.*;
import java.util.stream.Collectors;

// --- Interfaces and Abstract Classes ---
interface ParkingSensor {
    boolean detectVehicle();
    String getParkingStatus();
}

abstract class ParkingStrategy {
    public abstract ParkingSpace findAvailableParking();
    public abstract void optimizeParking();
}

// --- Domain Objects ---
class Vehicle {
    private String licensePlate;
    private String vehicleType;

    public Vehicle(String licensePlate, String vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}

class ParkingSpace {
    private String id;
    private boolean isOccupied;

    public ParkingSpace(String id) {
        this.id = id;
        this.isOccupied = false;
    }

    public String getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }
}

class ParkingLot {
    private List<ParkingSpace> parkingSpaces;

    public ParkingLot(int totalSpaces) {
        parkingSpaces = new ArrayList<>();
        for (int i = 1; i <= totalSpaces; i++) {
            parkingSpaces.add(new ParkingSpace("Space " + i));
        }
    }

    public List<ParkingSpace> getAvailableSpaces() {
        return parkingSpaces.stream()
                .filter(space -> !space.isOccupied())
                .collect(Collectors.toList());
    }

    public List<ParkingSpace> getAllSpaces() {
        return parkingSpaces;
    }
}

// --- Sensor Implementations ---
class UltrasonicSensor implements ParkingSensor {
    public boolean detectVehicle() {
        return Math.random() < 0.5;
    }

    public String getParkingStatus() {
        return detectVehicle() ? "Occupied" : "Vacant";
    }
}

class CameraSensor implements ParkingSensor {
    public boolean detectVehicle() {
        return true; // Simplified
    }

    public String getParkingStatus() {
        return "Processing Image - Vehicle detected";
    }
}

class EnvironmentalSensor {
    public double getTemperature() {
        return 20.0 + (Math.random() * 10); // Random temperature
    }

    public double getHumidity() {
        return 40.0 + (Math.random() * 20); // Random humidity
    }

    public String getAirQuality() {
        return "Good"; // Simplified
    }
}

// --- Parking Strategies ---
class BasicParkingStrategy extends ParkingStrategy {
    private List<ParkingSpace> parkingSpaces;

    public BasicParkingStrategy(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public ParkingSpace findAvailableParking() {
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isOccupied()) {
                return space;
            }
        }
        return null;
    }

    public void optimizeParking() {
        System.out.println("Basic optimization not implemented.");
    }
}

// --- Managers ---
class ReservationManager {
    private Map<String, ParkingSpace> reservations = new HashMap<>();

    public boolean reserveSpace(String licensePlate, ParkingSpace space) {
        if (space.isOccupied()) return false;
        reservations.put(licensePlate, space);
        space.setOccupied(true);
        return true;
    }

    public ParkingSpace getReservation(String licensePlate) {
        return reservations.get(licensePlate);
    }

    public List<String> getReservedVehicles() {
        return new ArrayList<>(reservations.keySet());
    }
}

class PaymentManager {
    private Map<String, Double> payments = new HashMap<>();

    public void processPayment(String licensePlate, double amount) {
        payments.put(licensePlate, payments.getOrDefault(licensePlate, 0.0) + amount);
        System.out.println("Payment of $" + amount + " processed for " + licensePlate);
    }
}

class NotificationManager {
    public void sendNotification(String message) {
        System.out.println("Notification: " + message);
    }
}

class MaintenanceManager {
    public void performMaintenance() {
        System.out.println("Performing routine maintenance.");
    }
}

class IntegrationManager {
    public void integrateWithSystem(String systemName) {
        System.out.println("Integrating with " + systemName);
    }
}