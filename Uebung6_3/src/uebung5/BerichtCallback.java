/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung5;

import java.rmi.RemoteException;

/**
 *
 * @author Chris
 */
public class BerichtCallback implements CallbackIF
{

    @Override
    public void setBericht(Bericht bericht) throws RemoteException {
        
        System.out.println("Bericht erhalten, Diagnose: "+bericht.diagnose);
    }
    
}
