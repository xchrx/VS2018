package entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlAttribute
    private int matrikelNr;
    private String vorname;
    private String nachname;
    int ects;



    Adresse adresse;

    // Default-Konstruktor zwingend notwendig
    public Student() {}

    public Student(String vorname, String nachname, Adresse adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }

    public Student(int matrikelNr, String vorname, String nachname, Adresse adresse) {
        this(vorname, nachname, adresse);
        this.matrikelNr = matrikelNr;
    }


    public int getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(int matrikelNr) {
        this.matrikelNr = matrikelNr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setAdresse(Adresse adresse){this.adresse = adresse;}
    public Adresse getAdresse (){return this.adresse;}
    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return matrikelNr == student.matrikelNr;
    }

    @Override
    public int hashCode() {

        return Objects.hash(matrikelNr);
    }
}
