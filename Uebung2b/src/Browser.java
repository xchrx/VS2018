import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Browser extends JFrame implements ActionListener{
	
	private int downloads;
	private JProgressBar[] balken;
	private JButton startButton;
    CountDownLatch start;
    CountDownLatch stop;

	// Deklaration Ihrer Synchronisations-Hilfsklassen hier:





	public Browser(int downloads) {
		super("Mein Download-Browser");
		this.downloads = downloads;
		
		// Initialisierung Ihrer Synchronisations-Hilfsklassen hier:







		// Aufbau der GUI-Elemente:	
		balken = new JProgressBar[downloads];
		start = new CountDownLatch(1);
		stop = new CountDownLatch(5);
		JPanel zeilen = new JPanel(new GridLayout(downloads, 1));
		
		for(int i=0; i<downloads; i++) {
			JPanel reihe = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 10));
			balken[i] = new JProgressBar(0, 100);
                        balken[i].setPreferredSize(new Dimension(500, 20));
			reihe.add(balken[i]);
			zeilen.add(reihe);




			new Download(balken[i],start, stop);



		}

		startButton = new JButton("Downloads starten");
		startButton.addActionListener(this);
		
		this.add(zeilen, BorderLayout.CENTER);
		this.add(startButton, BorderLayout.SOUTH);
		
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Browser(5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Blockierte Threads jetzt laufen lassen:

        start.countDown();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stop.await();
                    startButton.setText("ENDE");
                } catch (InterruptedException e1) {
                }
            }
        }).start();


		startButton.setEnabled(false);
		startButton.setSelected(false);
		startButton.setText("Downloads laufen...");
		
		// Auf Ende aller Download-Threads warten ... erst dann die Beschriftung ändern
		// Achtung, damit die Oberflaeche "reaktiv" bleibt dies in einem eigenen Runnable ausfuehren!










	}

}
