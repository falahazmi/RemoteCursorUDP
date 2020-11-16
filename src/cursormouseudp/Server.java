/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursormouseudp;

import java.awt.Robot;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author ASUS
 */
public class Server {

    public static void main(String[] args) {
        try {
            byte[] buffer = new byte[655];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            DatagramSocket ds = new DatagramSocket(2255);
            for (;;) {
                ds.receive(dp);
                byte[] data = dp.getData();
                String pesan = new String(data, 0, data.length);
                System.out.print("Pesannya adalah = " + pesan);
                //-----> "100|200"
//            ds.close();
                String[] posisi = pesan.split("|");
                int x = Integer.parseInt(posisi[0]);
                int y = Integer.parseInt(posisi[1]);
                Robot rb = new Robot();
                rb.mouseMove(x, y);
            }
        } catch (Exception e) {
        }
    }
}