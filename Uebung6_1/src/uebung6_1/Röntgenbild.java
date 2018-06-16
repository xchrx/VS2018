/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung6_1;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Chris
 */
public class Röntgenbild implements RoentgenbildIF{

    Date aufnahmeVom;
    transient String  patientenName;
    
    public Röntgenbild()
    {
        
    }

    public Röntgenbild(Date aufnahmeVom, String patientenName) {
        this.aufnahmeVom = aufnahmeVom;
        this.patientenName = patientenName;
    }
    @Override
    public Date getAufnahmeVom() throws RemoteException {
        return aufnahmeVom;
    }
    @Override
    public void setAufnahmeVom(Date aufnahmeVom)throws RemoteException  {
        this.aufnahmeVom = aufnahmeVom;
    }
    @Override
    public String getPatientenName() throws RemoteException {
        return patientenName;
    }
    @Override
    public void setPatientenName(String patientenName)throws RemoteException  {
        this.patientenName = patientenName;
    }
    
    
}
