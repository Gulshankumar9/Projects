show databases ;
 
create database SWAGGERUI_CHANGES;

use SWAGGERUI_CHANGES;

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
    PRIMARY KEY (ENTITY_ID, CHANNEL_ID, GROUP_ID)
);



CREATE TABLE BOA_URI_OPENAPI_API_DEFN
(
    ENTITY_ID    INT(3)       NOT NULL,
    CHANNEL_ID   INT(3)       NOT NULL,
    URI_ID       INT(3)       NOT NULL,
    GROUP_ID     VARCHAR(300) NOT NULL,
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
    SUMMARY        VARCHAR(300) NOT NULL,
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



INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
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
        'page info needed for performace', 'integer', 0, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_ATTR_DEFN
VALUES (1, 4, 2, 'user', 'logged in user object from the security context needed to perform fap checks ',
        'logged in user object from the security context needed to perform fap checks ', 'integer', 0, null, null, 0);


INSERT INTO BOA_URI_OPENAPI_API_DEFN
VALUES (1, 4, 6017, 'Business process managemnet api ', 'api used to get stepper component ',
        'api used to get stepper component', 'GET',
        1, 1, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_DEFN
VALUES (1, 4, 6018, 'Business process managemnet api ', 'api used to initialize the bpm process ',
        'api used to get stepper component', 'POST', 1, 1, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_DEFN
VALUES (1, 4, 6019, 'Electronic journal  apis ',
        'api used to save details of ej  ', 'api used to save details of ej ',
        'POST', 1, 1, null, null, 0);
INSERT INTO BOA_URI_OPENAPI_API_DEFN
VALUES ( 1, 4, 6020, 'Electronic journal  apis ', 'api used to get statistics of ej data '
       , 'api used to get statistics of ej data'
       , 'GET', 1, 1, null, null, 0);


INSERT INTO BOA_URI_OPENAPI_API_RQ_DEFN
VALUES (1, 4, 1, 'application/json', null, 1, null, 2, null, null, 0);

INSERT INTO BOA_URI_OPENAPI_API_RS_DEFN
VALUES (1, 4, 1, 'application/json', null, 3, null, null, null, 0);



INSERT INTO BOA_URI_OPENAPI_GRP_DEFN
VALUES (1, 4, 1, 1, 'Businesss Process Management API',
        ' API used to get stepper component', null, null, 0);



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