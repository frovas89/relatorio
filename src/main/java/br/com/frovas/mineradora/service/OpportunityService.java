package br.com.frovas.mineradora.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import br.com.frovas.mineradora.dto.OpportunityDTO;
import br.com.frovas.mineradora.dto.ProposalDTO;
import br.com.frovas.mineradora.dto.QuotationDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface OpportunityService {

	void buildOpportunity(ProposalDTO proposal);

	void saveQuotation(QuotationDTO quotation);

	List<OpportunityDTO> generateOpportunityData();

	ByteArrayInputStream generateCSVOpportunityReport();

}
