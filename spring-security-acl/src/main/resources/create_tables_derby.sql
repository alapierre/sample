create table "SA".USERS
(
	USERNAME VARCHAR(128) not null primary key,
	PASSWORD VARCHAR(256) not null,
	ENABLED BOOLEAN not null
);

create table "SA".AUTHORITIES
(
	USERNAME VARCHAR(128) not null,
	AUTHORITY VARCHAR(256) not null,
	primary key (USERNAME, AUTHORITY),
        constraint fk_authorities_users foreign key(username) references users(username)
);
alter table AUTHORITIES add foreign key (username) references users(username);
 
CREATE TABLE roles
(
  role_name CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (role_name)
);

CREATE TABLE  acl_sid (
  id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  principal int NOT NULL,
  sid varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (sid,principal)
);

CREATE TABLE acl_class (
  id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  class varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (class)
);

CREATE TABLE acl_entry (
  id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  acl_object_identity bigint NOT NULL,
  ace_order int NOT NULL,
  sid bigint NOT NULL,
  mask int NOT NULL,
  granting int NOT NULL,
  audit_success int NOT NULL,
  audit_failure int NOT NULL,
  PRIMARY KEY (id),
  UNIQUE  (acl_object_identity,ace_order),
  foreign KEY (sid) references acl_sid(id)
);

CREATE TABLE acl_object_identity (
  id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  object_id_class bigint NOT NULL,
  object_id_identity bigint NOT NULL,
  parent_object bigint DEFAULT NULL,
  owner_sid bigint DEFAULT NULL,
  entries_inheriting boolean NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (object_id_class,object_id_identity),
  FOREIGN KEY (parent_object) REFERENCES acl_object_identity (id),
  FOREIGN KEY (owner_sid) REFERENCES acl_sid (id)
);

CREATE TABLE groups (
  id  integer  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE group_authorities (
  group_id  integer       NOT NULL,
  authority VARCHAR(100) NOT NULL,
  CONSTRAINT foreign_fk_6 FOREIGN KEY (group_id) REFERENCES groups (id),
  PRIMARY KEY (group_id, authority);

CREATE TABLE group_users (
  id       integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  group_id integer       NOT NULL,
  username VARCHAR(100) NOT NULL,
  CONSTRAINT foreign_fk_7 FOREIGN KEY (group_id) REFERENCES groups (id)
);