/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : designrule

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2018-05-27 20:19:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for designdepartment
-- ----------------------------
DROP TABLE IF EXISTS `designdepartment`;
CREATE TABLE `designdepartment` (
  `id` int(11) NOT NULL,
  `mc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of designdepartment
-- ----------------------------
INSERT INTO `designdepartment` VALUES ('1', '梦之队设计部');
INSERT INTO `designdepartment` VALUES ('2', '天空蓝设计部');

-- ----------------------------
-- Table structure for sourcedepartment
-- ----------------------------
DROP TABLE IF EXISTS `sourcedepartment`;
CREATE TABLE `sourcedepartment` (
  `id` int(11) NOT NULL,
  `mc` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sourcedepartment
-- ----------------------------
INSERT INTO `sourcedepartment` VALUES ('1', '人才招聘小团队');
INSERT INTO `sourcedepartment` VALUES ('2', '人才收入杀手');

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` int(11) NOT NULL,
  `userid` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `groupid` int(11) NOT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `sysid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('1', 'admin', '管理员', '0', '123456', null);
INSERT INTO `sysuser` VALUES ('2', 'zk', '郑凯', '1', '123456', '1');
INSERT INTO `sysuser` VALUES ('3', 'sg', '帅哥', '1', '123456', '2');
INSERT INTO `sysuser` VALUES ('4', 'xm', '小明', '2', '123456', '1');
INSERT INTO `sysuser` VALUES ('5', 'lx', '刘星', '2', '123456', '2');
INSERT INTO `sysuser` VALUES ('6', 'mm', '妹妹', '3', '123465', '1');
INSERT INTO `sysuser` VALUES ('7', 'qq', '青青', '3', '123456', '2');

-- ----------------------------
-- Table structure for testdepartment
-- ----------------------------
DROP TABLE IF EXISTS `testdepartment`;
CREATE TABLE `testdepartment` (
  `id` int(11) NOT NULL,
  `mc` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testdepartment
-- ----------------------------
INSERT INTO `testdepartment` VALUES ('1', 'bug王测试部');
INSERT INTO `testdepartment` VALUES ('2', 'bug攻坚小队');
