show databases ;
 
create database SWAGGERUI;

use SWAGGERUI;

CREATE TABLE BOA_URI_OPENAPI_DOC_DEFN
(
    ENTITY_ID    INT(3)       NOT NULL,
    CHANNEL_ID   INT(3)       NOT NULL,
    DOC_ID       INT(3)       NOT NULL,
    SUMMARY      VARCHAR(300) NOT NULL,
    DESCRIPTION  VARCHAR(1000),
    VERSION      VARCHAR(10)  NOT NULL,
    CREATED_BY   BIGINT(19),
    CREATED_DATE TIMESTAMP,
    VERSION_NO   INT(3) DEFAULT 0,
    PRIMARY KEY (ENTITY_ID, CHANNEL_ID, DOC_ID)
);

CREATE TABLE BOA_URI_OPENAPI_GRP_DEFN
(
    ENTITY_ID    INT(3)       NOT NULL,
    CHANNEL_ID   INT(3)       NOT NULL,
    DOC_ID       INT(3)       NOT NULL,
    GROUP_ID     INT(3)       NOT NULL,
    NAME         VARCHAR(300) NOT NULL,
    DESCRIPTION  VARCHAR(1000),
    CREATED_BY   BIGINT(19),
    CREATED_DATE TIMESTAMP,
    VERSION_NO   INT(3) DEFAULT 0,
    ACTIVE_FLAG  TINYINT(1) DEFAULT 0,
    PRIMARY KEY (ENTITY_ID, CHANNEL_ID, GROUP_ID)
);



CREATE TABLE BOA_URI_OPENAPI_API_DEFN
(
    ENTITY_ID    INT(3)       NOT NULL,
    CHANNEL_ID   INT(3)       NOT NULL,
    URI_ID       INT(3)       NOT NULL,
    GROUP_ID     INT(3)       NOT NULL,
    URI_PATH     VARCHAR(100) NOT NULL,
    SUMMARY      VARCHAR(300) NOT NULL,
    DESCRIPTION  VARCHAR(1000),
    HTTP_METHOD  VARCHAR(10)  NOT NULL,
    REQ_DEFN_ID  INT(10),
    RES_DEFN_ID  INT(10),
    CREATED_BY   BIGINT(19),
    CREATED_DATE TIMESTAMP,
    VERSION_NO   INT(3) DEFAULT 0,
    PRIMARY KEY (ENTITY_ID, CHANNEL_ID, URI_ID)
);

CREATE TABLE BOA_URI_OPENAPI_API_RQ_DEFN
(
    ENTITY_ID                INT(3)       NOT NULL,
    CHANNEL_ID               INT(3)       NOT NULL,
    DEFN_ID                  INT(10)      NOT NULL,
    MEDIA_TYPE               VARCHAR(200) NOT NULL,
    HEADER_ATTR_DEFN_ID      INT(10),
    QUERY_PARAM_ATTR_DEFN_ID INT(10),
    PATH_PARAM_ATTR_DEFN_ID  INT(10),
    BODY_ATTR_DEFN_ID        INT(10),
    CREATED_BY               BIGINT(19),
    CREATED_DATE             TIMESTAMP,
    VERSION_NO               INT(3) DEFAULT 0,
    PRIMARY KEY (ENTITY_ID, CHANNEL_ID, DEFN_ID)
);

CREATE TABLE BOA_URI_OPENAPI_API_RS_DEFN
(
    ENTITY_ID                 INT(3)       NOT NULL,
    CHANNEL_ID                INT(3)       NOT NULL,
    DEFN_ID                   INT(10)      NOT NULL,
    MEDIA_TYPE                VARCHAR(200) NOT NULL,
    HEADER_ATTR_DEFN_ID       INT(10),
    BODY_SUCCESS_ATTR_DEFN_ID INT(10),
    BODY_FAILURE_ATTR_DEFN_ID INT(10),
    CREATED_BY                BIGINT(19),
    CREATED_DATE              TIMESTAMP,
    VERSION_NO                INT(3) DEFAULT 0,
    PRIMARY KEY (ENTITY_ID, CHANNEL_ID, DEFN_ID)
);
CREATE TABLE BOA_URI_OPENAPI_API_ATTR_DEFN
(
    ENTITY_ID      INT(3)       NOT NULL,
    CHANNEL_ID     INT(3)       NOT NULL,
    ATTR_DEFN_ID   INT(10)      NOT NULL,
    ATTR_NAME      VARCHAR(100) NOT NULL,
    SUMMARY        VARCHAR(300),
    DESCRIPTION    VARCHAR(1000),
    DATA_TYPE      VARCHAR(500),
    MANDATORY_FLAG BOOLEAN,
    CREATED_BY     BIGINT(19),
    CREATED_DATE   TIMESTAMP,
    VERSION_NO     INT(3) DEFAULT 0,
    PRIMARY KEY (ENTITY_ID, CHANNEL_ID, ATTR_DEFN_ID, ATTR_NAME)
);


DROP TABLE BOA_URI_OPENAPI_DOC_DEFN;
DROP TABLE BOA_URI_OPENAPI_GRP_DEFN;
DROP TABLE BOA_URI_OPENAPI_API_DEFN;
DROP TABLE BOA_URI_OPENAPI_API_RQ_DEFN;
DROP TABLE BOA_URI_OPENAPI_API_RS_DEFN;
DROP TABLE BOA_URI_OPENAPI_API_ATTR_DEFN;



/*INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 1, 'processDefnId', 'process definition id of bpm process of user tasks',
        'process definition id of bpm process of user tasks', 'String', 1, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 1, 'currentPage', 'pagenation info', 'pagenation info', 'integer', 1, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 3, 'response', 'response data if api returns rows ', 'response data if api returns rows ',
        'java.util.Map', 0,
        null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 1, 'pagesize', 'page info needed for performace ',
        'page info needed for performace', 'integer', 0, null, null, 0);*/
/*INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 2, 'user', 'logged in user object from the security context needed to perform fap checks ',
        'logged in user object from the security context needed to perform fap checks ', 'integer', 0, null, null, 0);*/



INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 2, 'ResponseModel', null,
        null, 'com.example.swaggercustomui.model.ResponseModel', true, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 5, 'ResponseModel', null,
        null, 'com.example.swaggercustomui.model.ResponseModel', true, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 6, 'RequestModel', null,
        null, 'com.example.swaggercustomui.model.RequestModel', true, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 7, 'AttributeModel', null,
        null, 'com.example.swaggercustomui.model.AttributeModel', true, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 92, 'pageSize', 'Pagenation info needed.....',
        'Pagenation info needed.....', 'integer', true, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 92, 'currentPage', 'Pagenation info needed.....',
        'Pagenation info needed.....', 'integer', true, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 90, 'pageSize', 'Pagenation info needed.....',
        'Pagenation info needed.....', 'integer', true, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 90, 'currentPage', 'Pagenation info needed.....',
        'Pagenation info needed.....', 'integer', true, null, null, 0);


INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 31, 'ChannelsBpmWizardRCM', null,
        null, 'com.example.swaggercustomui.model.ResponseModel', false, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 41, 'ChannelsBPMWizardRCM', null,
        null, 'com.example.swaggercustomui.model.ResponseModel', false, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 42, 'ejsaverestwebmodel', null,
        null, 'com.example.swaggercustomui.model.ResponseModel', false, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 43, 'ejsaverestwebmodel', null,
        null, 'com.example.swaggercustomui.model.ResponseModel', false, null, null, 0);



INSERT INTO BOA_URI_OPENAPI_API_DEFN
VALUES (1, 4, 6017, 1, '/bpm/process/initialize', 'api used to get stepper component ',
        'api used to get stepper component', 'GET',
        1, 1, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_DEFN
VALUES (1, 4, 6018, 2, '/bpm/process/wizard', 'api used to initialize the bpm process ',
        'api used to get stepper component', 'POST', 2, 2, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_DEFN
VALUES (1, 4, 6019, 3, '/ej/save/basic-details',
        'API used to save the details in EJ', 'API used to save the details in EJ',
        'POST', 3, 3, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_DEFN
VALUES ( 1, 4, 6020, 4, '/ej/statistics', 'Api used to get statisticts of ej data component based on the user tasks'
       , 'Api used to get statisticts of ej data'
       , 'GET', 4, 4, null, null, 0);


INSERT INTO BOA_URI_OPENAPI_API_RQ_DEFN
VALUES (1, 4, 1, 'application/json', null, null, null, 2, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_RQ_DEFN
VALUES (1, 4, 2, 'application/json', null, 90, null, 5, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_RQ_DEFN
VALUES (1, 4, 3, 'application/json', null, null, null, 6, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_RQ_DEFN
VALUES (1, 4, 4, 'application/json', null, 92, null, 7, null, null, 0);



INSERT INTO BOA_URI_OPENAPI_API_RS_DEFN
VALUES (1, 4, 1, 'application/json', null, 31, null, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_RS_DEFN
VALUES (1, 4, 2, 'application/json', null, 41, null, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_RS_DEFN
VALUES (1, 4, 3, 'application/xml', null, 42, null, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_RS_DEFN
VALUES (1, 4, 4, 'application/xml', null, 43, null, null, null, 0);



INSERT INTO BOA_URI_OPENAPI_GRP_DEFN
VALUES (1, 4, 1, 1, 'Business Process Management APIS',
        ' Business Process Management APIS', null, null, 0,1);
INSERT INTO BOA_URI_OPENAPI_GRP_DEFN
VALUES (1, 4, 1, 2, 'Business Process Management APIS',
        ' Business Process Management APIS', null, null, 0,1);
INSERT INTO BOA_URI_OPENAPI_GRP_DEFN
VALUES (1, 4, 1, 3, 'Electronic journal APIS',
        ' Electronic journal APIS', null, null, 0,1);
INSERT INTO BOA_URI_OPENAPI_GRP_DEFN
VALUES (1, 4, 1, 4, 'Electronic journal APIS',
        ' Electronic journal APIS', null, null, 0,1);



SELECT *
FROM BOA_URI_OPENAPI_API_ATTR_DEFN;
SELECT *
FROM BOA_URI_OPENAPI_API_DEFN;
SELECT *
FROM BOA_URI_OPENAPI_API_RQ_DEFN;
SELECT *
FROM BOA_URI_OPENAPI_API_RS_DEFN;
SELECT *
FROM BOA_URI_OPENAPI_GRP_DEFN;


TRUNCATE TABLE BOA_URI_OPENAPI_API_DEFN;
TRUNCATE TABLE BOA_URI_OPENAPI_API_RQ_DEFN;
TRUNCATE TABLE BOA_URI_OPENAPI_API_RS_DEFN;
TRUNCATE TABLE BOA_URI_OPENAPI_API_ATTR_DEFN;
TRUNCATE TABLE BOA_URI_OPENAPI_GRP_DEFN;