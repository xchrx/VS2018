/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung1c;

/**
 *
 * @author Chris
 */
public class Simulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Parkhaus parkhaus = new Parkhaus(10);
        new Hersteller(parkhaus,"Autohaus Neutraubling").start();
        for(int i = 1; i<5;i++)
           {
                   new Kunde(parkhaus,"Kunde"+i).start();
           }
        
        		Thread.sleep(30000);
                        System.out.println("Ende der Simulation!");	
        }
    
}
