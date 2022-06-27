package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.BasicVaccinationEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BasicVaccinationRepositoryTest {

    @Autowired
    private BasicVaccinationRepository repository;

    @Test
    void findByUuid() {

        Optional<BasicVaccinationEntity> byUuid = repository.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0");

        assertTrue(byUuid.isPresent());

        BasicVaccinationEntity diseaseEntity = byUuid.get();

        assertEquals(1L, diseaseEntity.getId());
        assertEquals("Dose única", diseaseEntity.getDescription());
        assertEquals("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0", diseaseEntity.getUuid());
    }

    @Test
    void findByUuidNotFound() {

        Optional<BasicVaccinationEntity> byUuid = repository.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67c99");

        assertFalse(byUuid.isPresent());


    }
}