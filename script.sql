drop database assessment;
show databases;
create database assessment;
use assessment;

CREATE TABLE users (
  user_id int(16) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email varchar(64) NOT NULL UNIQUE,
  password varchar(32) NOT NULL,
  first_name varchar(32) NOT NULL,
  last_name varchar(32) NOT NULL,
  profile_image MEDIUMBLOB
);
 
CREATE TABLE roles (
  role_id int(16) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(64) NOT NULL
);
 
CREATE TABLE users_roles (
  user_id int(16) NOT NULL,
  role_id int(16) NOT NULL,
  KEY user_fk_idx (user_id),
  KEY role_fk_idx (role_id),
  CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (role_id),
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

INSERT INTO users (email, password, first_name, last_name) VALUES ('abc@xyz.com', '123456', 'Ahmed', 'Bello');
INSERT INTO users (email, password, first_name, last_name) VALUES ('xyz@abc.com', '123456', 'Bello', 'Ahmed');


INSERT INTO roles (name) VALUES ("admin");
INSERT INTO roles (name) VALUES ("reader");

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1); 
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);

select * from users;

CREATE TABLE books (
  book_id int(16) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title varchar(64) NOT NULL UNIQUE,
  isbn varchar(32) NOT NULL,
  revision_number varchar(32) NOT NULL,
  published_date date NOT NULL,
  publisher varchar(32) NOT NULL,
  author varchar(32) NOT NULL,
  date_added date NOT NULL,
  genre varchar(32) NOT NULL,
  cover_image MEDIUMBLOB 
);