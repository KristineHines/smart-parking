import java.util.List;
import java.util.Scanner;

public class Testmain {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);
        BasicParkingStrategy strategy = new BasicParkingStrategy(parkingLot.getAllSpaces());
        ReservationManager reservationManager = new ReservationManager();
        PaymentManager paymentManager = new PaymentManager();
        NotificationManager notificationManager = new NotificationManager();
        MaintenanceManager maintenanceManager = new MaintenanceManager();
        IntegrationManager integrationManager = new IntegrationManager();
        EnvironmentalSensor environmentalSensor = new EnvironmentalSensor();
        Scanner objscn = new Scanner(System.in);

        while (true) {
            System.out.println("\nSmart Parking System");
            System.out.println("1. View Available Parking Spaces");
            System.out.println("2. Reserve a Parking Space");
            System.out.println("3. View Environment Data");
            System.out.println("4. View Reserved Vehicles");
            System.out.println("5. Perform Maintenance");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = objscn.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Available Spaces:");
                    parkingLot.getAvailableSpaces().forEach(space -> System.out.println(space.getId()));
                    break;

                    case 2:
                        System.out.println("Enter your vehicle license plate: ");
                        String licensePlate = objscn.next();
                        System.out.println("Enter your vehicle type (e.g. car, motorcycle, truck): ");
                        String vehicleType = objscn.next();
                        Vehicle vehicle = new Vehicle(licensePlate, vehicleType);
                        ParkingSpace space = strategy.findAvailableParking();
                        if (space != null && reservationManager.reserveSpace(vehicle.getLicensePlate(), space)) {
                            System.out.println("Space reserved: " + space.getId());
                            paymentManager.processPayment(vehicle.getLicensePlate(), 10.0); // Example payment
                            notificationManager.sendNotification("Reservation confirmed for " + vehicle.getVehicleType() +
                                    " with license plate number " + vehicle.getLicensePlate());
                        } else {
                            System.out.println("No available spaces or reservation failed.");
                        }
                        break;

                    case 3:
                        System.out.println("Temperature: " + environmentalSensor.getTemperature() + " °C");
                        System.out.println("Humidity: " + environmentalSensor.getHumidity() + "%");
                        System.out.println("Air Quality: " + environmentalSensor.getAirQuality());
                        break;

                    case 4:
                        List<String> reservedVehicles = reservationManager.getReservedVehicles();
                        if (reservedVehicles.isEmpty()) {
                            System.out.println("The parking lot is empty.");
                        } else {
                            System.out.println("Vehicles currently reserving parking spaces:");
                            reservedVehicles.forEach(System.out::println);
                        }
                        break;

                    case 5:
                        maintenanceManager.performMaintenance();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        objscn.close();
                        return;

                        default:
                            System.out.println("Invalid option.");
            }
        }
    }
}
