package br.com.frovas.mineradora.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("v1")
public class HelloResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	@Transactional
	public Response hello() {


		return Response.ok().entity("Ae daleeee PROPOSTA!!").build();
	}

}
