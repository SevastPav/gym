package com.urfu.sod.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * A ClientSystem.
 */
@Data
@Entity
@Table(name = "trainer_profile")
public class TrainerProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorForTrainer")
    @SequenceGenerator(name = "sequenceGeneratorForTrainer")
    @Column(name = "trainer_id", nullable = false, unique = true)
    private Long trainerId;

    @OneToOne(mappedBy = "trainerProfile", cascade = CascadeType.ALL)
    private CommonInfo commonProfile;

    @OneToMany(mappedBy="trainerId", cascade = CascadeType.ALL)
    private List<Training> trainings;
}
