package com.urfu.sod.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A ClientSystem.
 */
@Data
@Entity
@Table(name = "admin_profile")
public class AdminProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorForAdmin")
    @SequenceGenerator(name = "sequenceGeneratorForAdmin")
    @Column(name = "admin_id", nullable = false, unique = true)
    private Long adminId;

    @OneToOne(mappedBy = "adminProfile", cascade = CascadeType.ALL)
    private CommonInfo commonProfile;
}
