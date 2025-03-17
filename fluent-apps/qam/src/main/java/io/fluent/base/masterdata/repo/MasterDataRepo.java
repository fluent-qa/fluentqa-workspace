package io.fluent.base.masterdata.repo;

import io.fluent.base.masterdata.model.MasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterDataRepo extends JpaRepository<MasterData, Long>, JpaSpecificationExecutor<Long> {

    Optional<MasterData> findMasterDataByCode(String code);

}