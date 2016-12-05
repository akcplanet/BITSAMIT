package org.outreach.cts.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.outreach.cts.dao.DashboardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dashboardservice")
public class DashboardService extends BaseService{
	private static final Log log = LogFactory.getLog(DashboardService.class);
	@Autowired
	private DashboardDAO dashboardDAO;
}
