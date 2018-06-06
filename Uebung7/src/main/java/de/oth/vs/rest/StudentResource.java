/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.oth.vs.rest;

import de.oth.vs.entity.Student;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
    
    public List<Student>studentList = new ArrayList<Student>();
    
    @GET
    @Path("student/{id}")
 @Produces(MediaType.APPLICATION_JSON)	
    public Student getStudentById(@PathParam("id")int id) throws JAXBException{
        System.out.println("Request STudentid:"+id);
   Student chris = new Student(2000,"sepp","meyer");
              return chris;
//     JAXBContext jc = JAXBContext.newInstance(Student.class);
//     Student chris = new Student(2000,"sepp","meyer");
//     Marshaller marshaller = jc.createMarshaller();
//     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//     marshaller.marshal(chris, System.out);
//     return chris;
    }
    
    @DELETE
    @Path("student/{id}")
    public void deleteStudentById(@PathParam("id")int id)
    {
          System.out.println("deleted  Student " + id);
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
    

    
    public void createStudentlist(){
        studentList.add(new Student(1,"sepp","meyer"));
        studentList.add(new Student(12,"sepp","meyer"));
        studentList.add(new Student(123,"sepp","meyer"));
        studentList.add(new Student(1234,"sepp","meyer"));
      
      
    }
}
