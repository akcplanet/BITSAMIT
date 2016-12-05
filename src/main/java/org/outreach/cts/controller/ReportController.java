package org.outreach.cts.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.outreach.cts.dto.ReportDTO;
import org.outreach.cts.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;

@Controller("reportcontroller")
@Path("/report")
@Api(value = "/report")
public class ReportController extends BaseController {

	private static final Log log = LogFactory.getLog(ReportController.class);

	@Autowired
	private ReportService reportService;

	@GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response createReport() {
		try {
			ResponseBuilder response = Response.ok((Object) reportService.createReport());
			response.header("Content-Disposition", "attachment; filename=" + "amit" + ".xlxs");
			return response.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().entity(e.getMessage()).build();
		}

	}

	@GET
	@Path("/{fileName}/pdf")
	@Produces("application/pdf")
	public Response getFileInPDFFormat(@PathParam("fileName") String fileName) {

		File file = new File("c:/demoPDFFile.pdf");

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", fileName = "howtodoinjava.pdf");
		return response.build();
	}

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadReport(MultipartFormDataInput multipartFormDataInput) {

		// local variables
		MultivaluedMap<String, String> multivaluedMap = null;
		String fileName = null;
		InputStream inputStream = null;
		String uploadFilePath = null;

		try {
			Map<String, List<InputPart>> map = multipartFormDataInput.getFormDataMap();
			List<InputPart> lstInputPart = map.get("uploadedFile");

			for (InputPart inputPart : lstInputPart) {

				// get filename to be uploaded
				multivaluedMap = inputPart.getHeaders();
				/* fileName = getFileName(multivaluedMap); */

				if (null != fileName && !"".equalsIgnoreCase(fileName)) {

					// write & upload file to UPLOAD_FILE_SERVER
					inputStream = inputPart.getBody(InputStream.class, null);
					/*
					 * uploadFilePath = writeToFileServer(inputStream,
					 * fileName);
					 */

					// close the stream
					inputStream.close();
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// release resources, if any
		}
		return Response.ok("File uploaded successfully at " + uploadFilePath).build();

	}

}
