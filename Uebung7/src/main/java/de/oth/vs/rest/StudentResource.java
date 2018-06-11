/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.oth.vs.rest;

import static de.oth.vs.entity.SqlHelper.GetStudentById;
import de.oth.vs.entity.Student;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;




/**
 *
 * @author Chris
 */
@Path("studienangelegenheiten")
public class StudentResource {
    
   
    
    @GET
    @Path("student/{id}")
    @Produces(MediaType.APPLICATION_XML)	
    public Student getStudentById(@PathParam("id")int id) throws JAXBException, ClassNotFoundException, SQLException{
           Student currentStudent= GetStudentById(id);

     return currentStudent;
    }
    
    @DELETE
    @Path("student/{id}")
    public void deleteStudentById(@PathParam("id")int id)
    {
          System.out.println("deleted  Student " + id);
    }
    @PUT
    @Path("student/{data}")
    public void CreateStudent(@PathParam("data")String student)
    {
        System.out.println(student);
    }
    
    @GET
    @Path("students")
 
    public Student[] getStudentByIdRange(@QueryParam("from") int from,@QueryParam("to") int to)
    {
     Student[] students = new Student[2];
     students[0] = new Student(2000,"sepp","meyer");
     students[1] = new Student(2000,"sepp","meyer");
     System.out.println("return List of Students from"+from +" to: "+to );
     return students; 
    }
    

    

}
