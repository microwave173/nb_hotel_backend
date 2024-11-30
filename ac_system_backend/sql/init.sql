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
INSERT INTO `logs` VALUES ('1','turn on',0,0,'2024-11-29 22:50:10'),('1','update temperature',0.33333,0.33333,'2024-11-29 22:50:11'),('2','turn on',0,0,'2024-11-29 22:50:11'),('5','turn on',0,0,'2024-11-29 22:50:11'),('3','turn on',0,0,'2024-11-29 22:50:12'),('2','update temperature',0.33333,0.66666,'2024-11-29 22:50:13'),('4','turn on',0,0,'2024-11-29 22:50:13'),('1','removed from serve queue',0,1.33332,'2024-11-29 22:50:13'),('3','add to serve queue',0.33333,0,'2024-11-29 22:50:13'),('5','update temperature',0.33333,0.99999,'2024-11-29 22:50:14'),('2','removed from serve queue',0,1.33332,'2024-11-29 22:50:14'),('4','add to serve queue',0.33333,0,'2024-11-29 22:50:14'),('1','update mode',0,1.33332,'2024-11-29 22:50:15'),('5','removed from serve queue',0,1.33332,'2024-11-29 22:50:15'),('1','add to serve queue',0.33333,1.33332,'2024-11-29 22:50:15'),('2','turn off',0,1.33332,'2024-11-29 22:50:16'),('3','removed from serve queue',0,0.99999,'2024-11-29 22:50:16'),('5','add to serve queue',0.33333,1.33332,'2024-11-29 22:50:16'),('2','turn on',0,126.333,'2024-11-29 22:50:17'),('5','update mode',0.33333,1.33332,'2024-11-29 22:50:17'),('4','removed from serve queue',0,1.33332,'2024-11-29 22:50:18'),('3','add to serve queue',0.33333,0.99999,'2024-11-29 22:50:18'),('3','removed from serve queue',0,0.99999,'2024-11-29 22:50:18'),('2','add to serve queue',0.33333,126.333,'2024-11-29 22:50:18'),('1','update temperature',1,4.66665,'2024-11-29 22:50:19'),('4','update temperature',0,1.33332,'2024-11-29 22:50:19'),('4','update mode',0,1.33332,'2024-11-29 22:50:19'),('2','removed from serve queue',0,126.333,'2024-11-29 22:50:19'),('4','add to serve queue',0.33333,1.33332,'2024-11-29 22:50:19'),('2','update temperature',0,126.333,'2024-11-29 22:50:21'),('5','update mode',1,5.66665,'2024-11-29 22:50:22'),('5','removed from serve queue',0,5.66665,'2024-11-29 22:50:22'),('3','add to serve queue',0.33333,0.99999,'2024-11-29 22:50:22'),('3','removed from serve queue',0,0.99999,'2024-11-29 22:50:22'),('2','add to serve queue',0.33333,126.333,'2024-11-29 22:50:22'),('2','removed from serve queue',0,126.999,'2024-11-29 22:50:23'),('5','add to serve queue',0.33333,5.66665,'2024-11-29 22:50:23'),('5','removed from serve queue',0,5.66665,'2024-11-29 22:50:23'),('3','add to serve queue',0.33333,0.99999,'2024-11-29 22:50:23'),('1','turn off',1,9.66665,'2024-11-29 22:50:24'),('3','update temperature',0.33333,0.99999,'2024-11-29 22:50:24'),('3','update mode',0.33333,0.99999,'2024-11-29 22:50:24'),('5','update temperature',0,5.66665,'2024-11-29 22:50:25'),('5','update mode',0,5.66665,'2024-11-29 22:50:25'),('3','removed from serve queue',0,1.33332,'2024-11-29 22:50:25'),('5','add to serve queue',0.33333,5.66665,'2024-11-29 22:50:25'),('2','turn off',0,126.999,'2024-11-29 22:50:26'),('3','update mode',0,1.33332,'2024-11-29 22:50:27'),('4','removed from serve queue',0,8.66665,'2024-11-29 22:50:27'),('3','add to serve queue',0.33333,1.33332,'2024-11-29 22:50:27'),('1','turn on',0,109.667,'2024-11-29 22:50:28'),('1','removed from serve queue',0,109.667,'2024-11-29 22:50:28'),('4','add to serve queue',1,8.66665,'2024-11-29 22:50:28'),('4','update temperature',1,8.66665,'2024-11-29 22:50:28'),('4','update mode',1,8.66665,'2024-11-29 22:50:28'),('2','turn on',0,251.999,'2024-11-29 22:50:29'),('5','update temperature',1,9.99998,'2024-11-29 22:50:30'),('3','turn off',1,5.66665,'2024-11-29 22:50:32'),('5','turn off',1,13,'2024-11-29 22:50:33'),('1','turn off',0,109.667,'2024-11-29 22:50:34'),('2','turn off',0,251.999,'2024-11-29 22:50:35'),('4','turn off',0.5,12.6666,'2024-11-29 22:50:35');
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
  `cost` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
INSERT INTO `room` VALUES ('1',9.66665,22,22,16,0,209.667),('2',1.99998,23,23,16,0,376.999),('3',5.66665,24,24,24,2,155.667),('4',12.6666,21,21,20,1,212.667),('5',13,22,22,25,2,113);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('Jerry',3,'123123','customer');
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-30  0:34:23
