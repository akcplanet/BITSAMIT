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
import org.outreach.cts.domain.EventsType;
import org.outreach.cts.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;

@Controller("eventtypecontroller")
@Path("/eventtype")
@Api(value = "/eventtype")
public class EventTypeController extends BaseController {
	
	private static final Log log = LogFactory.getLog(EventTypeController.class);
	@Autowired
	private EventTypeService eventTypeService;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EventsType> getall() {
		return eventTypeService.getall();
	}

	@GET
	@Path("/byid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EventsType getByIdEventType(@PathParam("id") String id) {
		return eventTypeService.getByIdEventType(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addEventType(EventsType sd) {
		eventTypeService.addEventType(sd);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateEventType(@PathParam("id") String id, EventsType sd) {
		eventTypeService.updateEventType(id, sd);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEventType(@PathParam("id") String id) {
		eventTypeService.deleteEventType(id);
	}


}
