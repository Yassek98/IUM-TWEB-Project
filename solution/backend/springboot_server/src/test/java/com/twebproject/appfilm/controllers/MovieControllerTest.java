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
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllMovies() throws Exception {
        mockMvc.perform(get("/movies"))
            .andExpect(status().isOk());
    }

    @Test
    public void testSearchMovies() throws Exception {
        mockMvc.perform(get("/movies/search").param("name", "Inception"))
            .andExpect(status().isOk());
    }

    @Test
    public void testGetPosterById() throws Exception {
        mockMvc.perform(get("/posters/{id}", 1000096L))
                .andExpect(status().isOk());
    }
}
