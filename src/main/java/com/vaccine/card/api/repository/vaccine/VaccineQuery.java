package com.vaccine.card.api.repository.vaccine;

import com.vaccine.card.api.dto.filter.VaccineFilter;
import com.vaccine.card.api.model.VaccineEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VaccineQuery {

    List<VaccineEntity> findAllAndFilter(VaccineFilter vaccineFilter, Pageable pageable);
}
