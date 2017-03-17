import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lawrence on 3/7/16.
 */
public class MTServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(2333);
        } catch(IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        int i = 1;
        while(true) {
            try {
                Socket cs = ss.accept();
                new ServerThread(cs).start();
                System.out.println("Accept " + i + " Requests");
                i++;
            } catch(IOException e) {
                System.err.println(e);
            }
        }

    }
}
