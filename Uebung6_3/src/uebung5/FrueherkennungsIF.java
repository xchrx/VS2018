/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung5;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Chris
 */
public interface FrueherkennungsIF extends Remote{
    
    public void analysieren(Röntgenbild röntgenbild, CallbackIF callback) throws RemoteException;
}
