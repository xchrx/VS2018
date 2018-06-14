/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung1c;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Chris
 */
public class Parkhaus {

    int maxSpace;
    Deque<Auto> availableCars = new ArrayDeque<>();
    Parkhaus(int space) {
      maxSpace = space;
    }
    
    
    public synchronized void producedCar(Auto newCar)
    {
        while(maxSpace==availableCars.size())
        {
            try
            {
                System.out.println("Fahrzeug"+ Thread.currentThread().getName()+" an der Schranke wartend");
                this.wait();
            }catch(InterruptedException ex)
             {
                        
             }
        }
        availableCars.addLast(newCar);
        System.out.println("Fahrzeug"+ Thread.currentThread().getName()+" eingeparkt. Noch "+availableCars.size()+" verfügbar");
        this.notifyAll();
    }
    
   public synchronized void buyCar()
    {
       while((availableCars.size())==0 )
        {
            try
            {
                System.out.println("Kunde "+ Thread.currentThread().getName()+" wartend");
                this.wait();
            }catch(InterruptedException ex)
             {
                        
             }
        }
        this.availableCars.removeFirst();
        System.out.println(""+ Thread.currentThread().getName()+" Fahrzeug gekauft. Noch "+availableCars.size()+" verfügbar");
        this.notifyAll();
    }
    
}
