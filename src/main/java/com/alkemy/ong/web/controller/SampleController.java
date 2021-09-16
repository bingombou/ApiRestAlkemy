package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.sample.Sample;
import com.alkemy.ong.domain.sample.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("samples")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public ResponseEntity<List<Sample>> findAll() {
        return ResponseEntity.ok(sampleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sample> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(sampleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Sample> create(@Valid @RequestBody Sample sample) {
        return new ResponseEntity<>(sampleService.create(sample), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sample> update(@PathVariable("id") Long id, @Valid @RequestBody Sample sample) {
        checkExistence(id);
        return ResponseEntity.ok(sampleService.update(sample));
    }

    private void checkExistence(Long id) {
        sampleService.findById(id);
    }
}
