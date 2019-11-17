package Controller;

import com.google.gson.Gson;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    //initialize socket and input-output stream

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    //constructor to put IP address and port
    public Client(String address, int port) {
        //establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            //takes input from terminal
            input = new DataInputStream(System.in);

            //sends output to socket
            output = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
            ;
        }


    //string to read from client
    String line = "";

        try{
            line=input.readLine();
            output.writeUTF(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //close the connection
    try{
        input.close();
        output.close();
        socket.close();
    }catch (IOException e) {
        System.out.println(e);
    }

    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 1234);
    }
}
