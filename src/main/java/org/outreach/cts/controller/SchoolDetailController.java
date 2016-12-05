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
import org.outreach.cts.domain.SchoolDetails;
import org.outreach.cts.service.SchoolDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import io.swagger.annotations.Api;

@Controller("schooldetailcontroller")
@Path("/schooldetail")
@Api(value = "/schooldetail")
public class SchoolDetailController extends BaseController {

	private static final Log log = LogFactory.getLog(SchoolDetailController.class);

	@Autowired
	private SchoolDetailService schooldetailService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SchoolDetails> getall() {
		return schooldetailService.getall();
	}

	@GET
	@Path("/byid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SchoolDetails getByIdSchool(@PathParam("id") String id) {
		return schooldetailService.getByIdSchool(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addSchool(SchoolDetails sd) {
		schooldetailService.addSchool(sd);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateSchool(@PathParam("id") String id, SchoolDetails sd) {
		schooldetailService.updateSchool(id, sd);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteSchool(@PathParam("id") String id) {
		schooldetailService.deleteSchool(id);
	}

}
