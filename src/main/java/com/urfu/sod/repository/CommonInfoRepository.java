package com.urfu.sod.repository;

import com.urfu.sod.entity.CommonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Spring Data  repository for the ClientSystem entity.
 */
//@SuppressWarnings("unused")
@Repository
public interface CommonInfoRepository extends JpaRepository<CommonInfo, Long>, JpaSpecificationExecutor<CommonInfo> {

    List<CommonInfo> findAll();

    Optional<CommonInfo>  findByCommonId(Long commonId);

}
