CREATE TABLE `c_social_comment` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
`topicId` int(11) NULL DEFAULT NULL,
`userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论用户Id',
`floor` int(11) NULL DEFAULT NULL COMMENT '评论楼层',
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
COMMENT='社交--话题评论表';

CREATE TABLE `c_social_favorite` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收藏Id',
`topicId` int(11) NULL DEFAULT NULL,
`userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被赞用户Id',
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
COMMENT='社交--话题评论表';

CREATE TABLE `c_social_letter` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'letterId',
`content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '私信内容',
`fromUid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送方',
`toUid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接受方',
`isRead` tinyint(1) NULL DEFAULT 0 COMMENT '是否已读，发送方也提示此消息已读 0:未，1：已读',
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
COMMENT='社交--话题评论表';

CREATE TABLE `c_social_notice` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'noticeId',
`noticeType` tinyint(4) NULL DEFAULT NULL COMMENT '通知类型(被赞，被评论，被转发,被@),都是与',
`userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户Id',
`topicId` int(11) NULL DEFAULT NULL COMMENT '话题ID',
`commentId` int(11) NULL DEFAULT NULL,
`praiseId` int(11) NULL DEFAULT NULL COMMENT '赞ID',
`isRead` tinyint(1) NULL DEFAULT 0 COMMENT '是否已读，发送方也提示此消息已读 0:未，1：已读',
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
COMMENT='社交--话题评论表';

CREATE TABLE `c_social_praise` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`topicId` int(11) NULL DEFAULT NULL,
`userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被赞用户Id',
`praiseUserId` int(11) NULL DEFAULT NULL COMMENT '点赞用户',
`isRead` tinyint(4) NULL DEFAULT NULL,
`realtionship` tinyint(4) NULL DEFAULT NULL COMMENT '好友关系',
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
COMMENT='社交--话题评论表';

CREATE TABLE `c_social_request` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'requestId',
`userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被赞用户Id',
`requestUserId` int(11) NULL DEFAULT NULL COMMENT '点赞用户',
`isRead` tinyint(1) NULL DEFAULT 0 COMMENT '是否已读，发送方也提示此消息已读 0:未，1：已读',
`isAgree` tinyint(4) NULL DEFAULT NULL COMMENT '是否同意',
`content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求内容',
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
COMMENT='社交--话题评论表';

CREATE TABLE `c_social_topic` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'topicid',
`title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题标题',
`content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
`thumbnail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略图Url',
`image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片URL',
`localImage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本地图片URL',
`userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id，发布话题者',
`visibleRange` tinyint(4) NULL DEFAULT NULL,
`praiseCount` int(11) NULL DEFAULT NULL COMMENT '赞数',
`commentCount` int(11) NULL DEFAULT NULL COMMENT '评论数',
`forwardCount` int(11) NULL DEFAULT NULL COMMENT '转发次数',
`favoriteCount` int(11) NULL DEFAULT NULL COMMENT '被收藏次数',
`status` tinyint(4) NULL DEFAULT NULL COMMENT '话题状态',
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT 0,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

CREATE TABLE `c_user_friend` (
`id` int(11) NOT NULL,
`userId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
`friendId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '好友Id',
`relationship` tinyint(4) NULL DEFAULT NULL COMMENT '关系',
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `c_user_info` (
`id` bigint(20) NOT NULL COMMENT 'infoId',
`userId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '与用户表对应',
`userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像url',
`sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
`idNo` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
`province` tinyint(4) NULL DEFAULT NULL,
`city` int(8) NULL DEFAULT NULL,
`county` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国家缩写',
`mailAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`postcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`favorite` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`createTime` datetime NULL DEFAULT NULL,
`creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`updateTime` datetime NULL DEFAULT NULL,
`updater` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`enabled` tinyint(1) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

