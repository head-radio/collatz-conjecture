package com.collatz.controller;

import com.collatz.ICollatzService;
import com.collatz.exception.BadRequestException;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.collatz.util.WebURLSUtil.COLLATZ_BASE_PATH;
import static com.collatz.util.WebURLSUtil.TR_PATH;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CollatzController.class)
@AutoConfigureMockMvc
public class CollatzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICollatzService iCollatzService;

    @Test
    public void processCollatz() throws Exception {

        when(iCollatzService.processCollatz(12)).thenReturn(9L);
        mockMvc.perform(post(COLLATZ_BASE_PATH + "/12"))
                .andExpect(status().isOk());

    }

    @Test
    public void processCollatzTR() throws Exception {

        when(iCollatzService.processCollatz(12)).thenReturn(9L);
        mockMvc.perform(post(COLLATZ_BASE_PATH + TR_PATH + "/12"))
                .andExpect(status().isOk());

    }

    @Test
    public void processCollatz_Exception() throws Exception {

        when(iCollatzService.processCollatz(anyLong())).thenThrow(new BadRequestException("error"));
        mockMvc.perform(post(COLLATZ_BASE_PATH + "/-12"))
                .andExpect(status().isBadRequest());

    }

}