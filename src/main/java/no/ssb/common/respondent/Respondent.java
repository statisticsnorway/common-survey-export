package no.ssb.common.respondent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import no.ssb.common.Interviewer.Interviewer;
import no.ssb.common.survey.Survey;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESPONDENT")
@ToString
public class Respondent {

    @Id
    private Long id;

    @Column(name = "RESPONDENT_UUID", nullable = false)
    private UUID respondentId;

    @Column(name = "NAME")
    @ToString.Exclude
    private String name;

    @Column(name = "PHONE")
    @ToString.Exclude
    private String phone;

    @Column(name = "EMAIL")
    @ToString.Exclude
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "EDUCATION")
    @ToString.Exclude
    private String education;

    @Column(name = "ADDRESS")
    @ToString.Exclude
    private String address;

    @Column(name = "POSTCODE")
    private String postcode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "REGION")
    private String region;

    @Column(name = "MUNICIPALITY_NUMBER")
    private String municipalityNumber;

    @Column(name = "DWELLING_NUMBER")
    private String dwellingNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "INTERVIEWER_ID")
    private Interviewer interviewer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SURVEY_ID")
    private Survey survey;

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