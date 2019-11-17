package Model;

import java.util.ArrayList;

public class Cinema {
    private String name;
    private String location;
    private ArrayList<Hall> halls;
    private int noSeatsPerHall;

    public Cinema(String name, String location, int halls, int noSeatsPerHall){
        this.name = name;
        this.location = location;
        this.halls = new ArrayList<>();
        this.noSeatsPerHall = noSeatsPerHall;

        createHalls(halls);

    }


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    private void createHalls(int halls){

        for (int i = 0; i < halls; i++){
            String hallId = "A" + i;
           this.halls.add(new Hall(hallId,noSeatsPerHall ));
        }
    }

    public String getAllHalls()
    {
        String all = "";

        for(int i = 0; i < halls.size();i++)
            all+= halls.get(i).getId() + "\n";

        return all;
    }
}
