-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.17 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ccshoppingcart
DROP DATABASE IF EXISTS `ccshoppingcart`;
CREATE DATABASE IF NOT EXISTS `ccshoppingcart` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ccshoppingcart`;

-- Dumping structure for table ccshoppingcart.cart
DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '1',
  `product_id` int(11) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `status` enum('P','C') NOT NULL DEFAULT 'P',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table ccshoppingcart.cart: ~4 rows (approximately)
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` (`id`, `user_id`, `product_id`, `product_quantity`, `status`, `updated_on`) VALUES
	(1, 2, 1, 1, 'P', '2021-11-07 14:55:48'),
	(3, 1, 1, 3, 'C', '2021-11-07 15:05:22'),
	(4, 1, 1, 3, 'C', '2021-11-07 15:05:24'),
	(5, 1, 1, 3, 'C', '2021-11-07 15:05:25');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;

-- Dumping structure for table ccshoppingcart.product_inventory
DROP TABLE IF EXISTS `product_inventory`;
CREATE TABLE IF NOT EXISTS `product_inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) NOT NULL,
  `product_image` varchar(100) DEFAULT NULL,
  `product_description` text,
  `single_product_price` decimal(10,2) NOT NULL,
  `product_count` int(11) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) NOT NULL DEFAULT 'admin',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(50) NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table ccshoppingcart.product_inventory: ~3 rows (approximately)
/*!40000 ALTER TABLE `product_inventory` DISABLE KEYS */;
INSERT INTO `product_inventory` (`id`, `product_name`, `product_image`, `product_description`, `single_product_price`, `product_count`, `created_on`, `created_by`, `updated_on`, `updated_by`) VALUES
	(1, 'motog60', NULL, NULL, 5000.00, 10, '2021-11-01 15:20:55', 'admin', '2021-11-01 15:20:55', 'admin'),
	(2, 'redmi10', NULL, NULL, 7000.00, 50, '2021-11-01 15:21:26', 'admin', '2021-11-01 15:21:26', 'admin'),
	(3, 'nokia300', NULL, NULL, 9000.00, 30, '2021-11-01 15:21:52', 'admin', '2021-11-01 15:21:52', 'admin');
/*!40000 ALTER TABLE `product_inventory` ENABLE KEYS */;

-- Dumping structure for table ccshoppingcart.user_order
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE IF NOT EXISTS `user_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `order_id` varchar(100) NOT NULL,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` enum('S','F') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table ccshoppingcart.user_order: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_order` DISABLE KEYS */;
INSERT INTO `user_order` (`id`, `user_id`, `order_id`, `order_date`, `status`) VALUES
	(1, 1, '730e43ad-71d4-440a-88fd-87ce447da1a8', '2021-11-28 14:22:45', 'S');
/*!40000 ALTER TABLE `user_order` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
