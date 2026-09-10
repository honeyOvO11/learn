drop database if exists teaching;
create database  teaching;
use teaching;

CREATE TABLE `c` (
  `cno` char(4) NOT NULL,
  `cn` varchar(20) NOT NULL,
  `ct` int(11) DEFAULT NULL,
  PRIMARY KEY (`cno`)
) ;

LOCK TABLES `c` WRITE;

INSERT INTO `c` VALUES ('c1','Java程序设计',40),('c2','程序设计基础',48),('c3','线性代数',48),('c4','数据结构',64),('c5','数据库系统',56),('c6','数据挖掘',32),('c7','高等数学',60),('c8','控制理论',32);

UNLOCK TABLES;


DROP TABLE IF EXISTS `s`;

CREATE TABLE `s` (
  `sno` char(4) NOT NULL,
  `sn` varchar(20) NOT NULL,
  `sex` enum('男','女') DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `maj` varchar(20) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ;

LOCK TABLES `s` WRITE;

INSERT INTO `s` VALUES ('s1','王彤','女',18,'计算机','信息学院'),('s2','苏乐','女',20,'信息','信息学院'),('s3','林昕','男',19,'信息','信息学院'),('s4','陶然','女',18,'自动化','工学院'),('s5','魏文','男',17,'数学','理学院'),('s6','何欣荣','女',21,'计算机','信息学院'),('s7','赵琳琳','女',19,'数学','理学院'),('s8','李轩','男',19,'自动化','工学院');

UNLOCK TABLES;

DROP TABLE IF EXISTS `sc`;

CREATE TABLE `sc` (
  `sno` char(4) NOT NULL,
  `cno` char(4) NOT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`sno`,`cno`),
  KEY `cno` (`cno`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `s` (`sno`),
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`cno`) REFERENCES `c` (`cno`)
) ;

LOCK TABLES `sc` WRITE;

INSERT INTO `sc` VALUES ('s1','c1',90.5),('s1','c2',85),('s2','c4',70),('s2','c5',57),('s2','c6',81.5),('s2','c7',NULL),('s3','c1',75),('s3','c2',70.5),('s3','c4',85),('s4','c1',93),('s4','c2',85),('s4','c3',83),('s4','c6',NULL),('s5','c2',89),('s5','c7',60),('s7','c2',62),('s7','c5',80),('s7','c7',100),('s8','c3',96),('s8','c7',78.5);

UNLOCK TABLES;

DROP TABLE IF EXISTS `t`;

CREATE TABLE `t` (
  `tno` char(4) NOT NULL,
  `tn` varchar(20) NOT NULL,
  `sex` enum('男','女') DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `prof` varchar(20) DEFAULT NULL,
  `sal` decimal(10,2) DEFAULT NULL,
  `maj` varchar(20) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ;

LOCK TABLES `t` WRITE;

INSERT INTO `t` VALUES ('t1','刘杨','男',40,'教授',3610.50,'计算机','信息学院'),('t2','石丽','女',26,'讲师',2923.30,'信息','信息学院'),('t3','顾伟','男',32,'副教授',3134.00,'计算机','信息学院'),('t4','赵礼','女',50,'教授',4267.90,'自动化','工学院'),('t5','赵希希','女',36,'副教授',3332.67,'数学','理学院'),('t6','张刚','男',30,'讲师',3012.00,'自动化','工学院');

UNLOCK TABLES;

DROP TABLE IF EXISTS `tc`;

CREATE TABLE `tc` (
  `tno` char(4) NOT NULL,
  `cno` char(4) NOT NULL,
  `tcdate` date DEFAULT NULL,
  PRIMARY KEY (`tno`,`cno`),
  KEY `cno` (`cno`),
  CONSTRAINT `tc_ibfk_1` FOREIGN KEY (`tno`) REFERENCES `t` (`tno`),
  CONSTRAINT `tc_ibfk_2` FOREIGN KEY (`cno`) REFERENCES `c` (`cno`)
) ;

LOCK TABLES `tc` WRITE;

INSERT INTO `tc` VALUES ('t1','c1','2021-09-03'),('t1','c2','2021-09-04'),('t2','c5','2021-09-06'),('t2','c6','2021-09-10'),('t3','c2','2021-03-08'),('t3','c4','2021-03-06'),('t4','c3','2020-03-10'),('t5','c7','2020-03-09'),('t5','c8','2021-09-10');

UNLOCK TABLES;