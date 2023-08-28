package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.controller.PropertyController;
import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.propertydto;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropertyServiceImpl implements PropertyService {


    @Autowired
    private PropertyRepository propertyRepository;


    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public propertydto saveProperty(propertydto pdto) {
        PropertyEntity pe=propertyConverter.convertDTOtoEntity(pdto);
        pe=propertyRepository.save(pe);
        pdto=propertyConverter.convertEntitytoDTO(pe);
        return pdto;

    }
}
