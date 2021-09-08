/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.28-log : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mybatis`;

/*Table structure for table `tbl_dept` */

DROP TABLE IF EXISTS `tbl_dept`;

CREATE TABLE `tbl_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tbl_dept` */

insert  into `tbl_dept`(`id`,`dept_name`) values (1,'开发部'),(2,'测试部');

/*Table structure for table `tbl_employee` */

DROP TABLE IF EXISTS `tbl_employee`;

CREATE TABLE `tbl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `d_id` (`d_id`),
  CONSTRAINT `d_id` FOREIGN KEY (`d_id`) REFERENCES `tbl_dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tbl_employee` */

insert  into `tbl_employee`(`id`,`last_name`,`gender`,`email`,`d_id`) values (1,'tom','1','123@test.com',1),(2,'jerry','0','134@test.com',2),(3,'mary','1','mary@atguigu.com',1),(7,'pink','0','mary@atguigu.com',2),(8,'pink1','1','pink1@test.com',1),(9,'pink2','0','pink2@test.com',2),(10,'pink3','1','pink3@test.com',1),(11,'pink1','1','pink1@test.com',1),(12,'pink2','0','pink2@test.com',2),(13,'pink3','1','pink3@test.com',1),(14,'pink1','1','pink1@test.com',1),(15,'pink2','0','pink2@test.com',2),(16,'pink3','1','pink3@test.com',1),(17,'pink1','1','pink1@test.com',1),(18,'pink2','0','pink2@test.com',2),(19,'pink3','1','pink3@test.com',1),(20,'pink1','1','pink1@test.com',1),(21,'pink2','0','pink2@test.com',2),(22,'pink3','1','pink3@test.com',1),(23,'pink1','1','pink1@test.com',1),(24,'pink2','0','pink2@test.com',2),(25,'pink3','1','pink3@test.com',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
