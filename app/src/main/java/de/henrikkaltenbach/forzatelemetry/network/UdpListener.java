package de.henrikkaltenbach.forzatelemetry.network;

import java.io.IOException;
import java.net.*;

public class UdpListener extends Thread {

    private final int port;
    private final DataProcessor processor;
    private DatagramSocket socket;

    public UdpListener(int port) {
        this.port = port;
        processor = new DataProcessor();
    }

    @Override
    public void run() {
        try {
            socket = new DatagramSocket(port);
            byte[] buffer = new byte[320];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            boolean run = true;
            int counter = 0;
            while (run) {
                try {
                    socket.receive(packet);
                    processor.parseData(packet.getData(), counter);
                    counter++;
                    packet.setLength(buffer.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    run = false;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        socket.close();
    }
}
