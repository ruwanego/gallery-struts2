-- --------------------------------------------------------
-- Host:                         192.168.1.108
-- Server version:               5.6.12 - Source distribution
-- Server OS:                    Linux
-- HeidiSQL Version:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for gallery
DROP DATABASE IF EXISTS `gallery`;
CREATE DATABASE IF NOT EXISTS `gallery` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gallery`;


-- Dumping structure for table gallery.album
DROP TABLE IF EXISTS `album`;
CREATE TABLE IF NOT EXISTS `album` (
  `id` int(10) NOT NULL,
  `type` varchar(50) NOT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `parent_type` varchar(50) DEFAULT NULL,
  `description` text NOT NULL,
  `slug` varchar(100) NOT NULL,
  PRIMARY KEY (`id`,`type`),
  KEY `FK2_album` (`type`),
  CONSTRAINT `FK1_album` FOREIGN KEY (`id`, `type`) REFERENCES `resource` (`id`, `type`),
  CONSTRAINT `FK2_album` FOREIGN KEY (`type`) REFERENCES `album_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.album_type
DROP TABLE IF EXISTS `album_type`;
CREATE TABLE IF NOT EXISTS `album_type` (
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`type`),
  CONSTRAINT `FK1_album_type` FOREIGN KEY (`type`) REFERENCES `resource_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.image
DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `id` int(10) NOT NULL,
  `type` varchar(50) NOT NULL,
  `album_id` int(10) NOT NULL,
  `album_type` varchar(50) NOT NULL,
  `image` mediumblob,
  `thumbnail` mediumblob,
  `slug` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`type`),
  KEY `FK2_image` (`type`),
  KEY `FK3_image` (`album_id`,`album_type`),
  CONSTRAINT `FK3_image` FOREIGN KEY (`album_id`, `album_type`) REFERENCES `album` (`id`, `type`),
  CONSTRAINT `FK1_image` FOREIGN KEY (`id`, `type`) REFERENCES `resource` (`id`, `type`),
  CONSTRAINT `FK2_image` FOREIGN KEY (`type`) REFERENCES `image_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.image_type
DROP TABLE IF EXISTS `image_type`;
CREATE TABLE IF NOT EXISTS `image_type` (
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`type`),
  CONSTRAINT `FK1_image_type` FOREIGN KEY (`type`) REFERENCES `resource_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.resource
DROP TABLE IF EXISTS `resource`;
CREATE TABLE IF NOT EXISTS `resource` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT NULL,
  `deleted` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`,`type`),
  UNIQUE KEY `type_name` (`type`,`name`),
  CONSTRAINT `FK1_resource` FOREIGN KEY (`type`) REFERENCES `resource_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.resource_type
DROP TABLE IF EXISTS `resource_type`;
CREATE TABLE IF NOT EXISTS `resource_type` (
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.tag
DROP TABLE IF EXISTS `tag`;
CREATE TABLE IF NOT EXISTS `tag` (
  `id` int(10) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`,`type`),
  KEY `FK2_tag` (`type`),
  CONSTRAINT `FK2_tag` FOREIGN KEY (`type`) REFERENCES `tag_type` (`type`),
  CONSTRAINT `FK1_tag` FOREIGN KEY (`id`, `type`) REFERENCES `resource` (`id`, `type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.tag_album
DROP TABLE IF EXISTS `tag_album`;
CREATE TABLE IF NOT EXISTS `tag_album` (
  `tag_id` int(10) NOT NULL,
  `tag_type` varchar(50) NOT NULL,
  `album_id` int(10) NOT NULL,
  `album_type` varchar(50) NOT NULL,
  PRIMARY KEY (`tag_id`,`tag_type`,`album_id`,`album_type`),
  KEY `FK2_tag_album` (`tag_type`),
  KEY `FK3_tag_album` (`album_id`,`album_type`),
  KEY `FK4_tag_album` (`album_type`),
  CONSTRAINT `FK1_tag_album` FOREIGN KEY (`tag_id`, `tag_type`) REFERENCES `tag` (`id`, `type`),
  CONSTRAINT `FK2_tag_album` FOREIGN KEY (`tag_type`) REFERENCES `tag_type` (`type`),
  CONSTRAINT `FK3_tag_album` FOREIGN KEY (`album_id`, `album_type`) REFERENCES `album` (`id`, `type`),
  CONSTRAINT `FK4_tag_album` FOREIGN KEY (`album_type`) REFERENCES `album_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.tag_image
DROP TABLE IF EXISTS `tag_image`;
CREATE TABLE IF NOT EXISTS `tag_image` (
  `tag_id` int(10) NOT NULL,
  `tag_type` varchar(50) NOT NULL,
  `image_id` int(10) NOT NULL,
  `image_type` varchar(50) NOT NULL,
  PRIMARY KEY (`tag_id`,`tag_type`,`image_id`,`image_type`),
  KEY `FK2_tag_image` (`tag_type`),
  KEY `FK3_tag_image` (`image_id`,`image_type`),
  KEY `FK4_tag_image` (`image_type`),
  CONSTRAINT `FK1_tag_image` FOREIGN KEY (`tag_id`, `tag_type`) REFERENCES `tag` (`id`, `type`),
  CONSTRAINT `FK2_tag_image` FOREIGN KEY (`tag_type`) REFERENCES `tag_type` (`type`),
  CONSTRAINT `FK3_tag_image` FOREIGN KEY (`image_id`, `image_type`) REFERENCES `image` (`id`, `type`),
  CONSTRAINT `FK4_tag_image` FOREIGN KEY (`image_type`) REFERENCES `image_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.tag_type
DROP TABLE IF EXISTS `tag_type`;
CREATE TABLE IF NOT EXISTS `tag_type` (
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`type`),
  CONSTRAINT `FK1_tag_type` FOREIGN KEY (`type`) REFERENCES `resource_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


show warnings;