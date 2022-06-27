package com.vaccine.card.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DosageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getDosages() throws Exception {

        mockMvc.perform(get("/v1/api/dosage")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description", is("0,1 ml")))
                .andExpect(jsonPath("$[0].uuid", is("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0")))
                .andExpect(jsonPath("$[0].recommendedAge", is(1)))
                .andExpect(jsonPath("$[0].reinforcement", is(24)))
                .andExpect(jsonPath("$[1].description", is("2 gotas")))
                .andExpect(jsonPath("$[1].uuid", is("869c01f7-0cfb-4644-89cc-f119e1c790fc")))
                .andExpect(jsonPath("$[1].recommendedAge", is(2)))
                .andExpect(jsonPath("$[1].reinforcement", is(36)))
                .andExpect(jsonPath("$[*]", hasSize(2)));
    }
}