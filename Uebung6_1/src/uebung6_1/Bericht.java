/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung6_1;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Chris
 */
public class Bericht implements Serializable{
   public Date datum;
   public String diagnose;
   public String weiteresVorgehen;

    public Bericht() {
    }

    public Bericht(Date datum, String diagnose, String weiteresVorgehen) {
        this.datum = datum;
        this.diagnose = diagnose;
        this.weiteresVorgehen = weiteresVorgehen;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getWeiteresVorgehen() {
        return weiteresVorgehen;
    }

    public void setWeiteresVorgehen(String weiteresVorgehen) {
        this.weiteresVorgehen = weiteresVorgehen;
    }
    
    
}
