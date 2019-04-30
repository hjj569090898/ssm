/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : legi_db

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-04-30 17:52:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attence
-- ----------------------------
DROP TABLE IF EXISTS `attence`;
CREATE TABLE `attence` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `groups` varchar(255) DEFAULT NULL,
  `Mattence` int(3) DEFAULT NULL,
  `Rattence` int(3) DEFAULT NULL,
  `leave` double DEFAULT NULL,
  `outwork` double DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
