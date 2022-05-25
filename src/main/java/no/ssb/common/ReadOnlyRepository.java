package no.ssb.common;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

/*
The purpose of this interface is to expose read methods only.
This is to ensure that we don't accidentally modify data.
 */

@NoRepositoryBean
public interface ReadOnlyRepository<T,ID> extends Repository<T, ID> {
    List<T> findAllBySurveyAbbreviation(String abbreviation);
}
