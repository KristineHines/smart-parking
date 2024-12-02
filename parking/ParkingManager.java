package parking;

import managers.*;
import parking_strategy.BasicParkingStrategy;
import parking_strategy.ParkingStrategy;
import sensors.CameraSensor;
import sensors.EnvironmentalSensor;
import sensors.ParkingSensor;
import sensors.UltrasonicSensor;

import java.util.List;
import java.util.Random;

public class ParkingManager {
    private PaymentManager paymentManager;
    private ParkingStrategy parkingStrategy;
    private ReservationManager reservationManager;
    private NotificationManager notificationManager;
    private EnvironmentalSensor environmentalSensor;
    private ParkingSensor sensor;
    private ParkingLot parkingLot;
    private MaintenanceManager maintenanceManager;
    private IntegrationManager integrationManager;


    public ParkingManager(int totalSpaces) {
        this.parkingLot = new ParkingLot(totalSpaces);

        // TODO need to make random if we get a dynamic parking strategy
        BasicParkingStrategy parkingStrategy = new BasicParkingStrategy(this.parkingLot);

        // initialize other classes/managers
        this.reservationManager = new ReservationManager();
        this.paymentManager = new PaymentManager();
        this.notificationManager = new NotificationManager();
        this.environmentalSensor = new EnvironmentalSensor();

        // Not sure we want these
        this.maintenanceManager = new MaintenanceManager();
        this.integrationManager = new IntegrationManager();

        // Choose sensor
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        ParkingSensor sensor;
        if (randomBoolean) {
            sensor = new UltrasonicSensor();
        } else {
            sensor = new CameraSensor();
        }
        this.parkingStrategy = parkingStrategy;
        this.sensor = sensor;

        // TODO: need to string for sensor and strategy
        System.out.println("Currently using the " + "--" + "strategy and the " + "--" + " sensor.");
    }

    public List<ParkingSpace> getAvailableSpaces() {
        return parkingLot.getAvailableSpaces();
    }

    public List<ParkingSpace> getAllSpaces() {
        return this.parkingLot.getAllSpaces();
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

    public void getEnvironmentalInformation() {
        this.environmentalSensor.getEnvironmentalInformation();
    }

    public void getReservedVehicles() {
        this.reservationManager.getReservedVehicles();
    }

    public void performMaintenance() {
        this.maintenanceManager.performMaintenance();
    }
}