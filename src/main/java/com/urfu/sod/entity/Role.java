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
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorForRole")
    @SequenceGenerator(name = "sequenceGeneratorForRole")
    @Column(name = "role_id", nullable = false, unique = true)
    private Long roleId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy="roleId", cascade = CascadeType.ALL)
    public List<UserProfile> userProfiles;
}
