import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Lawrence on 3/7/16.
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("127.0.0.1", 8099);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        DataOutputStream dos = new DataOutputStream(os);
        DataInputStream dis = new DataInputStream(is);
        double[] testData = {
                1, 2, 3, 4, 5
        };
        dos.writeInt(testData.length);
        dos.flush();
        for(double data : testData) {
            dos.writeDouble(data);
        }
        double result = dis.readDouble();
//        String str = dis.readUTF();
        System.out.println(result);
        dis.close();
        dos.close();
        s.close();
    }
}
