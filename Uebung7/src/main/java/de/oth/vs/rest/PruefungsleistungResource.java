/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.oth.vs.rest;

import de.oth.vs.entity.Pruefungsleistung;
import static de.oth.vs.entity.SqlHelper.GetPruefungsleistungById;
import static de.oth.vs.entity.SqlHelper.InsertPruefungsleistung;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Chris
 */
@Path("Pruefungsleistungen")
public class PruefungsleistungResource {
    

  
  @POST
  @Path("leistungen")
  @Consumes(MediaType.APPLICATION_JSON)
  public void RegisterPruefung(Pruefungsleistung leistung) throws ClassNotFoundException, SQLException
  {
      InsertPruefungsleistung(leistung);
  }
  
  
  @GET
  @Path("leistungen/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Pruefungsleistung GetPruefungsleistung(@PathParam("id")int iD) throws SQLException, ClassNotFoundException
  {
     Pruefungsleistung leistung =  GetPruefungsleistungById(1);
     return leistung;
      
  }
}
