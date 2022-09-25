package com.faropay.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.faropay.demo.model.LoginResponse;
import com.faropay.demo.repository.PlaceRepository;
import com.google.gson.Gson;

@SpringBootTest
@AutoConfigureMockMvc
public class PlaceControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PlaceRepository placeRepository;

    @Test
    public void testLogin() throws Exception {
        MvcResult result = mockMvc
                .perform(post("/auth/login").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"admin\", \"password\":\"admin$123\"}"))
                .andExpect(status().isOk()).andReturn();
        String resp = result.getResponse().getContentAsString();
        LoginResponse loginResponse = new Gson().fromJson(resp, LoginResponse.class);
        mockMvc.perform(get("/places/list_places").header("Authorization", loginResponse.getToken()))
                .andExpect(status().isOk()).andReturn();
    }
}
