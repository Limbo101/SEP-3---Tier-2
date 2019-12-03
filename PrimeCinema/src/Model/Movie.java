package Model;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private int duration;
    private Cinema cinema;
    private int date;

    public Movie(String title, Cinema cinema, int duration, int date){
        this.setTitle(title);
        this.setCinema(cinema);
        this.setDuration(duration);
        this.setDate(date);
    }


    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public int getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString()
    {
        String data = "";

        data+= title + " - " + duration + "\n" + cinema + " - " + cinema.getLocation();

        return data;
    }
}
