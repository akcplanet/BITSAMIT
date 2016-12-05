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
import org.outreach.cts.domain.Activity;
import org.outreach.cts.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;

@Controller("activitycontroller")
@Path("/activity")
@Api(value = "/activity")
public class ActivityController extends BaseController {
	
	private static final Log log = LogFactory.getLog(ActivityController.class);

	@Autowired
	private ActivityService activityService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> getall() {
		return activityService.getall();
	}

	@GET
	@Path("/byid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Activity getByIdActivity(@PathParam("id") String id) {
		return activityService.getByIdActivity(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addActivity(Activity sd) {
		activityService.addActivity(sd);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateActivity(@PathParam("id") String id, Activity sd) {
		activityService.updateActivity(id, sd);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteActivity(@PathParam("id") String id) {
		activityService.deleteActivity(id);
	}

	

}
