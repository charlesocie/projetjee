CREATE TABLE Product
(
  id    INT AUTO_INCREMENT
    PRIMARY KEY,
  name  VARCHAR(20) NULL,
  price FLOAT       NULL,
  CONSTRAINT Product_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE TABLE User
(
  id        INT AUTO_INCREMENT
    PRIMARY KEY,
  lastname  VARCHAR(30) NULL,
  firstname VARCHAR(30) NULL,
  mail      VARCHAR(30) NULL,
  password  VARCHAR(30) NULL
)
  ENGINE = InnoDB;


