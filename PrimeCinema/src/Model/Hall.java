package Model;

import java.util.ArrayList;

public class Hall {

    private String id;
    private int numberOfSeats;
    private ArrayList<Seat> seats;

    public Hall(String id, int hallSize){
        this.id = id;
        seats = new ArrayList<>();
        createSeats(hallSize);
        this.numberOfSeats = hallSize;

    }

    public void createSeats(int hallSize){
        for(int i = 0; i<hallSize;i++){
            seats.add(new Seat(i));
        }
    }

    public String getId(){
        return id;
    }

    public int getNumberOfSeats(){
        return numberOfSeats;
    }

    public String getAllSeats(){
        String all = "";

        for(int i = 0; i < seats.size();i++)
            all+="Seat " + seats.get(i).getId()+ "\n";

        return all;
    }



}
