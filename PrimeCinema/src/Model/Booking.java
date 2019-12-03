package Model;

import java.io.Serializable;

public class Booking implements Serializable {

    private String location;
    private int date;
    private Seat seat;
    private String clientName;
    private int id;

    public Booking(String clientName, int date, int seatId, String location){
        this.clientName = clientName;
        this.date = date;
        this.seat = new Seat(seatId);
        this.location = location;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return getClientName() + "\n" + getDate() + "\n" + getId();
    }
}
