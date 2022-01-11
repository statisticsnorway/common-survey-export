package no.ssb.common.Interviewer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.ssb.common.respondent.Respondent;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INTERVIEWER")
public class Interviewer {

    @Id
    private Long id;

    @Column(name = "INTERVIEWER_UUID")
    private UUID interviewerId;

    // Personal information
    @Column(name = "INITIALS", unique = true)
    private String initials;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "interviewer")
    private List<Respondent> respondents;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_TIME")
    private LocalDateTime modifiedTime;

    @Override
    public String toString() {
        return "Interviewer{" +
                "id=" + id +
                ", interviewerId=" + interviewerId +
                ", initials='" + initials + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}