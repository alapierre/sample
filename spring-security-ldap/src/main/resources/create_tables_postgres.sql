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
ALTER TABLE users OWNER TO "ldap";

CREATE TABLE roles
(
  role_name CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (role_name)
)
WITH (
OIDS = FALSE
);
ALTER TABLE roles OWNER TO "ldap";

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
ALTER TABLE authorities OWNER TO "ldap";

CREATE UNIQUE INDEX ix_auth_username ON authorities USING BTREE (username COLLATE pg_catalog."default", authority
                                                                                                        COLLATE
                                                                                                        pg_catalog."default");

CREATE TABLE groups (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

ALTER TABLE groups OWNER TO "ldap";

CREATE TABLE group_authorities (
  group_id  BIGINT       NOT NULL,
  authority VARCHAR(100) NOT NULL,
  CONSTRAINT foreign_fk_6 FOREIGN KEY (group_id) REFERENCES groups (id),
  PRIMARY KEY (group_id, authority)
);

ALTER TABLE group_authorities OWNER TO "ldap";

CREATE TABLE group_users (
  id       SERIAL PRIMARY KEY,
  group_id BIGINT       NOT NULL,
  username VARCHAR(100) NOT NULL,
  CONSTRAINT foreign_fk_7 FOREIGN KEY (group_id) REFERENCES groups (id)
);

ALTER TABLE group_users OWNER TO "ldap";
