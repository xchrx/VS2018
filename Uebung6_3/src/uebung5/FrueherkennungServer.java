/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung5;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class FrueherkennungServer implements FrueherkennungsIF{

    public static void main(String[] args) throws RemoteException, AlreadyBoundException
    {
        FrueherkennungsIF serv = new FrueherkennungServer();    
        FrueherkennungsIF stub   = (FrueherkennungsIF) UnicastRemoteObject.exportObject(serv, 0);
        Registry r = LocateRegistry.createRegistry(1099);
        r.bind("analyse", stub);
        
    }

    @Override
    public void analysieren(Röntgenbild röntgenbild, CallbackIF callback) throws RemoteException {
        System.out.println("Bild erhalten");
         System.out.println("analyse läuft....");
        
         new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                 callback.setBericht(new Bericht(new Date(),"mehr Trinken","mehr Trinken"));
                } catch (InterruptedException ex) {
                    Logger.getLogger(FrueherkennungServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(FrueherkennungServer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
    }

    
}
