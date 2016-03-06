/*
Navicat MySQL Data Transfer

Source Server         : luohang
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : jadexdb

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2016-01-05 20:41:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for eccontents
-- ----------------------------
DROP TABLE IF EXISTS `eccontents`;
CREATE TABLE `eccontents` (
  `id` int(11) NOT NULL auto_increment,
  `uuid` varchar(255) NOT NULL,
  `name` varchar(30) default NULL,
  `precursorId` varchar(255) default NULL,
  `hostId` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `hostId` (`hostId`),
  KEY `precursorId` (`precursorId`),
  CONSTRAINT `eccontents_ibfk_1` FOREIGN KEY (`hostId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 10240 kB; (`hostId`) REFER `jadexdb/user`(`id`)';

-- ----------------------------
-- Records of eccontents
-- ----------------------------
INSERT INTO `eccontents` VALUES ('6', '5411bcb2327e4e96b79c708436109fb1', 'sdf', '-1', '1');
INSERT INTO `eccontents` VALUES ('8', '71025e1a3f5d4efd88fb310d7dd349b1', 'dfg', '5411bcb2327e4e96b79c708436109fb1', '1');
INSERT INTO `eccontents` VALUES ('9', 'e6d1333189b84c73b4d18dc5a12bcf4c', 'vxc', '71025e1a3f5d4efd88fb310d7dd349b1', '1');
INSERT INTO `eccontents` VALUES ('10', '50a1ddcc0f614eb79b8ddfdcacd8fff3', '725', 'e6d1333189b84c73b4d18dc5a12bcf4c', '1');
INSERT INTO `eccontents` VALUES ('11', '050c606648ad4f83ae04f8f41496b6a0', 'rth', '71025e1a3f5d4efd88fb310d7dd349b1', '1');

-- ----------------------------
-- Table structure for ec_10
-- ----------------------------
DROP TABLE IF EXISTS `ec_10`;
CREATE TABLE `ec_10` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_10
-- ----------------------------
INSERT INTO `ec_10` VALUES ('1', '785', '7525', ' ');
INSERT INTO `ec_10` VALUES ('2', '7582', '58', ' ');
INSERT INTO `ec_10` VALUES ('3', '587', '7852', ' ');

-- ----------------------------
-- Table structure for ec_11
-- ----------------------------
DROP TABLE IF EXISTS `ec_11`;
CREATE TABLE `ec_11` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_11
-- ----------------------------
INSERT INTO `ec_11` VALUES ('1', 'dfg', 'hhrt', ' ');

-- ----------------------------
-- Table structure for ec_6
-- ----------------------------
DROP TABLE IF EXISTS `ec_6`;
CREATE TABLE `ec_6` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_6
-- ----------------------------
INSERT INTO `ec_6` VALUES ('1', 'sdf', 'sdf', ' ');

-- ----------------------------
-- Table structure for ec_8
-- ----------------------------
DROP TABLE IF EXISTS `ec_8`;
CREATE TABLE `ec_8` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_8
-- ----------------------------
INSERT INTO `ec_8` VALUES ('1', 'dfg', 'dfg', ' ');

-- ----------------------------
-- Table structure for ec_9
-- ----------------------------
DROP TABLE IF EXISTS `ec_9`;
CREATE TABLE `ec_9` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_9
-- ----------------------------
INSERT INTO `ec_9` VALUES ('1', 'df', 'dfg', ' ');
INSERT INTO `ec_9` VALUES ('2', 'dfg', 'dfg', ' ');

-- ----------------------------
-- Table structure for egcontents
-- ----------------------------
DROP TABLE IF EXISTS `egcontents`;
CREATE TABLE `egcontents` (
  `id` int(11) NOT NULL auto_increment,
  `uuid` varchar(255) NOT NULL,
  `name` varchar(30) default NULL,
  `precursorId` varchar(255) default NULL,
  `hostId` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `hostId` (`hostId`),
  KEY `precursorId` (`precursorId`),
  CONSTRAINT `egcontents_ibfk_1` FOREIGN KEY (`hostId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 10240 kB; (`hostId`) REFER `jadexdb/user`(`id`)';

-- ----------------------------
-- Records of egcontents
-- ----------------------------
INSERT INTO `egcontents` VALUES ('3', 'bec6c81091eb471ba75cfe9f2613259e', 'sdf', '-1', '1');
INSERT INTO `egcontents` VALUES ('4', 'e81d6c4ab14c49c68eab17891a06a4d3', 'gdsf', 'bec6c81091eb471ba75cfe9f2613259e', '1');
INSERT INTO `egcontents` VALUES ('5', '6fdb695aca084186abd020caae8e1116', 'fsddfs', 'e81d6c4ab14c49c68eab17891a06a4d3', '1');

-- ----------------------------
-- Table structure for eg_3
-- ----------------------------
DROP TABLE IF EXISTS `eg_3`;
CREATE TABLE `eg_3` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eg_3
-- ----------------------------
INSERT INTO `eg_3` VALUES ('1', 'sd', 'sd', ' ');

-- ----------------------------
-- Table structure for eg_4
-- ----------------------------
DROP TABLE IF EXISTS `eg_4`;
CREATE TABLE `eg_4` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eg_4
-- ----------------------------
INSERT INTO `eg_4` VALUES ('1', 'sdf', 'df', ' ');
INSERT INTO `eg_4` VALUES ('2', 'sdfs', 'sd', ' ');

-- ----------------------------
-- Table structure for eg_5
-- ----------------------------
DROP TABLE IF EXISTS `eg_5`;
CREATE TABLE `eg_5` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eg_5
-- ----------------------------
INSERT INTO `eg_5` VALUES ('1', 'sdf', 'sdf', ' ');

-- ----------------------------
-- Table structure for entity
-- ----------------------------
DROP TABLE IF EXISTS `entity`;
CREATE TABLE `entity` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `hostId` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of entity
-- ----------------------------

-- ----------------------------
-- Table structure for iteminfo
-- ----------------------------
DROP TABLE IF EXISTS `iteminfo`;
CREATE TABLE `iteminfo` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL default '0',
  `hostId` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iteminfo
-- ----------------------------
INSERT INTO `iteminfo` VALUES ('49', 'Shirt', '15', '4', '5');
INSERT INTO `iteminfo` VALUES ('50', 'Shoes', '55', '3', '5');
INSERT INTO `iteminfo` VALUES ('51', 'Pants', '75', '2', '5');
INSERT INTO `iteminfo` VALUES ('52', 'Meat', '2', '1', '5');
INSERT INTO `iteminfo` VALUES ('53', 'Cookies', '0', '2', '5');
INSERT INTO `iteminfo` VALUES ('64', 'Shirt', '15', '4', '-1');
INSERT INTO `iteminfo` VALUES ('65', 'Shoes', '55', '3', '-1');
INSERT INTO `iteminfo` VALUES ('66', 'Pants', '75', '2', '-1');
INSERT INTO `iteminfo` VALUES ('67', 'Meat', '2', '1', '-1');
INSERT INTO `iteminfo` VALUES ('68', 'Cookies', '0', '2', '-1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `password` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'luohang', '0');
