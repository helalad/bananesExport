package com.bananes.export.controller;

import com.bananes.export.model.Destinataire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class BananesExportControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getDestinataires() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/destinataires")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void should_return_bad_request_saveDestinataires() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/destinataire" ).content("")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void should_create_saveDestinataires() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/destinataire" ).content("{\n" +
                        "        \"nom\": \"destination1\",\n" +
                        "        \"adresse\": \"Id\",\n" +
                        "        \"codePostal\": 75000,\n" +
                        "        \"ville\": \"paris\",\n" +
                        "        \"pays\": \"frances\"\n" +
                        "    }")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }



    @Test
    void shoud_throw_badRequest_getCommande() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/commandes").content("{\n" +
                "        \"nom\": \"destination1\",\n" +
                "        \"adresse\": \"Id\",\n" +
                "        \"codePostal\": 75000,\n" +
                "        \"ville\": \"paris\",\n" +
                "        \"pays\": \"frances\"\n" +
                "    }")).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}