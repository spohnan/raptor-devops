package com.icfi.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ch.qos.logback.classic.Logger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiApplication.class)
@ContextConfiguration(classes = ApiApplication.class)
public class ApiApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGreeting() throws Exception{
        this.mvc.perform(get("/greet").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void testVersion() throws Exception {
        this.mvc.perform(get("/version").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testRoot() throws Exception {
        this.mvc.perform(get("/").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

}