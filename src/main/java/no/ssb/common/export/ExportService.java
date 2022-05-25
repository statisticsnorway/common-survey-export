package no.ssb.common.export;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.cloud.storage.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.ssb.common.respondent.RespondentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ExportService {

    private final RespondentRepository respondentRepository;

    @Value("${storage.forbruk.bucket.name}")
    private String forbrukBucketName;

    @Value("${environment}")
    private String environment;

    private static final Storage storage = StorageOptions.getDefaultInstance().getService();

    private static final ExportMapper mapper = ExportMapper.getInstance();

    public List<ExportResponse> export() {
        List<ExportResponse> blobsCreated = new ArrayList<>();

        blobsCreated.add(exportFBU());

        return blobsCreated;
    }

    private ExportResponse exportFBU() {
        String respondentsBlob = respondentsBlobName("consumption");

        return createJsonBlob(respondentRepository.findAllBySurveyAbbreviation("FBU"), respondentsBlob, forbrukBucketName);
    }

    private ExportResponse createJsonBlob(List<?> content, String blobName, String bucketName) {
        final BlobId blobId = BlobId.of(bucketName, blobName);
        final BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/json").build();

        try {
            Blob blob = storage.create(blobInfo, mapper.writeValueAsBytes(content));
            if (blob.exists())
                log.info("Wrote {} to {}", content.size(),  blobName);
                return new ExportResponse(blobName, LocalDateTime.now(), "CREATED");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.warn("Could not process {}. {}", blobName, e.getMessage());
            return new ExportResponse(blobName, LocalDateTime.now(), "Failed to create", e.getMessage());
        }
    }

    private String respondentsBlobName(String prefix) {
        final String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return String.format("%s/%s/respondenter/%s/respondenter",environment, prefix, date);
    }
}