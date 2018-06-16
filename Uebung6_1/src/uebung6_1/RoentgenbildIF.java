/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung6_1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Chris
 */
public interface RoentgenbildIF extends Remote {

 
    public Date getAufnahmeVom() throws RemoteException; 
    public void setAufnahmeVom(Date aufnahmeVom)throws RemoteException; 

    public String getPatientenName()throws RemoteException; 
    public void setPatientenName(String patientenName)throws RemoteException; 
    
    
}
