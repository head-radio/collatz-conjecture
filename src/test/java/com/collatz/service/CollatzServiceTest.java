package com.collatz.service;

import com.collatz.exception.BadRequestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CollatzServiceTest {

    @InjectMocks
    CollatzService collatzService;

    @Test
    public void processCollatzOdd() {
        long result = collatzService.processCollatz(989345275647L);
        assertEquals(1348, result);
    }

    @Test
    public void processCollatzEven() {
        long result = collatzService.processCollatz(12L);
        assertEquals(9, result);
    }

    @Test(expected = BadRequestException.class)
    public void processCollatz_Exception() {
        collatzService.processCollatz(-1L);
    }

    @Test
    public void processCollatzTROdd() {
        long result = collatzService.processCollatzTR(989345275647L);
        assertEquals(1348, result);
    }

    @Test
    public void processCollatzTREven() {
        long result = collatzService.processCollatzTR(12L);
        assertEquals(9, result);
    }

    @Test(expected = BadRequestException.class)
    public void processCollatzTR_Exception() {
        collatzService.processCollatzTR(-1L);
    }

}