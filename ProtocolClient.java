import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ProtocolClient {
    public static void main(String[] args) {
        try {
            InputStream is = System.in;
        Socket s = new Socket("server", 4444);
        DataInputStream in = new DataInputStream(s.getInputStream());DataOutputStream out = new DataOutputStream(s.getOutputStream()); while (true) {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader stdIn = new BufferedReader(isr);
        String fromUser = stdIn.readLine();
        System.out.println(in.readUTF());
        if (fromUser.equals("Bye")) break;
        }
        in.close();
        out.close();
        s.close();
        
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String processLine(String fromClient) {
        return null;
    }
}
