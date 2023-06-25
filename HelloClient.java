import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4444);
    DataInputStream in = new DataInputStream(s.getInputStream());DataOutputStream out = new DataOutputStream(s.getOutputStream());out.writeUTF("Hello Word by client");
    System.out.println(in.readUTF());
    in.close();
    out.close();
    s.close();        
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    }