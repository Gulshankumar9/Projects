package com.example.swaggercustomui.repository;

import com.example.swaggercustomui.persistance.BoaUriApiDefn;
import com.example.swaggercustomui.persistance.BoaUriApiDefnId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoaUriApiDefnRepository extends JpaRepository<BoaUriApiDefn, BoaUriApiDefnId> {
    @Query("select b from BoaUriApiDefn b where b.id.entityId = ?1 and b.id.channelId = ?2 and b.groupId = ?3")
    List<BoaUriApiDefn> findByGroupId(Integer entityId, Integer channelId, Integer groupId);


}