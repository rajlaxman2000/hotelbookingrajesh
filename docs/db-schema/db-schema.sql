/*
SQLyog Community Edition- MySQL GUI v6.07
Host - 5.0.45-community-nt : Database - hostellatestGeetha
*********************************************************************
Server version : 5.0.45-community-nt
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `hostellatestGeetha`;

USE `hostellatestGeetha`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `bed` */

DROP TABLE IF EXISTS `bed`;

CREATE TABLE `bed` (
  `bed_id` int(11) NOT NULL auto_increment,
  `bed_name` varchar(45) default NULL,
  `room_id` int(11) default NULL,
  PRIMARY KEY  (`bed_id`),
  KEY `room_id_idx` (`room_id`),
  CONSTRAINT `room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Table structure for table `bed_cost` */

DROP TABLE IF EXISTS `bed_cost`;

CREATE TABLE `bed_cost` (
  `bed_id` int(11) NOT NULL,
  `date_range1` date default NULL,
  `date_range2` date default NULL,
  `bed_cost` decimal(10,0) default NULL,
  KEY `bed_id_idx` (`bed_id`),
  CONSTRAINT `bed_id` FOREIGN KEY (`bed_id`) REFERENCES `bed` (`bed_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` bigint(20) NOT NULL auto_increment,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(20) default NULL,
  `email` varchar(20) default NULL,
  `cc_number` varchar(45) default NULL,
  `expiration_date` varchar(20) default NULL,
  `security_code` varchar(10) default NULL,
  `phone` varchar(20) default NULL,
  PRIMARY KEY  (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Table structure for table `hostel` */

DROP TABLE IF EXISTS `hostel`;

CREATE TABLE `hostel` (
  `hostel_id` int(11) NOT NULL auto_increment,
  `hostel_name` varchar(45) default NULL,
  `hostel_street` varchar(30) NOT NULL,
  `hostel_city` varchar(20) default NULL,
  `hostel_state` varchar(20) default NULL,
  `hostel_postal_code` int(20) default NULL,
  `hostel_country` varchar(45) default NULL,
  `hostel_phone` varchar(20) default NULL,
  `hostel_email` varchar(40) default NULL,
  `hostel_facebook` varchar(40) default NULL,
  `hostel_web` varchar(30) default NULL,
  `hostel_checkIn_time` varchar(11) default NULL,
  `hostel_checkOut_time` varchar(11) default NULL,
  `smoking` varchar(4) default NULL,
  `alcohol` varchar(4) default NULL,
  `cancellation_hours_limit` int(11) default NULL,
  `cancellation_fee_percant` int(11) default NULL,
  `created_date` date default NULL,
  PRIMARY KEY  (`hostel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Table structure for table `order_bed` */

DROP TABLE IF EXISTS `order_bed`;

CREATE TABLE `order_bed` (
  `order_bed_id` int(11) NOT NULL auto_increment,
  `order_id` int(11) NOT NULL,
  `bed_id` int(11) NOT NULL,
  `start_date` datetime default NULL,
  `end_date` datetime default NULL,
  PRIMARY KEY  (`order_bed_id`),
  KEY `order_id_idx` (`order_id`),
  KEY `bed_id_idx` (`bed_id`),
  CONSTRAINT `bed_id_1` FOREIGN KEY (`bed_id`) REFERENCES `bed` (`bed_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL auto_increment,
  `customer_id` bigint(20) NOT NULL,
  `hostel_id` int(11) NOT NULL,
  `order_cost` decimal(4,2) default '0.00',
  `order_cancel_amt` decimal(4,2) default '0.00',
  `order_cancel_date` datetime default NULL,
  `order_placed_date` datetime default NULL,
  `order_start_date` datetime default NULL,
  `order_end_date` datetime default NULL,
  `active` varchar(4) default NULL,
  PRIMARY KEY  (`order_id`),
  KEY `customer_id_idx` (`customer_id`),
  KEY `hostel_id_idx` (`hostel_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hostel_id` FOREIGN KEY (`hostel_id`) REFERENCES `hostel` (`hostel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL auto_increment,
  `room_name` varchar(45) default NULL,
  `hostel_id` int(11) NOT NULL,
  PRIMARY KEY  (`room_id`),
  KEY `hostel_id_idx` (`hostel_id`),
  CONSTRAINT `hostel_room_idx` FOREIGN KEY (`hostel_id`) REFERENCES `hostel` (`hostel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
