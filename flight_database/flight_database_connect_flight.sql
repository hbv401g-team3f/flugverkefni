-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: flight_database
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
-- Table structure for table `connect_flight`
--

DROP TABLE IF EXISTS `connect_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connect_flight` (
  `flightNumber` varchar(45) NOT NULL,
  `departureDate` date NOT NULL,
  `connLoc` varchar(45) DEFAULT NULL,
  `connArrivalTime` time DEFAULT NULL,
  `connAirportId` varchar(3) DEFAULT NULL,
  `connDepartTime` time DEFAULT NULL,
  PRIMARY KEY (`flightNumber`,`departureDate`),
  CONSTRAINT `foreignKeyTwo` FOREIGN KEY (`flightNumber`, `departureDate`) REFERENCES `flight` (`flightNumber`, `departureDate`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connect_flight`
--

LOCK TABLES `connect_flight` WRITE;
/*!40000 ALTER TABLE `connect_flight` DISABLE KEYS */;
INSERT INTO `connect_flight` VALUES ('FI300','2016-04-20','Gothenburg','17:15:00','GOT','17:45:00'),('NY141','2016-04-22','Reykjavik','21:00:00','REK','21:15:00'),('NY147','2016-04-23','Isafjordur','19:00:00','IFJ','19:15:00'),('NY156','2016-04-22','Akureyri','17:00:00','AEY','17:15:00'),('NY178','2016-04-23','Isafjordur','17:00:00','IFJ','17:15:00'),('NY179','2016-04-23','Akureyri','21:00:00','AEY','21:15:00'),('NY187','2016-04-23','Akureyri','13:00:00','AEY','13:15:00'),('NY231','2016-04-23','Akureyri','21:00:00','AEY','21:15:00'),('NY242','2016-04-23','Akureyri','11:00:00','AEY','11:15:00'),('NY250','2016-04-23','Reykjavik','07:00:00','REK','07:15:00'),('NY279','2016-04-23','Akureyri','15:00:00','AEY','15:15:00'),('NY285','2016-04-23','Reykjavik','09:00:00','REK','09:15:00'),('NY291','2016-04-22','Akureyri','19:00:00','AEY','19:15:00');
/*!40000 ALTER TABLE `connect_flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-16 18:57:31
