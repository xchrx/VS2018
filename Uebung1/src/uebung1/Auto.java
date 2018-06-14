/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung1;

import static com.sun.glass.ui.Application.run;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class Auto extends Thread{
    
    Parkhaus parkaus;
    
    public Auto(String kfz, Parkhaus parkhaus){
    super(kfz);
    this.parkaus = parkhaus;
   
}
    @Override
    public void run()
    { 
        while(true)
        {
            try {
                Thread.sleep(10);
           
            } catch (InterruptedException ex) {
                 
            }
               parkaus.einparken();
             try {
                Thread.sleep(10);
        
            } catch (InterruptedException ex) {
               
            }
             parkaus.ausparken();
        }
    }
    
}
