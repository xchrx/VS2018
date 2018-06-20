package service;

import entity.Adresse;
import entity.Student;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("studienangelegenheiten")
public class StudentService {

    private static int nextStudentId = 1;

    public Student immatriculate(Student s) {

        throw new IllegalStateException("method needs to be implemented first");

    }

    public Student exmatriculate(int studentId) {

        throw new IllegalStateException("method needs to be implemented first");

    }
    @GET
    @Path("student/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("id") int studentId) {
        System.out.println("Request: Studentid: "+studentId);
      return new Student("chris","Jünger", new Adresse("zum Schwarzenberg 6 a","ohio"));

    }

    public Student updateStudentAccount(int nextStudentId, Student newData) {

        throw new IllegalStateException("method needs to be implemented first");

    }

    public List<Student> getAllStudents() {

        throw new IllegalStateException("method needs to be implemented first");

    }
    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_XML)
    public List<Student> getStudentsByRange(@QueryParam("from") int fromStudentId, @QueryParam("to")int toStudentId) {
        System.out.println("Request: Studentid: "+fromStudentId);
        List<Student> currentList = new ArrayList<>();
        currentList.add(    new Student("chris","Jünger", new Adresse("zum Schwarzenberg 6 a","ohio")));
        currentList.add(    new Student("chris","Jünger", new Adresse("zum Schwarzenberg 6 a","ohio")));

        return currentList;
    }
}
