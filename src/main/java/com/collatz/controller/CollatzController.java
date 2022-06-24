package com.collatz.controller;

import com.collatz.ICollatzService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.collatz.util.WebURLSUtil.*;

@RestController
@RequestMapping(COLLATZ_BASE_PATH)
@Log4j2
public class CollatzController {

    @Autowired
    private ICollatzService iCollatzService;

    @PostMapping(INPUT_VALUE_PATH_PARAM)
    public ResponseEntity<Long> collatzProcessing(@PathVariable(INPUT_VALUE) long input) {
        log.info("> collatzProcessing - input: " + input);
        return ResponseEntity.ok(iCollatzService.processCollatz(input));
    }

    @PostMapping(TR_PATH + INPUT_VALUE_PATH_PARAM)
    public ResponseEntity<Long> collatzProcessingTR(@PathVariable(INPUT_VALUE) long input) {
        log.info("> collatzProcessingTR - input: " + input);
        return ResponseEntity.ok(iCollatzService.processCollatzTR(input));
    }

}