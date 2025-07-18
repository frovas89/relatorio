package br.com.frovas.mineradora.resource;

import br.com.frovas.mineradora.service.QuotationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("v1")
public class HelloResource {

	@Inject
	QuotationService quotationService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public Response hello() {

		quotationService.getCurrencyPrice();

		return Response.ok().entity("Ae daleeee!!").build();
	}

}
