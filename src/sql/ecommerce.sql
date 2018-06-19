CREATE DATABASE  IF NOT EXISTS `ecommerce` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ecommerce`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id_customer` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `address` varchar(255) NOT NULL,
  `state` varchar(100) NOT NULL,
  `city` varchar(200) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoices` (
  `id_invoice` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_order` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id_invoice`),
  KEY `fk_invoice_order_idx` (`id_order`),
  CONSTRAINT `fk_invoice_order` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_items` (
  `id_ordem_item` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_order` bigint(20) NOT NULL,
  `id_product` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id_ordem_item`),
  KEY `fk_item_order_idx` (`id_order`),
  KEY `fk_item_product_idx` (`id_product`),
  CONSTRAINT `fk_item_order` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_product` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id_order` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_customer` bigint(20) NOT NULL,
  `customer_cpf` varchar(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `fk_customer_cpf_idx` (`customer_cpf`),
  KEY `fk_customer_id_idx` (`id_customer`),
  CONSTRAINT `fk_customer_id` FOREIGN KEY (`id_customer`) REFERENCES `customers` (`id_customer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payments` (
  `id_payment` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_order` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `amount` double NOT NULL,
  `credit_card_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id_payment`),
  KEY `fk_payment_order_idx` (`id_order`),
  CONSTRAINT `fk_payment_order` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_categories`
--

DROP TABLE IF EXISTS `product_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_categories` (
  `id_product_category` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_product_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id_product` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_category` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `stock_quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id_product`),
  KEY `fk_product_category_idx` (`id_category`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`id_category`) REFERENCES `product_categories` (`id_product_category`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stock_history_entries`
--

DROP TABLE IF EXISTS `stock_history_entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_history_entries` (
  `id_stock_history_entry` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_product` bigint(20) DEFAULT NULL,
  `date` datetime NOT NULL,
  `quantity` int(11) NOT NULL,
  `operation` int(11) NOT NULL,
  PRIMARY KEY (`id_stock_history_entry`),
  KEY `fk_stock_entry_product_idx` (`id_product`),
  CONSTRAINT `fk_stock_entry_product` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-18 21:51:38
