package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pruefungsleistung {
    String pruefungsid;
    int matrikelNr;
    int versuch;
    float note;

    public Pruefungsleistung() {
    }

    public Pruefungsleistung(String pruefungsid, int matrikelNr, int versuch, float note) {
        this.pruefungsid = pruefungsid;
        this.matrikelNr = matrikelNr;
        this.versuch = versuch;
        this.note = note;
    }

    public String getPruefungsid() {
        return pruefungsid;
    }

    public void setPruefungsid(String pruefungsid) {
        this.pruefungsid = pruefungsid;
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
}
