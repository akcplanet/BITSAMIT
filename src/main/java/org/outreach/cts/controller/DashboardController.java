package org.outreach.cts.controller;

import javax.ws.rs.Path;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.outreach.cts.service.ActivityService;
import org.outreach.cts.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;

@Controller("dashboardcontroller")
@Path("/dashboard")
@Api( value = "/dashboard")
public class DashboardController  extends BaseController {
	private static final Log log = LogFactory.getLog(DashboardController.class);
	
	@Autowired
	private DashboardService dashboardService;

}
