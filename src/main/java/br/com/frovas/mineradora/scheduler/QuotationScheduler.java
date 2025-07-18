package br.com.frovas.mineradora.scheduler;

import br.com.frovas.mineradora.message.KafkaEvents;
import br.com.frovas.mineradora.service.QuotationService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Transient;

@ApplicationScoped
public class QuotationScheduler {


    private final Logger LOG = LoggerFactory.getLogger(QuotationScheduler.class);

    @Inject
    QuotationService quotationService;

    @Transactional
    @Scheduled(every = "35s", identity = "task-job")
    void schedule() {
        LOG.info("\n\n-- Executando scheduler --\n");
        quotationService.getCurrencyPrice();
    }

}
