drop table oauth_access_token;
drop table oauth_approvals;
drop table oauth_client_details;
drop table oauth_client_token;
drop table oauth_code;
drop table oauth_refresh_token;
drop table clientdetails;

-- -----------------------------------------------------
-- Table oatuh2.oauth_client_details 客户端信息
-- -----------------------------------------------------
create table oauth_client_details
(
  client_id               VARCHAR2(128) NOT NULL,
  resource_ids            VARCHAR2(256),
  client_secret           VARCHAR2(256),
  scope                   VARCHAR2(256),
  authorized_grant_types  VARCHAR2(256),
  web_server_redirect_uri VARCHAR2(256),
  authorities             VARCHAR2(256),
  access_token_validity   NUMBER(11),
  refresh_token_validity  NUMBER(11),
  additional_information  VARCHAR2(2048),
  autoapprove             VARCHAR2(256),
  PRIMARY KEY (client_id)
);
-- -----------------------------------------------------
-- Table oatuh2.oauth_access_token 生成的token
-- -----------------------------------------------------
create table oauth_access_token
(
  token_id          VARCHAR2(256),
  token             BLOB,
  authentication_id VARCHAR2(128) NOT NULL,
  user_name         VARCHAR2(256),
  client_id         VARCHAR2(256),
  authentication    BLOB,
  refresh_token     VARCHAR2(256),
  PRIMARY KEY (authentication_id)
);
-- -----------------------------------------------------
-- Table oatuh2.oauth_refresh_token 刷新token
-- -----------------------------------------------------
create table oauth_refresh_token
(
  token_id       VARCHAR2(256),
  token          BLOB,
  authentication BLOB
);
















-- -----------------------------------------------------
-- Table oauth2.clientdetails
-- -----------------------------------------------------
create table clientdetails
(
  appId                  VARCHAR2(128) NOT NULL,
  resourceIds            VARCHAR2(256),
  appSecret              VARCHAR2(256),
  scope                  VARCHAR2(256),
  grantTypes             VARCHAR2(256),
  redirectUrl            VARCHAR2(256),
  authorities            VARCHAR2(256),
  access_token_validity  NUMBER(11),
  refresh_token_validity NUMBER(11),
  additionalInformation  VARCHAR2(2048),
  autoApproveScopes      VARCHAR2(256),
  PRIMARY KEY (appId)
);
-- -----------------------------------------------------
-- Table oatuh2.oauth_approvals
-- -----------------------------------------------------
create table oauth_approvals
(
  userId         VARCHAR2(256),
  clientId       VARCHAR2(256),
  scope          VARCHAR2(256),
  status         VARCHAR2(10),
  expiresAt      TIMESTAMP,
  lastModifiedAt TIMESTAMP
);
-- -----------------------------------------------------
-- Table oatuh2.oauth_client_token
-- -----------------------------------------------------
create table oauth_client_token
(
  token_id          VARCHAR2(256),
  token             BLOB,
  authentication_id VARCHAR2(128) NOT NULL,
  user_name         VARCHAR2(256),
  client_id         VARCHAR2(256),
  PRIMARY KEY (authentication_id)
);
-- -----------------------------------------------------
-- Table oatuh2.oauth_code 授权码
-- -----------------------------------------------------
create table oauth_code
(
  code           VARCHAR2(256),
  authentication BLOB
);

delete
from clientdetails
where 1 = 1;
delete
from oauth_access_token
where 1 = 1;
delete
from oauth_approvals
where 1 = 1;
delete
from oauth_client_token
where 1 = 1;
delete
from oauth_code
where 1 = 1;
delete
from oauth_refresh_token
where 1 = 1;

delete
from oauth_client_details
where 1 = 1;



select * from clientdetails;
select * from oauth_access_token;
select * from oauth_approvals;
select * from oauth_client_details;
select * from oauth_client_token;
select * from oauth_code;
select * from oauth_refresh_token;



insert into oauth_client_details(client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri, access_token_validity, refresh_token_validity)
values ('appClient', 'secret', 'all', 'authorization_code,client_credentials,password,refresh_token', 'http://www.baidu.com', 60, 1800);

