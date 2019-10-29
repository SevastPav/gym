package com.urfu.sod.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A ClientSystem.
 */
@Data
@Entity
@Table(name = "common_info")
public class CommonInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorForCommonInfo")
    @SequenceGenerator(name = "sequenceGeneratorForCommonInfo")
    @Column(name = "common_id", nullable = false, unique = true)
    private Long commonId;

    @Column(name = "fio", nullable = false)
    private String fio;

    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    private Role roleId;

    @Column(name = "login", nullable = false, length = 255)
    private String login;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "birthday", nullable = false)
    private LocalDateTime birthday;

    @Column(name = "phone", nullable = false, length = 255)
    private String phone;

    @Column(name = "entry_date", nullable = false)
    private LocalDateTime entryDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private ClientProfile clientProfile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private TrainerProfile trainerProfile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private AdminProfile adminProfile;
}
