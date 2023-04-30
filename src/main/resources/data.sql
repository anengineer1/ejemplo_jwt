DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS suministra;
DROP TABLE IF EXISTS piezas;
DROP TABLE IF EXISTS proveedores;
SET character_set_client = utf8mb4;

CREATE TABLE usuarios (
id int NOT NULL AUTO_INCREMENT,
username NVARCHAR(255),
password NVARCHAR(255),
role NVARCHAR(255),
PRIMARY KEY (id)
);

INSERT INTO usuarios (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

CREATE TABLE piezas (
  codigo int NOT NULL AUTO_INCREMENT,
  nombre nvarchar(100) DEFAULT NULL,
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table piezas
--

LOCK TABLES piezas WRITE;
INSERT INTO piezas (nombre) VALUES ('destornillador'),('tenazas'),('taladro');
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

SET character_set_client = utf8mb4;

CREATE TABLE proveedores (
  id char(4) NOT NULL,
  nombre nvarchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table proveedores
--

LOCK TABLES proveedores WRITE;
INSERT INTO proveedores (id, nombre) VALUES ('1234','Escoria SA'), ('1111','Almodobar SA'), ('2222','Baracas SA');
UNLOCK TABLES;

--
-- Table structure for table `registro_curso`
--

SET character_set_client = utf8mb4 ;
 
CREATE TABLE suministra (
  id int NOT NULL AUTO_INCREMENT,
  precio int NOT NULL,
  codigopieza int NOT NULL,
  idproveedor char(4) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT codigopieza_fk FOREIGN KEY (codigopieza) REFERENCES piezas (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT idproveedor_fk FOREIGN KEY (idproveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table suministra
--

LOCK TABLES suministra WRITE;
INSERT INTO suministra (precio, codigopieza, idproveedor) VALUES (20,1,'1234'),(30,2,'1111'),(27,3,'2222');
UNLOCK TABLES;
