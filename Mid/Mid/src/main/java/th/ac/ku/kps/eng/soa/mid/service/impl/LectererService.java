package th.ac.ku.kps.eng.soa.mid.service.impl;

import java.io.IOException;
import java.net.ResponseCache;
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

@Path("/v1")
public class LectererService {
LecturerDAO lecDao = new LecturerDAO();

@GET
@Path("/lecterers")
@Produces(MediaType.APPLICATION_JSON)
public List<Lecturer> getUsers() {
return lecDao.getAllLecturer();
}

@GET
@Path("/lecterers/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Lecturer getCustomerByname(@PathParam("id") int id) {
return lecDao.getLecturerById(id);
}

@POST
@Path("/lecterers")
@Consumes(MediaType.APPLICATION_JSON)
public Response createLecterer(Lecturer lec) throws IOException {
int i = lecDao.addLec(lec);
if (i == 1)
return Response.status(201).entity(" createsuccessfully").build();
else
return Response.status(401).entity(" create fail").build();
}

@PUT
@Path("/lecterers")
@Consumes(MediaType.APPLICATION_JSON)
public Response editLecterer(Lecturer lec) {
int i = lecDao.updateLecterer(lec);
if (i == 1)
return Response.status(200).entity(" UpdateSuccessfully").build();
else
return Response.status(400).entity(" Update fail").build();
}

@DELETE
@Path("/lecterers/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response deleteLecterer(@PathParam("id") int id) {
int i = lecDao.deleteLecterer(id);
if (i == 1)
return Response.status(200).entity(" DeleteSuccessfully").build();
else
return Response.status(400).entity(" Delete fail").build();
}
}