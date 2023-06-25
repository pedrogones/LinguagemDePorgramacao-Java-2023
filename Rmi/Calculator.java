import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements Runnable {

    private static List<Socket> clientes = new ArrayList<>();
    private Socket s;

    public Servidor(Socket ns) {
        s = ns;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            // Adiciona o socket do cliente à lista
            clientes.add(s);

            while (true) {
                String fromClient = in.readUTF();

                // Envia a mensagem para todos os clientes
                for (Socket cliente : clientes) {
                    DataOutputStream clienteOut = new DataOutputStream(cliente.getOutputStream());
                    clienteOut.writeUTF(fromClient);
                }

                if (fromClient.equals("Bye")) break;
            }

            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(4444);
            while (true) {
                Socket ns = s.accept();
                new Thread(new Servidor(ns)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
clientes:
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.1.6", 4444);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        // Thread para ler mensagens do servidor
        Thread serverReaderThread = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverReaderThread.start();

        // Loop principal para enviar mensagens
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String fromUser = scanner.nextLine();
            out.writeUTF(fromUser);
            if (fromUser.equals("Bye")) break;
        }

        // Encerrando a conexão
        in.close();
        out.close();
        s.close();
    }
}