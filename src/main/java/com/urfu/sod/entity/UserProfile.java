package com.urfu.sod.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A ClientSystem.
 */
@Data
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorForCommonInfo")
    @SequenceGenerator(name = "sequenceGeneratorForCommonInfo")
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "fio", nullable = false)
    private String fio;

    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    private Role roleId;

    @Column(name = "login", nullable = false, length = 255)
    private String login;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "balance")
    private Integer balance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_training",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    List<Training> clientTrainings;

    @OneToMany(mappedBy="trainerId", cascade = CascadeType.ALL)
    private List<Training> trainings;
}
