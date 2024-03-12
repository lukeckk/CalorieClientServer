package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalorieService implements Runnable
{
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Calorie calorie;

    public CalorieService(Socket aSocket, Calorie aCalorie)
    {
        s = aSocket;
        calorie = aCalorie;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run()
    {
        try
        {
            try
            {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            }
            finally
            {
                s.close();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

    }

    public void doService() throws IOException
    {
        while (true)
        {
            if (!in.hasNext()) { return; }
            String command = in.next();
            if (command.equals("QUIT")) { return; }
            else { executeCommand(command); }
        }
    }

    public void executeCommand(String command)
    {
        int account = in.nextInt();
        if (command.equals("CalorieIntake"))
        {
            int amount = in.nextInt();
            calorie.calorieIntake(account, amount);
            out.println(account + " " + calorie.getCurrentCalorie(account));
            out.flush();
        }
        else if (command.equals("Run"))
        {
            int amount = in.nextInt();
            out.println(calorie.run(account, amount));
            out.flush();
        }
        else if (command.equals("Walk"))
        {
            int amount = in.nextInt();
            out.println(calorie.walk(account, amount));
            out.flush();
        }
        else if (command.equals("Lift"))
        {
            int amount = in.nextInt();
            out.println(calorie.lift(account, amount));
            out.flush();
        }
        else if (command.equals("Balance"))
        {
            out.println(account + " " + calorie.getCurrentCalorie(account));
            out.flush();
        }
        else
        {
            out.println("Invalid command");
            out.flush();
            return;
        }

//        out.print(account + " " + calorie.getCurrentCalorie(account));
//        out.flush();
    }

}
