package entity;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlHelper {

    public static Connection GetConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c	=	DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08","vs-08",	"vs-08-pw");
        return c;
    }

    public static Student getStudentbyID(int id) throws SQLException, ClassNotFoundException {
        Connection c = GetConnection();
        Statement stmt = c.createStatement();
        String query = "Select* FROM Student WHERE matrikelNr="+id;
        ResultSet rs = stmt.executeQuery(query);
        rs.first();

        Student currentStudent = new Student();
        currentStudent.setMatrikelNr(rs.getInt("matrikelNr"));
        currentStudent.setVorname(rs.getString("vorname"));
        currentStudent.setNachname(rs.getString("nachname"));
        currentStudent.setEcts(rs.getInt("ects"));
        currentStudent.setAdresse(new Adresse(rs.getString("strasse"),rs.getString("ort")));
        c.close();
        return  currentStudent;
    }

    public static List<Pruefungsleistung>getPruefungsleistungenByStudentId(int id) throws SQLException, ClassNotFoundException {
        Connection c = GetConnection();
        Statement stmt = c.createStatement();
        String query = "Select* FROM Pruefungsleistung WHERE matrikelNr="+id;
        ResultSet rs = stmt.executeQuery(query);

        List<Pruefungsleistung> studentLeistung = new ArrayList<>();

        while(rs.next())
        {
            Pruefungsleistung leistung = new Pruefungsleistung();
            leistung.setMatrikelNr(rs.getInt("matrikelNr"));
            leistung.setPruefungsid(rs.getString("pruefungId"));
            leistung.setVersuch(rs.getInt("versuch"));
            leistung.setNote(rs.getFloat("note"));
            studentLeistung.add(leistung);
        }
        return studentLeistung;

    }

    public static void CreatePruefungsLeistung(Pruefungsleistung pruefungsleistung) throws SQLException, ClassNotFoundException {

        Connection c = GetConnection();
        c.setAutoCommit(false);

        try
        {


        Statement stmt = c.createStatement();
        String query = "Select * FROM Pruefung WHERE pruefungId='"+pruefungsleistung.getPruefungsid()+"'";
        ResultSet rs = stmt.executeQuery(query);
        rs.first();
        int ects = rs.getInt("ects");

            String query2 = "INSERT INTO Pruefungsleistung (pruefungId, matrikelNr, versuch, note) VALUES("+"'"+ pruefungsleistung.getPruefungsid()+"'"+","+pruefungsleistung.getMatrikelNr()+","+pruefungsleistung.getVersuch()+","+pruefungsleistung.getNote()+")";
            stmt.executeUpdate(query2);

            String query3 = "UPDATE Student SET ects = ects +"+ects+" WHERE matrikelNr="+pruefungsleistung.getMatrikelNr();
            stmt.executeUpdate(query3);
            c.commit();
        }catch (Exception e){
            c.rollback();
        }

    }


}
