package com.urfu.sod.repository;

import com.urfu.sod.entity.Training;
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
public interface TrainingRepository extends JpaRepository<Training, Long>, JpaSpecificationExecutor<Training> {

    List<Training> findAll();

}
