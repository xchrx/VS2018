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
public class Simulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Parkhaus parkhaus = new Parkhaus(10);
        for(int i = 1; i<20;i++)
           {
        Auto current =   new Auto("R-FH "+i,parkhaus);
        current.setDaemon(true);
        current.start();
            }
        
        		Thread.sleep(30000);
                        System.out.println("Ende der Simulation!");	
        }
    
}
