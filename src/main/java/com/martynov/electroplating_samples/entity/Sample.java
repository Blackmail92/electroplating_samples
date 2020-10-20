package com.martynov.electroplating_samples.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table (name = "samples")
@NoArgsConstructor
@AllArgsConstructor
public class Sample {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                 // Номер образца

    @Column (name = "date")
    private String date;                // Дата

    @Column (name = "amperage")
    private String amperage;            // Сила тока

    @Column (name = "ep_result")
    private String epResult;          // Результат высаживания

    @Column (name = "blacken_result")
    private String blackenResult;     // Результат чернения

    public Sample (String date, String amperage, String epResult, String blackenResult) {
        this.date = date;
        this.amperage = amperage;
        this.epResult = epResult;
        this.blackenResult = blackenResult;
    }
}
