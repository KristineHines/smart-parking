package parking;

import sensors.ParkingSensor;

import java.time.LocalDateTime;

public class ParkingSpace {
    private final String id;
    private boolean isOccupied;
    private boolean isReserved;
    private LocalDateTime reservationExpiryTime;
    // TODO: location
    private final ParkingSensor parkingSensor;

    public ParkingSpace(String id, ParkingSensor parkingSensor) {
        this.id = id;
        this.isOccupied = false;
        this.parkingSensor = parkingSensor;
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

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }

    public ParkingSensor getParkingSensor() {
        return parkingSensor;
    }

    public LocalDateTime getReservationExpiryTime() {
        return reservationExpiryTime;
    }

    public void setReservationExpiryTime(LocalDateTime reservationExpiryTime) {
        this.reservationExpiryTime = reservationExpiryTime;
    }

    public void reserveSpace(int lengthOfReservation) {
        this.reservationExpiryTime = LocalDateTime.now().plusMinutes(lengthOfReservation);
    }
}
