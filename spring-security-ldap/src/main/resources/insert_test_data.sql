INSERT INTO roles (role_name) VALUES ('ROLE_USER');
INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role_name) VALUES ('ROLE_SYS_ADMIN');
INSERT INTO roles (role_name) VALUES ('ROLE_SUPER_SYS_ADMIN');

INSERT INTO users (username, password, enabled) VALUES ('user', 'user', TRUE);
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');

INSERT INTO users (username, password, enabled) VALUES ('admin', 'admin', TRUE);
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO groups (name) VALUES ('ADMIN');

INSERT INTO group_authorities (group_id, authority) VALUES (1, 'ROLE_SYS_ADMIN');
INSERT INTO group_authorities (group_id, authority) VALUES (1, 'ROLE_SUPER_SYS_ADMIN');

INSERT INTO group_users (group_id, username) VALUES (1, 'admin');
