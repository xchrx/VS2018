/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung6_2;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Chris
 */
public class Röntgenbild implements Serializable{

    Date aufnahmeVom;
    transient String  patientenName;
    
    public Röntgenbild()
    {
        
    }

    public Röntgenbild(Date aufnahmeVom, String patientenName) {
        this.aufnahmeVom = aufnahmeVom;
        this.patientenName = patientenName;
    }
 
    public Date getAufnahmeVom() {
        return aufnahmeVom;
    }

    public void setAufnahmeVom(Date aufnahmeVom) {
        this.aufnahmeVom = aufnahmeVom;
    }

    public String getPatientenName() {
        return patientenName;
    }

    public void setPatientenName(String patientenName) {
        this.patientenName = patientenName;
    }
    
    
}
