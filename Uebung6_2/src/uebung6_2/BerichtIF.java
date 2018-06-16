/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung6_2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Chris
 */
public interface BerichtIF extends Remote{
     
    public Date getDatum() throws RemoteException;

    public void setDatum(Date datum) throws RemoteException;
    
    public String getDiagnose()  throws RemoteException;

    public void setDiagnose(String diagnose)  throws RemoteException;

    public String getWeiteresVorgehen()  throws RemoteException;
            
    public void setWeiteresVorgehen(String weiteresVorgehen)  throws RemoteException;
}