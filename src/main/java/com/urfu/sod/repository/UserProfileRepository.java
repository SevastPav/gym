package com.urfu.sod.repository;

import com.urfu.sod.entity.Role;
import com.urfu.sod.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Spring Data  repository for the ClientSystem entity.
 */
//@SuppressWarnings("unused")
@Repository
@Transactional
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>, JpaSpecificationExecutor<UserProfile> {

    List<UserProfile> findAll();

    List<UserProfile> findByRoleId(Role role);

    Optional<UserProfile>  findByUserId(Long userId);

}
