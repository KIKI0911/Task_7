DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  addressId int NOT NULL,
  age int NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users (name, email, addressId, age) VALUES ("鈴木", "suzuki@raise-tech.co.jp","5", 19);
INSERT INTO users (name, email, addressId, age) VALUES ("中村", "nakamura@raise-tech.co.jp","7", 55);
INSERT INTO users (name, email, addressId, age) VALUES ("田中", "tanaka@raise-tech.co.jp", "9", 35);
INSERT INTO users (name, email, addressId, age) VALUES ("小林", "kobayashi@raise-tech.co.jp","2", 7);