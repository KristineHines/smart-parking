package parking;

import managers.*;
import parking_strategy.BasicParkingStrategy;
import parking_strategy.DynamicParkingStrategy;
import parking_strategy.ParkingStrategy;
import sensors.EnvironmentalSensor;

import java.util.List;
import java.util.Random;

public class ParkingManager {
    private PaymentManager paymentManager;
    private ParkingStrategy parkingStrategy;
    private ReservationManager reservationManager;
    private NotificationManager notificationManager;
    private EnvironmentalSensor environmentalSensor;
    private ParkingLot parkingLot;
    private MaintenanceManager maintenanceManager;
    private IntegrationManager integrationManager;


    public ParkingManager(int totalSpaces) {
        this.parkingLot = new ParkingLot(totalSpaces);

        Random random = new Random();
        this.parkingStrategy = random.nextBoolean() ?
                new BasicParkingStrategy(this.parkingLot, totalSpaces) : new DynamicParkingStrategy(this.parkingLot, totalSpaces);

        // initialize other classes/managers
        this.reservationManager = new ReservationManager();
        this.paymentManager = new PaymentManager();
        this.notificationManager = new NotificationManager();
        this.environmentalSensor = new EnvironmentalSensor();

        // Not sure we want these
        this.maintenanceManager = new MaintenanceManager();
        this.integrationManager = new IntegrationManager();
    }

    // ---- Parking Spaces ----
    public List<ParkingSpace> getAvailableSpaces() {
        return parkingLot.getAvailableSpaces();
    }

    public List<ParkingSpace> getAllSpaces() {
        return this.parkingLot.getAllSpaces();
    }

    // ---- Reservations ----
    public ReservationManager getReservationManager() {
        return reservationManager;
    }

    public void getReservedVehicles() {
        this.reservationManager.getReservedVehicles();
    }

    public void reserveParkingSpace(String licensePlate, String vehicleType) {
        Vehicle vehicle = new Vehicle(licensePlate, vehicleType);
        ParkingSpace space = this.parkingStrategy.findAvailableParking();
        if (space != null && this.reservationManager.reserveSpace(vehicle.getLicensePlate(), space)) {
            System.out.println("Space reserved: " + space.getId());
            this.paymentManager.processPayment(vehicle.getLicensePlate(), 10.0); // Example payment
            this.notificationManager.sendNotification("Reservation confirmed for " + vehicle.getVehicleType() +
                    " with license plate number " + vehicle.getLicensePlate());
        } else {
            System.out.println("No available spaces or reservation failed.");
        }
    }

    // ---- Environmental ----
    public void getEnvironmentalInformation() {
        this.environmentalSensor.getEnvironmentalInformation();
    }

    // ---- Maintenance ----
    public void performMaintenance() {
        this.maintenanceManager.performMaintenance();
    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }
}
