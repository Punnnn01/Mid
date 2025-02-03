package th.ac.ku.kps.eng.soa.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import th.ac.ku.kps.eng.soa.mid.dao.DepartmentDAO;
import th.ac.ku.kps.eng.soa.mid.model.Department;
import th.ac.ku.kps.eng.soa.mid.model.Lecturer;

@Path("/services")
public class DepartmentService {
	
	 DepartmentDAO depDao = new DepartmentDAO();
	 @GET
	 @Path("/departments")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Department> getUsers(){
		 return depDao.getAllDepartment();
	 }
	 
	 @GET
	 @Path("/departments/{param}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Department getDepartmentByid(@PathParam("param") String id){
		 return depDao.getDepartmentById(id);
	 }
	 
	 @POST
	 @Path("/departments/create")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response createDepartment(Department dep) throws IOException {
	 int i = depDao.addDepartment(dep);
	 if (i == 1)
		 return Response.status(201).entity("create successfully").build();
	 else
		 return Response.status(201).entity("create fail").build();
	 }
	 
	 @DELETE
	 @Path("/departments/{param}")
	 public Response deleteDepartment(@PathParam("param") String id) {
	        int i = depDao.deleteDepartment(id);
	        if (i == 1)
	            return Response.status(200).entity("Delete successfully").build();
	        else
	            return Response.status(404).entity("Lecturer not found").build();
	 }

}
