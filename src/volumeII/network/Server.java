package volumeII.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(){
        try(ServerSocket s = new ServerSocket(8189)){
            try(Socket incoming = s.accept()){
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                try(Scanner in = new Scanner(inStream, "UTF-8")){
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"),true);
                    out.println("Hello! enter BYE to exit.");
                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        System.out.println("Message: " + line);
                        out.println("Echo: " + line);
                        if(line.trim().equals("BYE"))done=true;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
