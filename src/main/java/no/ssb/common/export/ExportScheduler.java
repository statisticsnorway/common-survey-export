package no.ssb.common.export;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ExportScheduler {

    private final ExportService service;

    public ExportScheduler(ExportService service) {
        this.service = service;
    }

    // Every day at 02:00
    @Scheduled(cron = "0 0 2 * * *")
    private void export() {
        service.export();
    }
}
