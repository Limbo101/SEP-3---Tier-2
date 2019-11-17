package Controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {

    public Database(){}

    public Connection getDatabase() throws Exception{
        // Establishing a connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseUrl = "jdbc:mysql://10.152.192.75:3306/database1";
            String user = "Catalin";
            String password = "root";

            Connection connection = DriverManager.getConnection(databaseUrl, user, password);
            System.out.println("Connection established to: " + databaseUrl);
            return connection;
        } catch (Exception exception) {
            System.out.println("Connection failed");
            exception.printStackTrace();
        }

        return null;
    }

    public ArrayList<String> get() throws Exception{
        try{
            Connection con = getDatabase();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Client");

            ResultSet result = statement.executeQuery();

            String something = "";

            ArrayList<String> array = new ArrayList<>();
            while(result.next()){
                System.out.print(result.getString(1));
                System.out.print(" ");
                System.out.println(result.getString(2));
                System.out.println(result.getString("Email"));

                something = result.getString(1) + " " + result.getString(2) +  " " +  result.getString("Email");

                array.add(something);

            }
            System.out.println("All records have been selected!");
            return array;

        }catch(Exception e){System.out.println(e);}
        return null;

    }


}