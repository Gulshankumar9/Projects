package com.example.swaggercustomui;

import com.example.swaggercustomui.model.*;
import com.example.swaggercustomui.persistance.*;
import com.example.swaggercustomui.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FetchData {

    @Autowired
    private BoaUriApiDefnRepository boaUriApiDefnRepository;
    @Autowired
    private BoaUriApiRqDefnRepository boaUriApiRqDefnRepository;
    @Autowired
    private BoaUriApiGrpDefnRepository boaUriApiGrpDefnRepository;
    @Autowired
    private BoaUriApiRsDefnRepository boaUriApiRsDefnRepository;
    @Autowired
    private BoaUriDocDefnRepository boaUriDocDefnRepository;
    @Autowired
    private BoaUriApiAttriDefnRepository boaUriApiAttriDefnRepository;

    public List<ApiGroupModel> fetch() {

        List<ApiGroupModel> apiGroupModels = new ArrayList<>();

        List<BoaUriApiGrpDefn> apiGrpDefns = boaUriApiGrpDefnRepository.findAll();

        for (BoaUriApiGrpDefn apiGrpDefn : apiGrpDefns) {

            ApiGroupModel apiGroupModel = new ApiGroupModel();
            apiGroupModel.setName(apiGrpDefn.getName());
            apiGroupModel.setDescription(apiGrpDefn.getDescription());

            List<BoaUriApiDefn> apiDefns = boaUriApiDefnRepository.findByGroupId(apiGrpDefn.getId()
                                                                                           .getEntityId(), apiGrpDefn
                    .getId().getChannelId(), apiGrpDefn.getId().getGroupId());
            List<ApiModel> apiModels = new ArrayList<>();

            for (BoaUriApiDefn apiDefn : apiDefns) {
                if (apiDefn.getGroupId().equals(apiGrpDefn.getId().getGroupId())) {
                    ApiModel apiModel = createApiModel(apiDefn);
                    apiModels.add(apiModel);
                }
            }

            apiGroupModel.setApiModels(apiModels);
            apiGroupModels.add(apiGroupModel);

        }


        return apiGroupModels;
    }

    private ApiModel createApiModel(BoaUriApiDefn apiDefn) {


        BoaUriApiDefnId id = apiDefn.getId();


        ApiModel apiModel = new ApiModel();
        apiModel.setUri(apiDefn.getUriPath());
        apiModel.setSummary(apiDefn.getSummary());
        apiModel.setDescription(apiDefn.getDescription());
        apiModel.setHttpMethod(apiDefn.getHttpMethod());


        Optional<BoaUriApiRqDefn> opApiRqDefn = boaUriApiRqDefnRepository.findByEntityChannelDefnId(id.getEntityId(),
                id.getChannelId(), apiDefn.getReqDefnId());


        opApiRqDefn.ifPresent(apiRqDefn -> {


            List<BoaUriApiAttriDefn> apiHeaderAttriDefns =
                    boaUriApiAttriDefnRepository.findByEntityChannelAttrDefnId(apiRqDefn
                    .getId().getEntityId(), apiRqDefn.getId().getChannelId(), apiRqDefn.getHeaderAttrDefnId());

            List<BoaUriApiAttriDefn> apiQueryParamAttriDefns =
                    boaUriApiAttriDefnRepository.findByEntityChannelAttrDefnId(id.getEntityId(), id.getChannelId(),
                            apiRqDefn.getQueryParamAttrDefnId());

            List<BoaUriApiAttriDefn> apiPathParamAttriDefns =
                    boaUriApiAttriDefnRepository.findByEntityChannelAttrDefnId(id.getEntityId(), id.getChannelId(),
                            apiRqDefn.getPathParamAttrDefnId());

            Optional<BoaUriApiAttriDefn> apiBodyAttriDefn =
                    boaUriApiAttriDefnRepository.findSingleByEntityChannelAttrDefnId(id.getEntityId(),
                            id.getChannelId(), apiRqDefn.getBodyAttrDefnId());

            RequestModel requestModel = new RequestModel();
            requestModel.setHeaders(convertToAttributeModels(apiHeaderAttriDefns));
            requestModel.setQueryParameters(convertToAttributeModels(apiQueryParamAttriDefns));
            requestModel.setPathParameters(convertToAttributeModels(apiPathParamAttriDefns));
            requestModel.setBody(convertToAttributeModel(apiBodyAttriDefn));
            requestModel.setMediaType(apiRqDefn.getMediaType());

            apiModel.setRequest(requestModel);


        });

        Optional<BoaUriApiRsDefn> opApiRsDefn = boaUriApiRsDefnRepository.findByEntityChannelDefnId(id.getEntityId(),
                id.getChannelId(), apiDefn.getResDefnId());

        opApiRsDefn.ifPresent(apiRsDefn -> {

            List<BoaUriApiAttriDefn> apiHeaderAttriDefns =
                    boaUriApiAttriDefnRepository.findByEntityChannelAttrDefnId(apiRsDefn
                    .getId().getEntityId(), apiRsDefn.getId().getChannelId(), apiRsDefn.getHeaderAttrDefnId());

            Optional<BoaUriApiAttriDefn> apiBodySuccessAttriDefn =
                    boaUriApiAttriDefnRepository.findSingleByEntityChannelAttrDefnId(apiRsDefn
                    .getId().getEntityId(), apiRsDefn.getId().getChannelId(), apiRsDefn.getBodySuccessAttrDefnId());

            Optional<BoaUriApiAttriDefn> apiBodyFailureAttriDefn =
                    boaUriApiAttriDefnRepository.findSingleByEntityChannelAttrDefnId(id.getEntityId(), apiRsDefn
                    .getId().getChannelId(), apiRsDefn.getBodyFailureAttrDefnId());

            ResponseModel responseModel = new ResponseModel();
            responseModel.setHeaders(convertToAttributeModels(apiHeaderAttriDefns));
            responseModel.setSuccessResponse(convertToAttributeModel(apiBodySuccessAttriDefn));
            responseModel.setFailureResponse(convertToAttributeModel(apiBodyFailureAttriDefn));
            responseModel.setMediaType(apiRsDefn.getMediaType());

            apiModel.setResponse(responseModel);

        });

        return apiModel;

    }

    private List<AttributeModel> convertToAttributeModels(List<BoaUriApiAttriDefn> apiAttriDefns) {
        List<AttributeModel> attributeModels = new ArrayList<>();
        for (BoaUriApiAttriDefn apiAttriDefn : apiAttriDefns) {
            AttributeModel attributeModel = new AttributeModel();
            attributeModel.setName(apiAttriDefn.getId().getAttrName());
            attributeModel.setDataType(apiAttriDefn.getDataType());
            attributeModel.setSummary(apiAttriDefn.getSummary());
            attributeModel.setDescription(apiAttriDefn.getDescription());
            attributeModel.setMandatory(apiAttriDefn.getMandatoryFlag());
            attributeModels.add(attributeModel);
        }
        return attributeModels;
    }

    private AttributeModel convertToAttributeModel(Optional<BoaUriApiAttriDefn> opApiAttriDefn) {
        if (opApiAttriDefn.isPresent()) {
            BoaUriApiAttriDefn apiAttriDefn = opApiAttriDefn.get();
            AttributeModel attributeModel = new AttributeModel();
            attributeModel.setName(apiAttriDefn.getId().getAttrName());
            attributeModel.setDataType(apiAttriDefn.getDataType());
            attributeModel.setSummary(apiAttriDefn.getSummary());
            attributeModel.setDescription(apiAttriDefn.getDescription());
            attributeModel.setMandatory(apiAttriDefn.getMandatoryFlag());
            return attributeModel;
        }
        return null;
    }
}