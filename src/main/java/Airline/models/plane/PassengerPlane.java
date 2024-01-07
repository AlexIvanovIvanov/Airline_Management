package Airline.models.plane;

public class PassengerPlane extends BasePlane {

    int rows;
    int seatsPerRow;

    public PassengerPlane(int planeNumber, String paneManufacturer_Model) {
        super(planeNumber, paneManufacturer_Model);
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }
}
