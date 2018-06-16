/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung6_2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

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
    public BerichtIF analysieren(Röntgenbild röntgenbild) throws RemoteException {
        System.out.println("Bild erhalten");
        BerichtIF bericht = new Bericht(new Date(),"mehr Essen","mehr Essen");
        BerichtIF berichtStub = (BerichtIF)UnicastRemoteObject.exportObject(bericht,0);
        return berichtStub;
    }

    
}
