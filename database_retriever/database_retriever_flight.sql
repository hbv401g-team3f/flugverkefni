-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: database_retriever
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `flightNumber` varchar(45) NOT NULL,
  `price` double DEFAULT NULL,
  `departureDate` date NOT NULL,
  `departureTime` time DEFAULT NULL,
  `departureLoc` varchar(45) DEFAULT NULL,
  `depAirportId` varchar(3) DEFAULT NULL,
  `arrivalDate` date DEFAULT NULL,
  `arrivalTime` time DEFAULT NULL,
  `arrivalLoc` varchar(45) DEFAULT NULL,
  `arrAirportId` varchar(3) DEFAULT NULL,
  `numSeats` int(11) DEFAULT NULL,
  `bookedSeats` int(11) DEFAULT NULL,
  `numSagaSeats` int(11) DEFAULT NULL,
  `bookedSagaSeats` int(11) DEFAULT NULL,
  `isConnected` tinyint(4) DEFAULT NULL,
  `hasLuxuries` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`flightNumber`,`departureDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('FI300',70000,'2016-04-20','15:15:00','Iceland','KEF','2016-04-21','00:15:00','Casablanca','WTF',100,20,5,2,1,1),('KEK200',100000,'2016-04-20','15:00:00','Iceland','KEF','2016-04-20','19:00:00','Casablanca','WTF',150,30,10,5,0,1),('WW250',70000,'2016-04-30','00:12:00','Iceland','KEF','2003-04-20','00:15:00','London','LGW',50,50,10,10,0,0);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-11 22:50:49
