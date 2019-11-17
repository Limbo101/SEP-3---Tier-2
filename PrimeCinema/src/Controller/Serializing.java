package Controller;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Serializing<T> {

    private T object;
    private ArrayList<T> objects;


  public Serializing(T obj){
      this.object = obj;
      objects = new ArrayList<>();
  }

  private T getObject(){
      return object;
  }

  public void addObject(){
      objects.add(getObject());
  }

    public String objectToJson(){

        Gson json = new Gson();

        String response = json.toJson(getObject());

        return response;

    }

    public String arrayListToJson(){
      Gson json = new Gson();

      String response = json.toJson((objects));

      return response;
    }


}
