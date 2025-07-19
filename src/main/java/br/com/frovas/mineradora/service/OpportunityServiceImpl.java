package br.com.frovas.mineradora.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.com.frovas.mineradora.dto.OpportunityDTO;
import br.com.frovas.mineradora.dto.ProposalDTO;
import br.com.frovas.mineradora.dto.QuotationDTO;
import br.com.frovas.mineradora.entity.OpportunityEntity;
import br.com.frovas.mineradora.entity.QuotationEntity;
import br.com.frovas.mineradora.repository.OpportunityRepository;
import br.com.frovas.mineradora.repository.QuotationRepository;
import br.com.frovas.mineradora.utils.CSVHelper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OpportunityServiceImpl implements OpportunityService{

	@Inject
	QuotationRepository quotationRepository;

	@Inject
	OpportunityRepository opportunityRepository;

	@Override
	public void buildOpportunity(ProposalDTO proposal) {

		List<QuotationEntity> quotationEntities = quotationRepository.findAll().list();
		Collections.reverse(quotationEntities);

		OpportunityEntity opportunity = new OpportunityEntity();
		opportunity.setDate(new Date());
		opportunity.setProposalId(proposal.getProposalId());
		opportunity.setCustomer(proposal.getCustomer());
		opportunity.setPriceTonne(proposal.getPriceTonne());
		opportunity.setLastDollarQuotation(quotationEntities.get(0).getCurrencyPrice());

		opportunityRepository.persist(opportunity);

	}

	@Override
	@Transactional
	public void saveQuotation(QuotationDTO quotation) {

		QuotationEntity createQuotation = new QuotationEntity();
		createQuotation.setDate(new Date());
		createQuotation.setCurrencyPrice(quotation.getCurrencyPrice());

		quotationRepository.persist(createQuotation);

	}

	@Override
	public List<OpportunityDTO> generateOpportunityData() {



		return null;
	}

	@Override
	public ByteArrayInputStream generateCSVOpportunityReport() {

		List<OpportunityDTO> opportunityList = new ArrayList<>();

		opportunityRepository.findAll().list().forEach(item -> {
			opportunityList.add(OpportunityDTO.builder()
					.proposalId(item.getProposalId())
					.customer(item.getCustomer())
					.priceTonne(item.getPriceTonne())
					.lastDollarQuotation(item.getLastDollarQuotation())
					.build());
		});

		return CSVHelper.opportunitiesToCSV(opportunityList);
	}

}
