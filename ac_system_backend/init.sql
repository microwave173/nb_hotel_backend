-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ac_data
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `room_id` varchar(50) DEFAULT NULL,
  `log_type` varchar(50) DEFAULT NULL,
  `cost_rate` float DEFAULT NULL,
  `cost_sum` float DEFAULT NULL,
  `log_time` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
INSERT INTO `logs` VALUES ('1','turn on',0,0,'2024-12-04 23:09:01'),('1','update temperature',0.5,0.5,'2024-12-04 23:09:03'),('2','turn on',0,0,'2024-12-04 23:09:03'),('3','turn on',0,0,'2024-12-04 23:09:05'),('2','update temperature',0.5,1,'2024-12-04 23:09:07'),('4','turn on',0,0,'2024-12-04 23:09:07'),('5','turn on',0,0,'2024-12-04 23:09:07'),('3','update temperature',0.5,1,'2024-12-04 23:09:09'),('5','update mode',0,0,'2024-12-04 23:09:09'),('1','removed from serve queue',0,2,'2024-12-04 23:09:09'),('5','add to serve queue',0.5,0,'2024-12-04 23:09:09'),('2','removed from serve queue',0,1.5,'2024-12-04 23:09:10'),('4','add to serve queue',0.5,0,'2024-12-04 23:09:10'),('1','update mode',0,2,'2024-12-04 23:09:11'),('3','removed from serve queue',0,1.5,'2024-12-04 23:09:11'),('1','add to serve queue',0.5,2,'2024-12-04 23:09:11'),('4','removed from serve queue',0,1,'2024-12-04 23:09:14'),('2','add to serve queue',0.5,1.5,'2024-12-04 23:09:14'),('2','removed from serve queue',0,1.5,'2024-12-04 23:09:14'),('3','add to serve queue',0.5,1.5,'2024-12-04 23:09:14'),('5','update temperature',1,3,'2024-12-04 23:09:15'),('3','removed from serve queue',0,2.5,'2024-12-04 23:09:18'),('4','add to serve queue',0.5,1,'2024-12-04 23:09:18'),('4','removed from serve queue',0,1,'2024-12-04 23:09:18'),('2','add to serve queue',0.5,1.5,'2024-12-04 23:09:18'),('1','update temperature',1,6,'2024-12-04 23:09:19'),('4','update temperature',0,1,'2024-12-04 23:09:19'),('4','update mode',0,1,'2024-12-04 23:09:19'),('2','removed from serve queue',0,2,'2024-12-04 23:09:19'),('4','add to serve queue',0.5,1,'2024-12-04 23:09:19'),('5','update mode',1,7,'2024-12-04 23:09:23'),('5','removed from serve queue',0,7,'2024-12-04 23:09:23'),('3','add to serve queue',0.5,2.5,'2024-12-04 23:09:23'),('3','removed from serve queue',0,2.5,'2024-12-04 23:09:23'),('2','add to serve queue',0.5,2,'2024-12-04 23:09:23'),('2','update mode',0.5,2.5,'2024-12-04 23:09:25'),('1','turn off',1,11,'2024-12-04 23:09:29'),('3','update mode',0,2.5,'2024-12-04 23:09:29'),('5','turn off',0.5,8,'2024-12-04 23:09:33'),('3','update mode',0.333333,2.83333,'2024-12-04 23:09:35'),('1','turn on',0,111,'2024-12-04 23:09:37'),('4','update temperature',1,10,'2024-12-04 23:09:37'),('4','update mode',1,10,'2024-12-04 23:09:37'),('4','removed from serve queue',0,10.5,'2024-12-04 23:09:40'),('1','add to serve queue',0.5,111,'2024-12-04 23:09:40'),('2','update temperature',1,10.5,'2024-12-04 23:09:41'),('2','update mode',1,10.5,'2024-12-04 23:09:41'),('5','turn on',0,108,'2024-12-04 23:09:41'),('2','removed from serve queue',0,11,'2024-12-04 23:09:44'),('4','add to serve queue',0.5,10.5,'2024-12-04 23:09:44'),('1','removed from serve queue',0,112,'2024-12-04 23:09:44'),('5','add to serve queue',0.5,108,'2024-12-04 23:09:44'),('4','removed from serve queue',0,11.5,'2024-12-04 23:09:48'),('2','add to serve queue',0.5,11,'2024-12-04 23:09:48'),('5','removed from serve queue',0,109,'2024-12-04 23:09:48'),('1','add to serve queue',0.5,112,'2024-12-04 23:09:48'),('1','turn off',0.5,112.5,'2024-12-04 23:09:49'),('3','turn off',1,9.83333,'2024-12-04 23:09:49'),('5','turn off',0.5,109,'2024-12-04 23:09:49'),('2','turn off',0.5,12,'2024-12-04 23:09:51'),('4','turn off',0.5,12,'2024-12-04 23:09:51'),('3','update params',0,159.833,'2024-12-13 23:30:25');
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_id` varchar(50) NOT NULL,
  `du` float NOT NULL,
  `cur_temperature` float NOT NULL,
  `init_temperature` float NOT NULL,
  `tar_temperature` float NOT NULL,
  `ac_mode` int NOT NULL,
  `cost` float NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
INSERT INTO `room` VALUES ('1',12.5,10,10,22,1,212.5),('2',12,15,15,27,1,137),('3',9.83333,17.3333,18,27,2,159.833),('4',12,12,12,25,1,212),('5',9,14,14,22,1,209);
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `name` varchar(50) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(50) NOT NULL,
  `tag` varchar(50) DEFAULT NULL,
  `room_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('Jerry',3,'123123','customer','');
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-14 19:21:13
