CREATE TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email varchar(45) NOT NULL UNIQUE,
  password varchar(64) NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL
);
 
CREATE TABLE roles (
  role_id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(45) NOT NULL
);
 
CREATE TABLE users_roles (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  KEY user_fk_idx (user_id),
  KEY role_fk_idx (role_id),
  CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (role_id),
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);
