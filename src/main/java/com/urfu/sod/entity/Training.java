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
    @JoinColumn(name="trainer_id")
    private UserProfile trainerId;

    @Column(name = "datetime")
    private ZonedDateTime dateTime;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToMany(mappedBy = "clientTrainings", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<UserProfile> clients;
}
