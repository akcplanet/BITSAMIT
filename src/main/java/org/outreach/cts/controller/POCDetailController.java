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
import org.outreach.cts.domain.PocDetails;
import org.outreach.cts.service.POCDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;

@Controller("pocdetailcontroller")
@Path("/pocdetail")
@Api(value = "/pocdetail")
public class POCDetailController extends BaseController {
	
	private static final Log log = LogFactory.getLog(POCDetailController.class);

	@Autowired
	private POCDetailService pocdetailService;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PocDetails> getall() {
		return pocdetailService.getall();
	}

	@GET
	@Path("/byid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PocDetails getByIdPocDetails(@PathParam("id") String id) {
		return pocdetailService.getByIdPocDetails(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addPocDetails(PocDetails sd) {
		pocdetailService.addPocDetails(sd);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updatePocDetails(@PathParam("id") String id, PocDetails sd) {
		pocdetailService.updatePocDetails(id, sd);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePocDetails(@PathParam("id") String id) {
		pocdetailService.deletePocDetails(id);
	}


}
