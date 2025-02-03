package th.ac.ku.kps.eng.soa.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import th.ac.ku.kps.eng.soa.mid.dao.LecturerDAO;
import th.ac.ku.kps.eng.soa.mid.model.Lecturer;

@Path("/services")
public class LecturerService {
	
	LecturerDAO lecDao = new LecturerDAO();
	 @GET
	 @Path("/lecturers")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Lecturer> getUsers(){
		 return lecDao.getAllLecturer();
	 }
	 
	 @GET
	 @Path("/lecturers/{param}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Lecturer getLecturerByid(@PathParam("param") String id){
		 return lecDao.getLecturerById(id);
	 }
	 
	 @POST
	 @Path("/lecturers/create")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response createLecturer(Lecturer lec) throws IOException {
	 int i = lecDao.addLecturer(lec);
	 if (i == 1)
		 return Response.status(201).entity("create successfully").build();
	 else
		 return Response.status(201).entity("create fail").build();
	 }
	 
	   @PUT
	   @Path("/lecturers")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response updateCustomer(Lecturer updatedCustomer) {
		   int i = lecDao.deleteLecturer(updatedCustomer.getId());
		   int j = lecDao.addLecturer(updatedCustomer);
	        if (i == 1)
	            return Response.status(200).entity("Update successfully").build();
	        else
	            return Response.status(404).entity("Customer not found").build();
	   }
	 
	 
	 @DELETE
	 @Path("/lecturers/{param}")
	 public Response deleteLecturer(@PathParam("param") String id) {
	        int i = lecDao.deleteLecturer(id);
	        if (i == 1)
	            return Response.status(200).entity("Delete successfully").build();
	        else
	            return Response.status(404).entity("Lecturer not found").build();
	 }

}
