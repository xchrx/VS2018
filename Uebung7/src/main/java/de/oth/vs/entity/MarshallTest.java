/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.oth.vs.entity;

import java.io.File;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;

/**
 *
 * @author Chris
 */
public class MarshallTest {

    
    public static void main(String []args) throws JAXBException
    {
//        Student chris = new Student(222,"chris","Jünger", new Adresse("zum Schwarzenberg 6 a","ohio"));
//        JAXB.marshal(chris,new File("chris.xml"));
//        JAXB.marshal(chris,System.out);
//       Student chris2= JAXB.unmarshal(new File("chris.xml"),Student.class);
//
//        System.out.println(chris2.getVornamen()+ " " + chris2.getNachnamen());
        Student chris = new Student(222,"chris","Jünger", new Adresse("zum Schwarzenberg 6 a","ohio"));
        JAXBContext jc = JAXBContext.newInstance(Student.class);
    
     Marshaller marshaller = jc.createMarshaller();
     marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/xml");
     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
     marshaller.marshal(chris, System.out);
    }
}
