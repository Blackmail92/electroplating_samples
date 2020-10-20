package com.martynov.electroplating_samples.controller;

import com.martynov.electroplating_samples.entity.Sample;
import com.martynov.electroplating_samples.service.SampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SampleController {
    private final SampleServiceImpl sampleService;

    @Autowired
    public SampleController (SampleServiceImpl sampleService) {
        this.sampleService = sampleService;
    }

    @PostMapping
    public void addSample(@RequestBody Sample sample) {
        sampleService.add(sample);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sample> getAll() {
        return sampleService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sample getById (@PathVariable int id) {
        return sampleService.getById(id);
    }

    @GetMapping(value = "/amp/{amp}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sample> getAllByAmp (@PathVariable String amp) {
        return sampleService.getAllByAmp(amp);
    }

    @GetMapping(value = "/date/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sample> getAllByDate (@PathVariable String date) {
        return sampleService.getAllByDate(date);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateById(@PathVariable int id, @RequestBody Sample sample) {
        sampleService.updateById(id, sample);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable int id) {
        sampleService.deleteById(id);
    }
}
