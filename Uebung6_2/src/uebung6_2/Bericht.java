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
public class Bericht implements BerichtIF{
    Date datum;
    String diagnose;
    String weiteresVorgehen;

    public Bericht() {
    }

    public Bericht(Date datum, String diagnose, String weiteresVorgehen) {
        this.datum = datum;
        this.diagnose = diagnose;
        this.weiteresVorgehen = weiteresVorgehen;
    }
@Override
    public Date getDatum() {
        return datum;
    }
@Override
    public void setDatum(Date datum) {
        this.datum = datum;
    }
@Override
    public String getDiagnose() {
        return diagnose;
    }
@Override
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
@Override
    public String getWeiteresVorgehen() {
        return weiteresVorgehen;
    }
@Override
    public void setWeiteresVorgehen(String weiteresVorgehen) {
        this.weiteresVorgehen = weiteresVorgehen;
    }
    
    
}
