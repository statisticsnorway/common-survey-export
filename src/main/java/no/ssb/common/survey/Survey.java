package no.ssb.common.survey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SURVEY")
public class Survey {

    @Id
    private Long id;

    @Column(name = "SURVEY_UUID")
    private UUID surveyId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "ABBREVIATION")
    private String abbreviation;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COLLECTION_START")
    private LocalDate collectionStart;

    @Column(name = "COLLECTION_END")
    private LocalDate collectionEnd;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_TIME")
    private LocalDateTime modifiedTime;
}