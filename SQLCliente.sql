CREATE schema if not exists bancocliente;

use bancocliente;

CREATE TABLE IF NOT EXISTS Cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL ,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (idCliente))
ENGINE = InnoDB

