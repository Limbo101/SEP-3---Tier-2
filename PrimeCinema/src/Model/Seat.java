package Model;

import java.io.Serializable;

public class Seat implements Serializable {

    private int id;

    public Seat(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
