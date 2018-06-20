package entity;

public class Adresse {

    String adresse;
    String ort;

    public Adresse()
    {

    }

    public Adresse(String adresse, String ort) {
        this.adresse = adresse;
        this.ort = ort;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
