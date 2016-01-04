package derek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

/**
 * Created by KAdamczyk on 2016-01-04.
 */
public class SimpleClient {
    public static void main(String args[]){
        try {
            //        open your connection to a server, at port 5432
            Socket s1 = new Socket("localhost", 5432);
//        Get an inpt stream from the socket
            InputStream is = s1.getInputStream();
//        Decorate it with a Buffered input stream
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
//        Read the input and print it to the screen
            System.out.println(bis.readLine());
//        When done, just close the steam and connection
            bis.close();
            s1.close();
        }
        catch (ConnectException ce) {
            System.err.println("Could not connect.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
