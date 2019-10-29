package com.urfu.sod.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * A ClientSystem.
 */
@Data
@Entity
@Table(name = "training")
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorForTraining")
    @SequenceGenerator(name = "sequenceGeneratorForTraining")
    @Column(name = "training_id", nullable = false, unique = true)
    private Long trainingId;

    @ManyToOne
    @JoinColumn(name="trainer_id", nullable = false)
    private TrainerProfile trainerId;

    @Column(name = "datetime", nullable = false)
    private ZonedDateTime dateTime;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @ManyToMany(mappedBy = "clientTrainings", cascade = CascadeType.ALL)
    List<ClientProfile> clients;
}
