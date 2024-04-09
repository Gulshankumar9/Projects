package com.example.swaggercustomui.repository;

import com.example.swaggercustomui.persistance.BoaUriApiRqDefn;
import com.example.swaggercustomui.persistance.BoaUriApiRqDefnId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoaUriApiRqDefnRepository extends JpaRepository<BoaUriApiRqDefn, BoaUriApiRqDefnId> {
    @Query("select b from BoaUriApiRqDefn b where b.id.entityId = ?1 and b.id.channelId = ?2 and b.id.defnId = ?3")
    Optional<BoaUriApiRqDefn> findByEntityChannelDefnId(Integer entityId, Integer channelId, Integer defnId);
}