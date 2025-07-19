package br.com.frovas.mineradora.repository;

import java.util.Optional;

import br.com.frovas.mineradora.entity.ProposalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProposalRepository implements PanacheRepository<ProposalEntity>{

	public Optional<ProposalEntity> findByCustomer(String customer) {

		return Optional.of(find("customer", customer).firstResult());
	}

}
