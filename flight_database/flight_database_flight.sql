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
  `hasLuxuries` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`flightNumber`,`departureDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('FI300',70000,'2016-04-20','15:15:00','Iceland','KEF','2016-04-21','00:15:00','Casablanca','WTF',100,37,5,9,1,1),('KEK200',100000,'2016-04-20','15:00:00','Iceland','KEF','2016-04-20','19:00:00','Casablanca','WTF',150,30,10,5,0,1),('NY100',14544,'2016-04-21','14:15:00','Akureyri','AEY','2016-04-21','14:55:00','Isafjordur','IFJ',70,18,0,0,0,1),('NY108',10532,'2016-04-22','08:15:00','Akureyri','AEY','2016-04-22','08:55:00','Egilsstadir','EGS',70,34,5,1,0,1),('NY112',10679,'2016-04-21','18:15:00','Akureyri','AEY','2016-04-21','18:55:00','Reykjavik','REK',70,23,0,0,0,1),('NY120',11817,'2016-04-21','16:15:00','Akureyri','AEY','2016-04-21','16:55:00','Isafjordur','IFJ',70,9,0,0,0,1),('NY129',13254,'2016-04-22','12:15:00','Isafjordur','IFJ','2016-04-22','12:55:00','Egilsstadir','EGS',70,13,5,2,0,1),('NY133',14999,'2016-04-20','06:15:00','Reykjavik','REK','2016-04-20','06:55:00','Akureyri','AEY',70,46,0,0,0,1),('NY137',14552,'2016-04-21','06:15:00','Egilstadir','EGS','2016-04-21','06:55:00','Reykjavik','REK',70,34,0,0,0,1),('NY141',13685,'2016-04-22','20:15:00','Isafjordur','IFJ','2016-04-22','20:55:00','Akureyri','AEY',70,11,5,2,1,1),('NY147',12025,'2016-04-23','18:15:00','Reykjavik','REK','2016-04-23','18:55:00','Akureyri','AEY',70,48,5,3,1,1),('NY156',14021,'2016-04-22','16:15:00','Isafjordur','IFJ','2016-04-22','16:55:00','Reykjavik','REK',70,17,5,5,1,1),('NY178',13126,'2016-04-23','16:15:00','Reykjavik','REK','2016-04-23','16:55:00','Akureyri','AEY',70,45,5,5,1,1),('NY179',10251,'2016-04-23','20:30:00','Reykjavik','REK','2016-04-23','21:10:00','Egilsstadir','EGS',70,26,5,2,1,1),('NY182',10631,'2016-04-20','08:15:00','Reykjavik','REK','2016-04-20','08:55:00','Akureyri','AEY',70,1,0,0,0,1),('NY187',10639,'2016-04-23','12:15:00','Reykjavik','REK','2016-04-23','12:55:00','Isafjordur','IFJ',70,43,5,0,1,1),('NY190',11658,'2016-04-20','16:15:00','Egilstadir','EGS','2016-04-20','16:55:00','Reykjavik','REK',70,45,0,0,0,1),('NY196',10427,'2016-04-20','10:15:00','Reykjavik','REK','2016-04-20','10:55:00','Akureyri','AEY',70,5,0,0,0,1),('NY199',10743,'2016-04-22','10:15:00','Akureyri','AEY','2016-04-22','10:55:00','Egilsstadir','EGS',70,40,5,2,0,1),('NY208',10156,'2016-04-22','06:15:00','Akureyri','AEY','2016-04-22','06:55:00','Reykjavik','REK',70,20,5,0,0,1),('NY227',13624,'2016-04-20','18:15:00','Egilstadir','EGS','2016-04-20','18:55:00','Reykjavik','REK',70,15,0,0,0,1),('NY229',12109,'2016-04-20','12:15:00','Reykjavik','REK','2016-04-20','12:55:00','Egilsstadir','EGS',70,8,0,0,0,1),('NY229',10142,'2016-04-21','12:15:00','Egilstadir','EGS','2016-04-21','12:55:00','Akureyri','AEY',70,15,0,0,0,1),('NY231',11919,'2016-04-23','20:15:00','Reykjavik','REK','2016-04-23','20:55:00','Egilsstadir','EGS',70,50,5,4,1,1),('NY242',13401,'2016-04-23','10:15:00','Reykjavik','REK','2016-04-23','10:55:00','Isafjordur','IFJ',70,7,5,3,1,1),('NY243',11177,'2016-04-21','10:15:00','Egilstadir','EGS','2016-04-21','10:55:00','Isafjordur','IFJ',70,19,0,0,0,1),('NY250',13846,'2016-04-23','06:15:00','Isafjordur','IFJ','2016-04-23','06:55:00','Akureyri','AEY',70,41,5,2,1,1),('NY269',14900,'2016-04-20','14:15:00','Reykjavik','REK','2016-04-20','14:55:00','Isafjordur','IFJ',70,16,0,0,0,1),('NY279',13295,'2016-04-23','14:15:00','Reykjavik','REK','2016-04-23','14:55:00','Kulusuk','KUL',70,39,5,1,1,1),('NY285',11443,'2016-04-23','08:15:00','Isafjordur','IFJ','2016-04-23','08:55:00','Akureyri','AEY',70,31,5,4,1,1),('NY291',13725,'2016-04-22','18:15:00','Isafjordur','IFJ','2016-04-22','18:55:00','Reykjavik','REK',70,1,5,0,1,1),('NY296',10930,'2016-04-22','14:15:00','Isafjordur','IFJ','2016-04-22','14:55:00','Reykjavik','REK',70,1,5,0,0,1),('NY297',10503,'2016-04-21','08:15:00','Egilstadir','EGS','2016-04-21','08:55:00','Isafjordur','IFJ',70,25,0,0,0,1),('WW250',70000,'2016-04-30','00:12:00','Iceland','KEF','2003-04-20','00:15:00','London','LGW',50,50,10,10,0,0);
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

-- Dump completed on 2016-04-16 17:08:36
