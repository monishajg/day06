package socketapp;

import java.net.Socket;

// import static socketapp.IOUtils.*;

public class ListClient {

    public static void main(String[] args) throws Exception {           // step 2
        
        // Get the list size
        Integer nums = Integer.parseInt(args[0]);                       // step

        // Get the number range
        Integer range = Integer.parseInt(args[1]);                      // step
        
        // Get the host
        String host = args[2];

        // Get the port
        Integer port = Integer.parseInt(args[3]);
        
        // Create the socket to the server
        Socket socket = new Socket(host, port);
        
        System.out.printf("Connected to %s:%d\n", host, port); // end of step 2

        IOUtils.write(socket, "%d %d".formatted(nums, range));          // step 4.1

        String response = IOUtils.read(socket);

        // Process response - calculate the average

        socket.close();                                                 // end step 3
    }
}