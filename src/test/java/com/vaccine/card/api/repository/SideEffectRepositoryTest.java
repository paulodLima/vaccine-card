package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.SideEffectEntity;
import com.vaccine.card.api.model.ValidityAfterOpenEntity;
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
class SideEffectRepositoryTest {

    @Autowired
    private SideEffectRepository repository;

    @Test
    void findByUuid() {

        Optional<SideEffectEntity> byUuid = repository.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0");

        assertTrue(byUuid.isPresent());

        SideEffectEntity sideEffectEntity = byUuid.get();

        assertEquals(1L, sideEffectEntity.getId());
        assertEquals("Poliomielite associada ao vírus vacinal – VAPP.", sideEffectEntity.getDescription());
        assertEquals("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0", sideEffectEntity.getUuid());
    }

    @Test
    void findByUuidNotFound() {

        Optional<SideEffectEntity> byUuid = repository.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67c99");

        assertFalse(byUuid.isPresent());


    }
}