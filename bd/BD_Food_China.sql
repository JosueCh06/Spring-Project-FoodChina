CREATE DATABASE  IF NOT EXISTS `bd_food_china` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_food_china`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_food_china
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_boleta`
--

DROP TABLE IF EXISTS `tb_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta` (
  `num_bol` int NOT NULL AUTO_INCREMENT,
  `cod_usu` int NOT NULL,
  `fec_emi_bol` datetime NOT NULL,
  `total_pagar` decimal(10,2) NOT NULL,
  PRIMARY KEY (`num_bol`),
  KEY `FK_Usuario_idx` (`cod_usu`),
  CONSTRAINT `FK_Usuario` FOREIGN KEY (`cod_usu`) REFERENCES `tb_usuario` (`cod_usu`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta`
--

LOCK TABLES `tb_boleta` WRITE;
/*!40000 ALTER TABLE `tb_boleta` DISABLE KEYS */;
INSERT INTO `tb_boleta` VALUES (2,1,'2021-11-29 00:00:00',56.30),(3,1,'2021-11-29 00:00:00',41.70),(4,1,'2021-11-29 00:00:00',65.80),(5,1,'2021-11-29 00:00:00',65.40),(6,1,'2021-11-29 00:00:00',44.00),(7,1,'2021-11-29 00:00:00',11.80),(8,1,'2021-11-29 00:00:00',45.60),(9,1,'2021-11-30 00:00:00',59.90),(10,1,'2021-11-30 00:00:00',35.80),(11,1,'2021-11-30 00:00:00',39.80),(12,1,'2021-11-30 00:00:00',17.30),(13,1,'2022-05-30 00:00:00',93.10),(14,1,'2022-05-31 00:00:00',82.70);
/*!40000 ALTER TABLE `tb_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria_platillo`
--

DROP TABLE IF EXISTS `tb_categoria_platillo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria_platillo` (
  `id_categoria_platillo` int NOT NULL AUTO_INCREMENT,
  `desc_cat_platillo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_categoria_platillo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria_platillo`
--

LOCK TABLES `tb_categoria_platillo` WRITE;
/*!40000 ALTER TABLE `tb_categoria_platillo` DISABLE KEYS */;
INSERT INTO `tb_categoria_platillo` VALUES (1,'Platos principales'),(2,'Sopas'),(3,'Bebidas'),(4,'Aperitivos');
/*!40000 ALTER TABLE `tb_categoria_platillo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria_proveedor`
--

DROP TABLE IF EXISTS `tb_categoria_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria_proveedor` (
  `id_categoriaP` int NOT NULL AUTO_INCREMENT,
  `desc_categoriaP` varchar(60) NOT NULL,
  PRIMARY KEY (`id_categoriaP`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria_proveedor`
--

LOCK TABLES `tb_categoria_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_categoria_proveedor` DISABLE KEYS */;
INSERT INTO `tb_categoria_proveedor` VALUES (1,'Abarrotes'),(2,'Supermercados'),(3,'Fruterias'),(4,'Verdulerias'),(5,'Embutidos y carnes');
/*!40000 ALTER TABLE `tb_categoria_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_enlace`
--

DROP TABLE IF EXISTS `tb_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_enlace` (
  `id_enlace` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `ruta` varchar(200) NOT NULL,
  PRIMARY KEY (`id_enlace`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_enlace`
--

LOCK TABLES `tb_enlace` WRITE;
/*!40000 ALTER TABLE `tb_enlace` DISABLE KEYS */;
INSERT INTO `tb_enlace` VALUES (1,'Ingrediente','ingrediente/'),(2,'Platillo','platillo/'),(3,'Proveedor','proveedor/'),(4,'Platillos','venta/'),(5,'Boleta','venta/listaDetalle'),(6,'Consultar Proveedor','proveedor/consulta'),(7,'Consultar Boleta','venta/consulta');
/*!40000 ALTER TABLE `tb_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ingrediente`
--

DROP TABLE IF EXISTS `tb_ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_ingrediente` (
  `id_ingrediente` int NOT NULL AUTO_INCREMENT,
  `desc_ingrediente` varchar(45) NOT NULL,
  `stock` int NOT NULL,
  `u_medida` varchar(255) DEFAULT NULL,
  `id_proveedor` int NOT NULL,
  PRIMARY KEY (`id_ingrediente`),
  KEY `id_proveedor_idx` (`id_proveedor`),
  CONSTRAINT `FK_Proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `tb_proveedor` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ingrediente`
--

LOCK TABLES `tb_ingrediente` WRITE;
/*!40000 ALTER TABLE `tb_ingrediente` DISABLE KEYS */;
INSERT INTO `tb_ingrediente` VALUES (1,'Arroz blanco',15,'Kg',1),(2,'Kion',50,'Cabezas',2),(3,'Pechuga de pollo',10,'Kg',6),(4,'Fideos de arroz',10,'Kg',7),(5,'Fideos caracol',9,'Kg',1),(6,'Cebolla china',5,'Kg',4),(7,'Maiz morado',10,'Kg',3),(8,'Hot Dog',16,'Kg',8),(9,'Sillao Fuerte',15,'Botella de 500ml',11),(10,'Champiñones',20,'Kg',10),(13,'Salsa Hoisin',10,'Botella de 500ml',11);
/*!40000 ALTER TABLE `tb_ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ingrediente_platillo`
--

DROP TABLE IF EXISTS `tb_ingrediente_platillo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_ingrediente_platillo` (
  `id_platillo` int NOT NULL,
  `id_ingrediente` int NOT NULL,
  PRIMARY KEY (`id_platillo`,`id_ingrediente`),
  KEY `id_ingrediente_idx` (`id_ingrediente`),
  CONSTRAINT `FK_ingrediente` FOREIGN KEY (`id_ingrediente`) REFERENCES `tb_ingrediente` (`id_ingrediente`),
  CONSTRAINT `FK_platillo` FOREIGN KEY (`id_platillo`) REFERENCES `tb_platillo` (`id_platillo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ingrediente_platillo`
--

LOCK TABLES `tb_ingrediente_platillo` WRITE;
/*!40000 ALTER TABLE `tb_ingrediente_platillo` DISABLE KEYS */;
INSERT INTO `tb_ingrediente_platillo` VALUES (1,1),(1,2),(1,3),(2,3),(2,4),(2,5),(1,6),(3,7),(1,8);
/*!40000 ALTER TABLE `tb_ingrediente_platillo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_platillo`
--

DROP TABLE IF EXISTS `tb_platillo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_platillo` (
  `id_platillo` int NOT NULL AUTO_INCREMENT,
  `desc_platillo` varchar(45) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_cat_platillo` int NOT NULL,
  PRIMARY KEY (`id_platillo`),
  KEY `id_cat_platillo_idx` (`id_cat_platillo`),
  CONSTRAINT `FK_cat_platillo` FOREIGN KEY (`id_cat_platillo`) REFERENCES `tb_categoria_platillo` (`id_categoria_platillo`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_platillo`
--

LOCK TABLES `tb_platillo` WRITE;
/*!40000 ALTER TABLE `tb_platillo` DISABLE KEYS */;
INSERT INTO `tb_platillo` VALUES (1,'Bombitas Chinas',20.00,4),(2,'Sopa wantan',5.90,2),(3,'Chicha morada',10.00,3),(4,'Wantan frito',6.90,4),(5,'Tallarin Saltado',15.90,1),(6,'Sopa china con tofu',5.90,2),(7,'Limonada fresh',8.00,3),(8,'Baozi',5.90,4),(9,'Aeropuerto Taypa',15.50,1),(10,'Chaufa primavera',22.50,1),(11,'Chaufa hawaiano',25.00,1),(13,'Piqueo Oriental',25.30,1),(15,'Pollo Cantones',13.90,1),(16,'Zongzi',15.90,1),(17,'Chi Jau',15.50,1),(18,'Chaufa triple sabor',13.50,1),(19,'Aeropuerto Saltado',15.20,1),(20,'ChinaFood box',13.50,1),(23,'Jugo de fruta',5.50,3),(27,'Cafe ',5.00,3),(29,'pan con pollo',15.00,4),(31,'Kam Lu Wantan',25.00,1);
/*!40000 ALTER TABLE `tb_platillo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_platillo_has_boleta`
--

DROP TABLE IF EXISTS `tb_platillo_has_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_platillo_has_boleta` (
  `num_bol` int NOT NULL,
  `id_platillo` int NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `sub_total` decimal(10,2) DEFAULT NULL,
  KEY `fk_boleta-detalle_idx` (`num_bol`),
  KEY `fk_platillo-detalle_idx` (`id_platillo`),
  CONSTRAINT `fk_boleta-detalle` FOREIGN KEY (`num_bol`) REFERENCES `tb_boleta` (`num_bol`),
  CONSTRAINT `fk_platillo-detalle` FOREIGN KEY (`id_platillo`) REFERENCES `tb_platillo` (`id_platillo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_platillo_has_boleta`
--

LOCK TABLES `tb_platillo_has_boleta` WRITE;
/*!40000 ALTER TABLE `tb_platillo_has_boleta` DISABLE KEYS */;
INSERT INTO `tb_platillo_has_boleta` VALUES (2,1,22.00,1,22.00),(11,5,15.90,2,31.80),(11,7,8.00,1,8.00),(12,2,5.90,2,11.80),(12,23,5.50,1,5.50),(13,1,22.00,2,44.00),(13,2,5.90,2,11.80),(13,3,10.00,2,20.00),(13,8,5.90,2,11.80),(13,23,5.50,1,5.50),(14,1,22.00,2,44.00),(14,2,5.90,2,11.80),(14,3,10.00,2,20.00),(14,4,6.90,1,6.90);
/*!40000 ALTER TABLE `tb_platillo_has_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedor` (
  `id_proveedor` int NOT NULL AUTO_INCREMENT,
  `nomb_proveedor` varchar(45) NOT NULL,
  `representante` varchar(45) NOT NULL,
  `cel_proveedor` varchar(9) NOT NULL,
  `dir_proveedor` varchar(45) NOT NULL,
  `id_categoriaP` int DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `fk_CategoriaProveedor` (`id_categoriaP`),
  CONSTRAINT `fk_CategoriaProveedor` FOREIGN KEY (`id_categoriaP`) REFERENCES `tb_categoria_proveedor` (`id_categoriaP`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES (1,'Vega','Jose Diaz','987654321','Av. Tupac Amaru #789',3),(2,'Tottus','Alberto Quintana','912345678','Av. Canta callao #321',2),(3,'Don Pepe','Pepe Lozano','987654322','Av. Primavera #456',3),(4,'Todo fresco','Juan Quispe','987654323','Av. Emancipacion #654',4),(5,'San fernando','Ramiro Salas','987654324','Av. Circumbalacion #789',5),(6,'Buen Filo','Dionisio Fernandes','987654325','Av. Panamericana norte #987',5),(7,'Global alimentos','Roberto Rimas','997654321','Av. Larco #123',1),(8,'Plaza Vea','Jesus Leguia','992345678','Av. Benavides #321',2),(9,'FastFruit','Tito Malca','997654322','Av. El sol #456',3),(10,'Del campo','Eugenio Flores','997654323','Av. Chinchaisuyo #654',4),(11,'Metro','Josefino Huerta','987645333','Av. Larco mar # 321',2);
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol`
--

DROP TABLE IF EXISTS `tb_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `desc_rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol`
--

LOCK TABLES `tb_rol` WRITE;
/*!40000 ALTER TABLE `tb_rol` DISABLE KEYS */;
INSERT INTO `tb_rol` VALUES (1,'cliente'),(2,'administrador'),(3,'gerente');
/*!40000 ALTER TABLE `tb_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol_enlace`
--

DROP TABLE IF EXISTS `tb_rol_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol_enlace` (
  `id_rol` int NOT NULL,
  `id_enlace` int NOT NULL,
  `idenlace` int NOT NULL,
  `idrol` int NOT NULL,
  PRIMARY KEY (`id_rol`,`id_enlace`),
  KEY `FKid_enlace_idx` (`id_enlace`),
  CONSTRAINT `FK_enlace` FOREIGN KEY (`id_enlace`) REFERENCES `tb_enlace` (`id_enlace`),
  CONSTRAINT `FK_rol_enlace` FOREIGN KEY (`id_rol`) REFERENCES `tb_rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol_enlace`
--

LOCK TABLES `tb_rol_enlace` WRITE;
/*!40000 ALTER TABLE `tb_rol_enlace` DISABLE KEYS */;
INSERT INTO `tb_rol_enlace` VALUES (1,4,0,0),(1,5,0,0),(2,1,0,0),(2,2,0,0),(2,3,0,0),(2,6,0,0),(2,7,0,0);
/*!40000 ALTER TABLE `tb_rol_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `cod_usu` int NOT NULL AUTO_INCREMENT,
  `login` varchar(70) NOT NULL,
  `password` varchar(200) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `Sexo` varchar(10) NOT NULL,
  `celular` varchar(9) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`cod_usu`),
  KEY `id_rol_idx` (`id_rol`),
  CONSTRAINT `FK_rol` FOREIGN KEY (`id_rol`) REFERENCES `tb_rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'joseph15','$2a$10$j6RdjjWt/NDxjkHa.EzfB./C5OEm58rF5uiod42ziBJ1btXtYX4e6','Joseph','Tello','12345678','Masculino','987654321','Av. Heroes del alto cenepa #155',1),(2,'josue26','$2a$10$j6RdjjWt/NDxjkHa.EzfB./C5OEm58rF5uiod42ziBJ1btXtYX4e6','Josue','Chupica','87654321','Masculino','987654322','Av. Primavera #155',1),(3,'jenny48','$2a$10$j6RdjjWt/NDxjkHa.EzfB./C5OEm58rF5uiod42ziBJ1btXtYX4e6','Jenny','Narciso','12387456','Femenino','987654323','Av. Canta Callao #155',1),(4,'maria59','$2a$10$j6RdjjWt/NDxjkHa.EzfB./C5OEm58rF5uiod42ziBJ1btXtYX4e6','Maria','Dias','87654123','Femenino','987654324','Av. Circumbalacion #155',2),(5,'hugo24','$2a$10$j6RdjjWt/NDxjkHa.EzfB./C5OEm58rF5uiod42ziBJ1btXtYX4e6','Hugo','Caceres','45612378','Femenino','987654325','Av. Proceres #155',3);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_food_china'
--

--
-- Dumping routines for database 'bd_food_china'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17 11:43:33
