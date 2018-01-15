CREATE TABLE country (
  country_id INT NOT NULL AUTO_INCREMENT,
  country_title VARCHAR(45) NULL,
  PRIMARY KEY (country_id));

CREATE TABLE proxy (
  proxy_id INT NOT NULL AUTO_INCREMENT,
  country_id INT NOT NULL ,
  city_title VARCHAR(45) NULL,
  host VARCHAR(45) NULL,
  port VARCHAR(45) NULL,
  last_seen VARCHAR(45) NULL,
  PRIMARY KEY (proxy_id));