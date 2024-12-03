package parking;

import java.time.*;

public class Vehicle {
    private String licensePlate;
    private String vehicleType;
    private Dimensions sizeDimensions;
    private LocalDateTime entryTimestamp;
    private LocalDateTime exitTimestamp;

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

    public Dimensions getSizeDimensions() {
        return sizeDimensions;
    }

    public void setSizeDimensions(Dimensions sizeDimensions) {
        this.sizeDimensions = sizeDimensions;
    }

    public LocalDateTime getEntryTimestamp() {
        return entryTimestamp;
    }

    public void setEntryTimestamp(LocalDateTime entryTimestamp) {
        this.entryTimestamp = entryTimestamp;
    }

    public LocalDateTime getExitTimestamp() {
        return exitTimestamp;
    }

    public void setExitTimestamp(LocalDateTime exitTimestamp) {
            this.exitTimestamp = exitTimestamp;
    }

    public long getDuration() {
        return Duration.between(entryTimestamp, exitTimestamp).toMinutes();
    }
}
