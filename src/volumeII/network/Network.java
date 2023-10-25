package volumeII.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Network {
    public static void main(){

        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost(); // the real address of your machind
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(address);

        Socket s = null;
        try {
            s = new Socket("time-a.nist.gov",13);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner in = null;
        try {
            in = new Scanner(s.getInputStream(), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (in.hasNextLine()){
            String line = in.nextLine();
            System.out.println(line);
        }

    }
}
