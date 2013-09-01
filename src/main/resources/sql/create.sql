-- --------------------------------------------------------
-- Host:                         192.168.1.108
-- Server version:               5.6.12 - Source distribution
-- Server OS:                    Linux
-- HeidiSQL Version:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for gallery
DROP DATABASE IF EXISTS `gallery`;
CREATE DATABASE IF NOT EXISTS `gallery` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gallery`;


-- Dumping structure for table gallery.album
DROP TABLE IF EXISTS `album`;
CREATE TABLE IF NOT EXISTS `album` (
  `album_id`          INT(10)     NOT NULL,
  `album_type`        VARCHAR(50) NOT NULL,
  `album_description` TEXT        NOT NULL,
  `album_slug`        VARCHAR(50) NOT NULL,
  `album_parent_id`   INT(10) DEFAULT NULL,
  `album_parent_type` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`album_id`, `album_type`),
  UNIQUE KEY `album_slug` (`album_slug`),
  KEY `FK2_album_parent` (`album_parent_id`, `album_parent_type`),
  CONSTRAINT `FK1_album_resource` FOREIGN KEY (`album_id`, `album_type`) REFERENCES `resource` (`resource_id`, `resource_type`),
  CONSTRAINT `FK2_album_parent` FOREIGN KEY (`album_parent_id`, `album_parent_type`) REFERENCES `album` (`album_id`, `album_type`)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.image
DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `image_id`           INT(10)     NOT NULL,
  `image_type`         VARCHAR(50) NOT NULL,
  `image_description`  TEXT        NOT NULL,
  `image_slug`         VARCHAR(50) NOT NULL,
  `image_content_type` VARCHAR(50) NOT NULL,
  `image_content`      MEDIUMBLOB  NOT NULL,
  `image_thumbnail`    MEDIUMBLOB  NOT NULL,
  `image_album_id`     INT(10)     NOT NULL,
  `image_album_type`   VARCHAR(50) NOT NULL,
  PRIMARY KEY (`image_id`, `image_type`),
  UNIQUE KEY `image_slug` (`image_slug`),
  KEY `FK2_image_album` (`image_album_id`, `image_album_type`),
  CONSTRAINT `FK1_image_resource` FOREIGN KEY (`image_id`, `image_type`) REFERENCES `resource` (`resource_id`, `resource_type`),
  CONSTRAINT `FK2_image_album` FOREIGN KEY (`image_album_id`, `image_album_type`) REFERENCES `album` (`album_id`, `album_type`)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.resource
DROP TABLE IF EXISTS `resource`;
CREATE TABLE IF NOT EXISTS `resource` (
  `resource_id`      INT(10)     NOT NULL AUTO_INCREMENT,
  `resource_type`    VARCHAR(50) NOT NULL,
  `resource_name`    VARCHAR(50) NOT NULL,
  `resource_created` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `resource_updated` TIMESTAMP   NULL DEFAULT NULL,
  `resource_deleted` TIMESTAMP   NULL DEFAULT NULL,
  PRIMARY KEY (`resource_id`, `resource_type`),
  UNIQUE KEY `resource_type_resource_name` (`resource_type`, `resource_name`)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

-- Data exporting was unselected.


-- Dumping structure for table gallery.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id`       INT(10)     NOT NULL,
  `user_type`     VARCHAR(50) NOT NULL,
  `user_login`    VARCHAR(50) NOT NULL,
  `user_password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`user_id`, `user_type`),
  UNIQUE KEY `user_login` (`user_login`),
  CONSTRAINT `FK1_user_resource` FOREIGN KEY (`user_id`, `user_type`) REFERENCES `resource` (`resource_id`, `resource_type`)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
