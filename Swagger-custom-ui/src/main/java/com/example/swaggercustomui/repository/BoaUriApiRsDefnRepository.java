package com.example.swaggercustomui.repository;

import com.example.swaggercustomui.persistance.BoaUriApiRsDefn;
import com.example.swaggercustomui.persistance.BoaUriApiRsDefnId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoaUriApiRsDefnRepository extends JpaRepository<BoaUriApiRsDefn, BoaUriApiRsDefnId> {
    @Query("select b from BoaUriApiRsDefn b where b.id.entityId = ?1 and b.id.channelId = ?2 and b.id.defnId = ?3")
    Optional<BoaUriApiRsDefn> findByEntityChannelDefnId(Integer entityId, Integer channelId, Integer defnId);
}