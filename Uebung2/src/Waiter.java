public class Waiter extends Thread {

    KitchenCounter theke;

    public Waiter(KitchenCounter theke, String name)
    {
        super(name);
        this.theke = theke;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            theke.put();
        }
    }
}
