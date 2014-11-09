/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : vinedb

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2014-11-07 19:12:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_access_log
-- ----------------------------
DROP TABLE IF EXISTS `c_access_log`;
CREATE TABLE `c_access_log` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL COMMENT '登录令牌',
  `expiresIn` bigint(20) DEFAULT NULL COMMENT '超时时间',
  `versionCode` varchar(128) DEFAULT NULL COMMENT '应用版本',
  `macId` varchar(50) DEFAULT NULL COMMENT 'mac地址',
  `ip` varchar(15) DEFAULT NULL COMMENT '登录IP',
  `deviceSystem` varchar(128) DEFAULT NULL COMMENT '操作系统版本',
  `deviceName` varchar(128) DEFAULT NULL COMMENT '设备名称',
  `deviceBrand` varchar(50) DEFAULT NULL COMMENT '设备厂商',
  `deviceType` varchar(50) DEFAULT NULL COMMENT '机型',
  `networkType` varchar(50) DEFAULT NULL COMMENT '网络类型',
  `operator` varchar(128) DEFAULT NULL COMMENT '运营商',
  `area` varchar(50) DEFAULT NULL COMMENT '登录地区名称',
  `country` varchar(50) DEFAULT NULL COMMENT '登录国家名称',
  `channelId` varchar(50) DEFAULT NULL COMMENT '渠道号',
  `prisonBreak` tinyint(4) DEFAULT '0' COMMENT '是否越狱0未越狱1越狱',
  `serverId` varchar(50) DEFAULT NULL COMMENT '服务器号',
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_access_log
-- ----------------------------

-- ----------------------------
-- Table structure for c_calendar_category
-- ----------------------------
DROP TABLE IF EXISTS `c_calendar_category`;
CREATE TABLE `c_calendar_category` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryId` bigint(20) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL COMMENT '日程分类',
  `userId` varchar(50) DEFAULT NULL,
  `showOrder` tinyint(4) DEFAULT '0' COMMENT '显示顺序 0:正顺',
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_calendar_category
-- ----------------------------

-- ----------------------------
-- Table structure for c_calendar_comment
-- ----------------------------
DROP TABLE IF EXISTS `c_calendar_comment`;
CREATE TABLE `c_calendar_comment` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `cmtUserId` varchar(50) DEFAULT NULL COMMENT '评论用户Id',
  `comment` text,
  `calTitle` varchar(255) DEFAULT NULL,
  `calDesc` varchar(255) DEFAULT NULL,
  `calPic` varchar(255) DEFAULT NULL COMMENT '拍照',
  `calAudio` varchar(255) DEFAULT NULL COMMENT '音频',
  `calVideo` varchar(255) DEFAULT NULL COMMENT '视频',
  `longitude` decimal(10,7) DEFAULT NULL,
  `latitude` decimal(10,7) DEFAULT NULL,
  `locality` varchar(128) DEFAULT NULL COMMENT '位置',
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of c_calendar_comment
-- ----------------------------

-- ----------------------------
-- Table structure for c_calendar_info
-- ----------------------------
DROP TABLE IF EXISTS `c_calendar_info`;
CREATE TABLE `c_calendar_info` (
  `seqno` bigint(20) NOT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `calTitle` varchar(255) DEFAULT NULL,
  `calDesc` varchar(255) DEFAULT NULL,
  `calPic` varchar(255) DEFAULT NULL COMMENT '拍照',
  `calAudio` varchar(255) DEFAULT NULL COMMENT '音频',
  `calVideo` varchar(255) DEFAULT NULL COMMENT '视频',
  `priority` varchar(255) DEFAULT NULL,
  `alterEnabled` varchar(255) DEFAULT NULL,
  `endEnabled` varchar(255) DEFAULT NULL,
  `alterTime` datetime DEFAULT NULL,
  `alterForward` varchar(255) DEFAULT NULL COMMENT '提前提醒',
  `longitude` decimal(10,7) DEFAULT NULL,
  `latitude` decimal(10,7) DEFAULT NULL,
  `locality` varchar(128) DEFAULT NULL COMMENT '位置',
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_calendar_info
-- ----------------------------

-- ----------------------------
-- Table structure for c_guest_info
-- ----------------------------
DROP TABLE IF EXISTS `c_guest_info`;
CREATE TABLE `c_guest_info` (
  `seqno` bigint(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_guest_info
-- ----------------------------

-- ----------------------------
-- Table structure for c_guest_log
-- ----------------------------
DROP TABLE IF EXISTS `c_guest_log`;
CREATE TABLE `c_guest_log` (
  `seqno` bigint(20) NOT NULL,
  `guestId` int(11) DEFAULT NULL,
  `macId` varchar(20) DEFAULT NULL,
  `deviceNo` int(11) DEFAULT NULL,
  `deviceName` varchar(20) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updator` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_guest_log
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_access
-- ----------------------------
DROP TABLE IF EXISTS `c_user_access`;
CREATE TABLE `c_user_access` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `token` varchar(255) NOT NULL COMMENT '登录令牌',
  `expiresIn` bigint(20) DEFAULT NULL COMMENT '超时时间',
  `versionCode` varchar(128) DEFAULT NULL COMMENT '应用版本',
  `macId` varchar(50) DEFAULT NULL COMMENT 'mac地址',
  `ip` varchar(15) DEFAULT NULL COMMENT '登录IP',
  `deviceSystem` varchar(128) DEFAULT NULL COMMENT '操作系统版本',
  `deviceName` varchar(128) DEFAULT NULL COMMENT '设备名称',
  `deviceBrand` varchar(50) DEFAULT NULL COMMENT '设备厂商',
  `deviceType` varchar(50) DEFAULT NULL COMMENT '机型',
  `networkType` varchar(50) DEFAULT NULL COMMENT '网络类型',
  `operator` varchar(128) DEFAULT NULL COMMENT '运营商',
  `area` varchar(50) DEFAULT NULL COMMENT '登录地区名称',
  `country` varchar(50) DEFAULT NULL COMMENT '登录国家名称',
  `channelId` varchar(50) DEFAULT NULL COMMENT '渠道号',
  `prisonBreak` tinyint(4) DEFAULT '0' COMMENT '是否越狱0未越狱1越狱',
  `serverId` varchar(50) DEFAULT NULL COMMENT '服务器号',
  `enabled` tinyint(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户访问记录';

-- ----------------------------
-- Records of c_user_access
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_acct
-- ----------------------------
DROP TABLE IF EXISTS `c_user_acct`;
CREATE TABLE `c_user_acct` (
  `seqno` bigint(20) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `bankCard` varchar(20) DEFAULT NULL,
  `bankName` varchar(30) DEFAULT NULL,
  `bankAddress` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(15) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(15) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_acct
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_company
-- ----------------------------
DROP TABLE IF EXISTS `c_user_company`;
CREATE TABLE `c_user_company` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(15) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(15) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_company
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_enroll
-- ----------------------------
DROP TABLE IF EXISTS `c_user_enroll`;
CREATE TABLE `c_user_enroll` (
  `seqno` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增序列号',
  `userId` varchar(50) DEFAULT NULL COMMENT '用户ID，系统中唯一编号，有一定的生成规则',
  `mobileNo` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `password` varchar(20) DEFAULT NULL COMMENT '登陆密码',
  `status` int(10) unsigned zerofill DEFAULT '0000000000' COMMENT '注册状态 0:注册未验证，1：注册已验证，2：已注销',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新者',
  `enabled` tinyint(1) unsigned DEFAULT '0' COMMENT '是否逻辑删除 0：未删除，有效，1:已删除',
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_enroll
-- ----------------------------
INSERT INTO `c_user_enroll` VALUES ('27', 'a3dac8b36cb34a248e3bf3c63e89536a', '13096936482', null, '111111', '0000000000', '2014-11-05 10:12:06', 'admin', '2014-11-05 10:12:06', 'admin', '0');
INSERT INTO `c_user_enroll` VALUES ('28', '71c7e2d8c3a74674bcdd70bd5402b103', '13096936483', null, '111111', '0000000000', '2014-11-05 10:13:58', 'admin', '2014-11-05 10:13:58', 'admin', '0');
INSERT INTO `c_user_enroll` VALUES ('29', 'fd6bf611183c426abf9aae6842f08a22', '', 'chengfei@qq.com', '96646', '0000000000', '2014-11-05 10:55:01', 'admin', '2014-11-05 10:55:01', 'admin', '0');
INSERT INTO `c_user_enroll` VALUES ('30', '67cb796f61794f76a2751f9a3fd88545', '123', '', '74142', '0000000000', '2014-11-05 11:16:20', 'admin', '2014-11-05 11:16:20', 'admin', '0');
INSERT INTO `c_user_enroll` VALUES ('31', '1395a32f387f4d3d94f2e2d898394f37', '13096936484', '', '11864', '0000000000', '2014-11-05 15:40:09', 'admin', '2014-11-05 15:40:09', 'admin', '0');
INSERT INTO `c_user_enroll` VALUES ('32', '9c2abd33554a44ada3def609b55570f3', '', 'guofang@qq.com', '98335', '0000000000', '2014-11-05 15:42:21', 'admin', '2014-11-05 15:42:21', 'admin', '0');
INSERT INTO `c_user_enroll` VALUES ('33', '131be08e0f344502ab42e8727e99844c', '13096936485', '', '99350', '0000000000', '2014-11-05 18:33:23', 'admin', '2014-11-05 18:33:23', 'admin', '0');

-- ----------------------------
-- Table structure for c_user_files
-- ----------------------------
DROP TABLE IF EXISTS `c_user_files`;
CREATE TABLE `c_user_files` (
  `seqno` bigint(20) NOT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL COMMENT '文件显示名称',
  `fileName` varchar(20) DEFAULT NULL COMMENT '物理名称',
  `abstract` text COMMENT '摘要描述',
  `fileUrl` varchar(50) DEFAULT NULL COMMENT '文件地址',
  `fileType` int(8) DEFAULT NULL COMMENT '文件类型，1代表文本\r\n2代表HTML \r\n            3代表Pdf\r\n            4代表Doc\r\n            5代表图像\r\n            6代表视频\r\n            7代表音频',
  `fileSize` bigint(255) DEFAULT NULL COMMENT '文件大小,存储单位B',
  `fileImageUrl` varchar(50) DEFAULT NULL COMMENT '文件图标地址',
  `keyword` varchar(128) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(15) DEFAULT NULL COMMENT '创建者',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(15) DEFAULT NULL COMMENT '更新',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否逻辑删除',
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_files
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_friend
-- ----------------------------
DROP TABLE IF EXISTS `c_user_friend`;
CREATE TABLE `c_user_friend` (
  `seqno` bigint(20) NOT NULL,
  `userId` varchar(50) DEFAULT NULL COMMENT '用户id',
  `friendId` varchar(50) DEFAULT NULL COMMENT '好友Id',
  `relation` int(11) DEFAULT NULL COMMENT '关系',
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_friend
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_info
-- ----------------------------
DROP TABLE IF EXISTS `c_user_info`;
CREATE TABLE `c_user_info` (
  `seqno` bigint(20) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `idNo` int(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `mailAddress` varchar(255) DEFAULT NULL,
  `postCode` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `favorite` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_log
-- ----------------------------
DROP TABLE IF EXISTS `c_user_log`;
CREATE TABLE `c_user_log` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_log
-- ----------------------------

-- ----------------------------
-- Table structure for c_user_mail
-- ----------------------------
DROP TABLE IF EXISTS `c_user_mail`;
CREATE TABLE `c_user_mail` (
  `seqno` bigint(20) NOT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `telephone` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postCode` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user_mail
-- ----------------------------

-- ----------------------------
-- Table structure for user_test
-- ----------------------------
DROP TABLE IF EXISTS `user_test`;
CREATE TABLE `user_test` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_test
-- ----------------------------
INSERT INTO `user_test` VALUES ('1', null, 'liguoang', 'no', '2014-10-27 16:52:43', null, null);
INSERT INTO `user_test` VALUES ('3', null, 'Jasmin', '123456', '2014-10-27 16:58:56', null, null);
INSERT INTO `user_test` VALUES ('4', null, 'Jasmin', '123456', '2014-10-27 17:00:33', '2014-10-27 17:00:33', null);
INSERT INTO `user_test` VALUES ('5', null, 'Jasmin', '123456', '2014-10-28 12:36:30', '2014-10-28 12:36:30', null);
INSERT INTO `user_test` VALUES ('6', null, 'Jasmin', '123456', '2014-10-28 13:35:31', '2014-10-28 13:35:31', null);
INSERT INTO `user_test` VALUES ('7', null, 'Jasmin', '123456', '2014-10-28 13:46:35', '2014-10-28 13:46:35', null);
INSERT INTO `user_test` VALUES ('8', null, 'lily', '000000', '2014-10-29 10:28:48', '2014-10-29 10:28:48', null);
INSERT INTO `user_test` VALUES ('9', null, 'lily', '000000', '2014-10-29 10:46:26', '2014-10-29 10:46:26', '测试插入数据返回主键功能');
INSERT INTO `user_test` VALUES ('10', null, 'lily', '000000', '2014-10-29 10:52:31', '2014-10-29 10:52:31', '测试插入数据返回主键功能');
INSERT INTO `user_test` VALUES ('99', null, 'lily', '000000', '2014-10-29 11:02:48', '2014-10-29 11:02:48', '测试插入数据返回主键功能');
INSERT INTO `user_test` VALUES ('100', '174a52e7-f675-4002-ae65-ce54b6f99ceb', 'liguofang', '000000', '2014-10-29 11:16:27', '2014-10-29 11:16:27', '测试插入数据返回主键功能');
INSERT INTO `user_test` VALUES ('101', 'a0a1a31901974af190db672baf8f4e47', 'liguofang', '000000', '2014-10-29 11:33:36', '2014-10-29 11:33:36', '测试插入数据返回主键功能');
