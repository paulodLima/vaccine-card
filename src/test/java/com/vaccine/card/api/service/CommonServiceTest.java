package com.vaccine.card.api.service;

import com.vaccine.card.api.exception.MessageErrorImpl;
import com.vaccine.card.api.mapper.CommonMapper;
import com.vaccine.card.api.model.CommonEntity;
import com.vaccine.card.api.repository.CommonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static com.vaccine.card.api.util.MessagesUtil.getMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommonServiceTest {

    @Mock
    private CommonRepository repository;

    @Mock
    private CommonMapper mapper;

    @InjectMocks
    private CommonService service;

    @Test
    void findByUuid() {

        CommonEntity commonEntity = new CommonEntity();

        when(repository.findByUuid(anyString())).thenReturn(Optional.of(commonEntity));

        service.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0");

        verify(repository, times(1)).findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0");
        verify(mapper, times(1)).toResponseDTO(commonEntity);

    }


    @Test
    void findByUuidNotFound() {

        when(repository.findByUuid(anyString())).thenReturn(Optional.empty());

        EntityNotFoundException abstractRuntimeException = assertThrows(EntityNotFoundException.class, () -> service.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0"));

        verify(repository, times(1)).findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0");

        assertEquals(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.RESOURCE)), abstractRuntimeException.getMessage());
    }

}