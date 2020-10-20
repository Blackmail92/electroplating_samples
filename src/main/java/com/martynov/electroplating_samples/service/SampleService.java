package com.martynov.electroplating_samples.service;

import com.martynov.electroplating_samples.entity.Sample;

import java.util.List;

public interface SampleService {
    void add(Sample sample);
    List<Sample> getAll();
    Sample getById(int id);
    List<Sample> getByAmp(String amp);
    boolean updateById(int id, Sample sample);
    boolean deleteById(int id);
}
