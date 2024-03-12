package src;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        final int USER_LENGTH = 10;
        //1 Calorie
        //instantiate Calorie class
        Calorie calorie = new Calorie(USER_LENGTH);


        final int SBAP_PORT = 5110;
        //2 Server. to connect
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for client to connect...");

        while(true)
        {
            Socket s = server.accept();
            System.out.println("Client connected.");
            //3 Service. To give function after connecting
            CalorieService service = new CalorieService(s, calorie);
            Thread t = new Thread(service);
            t.start();


        }
    }
}
