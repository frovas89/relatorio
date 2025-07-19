package br.com.frovas.mineradora.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.frovas.mineradora.dto.ProposalDetailsDTO;
import br.com.frovas.mineradora.service.ProposalService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/proposal")
public class ProposalController {

	private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);

	@Inject
	ProposalService proposalService;

	@GET
	@Path("/{id}")
	//	@RolesAllowed({"user", "manager"})
	public ProposalDetailsDTO findDetailsProposal(@PathParam("id") long id) {
		return proposalService.findFullProposal(id);
	}

	@POST
	public Response createProposal(ProposalDetailsDTO proposalDetails) {
		LOG.info("\n\n-- Recebendo Proposta de Compra --\n");

		try {

			proposalService.createNewProposal(proposalDetails);
			return Response.ok().build();

		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@DELETE
	@Path("/{id}")
	//	@RolesAllowed({"manager"})
	public Response removeProposal(@PathParam("id") long id) {
		try {

			proposalService.removeProposal(id);
			return Response.ok().build();

		} catch (Exception e) {
			return Response.serverError().build();
		}
	}


}
