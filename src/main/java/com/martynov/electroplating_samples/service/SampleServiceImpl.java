package com.martynov.electroplating_samples.service;

import com.martynov.electroplating_samples.entity.Sample;
import com.martynov.electroplating_samples.repository.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;

    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public void add(Sample sample) {
        sampleRepository.save(sample);
    }

    @Override
    public List<Sample> getAll() {
        return sampleRepository.findAll();
    }

    @Override
    public Sample getById(int id) {
        return sampleRepository.getOne(id);
    }

    @Override
    public List<Sample> getByAmp(String amp) {
        return sampleRepository.getByAmperage(amp);
    }

    @Override
    public boolean updateById(int id, Sample sample) {
        if (sampleRepository.existsById(id)) {
            sample.setId(id);
            sampleRepository.save(sample);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        if (sampleRepository.existsById(id)) {
            sampleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
