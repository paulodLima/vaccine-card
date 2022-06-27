package com.vaccine.card.api.repository.vaccine;

import com.vaccine.card.api.dto.filter.VaccineFilter;
import com.vaccine.card.api.model.DosageEntity;
import com.vaccine.card.api.model.VaccineEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.vaccine.card.api.util.RepositoryUtils.*;

public class VaccineRepositoryImpl implements VaccineQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VaccineEntity> findAllAndFilter(VaccineFilter personFilter, Pageable pageable) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VaccineEntity> criteriaQuery = builder.createQuery(VaccineEntity.class);
        Root<VaccineEntity> rootPerson = criteriaQuery.from(VaccineEntity.class);
        Fetch<VaccineEntity, DosageEntity> addressesFetch = rootPerson.fetch("dosageEntities", JoinType.LEFT);


        Predicate[] predicates = createPersonPredicates(builder, personFilter, rootPerson);


        if (predicatesExists(predicates)) {
            criteriaQuery.where(predicates);
        }

        addOrdination(pageable, builder, criteriaQuery, rootPerson);
        TypedQuery<VaccineEntity> query = entityManager.createQuery(criteriaQuery);
        addPagination(query, pageable);

        List<VaccineEntity> resultList = query.getResultList();

        return new PageImpl<>(resultList).getContent();
    }

    private Predicate[] createPersonPredicates(CriteriaBuilder builder, VaccineFilter personFilter, Root<VaccineEntity> rootPerson) {

        List<Predicate> predicates = new ArrayList<>();

        if (Objects.isNull(personFilter)) {
            return null;
        }

        if (StringUtils.isNotBlank(personFilter.getName())) {
            predicates.add(builder.like(builder.lower(rootPerson.get("name")), personFilter.getName().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
