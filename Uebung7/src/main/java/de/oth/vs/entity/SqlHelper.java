/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.oth.vs.entity;

import de.oth.vs.rest.PruefungsleistungResource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Chris
 */
public class SqlHelper {
   public static Student GetStudentById(int id) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection("jdbc:mysql://dd1906.kasserver.com/d02ac0ab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "d02ac0ab", "vs-08-pw");
   Connection c = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08", "vs-08", "vs-08-pw");        
   Statement stmt = c.createStatement();
        String query = "SELECT * FROM Student WHERE matrikelNr="+id;
        ResultSet res = stmt.executeQuery(query);
       res.first();
       Student currentStudent = new Student();
       if(res!=null)
       {
       
       currentStudent.matrikelNr = res.getInt("matrikelNr");
       currentStudent.vornamen = res.getString("vorname");
       currentStudent.nachnamen = res.getString("nachname");
     currentStudent.ECTS = res.getInt("ects");
     
       currentStudent.adresse = new Adresse(res.getString("strasse"), res.getString("ort"));
    
       }
       
         c.close();
        return currentStudent;
    }
    
    
   public static void InsertPruefungsleistung(Pruefungsleistung leistung) throws ClassNotFoundException, SQLException
   {    
       int etcsOfExam = GetCreditsOfExam(leistung.pruefungId);
       Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection("jdbc:mysql://dd1906.kasserver.com/d02ac0ab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "d02ac0ab", "vs-08-pw");
      Connection c = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08", "vs-08", "vs-08-pw");
        c.setAutoCommit(false);
       try
       {

        Statement stmt = c.createStatement();
        String query = "INSERT INTO Pruefungsleistung VALUES("+leistung.pruefungId+","+leistung.matrikelNr+","+leistung.versuch+","+leistung.note;
        stmt.executeQuery(query);
        
       query = "UPDATE Student SET ects = ects+"+etcsOfExam+" WHERE matrikelNr="+leistung.matrikelNr;
       stmt.executeQuery(query);
        c.close();
       }
       catch(Exception	e)
       {    c.rollback();
       
       }
      
   }
   
   public static Pruefungsleistung GetPruefungsleistungById(int id) throws SQLException, ClassNotFoundException
   {
       Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection("jdbc:mysql://dd1906.kasserver.com/d02ac0ab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "d02ac0ab", "vs-08-pw");
      Connection c = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08", "vs-08", "vs-08-pw");
      Statement stmt = c.createStatement();
      String query = "SELECT* FROM Pruefungsleistung WHERE id="+id;
      ResultSet res = stmt.executeQuery(query);
            res.first();
        Pruefungsleistung leistung = new Pruefungsleistung();
        leistung.matrikelNr = res.getInt("matrikelNr");
        leistung.versuch = res.getInt("versuch");
        leistung.note = res.getFloat("note");
        leistung.pruefungId = res.getString("pruefungId");
        
        return leistung;
                
        
   }
   

   public static int GetCreditsOfExam(String examId) throws ClassNotFoundException, SQLException
   {
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection c = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08", "vs-08", "vs-08-pw");  
       String query = "SELECT ects FROM Pruefung WHERE pruefungId LIKE '"+examId+"'";
       Statement stmt = c.createStatement();
       ResultSet res = stmt.executeQuery(query);
       res.first();
      
       return res.getInt("ects");
   }
}
