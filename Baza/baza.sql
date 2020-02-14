/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.1.36-MariaDB : Database - seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `seminarski`;

/*Table structure for table `grad` */

DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `grad` */

insert  into `grad`(`id`,`naziv`) values 
(1,'Beograd'),
(2,'Novi Sad'),
(3,'Cacak'),
(4,'Subotica'),
(5,'Užice'),
(6,'Kruševac'),
(7,'Zrenjanin'),
(8,'Ivanjica'),
(9,'Šabac'),
(10,'Surdulica'),
(11,'Lucani'),
(12,'Backa Topola');

/*Table structure for table `igraci` */

DROP TABLE IF EXISTS `igraci`;

CREATE TABLE `igraci` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `pozicija` varchar(255) DEFAULT NULL,
  `br_dresa` varchar(255) DEFAULT NULL,
  `klub_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `klub_id` (`klub_id`),
  CONSTRAINT `igraci_ibfk_1` FOREIGN KEY (`klub_id`) REFERENCES `klubovi` (`klubID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `igraci` */

/*Table structure for table `klubovi` */

DROP TABLE IF EXISTS `klubovi`;

CREATE TABLE `klubovi` (
  `klubID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `godinaOsnivanja` int(11) DEFAULT NULL,
  `gradID` int(11) DEFAULT NULL,
  `popularnostID` int(11) DEFAULT NULL,
  PRIMARY KEY (`klubID`),
  KEY `gradID` (`gradID`),
  KEY `popularnostID` (`popularnostID`),
  CONSTRAINT `klubovi_ibfk_1` FOREIGN KEY (`gradID`) REFERENCES `grad` (`id`),
  CONSTRAINT `klubovi_ibfk_2` FOREIGN KEY (`popularnostID`) REFERENCES `popularnost` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `klubovi` */

insert  into `klubovi`(`klubID`,`naziv`,`godinaOsnivanja`,`gradID`,`popularnostID`) values 
(1,'Crvena Zvezda',1945,1,4),
(2,'Partizan',1945,1,4),
(3,'Cukaricki',1926,1,3),
(4,'Proleter',1947,7,2),
(5,'Mladost',1952,11,1),
(7,'Macva',1919,9,2),
(8,'Napredak',1946,6,2),
(9,'TSC',1913,12,1),
(10,'Zemun',1946,1,1),
(11,'FK Bezanija',1949,1,1),
(13,'OFK Beograd',1911,1,2);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `korisnickoIme` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



/*Table structure for table `popularnost` */

DROP TABLE IF EXISTS `popularnost`;

CREATE TABLE `popularnost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `popularnost` */

insert  into `popularnost`(`id`,`nivo`) values 
(1,'lokalna'),
(2,'gradska'),
(3,'regionalna'),
(4,'svetska');

/*Table structure for table `rezultati` */

DROP TABLE IF EXISTS `rezultati`;

CREATE TABLE `rezultati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domacin` varchar(255) DEFAULT NULL,
  `gost` varchar(255) DEFAULT NULL,
  `goloviDomacin` int(11) DEFAULT NULL,
  `goloviGost` int(11) DEFAULT NULL,
  `takmicenje` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rezultati` */

/*Table structure for table `statistike` */

DROP TABLE IF EXISTS `statistike`;

CREATE TABLE `statistike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `klub_id` int(11) DEFAULT NULL,
  `golovi` int(11) DEFAULT NULL,
  `faulovi` int(11) DEFAULT NULL,
  `zuti_kartoni` int(11) DEFAULT NULL,
  `pretrcani_kilometri` double DEFAULT NULL,
  `odbrane` int(11) DEFAULT NULL,
  `utakmica_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `klub_id` (`klub_id`),
  CONSTRAINT `statistike_ibfk_1` FOREIGN KEY (`klub_id`) REFERENCES `klubovi` (`klubID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `statistike` */

/*Table structure for table `takmicenja` */

DROP TABLE IF EXISTS `takmicenja`;

CREATE TABLE `takmicenja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `mesto` varchar(255) DEFAULT NULL,
  `pocetak` date DEFAULT NULL,
  `zavrsetak` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `takmicenja` */

insert  into `takmicenja`(`id`,`naziv`,`mesto`,`pocetak`,`zavrsetak`) values 
(1,'Kup Srbije','Beograd','2019-09-11','2020-05-23'),
(2,'Linglong Superliga','Srbija','2019-07-21','2020-04-04'),
(6,'2. Liga Srbije','Srbija','2019-07-22','2020-03-19');

/*Table structure for table `utakmice` */

DROP TABLE IF EXISTS `utakmice`;

CREATE TABLE `utakmice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `domacin` varchar(255) DEFAULT NULL,
  `gost` varchar(255) DEFAULT NULL,
  `rezultat_id` int(11) DEFAULT NULL,
  `takmicenje_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rezultat_id` (`rezultat_id`),
  KEY `takmicenje_id` (`takmicenje_id`),
  CONSTRAINT `utakmice_ibfk_1` FOREIGN KEY (`rezultat_id`) REFERENCES `rezultati` (`id`),
  CONSTRAINT `utakmice_ibfk_2` FOREIGN KEY (`takmicenje_id`) REFERENCES `takmicenja` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `utakmice` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
