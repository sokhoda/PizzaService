CREATE DATABASE  IF NOT EXISTS `pizza` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pizza`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pizza
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL,
  `appNo` varchar(255) DEFAULT NULL,
  `buildingNo` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `strName` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `Cust_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgo99edubu6rcsnqbtj38dh204` (`Cust_ID`),
  CONSTRAINT `FKgo99edubu6rcsnqbtj38dh204` FOREIGN KEY (`Cust_ID`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheque`
--

DROP TABLE IF EXISTS `cheque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheque` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `totalSum` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque`
--

LOCK TABLES `cheque` WRITE;
/*!40000 ALTER TABLE `cheque` DISABLE KEYS */;
/*!40000 ALTER TABLE `cheque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerId` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `LoyalCard_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  KEY `FKimdowhusaf02j60kd3oegiswp` (`LoyalCard_ID`),
  CONSTRAINT `FKimdowhusaf02j60kd3oegiswp` FOREIGN KEY (`LoyalCard_ID`) REFERENCES `loyaltycard` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'john@bestcompany.com','John',NULL),(2,'marry@bestcompany.com','Marry',NULL),(3,'irene@bestcompany.com','Irene',NULL),(4,'mike@bestcompany.com','Mike Poland',NULL),(5,'steward@bestcompany.com','Steward',NULL),(6,'jeffry@bestcompany.com','Jeffry',NULL),(7,'alex@bestcompany.com','Alex',NULL),(8,'alan@bestcompany.com','Alan',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discountrecord`
--

DROP TABLE IF EXISTS `discountrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discountrecord` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sum` double DEFAULT NULL,
  `Cheque_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcs54ddicxxuglkcns7vhh6vmi` (`Cheque_ID`),
  CONSTRAINT `FKcs54ddicxxuglkcns7vhh6vmi` FOREIGN KEY (`Cheque_ID`) REFERENCES `cheque` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discountrecord`
--

LOCK TABLES `discountrecord` WRITE;
/*!40000 ALTER TABLE `discountrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `discountrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `id_gen`
--

DROP TABLE IF EXISTS `id_gen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `id_gen` (
  `GEN_KEY` varchar(255) NOT NULL,
  `GEN_VALUE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`GEN_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id_gen`
--

LOCK TABLES `id_gen` WRITE;
/*!40000 ALTER TABLE `id_gen` DISABLE KEYS */;
INSERT INTO `id_gen` VALUES ('CUSTOMER_ID',9),('PIZZA_ID',9);
/*!40000 ALTER TABLE `id_gen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loyaltycard`
--

DROP TABLE IF EXISTS `loyaltycard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loyaltycard` (
  `id` bigint(20) NOT NULL,
  `sum` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loyaltycard`
--

LOCK TABLES `loyaltycard` WRITE;
/*!40000 ALTER TABLE `loyaltycard` DISABLE KEYS */;
/*!40000 ALTER TABLE `loyaltycard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza` (
  `pizzaId` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pizzaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` VALUES (1,'Napoletano',100,'MEAT'),(2,'Hawaii',130,'SEA'),(3,'Country',129,'VEGETERIAN'),(4,'Mushroom',245,'VEGETERIAN'),(5,'Cheese',354,'VEGETERIAN'),(6,'calamari',454,'SEA'),(7,'DoubleCheese',453,'VEGETERIAN'),(8,'DoubleMushroom',200,'VEGETERIAN');
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_quant`
--

DROP TABLE IF EXISTS `pizza_quant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_quant` (
  `Ord_ID` bigint(20) NOT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `PIZZA_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`Ord_ID`,`PIZZA_ID`),
  KEY `FKpb3ao6h8b53ol0ep7my0ati5d` (`PIZZA_ID`),
  CONSTRAINT `FK4q84akwhv9ul7c6al4h3r9gd2` FOREIGN KEY (`Ord_ID`) REFERENCES `tb_order` (`id`),
  CONSTRAINT `FKpb3ao6h8b53ol0ep7my0ati5d` FOREIGN KEY (`PIZZA_ID`) REFERENCES `pizza` (`pizzaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_quant`
--

LOCK TABLES `pizza_quant` WRITE;
/*!40000 ALTER TABLE `pizza_quant` DISABLE KEYS */;
/*!40000 ALTER TABLE `pizza_quant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_order`
--

DROP TABLE IF EXISTS `tb_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL,
  `curState` varchar(255) DEFAULT NULL,
  `CHEQUE_ID` bigint(20) DEFAULT NULL,
  `CUST_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdhdkpgiinpxgafqe57p58s305` (`CHEQUE_ID`),
  KEY `FKhaljhbl5sqg9yt70blddck54x` (`CUST_ID`),
  CONSTRAINT `FKdhdkpgiinpxgafqe57p58s305` FOREIGN KEY (`CHEQUE_ID`) REFERENCES `cheque` (`id`),
  CONSTRAINT `FKhaljhbl5sqg9yt70blddck54x` FOREIGN KEY (`CUST_ID`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_order`
--

LOCK TABLES `tb_order` WRITE;
/*!40000 ALTER TABLE `tb_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pizza'
--

--
-- Dumping routines for database 'pizza'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-30  0:41:06
