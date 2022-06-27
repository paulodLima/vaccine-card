package com.vaccine.card.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class VaccineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception {

        mockMvc.perform(post("/v1/api/vaccine")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"Foo Vaccine\",\n" +
                        "    \"description\": \"vacina para foo\",\n" +
                        "    \"applicationLocationId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"basicVaccinationId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"compositionId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"diseaseId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"dosageIds\" : [ \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\", \"869c01f7-0cfb-4644-89cc-f119e1c790fc\"],\n" +
                        "    \"needleId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"recommendedAgeId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"reinforcementId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"routeAdministrationId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"sideEffectId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\",\n" +
                        "    \"validityAfterOpenId\": \"45b7d9a5-c2f1-4332-9e4e-d11733f67ce0\"\n" +
                        "    \n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("vacina para foo")))
                .andExpect(jsonPath("$.uuid", notNullValue()))
                .andExpect(jsonPath("$.name", is("Foo Vaccine")))
                .andExpect(jsonPath("$.applicationLocation", is("Cavidade oral")))
                .andExpect(jsonPath("$.basicVaccination", is("Dose única")))
                .andExpect(jsonPath("$.composition", is("Virus vivo atenuado")))
                .andExpect(jsonPath("$.disease", is("Tuberculose")))
                .andExpect(jsonPath("$.dosages[0].description", is("0,1 ml")))
                .andExpect(jsonPath("$.dosages[0].recommendedAge", is(1)))
                .andExpect(jsonPath("$.dosages[0].reinforcement", is(24)))
                .andExpect(jsonPath("$.dosages[1].description", is("2 gotas")))
                .andExpect(jsonPath("$.dosages[1].recommendedAge", is(2)))
                .andExpect(jsonPath("$.dosages[1].reinforcement", is(36)))
                .andExpect(jsonPath("$.needle", is("13x3,8")))
                .andExpect(jsonPath("$.routeAdministration", is("Intradérmica")))
                .andExpect(jsonPath("$.sideEffect", is("Poliomielite associada ao vírus vacinal – VAPP.")))
                .andExpect(jsonPath("$.validityAfterOpen", is("6 horas (multidose)")));

    }

    @Test
    void list() throws Exception {

        mockMvc.perform(get("/v1/api/vaccine?name=Bc")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description", is("Vacina para turbeculose")))
                .andExpect(jsonPath("$[0].name", is("BCG")))
                .andExpect(jsonPath("$[0].uuid", is("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0")))
                .andExpect(jsonPath("$[0].applicationLocation", is("Cavidade oral")))
                .andExpect(jsonPath("$[0].basicVaccination", is("Dose única")))
                .andExpect(jsonPath("$[0].composition", is("Virus vivo atenuado")))
                .andExpect(jsonPath("$[0].disease", is("Tuberculose")))
                .andExpect(jsonPath("$[0].dosages[0].description", is("0,1 ml")))
                .andExpect(jsonPath("$[0].dosages[0].recommendedAge", is(1)))
                .andExpect(jsonPath("$[0].dosages[0].reinforcement", is(24)))
                .andExpect(jsonPath("$[0].dosages[1].description", is("2 gotas")))
                .andExpect(jsonPath("$[0].dosages[1].recommendedAge", is(2)))
                .andExpect(jsonPath("$[0].dosages[1].reinforcement", is(36)))
                .andExpect(jsonPath("$[0].needle", is("13x3,8")))
                .andExpect(jsonPath("$[0].routeAdministration", is("Intradérmica")))
                .andExpect(jsonPath("$[0].sideEffect", is("Poliomielite associada ao vírus vacinal – VAPP.")))
                .andExpect(jsonPath("$[0].validityAfterOpen", is("6 horas (multidose)")))
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    void listWithoutFilter() throws Exception {

        mockMvc.perform(get("/v1/api/vaccine")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description", is("Vacina para turbeculose")))
                .andExpect(jsonPath("$[0].name", is("BCG")))
                .andExpect(jsonPath("$[0].uuid", is("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0")))
                .andExpect(jsonPath("$[0].applicationLocation", is("Cavidade oral")))
                .andExpect(jsonPath("$[0].basicVaccination", is("Dose única")))
                .andExpect(jsonPath("$[0].composition", is("Virus vivo atenuado")))
                .andExpect(jsonPath("$[0].disease", is("Tuberculose")))
                .andExpect(jsonPath("$[0].dosages[0].description", is("0,1 ml")))
                .andExpect(jsonPath("$[0].dosages[0].recommendedAge", is(1)))
                .andExpect(jsonPath("$[0].dosages[0].reinforcement", is(24)))
                .andExpect(jsonPath("$[0].dosages[1].description", is("2 gotas")))
                .andExpect(jsonPath("$[0].dosages[1].recommendedAge", is(2)))
                .andExpect(jsonPath("$[0].dosages[1].reinforcement", is(36)))
                .andExpect(jsonPath("$[0].needle", is("13x3,8")))
                .andExpect(jsonPath("$[0].routeAdministration", is("Intradérmica")))
                .andExpect(jsonPath("$[0].sideEffect", is("Poliomielite associada ao vírus vacinal – VAPP.")))
                .andExpect(jsonPath("$[0].validityAfterOpen", is("6 horas (multidose)")))
                .andExpect(jsonPath("$", hasSize(2)));


    }


    @Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    void getByUuid() throws Exception {

        mockMvc.perform(get("/v1/api/vaccine/45b7d9a5-c2f1-4332-9e4e-d11733f67ce0")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("Vacina para turbeculose")))
                .andExpect(jsonPath("$.name", is("BCG")))
                .andExpect(jsonPath("$.uuid", is("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0")))
                .andExpect(jsonPath("$.applicationLocation", is("Cavidade oral")))
                .andExpect(jsonPath("$.basicVaccination", is("Dose única")))
                .andExpect(jsonPath("$.composition", is("Virus vivo atenuado")))
                .andExpect(jsonPath("$.disease", is("Tuberculose")))
                .andExpect(jsonPath("$.dosages[0].description", is("0,1 ml")))
                .andExpect(jsonPath("$.dosages[0].recommendedAge", is(1)))
                .andExpect(jsonPath("$.dosages[0].reinforcement", is(24)))
                .andExpect(jsonPath("$.dosages[1].description", is("2 gotas")))
                .andExpect(jsonPath("$.dosages[1].recommendedAge", is(2)))
                .andExpect(jsonPath("$.dosages[1].reinforcement", is(36)))
                .andExpect(jsonPath("$.needle", is("13x3,8")))
                .andExpect(jsonPath("$.routeAdministration", is("Intradérmica")))
                .andExpect(jsonPath("$.sideEffect", is("Poliomielite associada ao vírus vacinal – VAPP.")))
                .andExpect(jsonPath("$.validityAfterOpen", is("6 horas (multidose)")));

    }
}