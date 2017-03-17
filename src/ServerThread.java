import java.io.*;
import java.net.Socket;

/**
 * Created by Lawrence on 3/7/16.
 */
public class ServerThread extends Thread {
    Socket socket;
    public ServerThread(Socket s) {
        socket = s;
    }
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            DataInputStream din = new DataInputStream(in);
            String name = din.readUTF();
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("Hello, " + name);
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
