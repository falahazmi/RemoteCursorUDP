/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursormouseudp;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author ASUS
 */
public class Client {
    public static void main(String[] args) {
        try {
            InetAddress alamat=InetAddress.getByName("10.10.100.19");
            int port=2255;
            PointerInfo a;
            Point bb;
            for(;;){
                a= MouseInfo.getPointerInfo();
                bb = a.getLocation();
                int x = (int) bb.getX();
                int y = (int) bb.getY();
                String xx=String.valueOf(x);
                String yy=String.valueOf(y);
                String pesan=xx+"|"+yy+"|";
                byte[] b=pesan.getBytes();
                DatagramPacket dp=new DatagramPacket(b,b.length,alamat, port);
                DatagramSocket ds=new DatagramSocket();
                ds.send(dp);
                System.out.println(pesan);
            }
        } catch (Exception e) {
        }
    }
    
}
