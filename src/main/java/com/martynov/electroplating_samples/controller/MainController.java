package com.martynov.electroplating_samples.controller;

import com.martynov.electroplating_samples.entity.Sample;
import com.martynov.electroplating_samples.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/samples")
public class MainController {
    private final SampleService sampleService;

    @Autowired
    public MainController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Sample> samples = sampleService.getAll();
        model.addAttribute("samples", samples);
        model.addAttribute("sample", new Sample());
        return "sampleList";
    }

    @PostMapping
    public String add(@RequestParam("date") String date, @RequestParam("amperage") String amperage,
                      @RequestParam("epResult") String epResult, @RequestParam("blackenResult") String blackenResult, Model model) {
        Sample newSample = Sample.builder()
                .date(date).amperage(amperage)
                .epResult(epResult)
                .blackenResult(blackenResult)
                .build();
        sampleService.add(newSample);
        model.addAttribute("newSample", newSample);
        return "redirect:/samples";
    }

    @GetMapping(value = "{id}")
    public String getById (@PathVariable int id, Model model) {
        Sample sample = sampleService.getById(id);
        model.addAttribute("sampleById", sample);
        return "oneItem";
    }

    @GetMapping(value = "delete/{id}")
    public String deleteById(@PathVariable int id) {
        sampleService.deleteById(id);
        return "redirect:/samples";
    }

    @PostMapping(value = "update/{id}")
    public String updateById(@PathVariable int id, @RequestParam("date") String date, @RequestParam("amperage") String amperage,
                             @RequestParam("epResult") String epResult, @RequestParam("blackenResult") String blackenResult) {
        Sample updated = new Sample(id, date, amperage, epResult, blackenResult);
        sampleService.updateById(id, updated);
        return "redirect:/samples";
    }
}

// @RequestParam("date") String date, @RequestParam("amperage") String amperage,
//                      @RequestParam("epResult") String epResult, @RequestParam("blackenResult") String blackenResult