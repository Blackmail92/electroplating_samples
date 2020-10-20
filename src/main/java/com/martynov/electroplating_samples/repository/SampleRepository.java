package com.martynov.electroplating_samples.repository;

import com.martynov.electroplating_samples.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SampleRepository extends JpaRepository<Sample, Integer> {
    List<Sample> getAllByAmperage(String amperage);
    List<Sample> getAllByDate(String date);
}
