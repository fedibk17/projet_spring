CREATE TABLE app_role (
                          id int(11) AUTO_INCREMENT PRIMARY KEY,
                          role varchar(255) NOT NULL
) ENGINE=InnoDB;

ALTER TABLE app_role ADD UNIQUE KEY Key1 (role);

CREATE TABLE app_user (
                          id int(11) AUTO_INCREMENT PRIMARY KEY,
                          email varchar(255) NOT NULL,
                          password varchar(255) NOT NULL,
                          username varchar(255) NOT NULL
) ENGINE=InnoDB;

ALTER TABLE app_user  ADD UNIQUE KEY Key2 (username);

CREATE TABLE app_user_roles (
                                app_user_id int(11) NOT NULL,
                                CONSTRAINT fk_roles FOREIGN KEY (roles_id) REFERENCES app_role (id),
                                roles_id int(11) NOT NULL,
                                CONSTRAINT fk_user FOREIGN KEY (app_user_id) REFERENCES app_user (id)
) ENGINE=InnoDB;

ALTER TABLE app_user_roles
    ADD KEY fk_roles (roles_id),
  ADD KEY fk_user (app_user_id);