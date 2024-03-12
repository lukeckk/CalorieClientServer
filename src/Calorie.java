package src;

public class Calorie
{
    private User[] accounts;

    public Calorie(int size)
    {
        accounts = new User[size];
        for (int i = 0; i < accounts.length; i++)
        {
            accounts[i] = new User();
        }
    }

    public void calorieIntake (int userId, int amount)
    {
        User account = accounts[userId];
        account.calorieIntake(amount);
    }

    public int run (int userId, int amount)
    {
        User account = accounts[userId];
        return account.run(amount);
    }

    public int walk (int userId, int amount)
    {
        User account = accounts[userId];
        return account.walk(amount);
    }

    public int lift (int userId, int amount)
    {
        User account = accounts[userId];
        return account.lift(amount);
    }

    public int getCurrentCalorie (int userId)
    {
        User account = accounts[userId];
        return account.getCurrentCalorie();
    }

}
