/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung1c;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class Kunde extends Thread {
    
    Parkhaus parkhaus;
    
    public Kunde(Parkhaus parkhaus, String name)
    {
        super(name);
        this.parkhaus = parkhaus;
    }
    @Override
    public void run(){
        
        while(true)
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hersteller.class.getName()).log(Level.SEVERE, null, ex);
            }
            parkhaus.buyCar();
        }
        
    }
}
