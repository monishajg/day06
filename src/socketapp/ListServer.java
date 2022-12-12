package socketapp;

import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListServer {
    
    public static void main(String[] args) throws Exception {   // step 1 throw exception

        // Get the port
        Integer port = Integer.parseInt(args[0]); // [0] refers to port 8080

        // Random number generator
        Random rnd = new SecureRandom();                        // step 6

        // Create a ServerSocket and Bind to the port
        ServerSocket server = new ServerSocket(port);
        System.out.printf("Listening on port %d\n", port);

        // Server loop
        while (true) {
            //Wait for a connection
            System.out.println("Waiting for connections...");
            Socket socket = server.accept();              // end step 1

            System.out.printf("New connection on port %d\n", socket.getPort());

            String payload = IOUtils.read(socket);              // step 5
            String[] values = payload.split(" ");         // step 6.1
           
            Integer count = Integer.parseInt(values[0]);
            Integer range = Integer.parseInt(values[1]);
            
            List<Integer> randNums = new LinkedList <>();
            for (Integer i = 0; i < count; i++)
                randNums.add(rnd.nextInt(range));

            String response = randNums.stream()
                .map(v -> v.toString())
                .collect(Collectors.joining(":"));

            IOUtils.write(socket,response);

            socket.close();                                    // step 3
        }
    }
}