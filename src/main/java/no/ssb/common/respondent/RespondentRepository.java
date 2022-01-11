package no.ssb.common.respondent;

import no.ssb.common.ReadOnlyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespondentRepository extends ReadOnlyRepository<Respondent, Long> {
}