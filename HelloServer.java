import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    public static void main(String[] args) {
      try {
        ServerSocket s = new ServerSocket(4444);
        Socket ns = s.accept();
        DataInputStream in = new DataInputStream(ns.getInputStream());DataOutputStream out = new DataOutputStream(ns.getOutputStream());System.out.println(in.readUTF());
        out.writeUTF("Hello Client by server");
        in.close();
        out.close();
        ns.close();
        s.close();
      } catch (Exception e) {
        // TODO: handle exception
      }

    }
}
