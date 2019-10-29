package com.urfu.sod.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * A ClientSystem.
 */
@Data
@Entity
@Table(name = "client_profile")
public class ClientProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorForClient")
    @SequenceGenerator(name = "sequenceGeneratorForClient")
    @Column(name = "client_id", nullable = false, unique = true)
    private Long clientId;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @ManyToMany
    @JoinTable(
            name = "client_training",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    List<Training> clientTrainings;

    @OneToOne(mappedBy = "clientProfile", cascade = CascadeType.ALL)
    private CommonInfo commonProfile;
}
