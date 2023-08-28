package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.propertydto;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity (propertydto pdto){
        PropertyEntity pe= new PropertyEntity();
        pe.setId(pdto.getId());
        pe.setTitle(pdto.getTitle());
        pe.setAddress(pdto.getAddress());
        pe.setOwneremail(pdto.getOwneremail());
        pe.setOwnername(pdto.getOwnername());
        pe.setPrice(pdto.getPrice());
        pe.setDescription(pdto.getDescription());
        return pe;

    }

    public propertydto convertEntitytoDTO (PropertyEntity propertyEntity){
        propertydto pdto= new propertydto();
        pdto.setId(propertyEntity.getId());
        pdto.setTitle(propertyEntity.getTitle());
        pdto.setAddress(propertyEntity.getAddress());
        pdto.setOwneremail(propertyEntity.getOwneremail());
        pdto.setOwnername(propertyEntity.getOwnername());
        pdto.setPrice(propertyEntity.getPrice());
        pdto.setDescription(propertyEntity.getDescription());
        return pdto;

    }

}
