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
    private Integer id;

    @Column (name = "date")
    private String date;

    @Column (name = "amperage")
    private String amperage;

    @Column (name = "ep_result")
    private String epResult;

    @Column (name = "blacken_result")
    private String blackenResult;

    public Sample (String date, String amperage, String epResult, String blackenResult) {
        this.date = date;
        this.amperage = amperage;
        this.epResult = epResult;
        this.blackenResult = blackenResult;
    }
}
