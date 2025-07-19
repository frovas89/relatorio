package br.com.frovas.mineradora.message;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.frovas.mineradora.dto.ProposalDTO;
import br.com.frovas.mineradora.dto.QuotationDTO;
import br.com.frovas.mineradora.service.OpportunityService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class KafkaEvent {

	private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

	@Inject
	OpportunityService opportunityService;

	@Incoming("proposal-channel")
	@Transactional
	public void receiveProposal(ProposalDTO proposal) {
		LOG.info("\n\n-- REcebendo Nova Proposta do Tópico Kafka --\n");
		opportunityService.buildOpportunity(proposal);
	}

	@Incoming("quotation-channel")
	@Blocking
	public void receiveProposal(QuotationDTO quotation) {
		LOG.info("\n\n-- REcebendo Nova Cotação de Moeda do Tópico Kafka --\n");
		opportunityService.saveQuotation(quotation);

	}
}
