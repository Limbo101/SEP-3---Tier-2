package com.company;

import Model.Booking;

import java.awt.print.Book;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        while(true) {
            String id = "localhost";
            int port = 4545;

            Socket socket = new Socket(id, port);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            Booking booking = new Booking("Andrei", 1202, 14, "CinemaCiy");

            out.writeObject(booking);
        }
    }
}
