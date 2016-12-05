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
import org.outreach.cts.domain.Council;
import org.outreach.cts.service.CouncilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;

@Controller("councilcontroller")
@Path("/council")
@Api( value = "/council")
public class CouncilController extends BaseController  {
	private static final Log log = LogFactory.getLog(CouncilController.class);
	@Autowired
	private CouncilService councilService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Council> getall() {
		return councilService.getall();
	}

	@GET
	@Path("/byid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Council getByIdCouncil(@PathParam("id") String id) {
		return councilService.getByIdCouncil(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addCouncil(Council sd) {
		councilService.addCouncil(sd);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateCouncil(@PathParam("id") String id, Council sd) {
		councilService.updateCouncil(id, sd);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCouncil(@PathParam("id") String id) {
		councilService.deleteCouncil(id);
	}


}
