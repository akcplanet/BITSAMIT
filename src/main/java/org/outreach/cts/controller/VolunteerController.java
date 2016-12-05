package org.outreach.cts.controller;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.outreach.cts.domain.VolunteerDetails;
import org.outreach.cts.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;

@Controller("volunteercontroller")
@Path("/volunteer")
@Api( value = "/volunteer")
public class VolunteerController extends BaseController {
	
	private static final Log log = LogFactory.getLog(VolunteerController.class);
	
	@Autowired
	private VolunteerService volunteerService;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VolunteerDetails> getall() {
		return volunteerService.getall();
	}

	@GET
	@Path("/byid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public VolunteerDetails getByIdVolunteer(@PathParam("id") String id) {
		return volunteerService.getByIdVolunteer(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addVolunteer(VolunteerDetails sd) {
		volunteerService.addVolunteer(sd);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateVolunteer(@PathParam("id") String id, VolunteerDetails sd) {
		volunteerService.updateVolunteer(id, sd);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteVolunteer(@PathParam("id") String id) {
		volunteerService.deleteVolunteer(id);
	}

}
