package com.example.swaggercustomui.repository;

import com.example.swaggercustomui.persistance.BoaUriApiAttriDefn;
import com.example.swaggercustomui.persistance.BoaUriApiAttriDefnId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoaUriApiAttriDefnRepository extends JpaRepository<BoaUriApiAttriDefn, BoaUriApiAttriDefnId> {
    @Query("select b from BoaUriApiAttriDefn b where b.id.entityId = ?1 and b.id.channelId = ?2 and b.id.attrDefnId " + "=" + " ?3")
    List<BoaUriApiAttriDefn> findByEntityChannelAttrDefnId(Integer entityId, Integer channelId, Integer attrDefnId);

    @Query("select b from BoaUriApiAttriDefn b where b.id.entityId = ?1 and b.id.channelId = ?2 and b.id.attrDefnId " + "=" + " ?3")
    Optional<BoaUriApiAttriDefn> findSingleByEntityChannelAttrDefnId(Integer entityId, Integer channelId,
                                                                     Integer attrDefnId);

}