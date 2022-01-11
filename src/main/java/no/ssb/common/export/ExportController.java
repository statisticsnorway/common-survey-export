package no.ssb.common.export;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/export")
public class ExportController {

    private final ExportService service;

    @GetMapping("/poll")
    public PollResponse export() {
        final LocalDateTime timePolled = LocalDateTime.now();
        List<ExportResponse> export = service.export();

        return new PollResponse(export, timePolled);
    }

}