/*
Navicat MySQL Data Transfer

Source Server         : luohang
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : jadexdb

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2016-01-16 16:52:57
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eccontents
-- ----------------------------
INSERT INTO `eccontents` VALUES ('1', 'bed634c5e8304681a7d75a2968c486d3', 'kluk', '-1', '1');
INSERT INTO `eccontents` VALUES ('2', 'bb01ad5d82da44dd908307cd9517f7b2', 'ytu', 'bed634c5e8304681a7d75a2968c486d3', '1');
INSERT INTO `eccontents` VALUES ('3', '07dea608b1764450b4bfe0f6c186c582', 'liol', 'bb01ad5d82da44dd908307cd9517f7b2', '1');
INSERT INTO `eccontents` VALUES ('4', '99b3746308fc420986fbd9c0a64468ea', 'gfbt', 'bb01ad5d82da44dd908307cd9517f7b2', '1');
INSERT INTO `eccontents` VALUES ('5', '9ae277d00534490ca841f80ef0340502', 'hgyjuil', 'bed634c5e8304681a7d75a2968c486d3', '1');

-- ----------------------------
-- Table structure for ec_1
-- ----------------------------
DROP TABLE IF EXISTS `ec_1`;
CREATE TABLE `ec_1` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_1
-- ----------------------------
INSERT INTO `ec_1` VALUES ('1', 'uik', 'hjk', ' ');
INSERT INTO `ec_1` VALUES ('2', 'hjk', 'hjk', ' ');

-- ----------------------------
-- Table structure for ec_2
-- ----------------------------
DROP TABLE IF EXISTS `ec_2`;
CREATE TABLE `ec_2` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_2
-- ----------------------------
INSERT INTO `ec_2` VALUES ('1', 'ui', '7o8', ' ');
INSERT INTO `ec_2` VALUES ('2', 'tyu', 'o78', ' ');
INSERT INTO `ec_2` VALUES ('3', '78o8', '78io', ' ');

-- ----------------------------
-- Table structure for ec_3
-- ----------------------------
DROP TABLE IF EXISTS `ec_3`;
CREATE TABLE `ec_3` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_3
-- ----------------------------
INSERT INTO `ec_3` VALUES ('1', 'uuj', 'yuk', ' ');
INSERT INTO `ec_3` VALUES ('2', '.io.', 'kuyk', ' ');
INSERT INTO `ec_3` VALUES ('3', 'ghjtyj', 'kuy', ' ');

-- ----------------------------
-- Table structure for ec_4
-- ----------------------------
DROP TABLE IF EXISTS `ec_4`;
CREATE TABLE `ec_4` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_4
-- ----------------------------
INSERT INTO `ec_4` VALUES ('1', 'trger', 'tgbhtr', ' ');
INSERT INTO `ec_4` VALUES ('2', 'erg', 'erg', ' ');
INSERT INTO `ec_4` VALUES ('3', 'gf', 'eh', ' ');

-- ----------------------------
-- Table structure for ec_5
-- ----------------------------
DROP TABLE IF EXISTS `ec_5`;
CREATE TABLE `ec_5` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_5
-- ----------------------------
INSERT INTO `ec_5` VALUES ('1', 'kyu', 'hjk', ' ');
INSERT INTO `ec_5` VALUES ('2', 'jh', 'hjk', ' ');

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
INSERT INTO `egcontents` VALUES ('6', 'bec68cd8fa4540bfbfbd9a8e0850d615', 'fhg', 'e81d6c4ab14c49c68eab17891a06a4d3', '1');
INSERT INTO `egcontents` VALUES ('7', 'aa31200f3d354f03878677700cb2c30e', 'ghjkliul', 'bec68cd8fa4540bfbfbd9a8e0850d615', '1');
INSERT INTO `egcontents` VALUES ('8', '96abb894db7945a6b311b93a0fc3f301', 'llllll', 'e81d6c4ab14c49c68eab17891a06a4d3', '1');

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
-- Table structure for eg_6
-- ----------------------------
DROP TABLE IF EXISTS `eg_6`;
CREATE TABLE `eg_6` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eg_6
-- ----------------------------
INSERT INTO `eg_6` VALUES ('1', 'hjk', 'hjk', ' ');

-- ----------------------------
-- Table structure for eg_7
-- ----------------------------
DROP TABLE IF EXISTS `eg_7`;
CREATE TABLE `eg_7` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eg_7
-- ----------------------------
INSERT INTO `eg_7` VALUES ('1', 'uil', 'uli', ' ');
INSERT INTO `eg_7` VALUES ('2', 'uli', 'iul', ' ');

-- ----------------------------
-- Table structure for eg_8
-- ----------------------------
DROP TABLE IF EXISTS `eg_8`;
CREATE TABLE `eg_8` (
  `id` int(11) NOT NULL auto_increment,
  `C` varchar(30) NOT NULL,
  `V` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eg_8
-- ----------------------------
INSERT INTO `eg_8` VALUES ('1', 'jy', 'jy', ' ');
INSERT INTO `eg_8` VALUES ('2', 'tyk', 'ghj', ' ');
INSERT INTO `eg_8` VALUES ('3', 'jyt', 'hgj', ' ');

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
