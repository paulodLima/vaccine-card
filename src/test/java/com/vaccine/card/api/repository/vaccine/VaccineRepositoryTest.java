package com.vaccine.card.api.repository.vaccine;

import com.vaccine.card.api.dto.filter.VaccineFilter;
import com.vaccine.card.api.model.DosageEntity;
import com.vaccine.card.api.model.VaccineEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VaccineRepositoryTest {

    @Autowired
    private VaccineRepository repository;

    @Mock
    private Pageable pageable;

    @BeforeEach
    public void setup() {

        when(pageable.getPageNumber()).thenReturn(0);
        when(pageable.isPaged()).thenReturn(Boolean.TRUE);
        when(pageable.getPageSize()).thenReturn(5);
        when(pageable.getSort()).thenReturn(Sort.unsorted());
    }


    @Test
    void findByUuid() {

        Optional<VaccineEntity> byUuid = repository.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0");

        assertTrue(byUuid.isPresent());

        VaccineEntity diseaseEntity = byUuid.get();

        assertEquals(101L, diseaseEntity.getId());
        assertEquals("Vacina para turbeculose", diseaseEntity.getDescription());
        assertEquals("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0", diseaseEntity.getUuid());


    }

    @Test
    void findByUuidNotFound() {

        Optional<VaccineEntity> byUuid = repository.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67c99");

        assertFalse(byUuid.isPresent());


    }


    @Test
    void findAllAndFilterPerName() {

        VaccineFilter vaccineFilter = new VaccineFilter();
        vaccineFilter.setName("Bc");

        List<VaccineEntity> persons = repository.findAllAndFilter(vaccineFilter, pageable);

        assertFalse(persons.isEmpty());

        VaccineEntity vaccineEntity = persons.get(0);

        List<DosageEntity> dosageEntities = vaccineEntity.getDosageEntities();

        assertFalse(dosageEntities.isEmpty());
        assertEquals("BCG", vaccineEntity.getName());


    }


    @Test
    void findAllAndWithIncorrectNameInFilter() {

        VaccineFilter vaccineFilter = new VaccineFilter();
        vaccineFilter.setName("vacininha da king");

        List<VaccineEntity> persons = repository.findAllAndFilter(vaccineFilter, pageable);

        assertTrue(persons.isEmpty());

    }


    @Test
    void findAllAndFilterWithLimit() {

        when(pageable.getPageSize()).thenReturn(0);

        VaccineFilter vaccineFilter = new VaccineFilter();

        List<VaccineEntity> persons = repository.findAllAndFilter(vaccineFilter, pageable);

        assertTrue(persons.isEmpty());

    }


    @Test
    void findAllAndFilterWithNullFilter() {

        List<VaccineEntity> persons = repository.findAllAndFilter(null, pageable);

        assertEquals(2, persons.size());

        VaccineEntity vaccineEntity = persons.get(0);

        assertEquals("BCG", vaccineEntity.getName());


        VaccineEntity secondVaccineEntity = persons.get(1);

        assertEquals("Febre Amarela", secondVaccineEntity.getName());


    }


    @Test
    void findAllAndFilterWithoutFilter() {

        VaccineFilter vaccineFilter = new VaccineFilter();


        List<VaccineEntity> persons = repository.findAllAndFilter(vaccineFilter, pageable);


        assertEquals(2, persons.size());


        VaccineEntity vaccineEntity = persons.get(0);

        assertEquals("BCG", vaccineEntity.getName());


        VaccineEntity secondVaccineEntity = persons.get(1);

        assertEquals("Febre Amarela", secondVaccineEntity.getName());


    }

}