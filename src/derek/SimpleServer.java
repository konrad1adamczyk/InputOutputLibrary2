package derek;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by KAdamczyk on 2016-01-04.
 */
public class SimpleServer {
    public static void main(String args[])
    {
        ServerSocket s = null;
        try {
            s = new ServerSocket(5432);
        } catch (IOException e){
            e.printStackTrace();
        }

        while (true){
            try {
//                Whait here and listen for a connection
                Socket s1 = s.accept();
//                get output stream associated with the socket
                OutputStream s1out = s1.getOutputStream();
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(s1out));
//                Send yout string!
                bw.write("Hello Net World!\n");
//                Close the connection, but not the server socket
                bw.close();
                s1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
 //            End of try-catch
        }
//        End of while(true)
    }
//        End of main method
}
