package com.github.jeffreff.fishstory.controller;

import com.github.jeffreff.fishstory.domain.Fish;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql", "classpath:data-test.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class FishControllerIntegrationTest {

    private final String url = "http://localhost:8080/";
    private Long id = 1L;
    private Fish testFish;

    @Autowired
    private MockMvc myMockMvc;

    @Autowired
    private ObjectMapper jsonifier;

    @BeforeEach
    void testSetUp() {
        testFish = new Fish(5L, "Salmon", 4.5, false);
    }

    @Test
    void createTest() throws Exception {
        Fish expectedFish = new Fish(2L, "Salmon", 4.5, false);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST,
                        url + "createFish").contentType(MediaType.APPLICATION_JSON)
                .content(jsonifier.writeValueAsString(testFish)).accept(MediaType.APPLICATION_JSON);

        ResultMatcher status = MockMvcResultMatchers.status().isOk();
        ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedFish));

        this.myMockMvc.perform(mockRequest).andExpect(status).andExpect(content);
    }

    @Test
    void gutFishTest() throws Exception {
        Fish expectedFish = new Fish(1L, "Salmon", 4.5, true);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,
                        url + "gutFish/1");

        ResultMatcher status = MockMvcResultMatchers.status().isOk();
        ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedFish));

        this.myMockMvc.perform(mockRequest).andExpect(status).andExpect(content);
    }
}
