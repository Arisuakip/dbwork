/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.26 : Database - managedb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`managedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `managedb`;

/*Table structure for table `equipinfo` */

DROP TABLE IF EXISTS `equipinfo`;

CREATE TABLE `equipinfo` (
  `e_id` int NOT NULL AUTO_INCREMENT,
  `e_name` varchar(15) NOT NULL,
  `e_count` int NOT NULL,
  `e_date` date DEFAULT NULL,
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `equipinfo` */

insert  into `equipinfo`(`e_id`,`e_name`,`e_count`,`e_date`) values 
(1,'书本A',2,'2021-12-12'),
(2,'书本002',2,'2017-07-03'),
(3,'瓶装药品001',2,'2019-05-24'),
(4,'瓶装药品002',9,'2021-05-07'),
(5,'实验仪器001',1,'2022-02-11'),
(6,'实验仪器002',1,'2013-05-03'),
(7,'打印机A',2,'2019-05-23'),
(8,'打印机B',2,'2019-05-03'),
(9,'设备A',1,'2017-05-09'),
(10,'设备B',1,'2019-08-18'),
(12,'投影仪',3,'2022-02-15');

/*Table structure for table `memberinfo` */

DROP TABLE IF EXISTS `memberinfo`;

CREATE TABLE `memberinfo` (
  `t_type` enum('学生','教师') NOT NULL,
  `t_id` varchar(10) NOT NULL,
  `t_name` varchar(15) NOT NULL,
  `t_sex` enum('男','女') NOT NULL,
  `t_phone` varchar(15) DEFAULT NULL,
  `t_teacherid` varchar(10) DEFAULT NULL,
  `t_level` enum('讲师','副教授','教授') DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  UNIQUE KEY `t_phone` (`t_phone`),
  KEY `fk` (`t_teacherid`),
  CONSTRAINT `fk` FOREIGN KEY (`t_teacherid`) REFERENCES `memberinfo` (`t_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `memberinfo` */

insert  into `memberinfo`(`t_type`,`t_id`,`t_name`,`t_sex`,`t_phone`,`t_teacherid`,`t_level`) values 
('教师','05001','教师AB','男','13212341234',NULL,'教授'),
('教师','05023','教师乙','男','13312542552',NULL,'教授'),
('教师','05051','教师丁','男','17512542544',NULL,'教授'),
('教师','05061','教师戊','男','13812324501',NULL,'副教授'),
('教师','05071','教师丙','女','14312542542',NULL,'副教授'),
('教师','05121','教师己','男','18954224042',NULL,'讲师'),
('学生','BX1905123','学生丁A','男','15242422452','05051',NULL),
('学生','SX1905147','学生己','女','13524578525','05001',NULL),
('学生','SX2105017','学生丙','男','15425420782','05071',NULL),
('学生','SZ1905024','学生戊','女','17325244525','05061',NULL),
('学生','SZ2005077','学生乙','男','15352785534','05001',NULL),
('学生','SZ2105011','学生甲','男','15208752412','05001',NULL),
('学生','SZ2105023','Tom','男','1954613132','05001',NULL),
('学生','SZ2105081','Bella','女','1982752727','05071',NULL);

/*Table structure for table `moneyinfo` */

DROP TABLE IF EXISTS `moneyinfo`;

CREATE TABLE `moneyinfo` (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `m_action` enum('减少','增加') DEFAULT NULL,
  `m_count` decimal(10,2) DEFAULT NULL,
  `m_date` date DEFAULT NULL,
  `m_userid` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `tm` (`m_userid`),
  CONSTRAINT `tm` FOREIGN KEY (`m_userid`) REFERENCES `memberinfo` (`t_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `moneyinfo` */

insert  into `moneyinfo`(`m_id`,`m_action`,`m_count`,`m_date`,`m_userid`) values 
(1,'减少',5200.00,'2020-02-22','05001'),
(2,'增加',7000.00,'2018-09-03','05071'),
(3,'减少',3000.00,'2019-07-07','SZ2105011'),
(4,'增加',7000.00,'2015-08-05','BX1905123'),
(5,'减少',10000.00,'2020-08-05','05061'),
(6,'增加',2200.00,'2017-08-07','05121'),
(7,'增加',15000.00,'2019-08-23','05121'),
(8,'减少',8800.00,'2021-07-08','SX1905147'),
(9,'增加',5500.00,'2021-05-30','05051'),
(10,'增加',4500.00,'2022-02-14','SZ2005077'),
(12,'增加',2200.00,'2022-02-16','05001'),
(13,'增加',22222.00,'2022-02-16','SZ2105023');

/*Table structure for table `recordinfo` */

DROP TABLE IF EXISTS `recordinfo`;

CREATE TABLE `recordinfo` (
  `r_rid` int NOT NULL AUTO_INCREMENT,
  `r_eid` int DEFAULT NULL,
  `r_tid` varchar(10) DEFAULT NULL,
  `r_date` date DEFAULT NULL,
  `r_remark` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`r_rid`),
  KEY `em` (`r_eid`),
  KEY `mt` (`r_tid`),
  CONSTRAINT `em` FOREIGN KEY (`r_eid`) REFERENCES `equipinfo` (`e_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `mt` FOREIGN KEY (`r_tid`) REFERENCES `memberinfo` (`t_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `recordinfo` */

insert  into `recordinfo`(`r_rid`,`r_eid`,`r_tid`,`r_date`,`r_remark`) values 
(1,1,'05061','2017-02-23','132123'),
(2,4,'SX1905147','2017-06-07',NULL),
(3,7,'BX1905123','2020-05-17','备注123'),
(4,5,'05121','2018-07-25','备注123'),
(5,8,'05001','2019-05-27',NULL),
(6,1,'SZ2005077','2021-02-23','无');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
