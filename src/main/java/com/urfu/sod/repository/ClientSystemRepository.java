package com.urfu.sod.repository;

import com.urfu.sod.entity.ClientSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Spring Data  repository for the ClientSystem entity.
 */
//@SuppressWarnings("unused")
@Repository
public interface ClientSystemRepository extends JpaRepository<ClientSystem, Long>, JpaSpecificationExecutor<ClientSystem> {

    Optional<ClientSystem> findById(String Id);

}
