package com.twebproject.appfilm.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ActorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllActors() throws Exception {
        mockMvc.perform(get("/actors").param("limit", "10"))
            .andExpect(status().isOk());
    }

    @Test
    public void testSearchActors() throws Exception {
        mockMvc.perform(get("/actors/search").param("name", "Margot Robbie"))
            .andExpect(status().isOk());
    }
}
