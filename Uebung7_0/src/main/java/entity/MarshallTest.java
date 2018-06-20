package entity;

import javax.xml.bind.JAXB;
import java.io.File;

public class MarshallTest {


    public static void main(String []args)
    {
       Student chris = new Student("chris","Jünger", new Adresse("zum Schwarzenberg 6 a","ohio"));
        JAXB.marshal(chris,new File("chris.xml"));
        JAXB.marshal(chris,System.out);
       Student chris2= JAXB.unmarshal(new File("chris.xml"),Student.class);

        System.out.println(chris2.getVorname() + " " + chris2.getNachname());

//        Student chris = new Student(222,"chris","Jünger", new Adresse("zum Schwarzenberg 6 a","ohio"));
//        JAXBContext jc = JAXBContext.newInstance(Student.class);
//
//        Marshaller marshaller = jc.createMarshaller();
//        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/xml");
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(chris, System.out);
    }
}
