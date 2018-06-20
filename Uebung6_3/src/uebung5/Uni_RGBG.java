/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung5;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author Chris
 */
public class Uni_RGBG {
    
    public static void main(String []arsgs) throws RemoteException, NotBoundException
    {
        Registry r = LocateRegistry.getRegistry("localhost",1099);
        FrueherkennungsIF serv = (FrueherkennungsIF) r.lookup("analyse");
        
        Röntgenbild bild = new Röntgenbild(new Date(),"christian j");
        CallbackIF callback = new BerichtCallback();
        CallbackIF callbackStub = (CallbackIF)UnicastRemoteObject.exportObject(callback,0);
        serv.analysieren(bild,callbackStub);
    
    
    }
    
}
