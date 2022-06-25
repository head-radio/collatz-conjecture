package com.collatz.service;

import com.collatz.ICollatzService;
import com.collatz.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CollatzService implements ICollatzService {

    /**
     * collatz conjecture calculation by recursive function
     *
     * @param inputValue is the value used for the calculation
     * @return result of the collatz calculation
     */
    @Override
    public long processCollatz(long inputValue) {
        if (inputValue <= 0) {
            throw new BadRequestException("input data must be an integer value");
        }
        return processCollatzLocal(inputValue);
    }

    private long processCollatzLocal(long inputValue) {

        if (inputValue == 1) {
            return 0;
        }

        if ((inputValue % 2) == 0) {
            return 1 + processCollatzLocal(inputValue / 2);
        } else {
            return 1 + processCollatzLocal(inputValue * 3 + 1);
        }

    }

    /**
     * collatz conjecture calculation by tail recursive function
     *
     * @param inputValue is the value used for the calculation
     * @return result of the collatz calculation
     */
    @Override
    public long processCollatzTR(long inputValue) {
        if (inputValue <= 0) {
            throw new BadRequestException("input data must be an integer value");
        }
        return processCollatzTRLocal(0L, inputValue);
    }

    private long processCollatzTRLocal(long a, long b) {

        if (b == 1) {
            return a;
        }

        if ((b % 2) == 0) {
            return processCollatzTRLocal(a + 1, b / 2);
        } else {
            return processCollatzTRLocal(a + 1, b * 3 + 1);
        }

    }

}
