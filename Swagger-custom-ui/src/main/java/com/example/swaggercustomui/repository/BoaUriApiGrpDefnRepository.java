package com.example.swaggercustomui.repository;

import com.example.swaggercustomui.persistance.BoaUriApiGrpDefn;
import com.example.swaggercustomui.persistance.BoaUriApiGrpDefnId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoaUriApiGrpDefnRepository extends JpaRepository<BoaUriApiGrpDefn, BoaUriApiGrpDefnId> {
    @Query("select b from BoaUriApiGrpDefn b where b.id.entityId = ?1 and b.id.channelId = ?2 and b.id.groupId = ?3")
    Optional<BoaUriApiGrpDefn> findByApiGrpId(Integer entityId, Integer channelId, Integer groupId);

}