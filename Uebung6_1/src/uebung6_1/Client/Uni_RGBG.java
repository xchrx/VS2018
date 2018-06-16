/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung6_1.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import uebung6_1.Bericht;
import uebung6_1.FrueherkennungsIF;
import uebung6_1.RoentgenbildIF;
import uebung6_1.Röntgenbild;

/**
 *
 * @author Chris
 */
public class Uni_RGBG {
    
    public static void main(String []arsgs) throws RemoteException, NotBoundException
    {
        Registry r = LocateRegistry.getRegistry("localhost",1099);
        FrueherkennungsIF serv = (FrueherkennungsIF) r.lookup("analyse");   
        RoentgenbildIF bild = new Röntgenbild(new Date(),"christian j");
        
        RoentgenbildIF bildStub = (RoentgenbildIF)UnicastRemoteObject.exportObject(bild, 0);
        Bericht bericht = serv.analysieren(bildStub);
        
        System.out.println("Bericht erhalten, Diagnose: "+bericht.diagnose);
        System.out.println("Röntgenbild Name"+ bild.getPatientenName());
    
    }
    
}
