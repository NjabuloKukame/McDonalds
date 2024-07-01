-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: mcdonalds
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `burger`
--

DROP TABLE IF EXISTS `burger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `burger` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(150) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burger`
--

LOCK TABLES `burger` WRITE;
/*!40000 ALTER TABLE `burger` DISABLE KEYS */;
INSERT INTO `burger` VALUES (1,'Big Tasty (burger only)',59.50),(2,'Big Tasty Meal (medium)',74.50),(3,'Big Tasty Meal (large)',84.50),(4,'Big Tasty Meal (extra large)',89.50),(5,'Big Mac (burger only)',31.00),(6,'Big Mac Meal (medium)',39.90),(7,'Big Mac Meal (large)',49.90),(8,'Big Mac Meal (extra large)',54.90),(9,'Quarter Pounder with Cheese (burger only)',42.00),(10,'Quarter Pounder with Cheese Meal (medium)',51.50),(11,'Quarter Pounder with Cheese Meal (large)',61.50),(12,'Quarter Pounder with Cheese Meal (extra large)',66.50),(13,'Double Quarter Pounder with Cheese (burger only)',47.50),(14,'Double Quarter Pounder with Cheese Meal (medium)',65.50),(15,'Double Quarter Pounder with Cheese Meal (large)',75.50),(16,'Double Quarter Pounder with Cheese Meal (extra large)',80.50),(17,'McFeast (burger only)',59.50),(18,'McFeast Meal (medium)',73.50),(19,'McFeast Meal (large)',83.50),(20,'McFeast Meal (extra large)',88.50),(21,'McRoyale (burger only)',42.00),(22,'McRoyale Meal (medium)',55.00),(23,'McRoyale Meal (large)',65.00),(24,'McRoyale Meal (extra large)',70.00),(25,'Hamburger (burger only)',16.50),(26,'Cheeseburger (burger only)',19.00),(27,'Cheeseburger Meal (medium)',35.00),(28,'Cheeseburger Meal (large)',45.00),(29,'Cheeseburger Meal (extra large)',50.00),(30,'Double Cheeseburger (burger only)',29.00),(31,'Grand Chicken (burger only)',46.00),(32,'Grand Chicken Meal (medium)',60.50),(33,'Grand Chicken Meal (large)',70.50),(34,'Grand Chicken Meal (extra large)',75.70),(35,'Chicken Burger (burger only)',18.50),(36,'Double Chicken Burger (burger only)',26.50),(37,'McChicken (burger only)',28.00),(38,'McChicken Meal (medium)',34.90),(39,'McChicken Meal (large)',44.90),(40,'McChicken Meal (extra large)',49.90),(41,'Filet-O-Fish (burger only)',29.00),(42,'Filet-O-Fish Meal (medium)',47.50),(43,'Filet-O-Fish Meal (large)',57.50),(44,'Filet-O-Fish Meal (extra large)',62.50),(45,'Veggie Burger (burger only)',23.50),(46,'Veggie Burger Meal (medium)',43.50),(47,'Veggie Burger Meal (large)',53.50),(48,'Veggie Burger Meal (extra large)',58.50),(49,'Single Jalapeno Burger (burger only)',18.50),(50,'Single Jalapeno Burger Meal (small)',27.50),(51,'Double Jalapeno Burger (burger only)',23.00),(52,'Double Jalapeno Burger Meal (medium)',34.90),(53,'Single Boerie Burger (burger only)',19.50),(54,'Single Boerie Burger Meal (small)',27.50),(55,'Double Boerie Burger (burger only)',23.00),(56,'Double Boerie Burger Meal (medium)',34.90),(57,'Double BBQ Burger (burger only)',23.00),(58,'Double BBQ Burger Meal (medium)',39.90),(59,'None',0.00);
/*!40000 ALTER TABLE `burger` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-01 10:02:37
