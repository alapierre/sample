CREATE TABLE users
(
  username CHARACTER VARYING(50)  NOT NULL,
  password CHARACTER VARYING(150) NOT NULL,
  enabled  BOOLEAN                NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (username)
)
WITH (
OIDS = FALSE
);
ALTER TABLE users OWNER TO "acl";

CREATE TABLE roles
(
  role_name CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (role_name)
)
WITH (
OIDS = FALSE
);
ALTER TABLE roles OWNER TO "acl";

CREATE TABLE authorities
(
  username  CHARACTER VARYING(50) NOT NULL,
  authority CHARACTER VARYING(50) NOT NULL,
  CONSTRAINT authorities_pkey PRIMARY KEY (username, authority),
  CONSTRAINT authorities_authority_fkey FOREIGN KEY (authority)
  REFERENCES roles (role_name) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_authorities_users FOREIGN KEY (username)
  REFERENCES users (username) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
);
ALTER TABLE authorities OWNER TO "acl";

CREATE UNIQUE INDEX ix_auth_username ON authorities USING BTREE (username COLLATE pg_catalog."default", authority
                                                                                                        COLLATE
                                                                                                        pg_catalog."default");


CREATE TABLE acl_sid (
  id        BIGSERIAL    NOT NULL PRIMARY KEY,
  principal BOOLEAN      NOT NULL,
  sid       VARCHAR(100) NOT NULL,
  CONSTRAINT unique_uk_1 UNIQUE (sid, principal)
);

ALTER TABLE acl_sid OWNER TO "acl";

CREATE TABLE acl_class (
  id    BIGSERIAL    NOT NULL PRIMARY KEY,
  class VARCHAR(100) NOT NULL,
  CONSTRAINT unique_uk_2 UNIQUE (class)
);

ALTER TABLE acl_class OWNER TO "acl";

CREATE TABLE acl_object_identity (
  id                 BIGSERIAL PRIMARY KEY,
  object_id_class    BIGINT  NOT NULL,
  object_id_identity BIGINT  NOT NULL,
  parent_object      BIGINT,
  owner_sid          BIGINT,
  entries_inheriting BOOLEAN NOT NULL,
  CONSTRAINT unique_uk_3 UNIQUE (object_id_class, object_id_identity),
  CONSTRAINT foreign_fk_1 FOREIGN KEY (parent_object) REFERENCES acl_object_identity (id),
  CONSTRAINT foreign_fk_2 FOREIGN KEY (object_id_class) REFERENCES acl_class (id),
  CONSTRAINT foreign_fk_3 FOREIGN KEY (owner_sid) REFERENCES acl_sid (id)
);

ALTER TABLE acl_object_identity OWNER TO "acl";

CREATE TABLE acl_entry (
  id                  BIGSERIAL PRIMARY KEY,
  acl_object_identity BIGINT  NOT NULL,
  ace_order           INT     NOT NULL,
  sid                 BIGINT  NOT NULL,
  mask                INTEGER NOT NULL,
  granting            BOOLEAN NOT NULL,
  audit_success       BOOLEAN NOT NULL,
  audit_failure       BOOLEAN NOT NULL,
  CONSTRAINT unique_uk_4 UNIQUE (acl_object_identity, ace_order),
  CONSTRAINT foreign_fk_4 FOREIGN KEY (acl_object_identity) REFERENCES acl_object_identity (id),
  CONSTRAINT foreign_fk_5 FOREIGN KEY (sid) REFERENCES acl_sid (id)
);

ALTER TABLE acl_entry OWNER TO "acl";

CREATE TABLE groups (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

ALTER TABLE groups OWNER TO "acl";

CREATE TABLE group_authorities (
  group_id  BIGINT       NOT NULL,
  authority VARCHAR(100) NOT NULL,
  CONSTRAINT foreign_fk_6 FOREIGN KEY (group_id) REFERENCES groups (id),
  PRIMARY KEY (group_id, authority)
);

ALTER TABLE group_authorities OWNER TO "acl";

CREATE TABLE group_users (
  id       SERIAL PRIMARY KEY,
  group_id BIGINT       NOT NULL,
  username VARCHAR(100) NOT NULL,
  CONSTRAINT foreign_fk_7 FOREIGN KEY (group_id) REFERENCES groups (id)
);

ALTER TABLE group_users OWNER TO "acl";
