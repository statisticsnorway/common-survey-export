package no.ssb.common.export;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class PollResponse {

    private List<ExportResponse> exportResponses;

    private LocalDateTime timePolled;
}
