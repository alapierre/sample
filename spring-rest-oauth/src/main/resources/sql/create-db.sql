CREATE TABLE oauth_access_token
( 
    token_id character varying(256) NOT NULL, 
    authentication bytea, 
    authentication_id character varying(256), 
    client_id character varying(256), 
    refresh_token character varying(256), 
    token bytea, 
    ser_name character varying(256), 
    USER_NAME character varying(256),
    CONSTRAINT oauth_access_token_pkey PRIMARY KEY (token_id)
);

CREATE TABLE oauth_refresh_token
(
  token_id character varying(256) NOT NULL,
  authentication bytea,
  token bytea,
  CONSTRAINT oauth_refresh_token_pkey PRIMARY KEY (token_id)
);

create table users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled boolean not null);

  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      
create unique index ix_auth_username on authorities (username,authority);
