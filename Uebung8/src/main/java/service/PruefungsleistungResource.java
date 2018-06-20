package service;

import entity.Pruefungsleistung;
import entity.SqlHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

@Path("pruefungsleistungen")
public class PruefungsleistungResource {


    @GET
    @Path("/leistungen/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Pruefungsleistung> getPruefungsLeistungByStudentId(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        System.out.println("Leistungsrequest id: "+id);
        List<Pruefungsleistung> leistung = SqlHelper.getPruefungsleistungenByStudentId(id);
        return  leistung;
    }

    @POST
    @Path("/leistung")
    public boolean CreatePruefungsleistung(Pruefungsleistung leistung) throws SQLException, ClassNotFoundException {
        System.out.println("Prüfungsleistung eintragen für matrikelnr: "+ leistung.getMatrikelNr());
            SqlHelper.CreatePruefungsLeistung(leistung);
            return true;
    }
}
