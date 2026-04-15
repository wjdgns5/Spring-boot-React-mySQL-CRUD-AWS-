-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demo_db
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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` varchar(3000) NOT NULL,
  `user_id` int NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_board_user` (`user_id`),
  CONSTRAINT `fk_board_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'ㄹㅇㄴㄹㅇㄴㄹㅇㄴ','ㄹㄴㅇㄹㄴㅇㄹ',4,'2026-04-15 15:11:41','2026-04-15 15:11:41'),(3,'ㄹㅈㄷㄹㄷㅈㄹㅈㄷㄹㅈㄷㄹ','ㄹㅇㄴㄹㄴㅇㄹㄴㅇ',4,'2026-04-15 15:11:54','2026-04-15 15:11:54'),(5,'테스트 제목 2','테스트 내용 2 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(6,'테스트 제목 3','테스트 내용 3 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(7,'테스트 제목 4','테스트 내용 4 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(8,'테스트 제목 5','테스트 내용 5 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(9,'테스트 제목 6','테스트 내용 6 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(10,'테스트 제목 7','테스트 내용 7 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(11,'테스트 제목 8','테스트 내용 8 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(12,'테스트 제목 9','테스트 내용 9 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(13,'테스트 제목 10','테스트 내용 10 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(14,'테스트 제목 11','테스트 내용 11 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(15,'테스트 제목 12','테스트 내용 12 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(16,'테스트 제목 13','테스트 내용 13 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(17,'테스트 제목 14','테스트 내용 14 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(18,'테스트 제목 15','테스트 내용 15 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(19,'테스트 제목 16','테스트 내용 16 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(20,'테스트 제목 17','테스트 내용 17 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(21,'테스트 제목 18','테스트 내용 18 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(22,'테스트 제목 19','테스트 내용 19 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(36,'테스트 제목 33','테스트 내용 33 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(37,'테스트 제목 34','테스트 내용 34 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(38,'테스트 제목 35','테스트 내용 35 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(39,'테스트 제목 36','테스트 내용 36 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(40,'테스트 제목 37','테스트 내용 37 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(41,'테스트 제목 38','테스트 내용 38 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(42,'테스트 제목 39','테스트 내용 39 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(43,'테스트 제목 40','테스트 내용 40 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(44,'테스트 제목 41','테스트 내용 41 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(45,'테스트 제목 42','테스트 내용 42 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(46,'테스트 제목 43','테스트 내용 43 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(47,'테스트 제목 44','테스트 내용 44 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(48,'테스트 제목 45','테스트 내용 45 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(49,'테스트 제목 46','테스트 내용 46 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(50,'테스트 제목 47','테스트 내용 47 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(51,'테스트 제목 48','테스트 내용 48 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(52,'테스트 제목 49','테스트 내용 49 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25'),(53,'테스트 제목 50','테스트 내용 50 - 작성자 user_id=4, username=kakao_4847528983',4,'2026-04-15 15:48:25','2026-04-15 15:48:25');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-15 16:09:59
