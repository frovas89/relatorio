package br.com.frovas.mineradora.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvent {

	private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

	//	@Channel("proposal-channel")
	//	Emitter<ProposalDTO> proposalRequestEmitter;
	//
	//	public void sendNewKafkaEvent(ProposalDTO proposalDTO) {
	//
	//		LOG.info("\n\n-- Enviando Nova Proposta para Tópico Kafka --\n");
	//		proposalRequestEmitter.send(proposalDTO).toCompletableFuture().join();
	//	}

}
