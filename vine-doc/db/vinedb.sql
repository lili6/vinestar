/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : vinedb

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2014-10-29 16:51:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for calendar_category
-- ----------------------------
DROP TABLE IF EXISTS `calendar_category`;
CREATE TABLE `calendar_category` (
  `seqno` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL COMMENT '日程分类',
  `userId` int(11) DEFAULT NULL,
  `showOrder` tinyint(4) DEFAULT '0' COMMENT '显示顺序 0:正顺',
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of calendar_category
-- ----------------------------

-- ----------------------------
-- Table structure for calendar_additive
-- ----------------------------
DROP TABLE IF EXISTS `calendar_additive`;
CREATE TABLE `calendar_additive` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `cmtUserId` int(11) DEFAULT NULL COMMENT '评论用户Id',
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
-- Records of calendar_comment
-- ----------------------------

-- ----------------------------
-- Table structure for calendar_info
-- ----------------------------
DROP TABLE IF EXISTS `calendar_info`;
CREATE TABLE `calendar_info` (
  `seqno` bigint(20) NOT NULL,
  `userId` int(11) DEFAULT NULL,
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
-- Records of calendar_info
-- ----------------------------

-- ----------------------------
-- Table structure for guest_info
-- ----------------------------
DROP TABLE IF EXISTS `guest_info`;
CREATE TABLE `guest_info` (
  `seqno` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guest_info
-- ----------------------------

-- ----------------------------
-- Table structure for guest_log
-- ----------------------------
DROP TABLE IF EXISTS `guest_log`;
CREATE TABLE `guest_log` (
  `seqno` int(11) NOT NULL,
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
  `enabled` int(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guest_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_acct
-- ----------------------------
DROP TABLE IF EXISTS `user_acct`;
CREATE TABLE `user_acct` (
  `seqno` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `bankCard` varchar(20) DEFAULT NULL,
  `bankName` varchar(30) DEFAULT NULL,
  `bankAddress` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(15) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(15) DEFAULT NULL,
  `enabled` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_acct
-- ----------------------------

-- ----------------------------
-- Table structure for user_company
-- ----------------------------
DROP TABLE IF EXISTS `user_company`;
CREATE TABLE `user_company` (
  `seqno` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(15) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(15) DEFAULT NULL,
  `enabled` int(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_company
-- ----------------------------

-- ----------------------------
-- Table structure for user_enroll
-- ----------------------------
DROP TABLE IF EXISTS `user_enroll`;
CREATE TABLE `user_enroll` (
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_enroll
-- ----------------------------
INSERT INTO `user_enroll` VALUES ('1', '0000010001', '13096936483', null, 'password002', '0000000000', '2014-10-27 17:23:53', '10001', '2014-10-27 17:23:53', '10001', '0');
INSERT INTO `user_enroll` VALUES ('2', '0000010002', '13096936482', null, 'password002', '0000000000', '2014-10-27 17:26:37', '10002', '2014-10-27 17:33:33', 'liguofang', '1');
INSERT INTO `user_enroll` VALUES ('3', '0000010002', '13096936482', null, 'password002', '0000000000', '2014-10-27 17:29:00', '10002', '2014-10-27 17:29:00', '10002', '0');
INSERT INTO `user_enroll` VALUES ('4', '0000010002', '13096936482', null, 'password002', '0000000000', '2014-10-27 17:30:08', '10002', '2014-10-27 17:30:08', '10002', '0');
INSERT INTO `user_enroll` VALUES ('5', '0000010002', '13096936482', null, 'password002', '0000000000', '2014-10-27 17:31:23', '10002', '2014-10-27 17:31:23', '10002', '0');
INSERT INTO `user_enroll` VALUES ('6', '0000010002', '13096936482', null, 'password002', '0000000000', '2014-10-27 17:32:24', '10002', '2014-10-27 17:32:24', '10002', '0');
INSERT INTO `user_enroll` VALUES ('7', '0000010002', '13096936482', null, 'password002', '0000000000', '2014-10-27 17:32:45', '10002', '2014-10-27 17:32:45', '10002', '0');
INSERT INTO `user_enroll` VALUES ('8', '0000000999', '13096936482', null, '000000', '0000000000', '2014-10-27 17:33:33', '10002', '2014-10-28 20:26:25', '999', '0');
INSERT INTO `user_enroll` VALUES ('9', '0000000004', '18511248226', '34793278@qq.com', '999999', '0000000000', '2014-10-28 19:47:51', 'admin', '2014-10-28 19:47:51', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('10', '0000000066', '18511248226', '34793278@qq.com', '000000', '0000000000', '2014-10-28 19:48:56', 'admin', '2014-10-28 20:37:48', '66', '0');
INSERT INTO `user_enroll` VALUES ('11', '0000000001', '525220466', '34793278@qq.com', '77826', '0000000000', '2014-10-28 19:49:41', 'admin', '2014-10-28 19:49:41', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('12', '0000000007', '957220269', '34793278@qq.com', '95100', '0000000000', '2014-10-28 20:26:17', 'admin', '2014-10-28 20:26:17', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('13', '0000000000', '542982556', '34793278@qq.com', '52905', '0000000000', '2014-10-28 20:35:45', 'admin', '2014-10-28 20:35:45', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('14', '0000000003', '1329442049', '34793278@qq.com', '000000', '0000000000', '2014-10-28 20:37:38', 'admin', '2014-10-28 20:43:49', '3', '0');
INSERT INTO `user_enroll` VALUES ('15', '0000000000', '711944418', '34793278@qq.com', '27473', '0000000000', '2014-10-28 20:43:29', 'admin', '2014-10-28 20:43:29', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('16', '0000000004', '565970059', '34793278@qq.com', '5520', '0000000000', '2014-10-28 20:43:49', 'admin', '2014-10-28 20:43:49', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('17', 'b08d96c9b6b64d73b2d9070e3ff147a8', '13096936482', null, '111111', '0000000000', '2014-10-29 12:26:55', 'admin', '2014-10-29 12:26:55', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('18', 'b2ccdd6975384a978700e161ce49d309', '13096936482', null, '111111', '0000000000', '2014-10-29 12:28:00', 'admin', '2014-10-29 12:28:00', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('19', 'ebdb98c0920042eb85f127ba8628c32f', '13096936482', null, '000000', '0000000000', '2014-10-29 13:56:20', 'admin', '2014-10-29 14:23:46', 'ebdb98c0920042eb85f127ba8628c32f', '0');
INSERT INTO `user_enroll` VALUES ('20', '980668346ffb4e879ccb6016e573889d', '13096936482', null, '111111', '0000000000', '2014-10-29 13:59:42', 'admin', '2014-10-29 13:59:42', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('21', '6d4120c9047f41f8a7517b7f81a4bb6e', '13096936482', null, '111111', '0000000000', '2014-10-29 14:00:52', 'admin', '2014-10-29 14:00:52', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('22', '2febfd90c6c54c9eb28538442950c433', '13096936482', null, '111111', '0000000000', '2014-10-29 14:03:05', 'admin', '2014-10-29 14:03:05', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('23', '2bad679239594369a9b2541f6ab26820', '991221826', '34793278@qq.com', '32886', '0000000000', '2014-10-29 14:12:23', 'admin', '2014-10-29 14:12:23', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('24', 'c21c3d193bd3440693fa1b3dfca5705b', '110412319', '34793278@qq.com', '9372', '0000000000', '2014-10-29 14:20:43', 'admin', '2014-10-29 14:20:43', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('25', '3b719c0388cc4432a432643d22a8ce81', '166243656', '34793278@qq.com', '55542', '0000000000', '2014-10-29 14:22:16', 'admin', '2014-10-29 14:22:16', 'admin', '0');
INSERT INTO `user_enroll` VALUES ('26', '2f852bc435184daba244230f4b31f0b2', '1727602123', '34793278@qq.com', '26895', '0000000000', '2014-10-29 14:23:47', 'admin', '2014-10-29 14:23:47', 'admin', '0');

-- ----------------------------
-- Table structure for user_files
-- ----------------------------
DROP TABLE IF EXISTS `user_files`;
CREATE TABLE `user_files` (
  `seqno` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
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
-- Records of user_files
-- ----------------------------

-- ----------------------------
-- Table structure for user_friend
-- ----------------------------
DROP TABLE IF EXISTS `user_friend`;
CREATE TABLE `user_friend` (
  `seqno` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `friendId` int(11) DEFAULT NULL COMMENT '好友Id',
  `relation` int(11) DEFAULT NULL COMMENT '关系',
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` int(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_friend
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `userId` int(11) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `nickName` varchar(255) DEFAULT NULL,
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
  `enabled` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_log
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `seqno` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` int(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_mail
-- ----------------------------
DROP TABLE IF EXISTS `user_mail`;
CREATE TABLE `user_mail` (
  `seqno` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `telephone` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postCode` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `enabled` int(1) DEFAULT NULL,
  PRIMARY KEY (`seqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_mail
-- ----------------------------

-- ----------------------------
-- Table structure for user_test
-- ----------------------------
DROP TABLE IF EXISTS `user_test`;
CREATE TABLE `user_test` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
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
