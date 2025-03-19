package io.fluent.qtm.api.repo;

import io.fluent.qtm.api.model.RemoteApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RemoteServiceRepo extends JpaRepository<RemoteApi, Long>, JpaSpecificationExecutor<Long> {

    Optional<RemoteApi> findRemoteApiByEndpointAndServiceNameAndServiceMethod(
            String endpoint,String serviceName,String serviceMethod
    );

    Optional<List<RemoteApi>> findRemoteApiByModuleNameAndServiceNameAndLatestVersionNot(
            String moduleName,String serviceName,String latestVersion
    );


}
