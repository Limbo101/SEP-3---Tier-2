package Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Schedule implements Serializable {

    private ArrayList<Movie> movies;

    public Schedule(){
        movies = new ArrayList<>();
    }

    public void addMovieToSchedule(String title, Cinema cinema, int duration, int date){
        movies.add(new Movie(title,cinema,duration,date));
    }

    public Movie getMovie(int index){
        return movies.get(index);
    }

    public String displayAllMovies() throws Exception {
        String all = "";
        try{

        for (int i = 0; i < movies.size();i++) {
            all+= movies.get(i).toString() + "\n" + "\n";
        }
        }
        catch (Exception e){
            if(movies.size() == 0)
                throw new Exception("List empty");
        }
        return all;
    }



}
