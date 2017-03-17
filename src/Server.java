import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lawrence on 3/7/16.
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2333);
        while(true) {
            Socket s = server.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
            System.out.println("Hello Client!" + s.getInetAddress() + ", " + s.getPort());
            dis.close();
            s.close();
        }
    }
}
