package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.sample.Sample;
import com.alkemy.ong.domain.sample.SampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("samples")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public ResponseEntity<List<Sample>> findAll() {
        return new ResponseEntity<>(sampleService.findAll(), HttpStatus.OK);
    }
}
