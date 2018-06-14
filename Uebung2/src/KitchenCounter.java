import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KitchenCounter {

    int capacity;
    int currentState;
    Lock monitor = new ReentrantLock();
    Condition leereTheke = monitor.newCondition();
    Condition volletheke = monitor.newCondition();


    public KitchenCounter(int capacity)
    {
        this.capacity = capacity;
        this.currentState = 0;
    }

    public void put()
    {
        monitor.lock();
        try{


        while(currentState==4)
        {
            try {
                volletheke.await();
                System.out.println(Thread.currentThread().getName()+" wartet");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        currentState++;
            leereTheke.signal();
            System.out.println("Semmel gebracht. Aktueller Stand: "+currentState);
        }finally {
            monitor.unlock();
        }
    }

    public void take()
    {
        monitor.lock();
        try{

            while(currentState==0)
            {
                try {
                    leereTheke.await();
                    System.out.println(Thread.currentThread().getName()+" wartet");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            currentState--;
            volletheke.signal();
            System.out.println("Semmel entnommen. Aktueller Stand: "+currentState);
        }finally {
            monitor.unlock();
        }
    }
}
