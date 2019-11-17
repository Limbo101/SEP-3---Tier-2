package Controller;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a string : ");

        String input = s.nextLine();
        byte[] buffer = input.getBytes();

        DatagramSocket sck = new DatagramSocket();

        InetAddress address = InetAddress.getByName("localhost");

        DatagramPacket mypacket = new DatagramPacket(buffer, buffer.length, address,8888);

        sck.send(mypacket);
    }
}
