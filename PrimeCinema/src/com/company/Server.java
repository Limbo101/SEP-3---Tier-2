package com.company;

import Model.Booking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public
    static void main(String args[]) throws IOException, ClassNotFoundException {
        final int PORT = 4545;

        System.out.println("Starting Server...");

// create welcoming socket at port 4545
        ServerSocket welcomeSocket = new ServerSocket(PORT);

        while (true) {
            System.out.println("Waiting for a client...");
            // Wait, on welcoming socket for contact by client
            Socket socket = welcomeSocket.accept();
            System.out.println("The client " + socket.getInetAddress().getHostName() + " has connected");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Start a thread with the client communication
            Object data = in.readObject();

            Booking booking = (Booking)data;

            System.out.println(booking.getClientName());



        }
    }
}
