/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author Willy
 */
public class Client {

    public static void main(String args[]) {
        try {
            String ip = "187.236.19.10";
            InetSocketAddress sa = new InetSocketAddress(ip, 25565);
            //Socket skt = new Socket("0.0.0.0", 52000); //local - this works fine.
            Socket skt = new Socket();
            skt.connect(sa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
