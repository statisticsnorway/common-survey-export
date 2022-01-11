package no.ssb.common.export;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExportResponse {

    private String name;
    private LocalDateTime timeFinished;

    private String status;

    private String error;

    public ExportResponse(String name, LocalDateTime timeFinished, String status, String error) {
        this.name = name;
        this.timeFinished = timeFinished;
        this.status = status;
        this.error = error;
    }

    public ExportResponse(String name, LocalDateTime timeFinished, String status) {
        this.name = name;
        this.timeFinished = timeFinished;
        this.status = status;
    }
}
