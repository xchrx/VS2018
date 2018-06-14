/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung1;

/**
 *
 * @author Chris
 */
public class Parkhaus {

    int maxSpace;
    int currentState;
    Parkhaus(int space) {
      maxSpace = space;
    }
    
    
    public  synchronized void einparken()
    {
        while(maxSpace==currentState)
        {
            try
            {
                System.out.println("Fahrzeug"+ Thread.currentThread().getName()+" an der Schranke wartend");
                this.wait();
            }catch(InterruptedException ex)
             {
                        
             }
        }
        currentState++;
        System.out.println("Fahrzeug"+ Thread.currentThread().getName()+" eingeparkt");
        this.notifyAll();
    }
    
   public synchronized void ausparken()
    {
       while((currentState-1)<=2 )
        {
            try
            {
                System.out.println("Fahrzeug"+ Thread.currentThread().getName()+" an der Schranke wartend");
                this.wait();
            }catch(InterruptedException ex)
             {
                        
             }
        }
        currentState--;
        System.out.println("Fahrzeug"+ Thread.currentThread().getName()+" ausgeparkt");
        this.notifyAll();
    }
    
}
