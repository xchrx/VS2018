import javax.swing.JProgressBar;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

// aktive Klasse
public class Download extends Thread
{
	
	private final JProgressBar balken;
	CountDownLatch start, stop;
    // weitere Attribute zur Synchronisation hier definieren
    
	public Download(JProgressBar balken, CountDownLatch start, CountDownLatch stop) {
		this.balken = balken;
		this.start = start;
		this.stop = stop;
		start();

    }
	@Override
	public void run()
	{
		int timePerKb = new Random().nextInt(500);

		try
		{
			start.await();
			System.out.println(Thread.currentThread().getName() + " start nach await");

			for(int i=0; i<=balken.getMaximum(); i++) {
				TimeUnit.MILLISECONDS.sleep(timePerKb);
				balken.setValue(i);
			}
			stop.countDown();


		System.out.println(Thread.currentThread().getName() + " has started running again");
		} catch (InterruptedException e)
		{ e.printStackTrace();
		}

	}





}
