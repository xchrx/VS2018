/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.oth.vs.entity;

/**
 *
 * @author Chris
 */
public class Pruefungsleistung {
  String pruefungId;
  int matrikelNr;
  int versuch;
  float note;

    public Pruefungsleistung(String pruefungId, int matrikelNr, float note) {
        this.pruefungId = pruefungId;
        this.matrikelNr = matrikelNr;
        this.note = note;
    }

    public String getPruefungId() {
        return pruefungId;
    }

    public void setPruefungId(String pruefungId) {
        this.pruefungId = pruefungId;
    }

    public int getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(int matrikelNr) {
        this.matrikelNr = matrikelNr;
    }

    public int getVersuch() {
        return versuch;
    }

    public void setVersuch(int versuch) {
        this.versuch = versuch;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Pruefungsleistung() {
    }
}
