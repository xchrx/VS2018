/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.oth.vs.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris
 */
@XmlRootElement
public class Adresse {
    String Strasse;
    String Ort;

    public Adresse(String Strasse, String Ort) {
        this.Strasse = Strasse;
        this.Ort = Ort;
    }

    public Adresse() {
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String Strasse) {
        this.Strasse = Strasse;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String Ort) {
        this.Ort = Ort;
    }
    
  
}
