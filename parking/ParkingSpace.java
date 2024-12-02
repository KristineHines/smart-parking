package parking;

public class ParkingSpace {
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
