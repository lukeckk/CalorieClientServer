package src;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class User
{
    private int currentCalorie;
    private Lock balanceChangeLock;

    public User()
    {
        currentCalorie = 0;
        balanceChangeLock = new ReentrantLock();
    }

    public User (int initialCalorie)
    {
        currentCalorie = initialCalorie;
    }

    public void calorieIntake(int amount)
    {
        balanceChangeLock.lock();
        try
        {
            int newCalorie = currentCalorie + amount;
            currentCalorie = newCalorie;
        }
        finally
        {
            balanceChangeLock.unlock();
        }
    }

    public int run(int amount)
    {
        balanceChangeLock.lock();
        try
        {
            int calorieBurned = amount * 10;
            currentCalorie = currentCalorie - (amount * 10);
            return calorieBurned;
        }
        finally
        {
            balanceChangeLock.unlock();
        }
    }

    public int walk(int amount)
    {
        balanceChangeLock.lock();
        try
        {
            int calorieBurned = amount * 5;
            currentCalorie = currentCalorie - (amount * 5);
            return calorieBurned;
        }
        finally
        {
            balanceChangeLock.unlock();
        }
    }

    public int lift(int amount)
    {
        balanceChangeLock.lock();
        try
        {
            int calorieBurned = amount * 8;
            currentCalorie = currentCalorie - (amount * 8);
            return calorieBurned;
        }
        finally
        {
            balanceChangeLock.unlock();
        }
    }

    public int getCurrentCalorie()
    {
        return currentCalorie;
    }


}
