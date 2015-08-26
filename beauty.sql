/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : beauty

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-08-24 22:22:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `beauty_authority`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_authority`;
CREATE TABLE `beauty_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(100) NOT NULL DEFAULT '',
  `group_id` bigint(20) NOT NULL DEFAULT '0',
  `type` tinyint(4) NOT NULL DEFAULT '2' COMMENT '区分菜单权限与资源权限，1：菜单  2：资源',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， 0：无效',
  `def1` varchar(50) NOT NULL DEFAULT '',
  `def2` varchar(50) NOT NULL DEFAULT '',
  `def3` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of beauty_authority
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_authority_resource`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_authority_resource`;
CREATE TABLE `beauty_authority_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority_id` bigint(20) NOT NULL COMMENT '权限id',
  `resource_id` bigint(20) NOT NULL COMMENT '菜单/资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个权限可以对应多个菜单或资源';

-- ----------------------------
-- Records of beauty_authority_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_menu`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_menu`;
CREATE TABLE `beauty_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(100) NOT NULL DEFAULT '',
  `url` varchar(200) NOT NULL DEFAULT '',
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `level` tinyint(4) NOT NULL DEFAULT '0',
  `group_id` bigint(20) NOT NULL DEFAULT '0',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， 0：无效',
  `def1` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单中的role',
  `def2` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单中的class',
  `def3` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code_uqe` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of beauty_menu
-- ----------------------------
INSERT INTO `beauty_menu` VALUES ('1', 'MAIN_PAGE', '主页', '#', '0', '0', '0', '主页', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', 'current', 'fa-home', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('2', 'SYS-M', '系统管理', '#', '0', '0', '0', '系统管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', 'fa-laptop', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('3', 'EMP-M', '员工管理', '#', '0', '0', '0', '员工管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', 'fa-user', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('4', 'VIP-M', '会员管理', '#', '0', '0', '0', '会员管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', 'fa-users', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('5', 'CHK-M', '考勤管理', '#', '0', '0', '0', '考勤管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', 'fa-calendar', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('6', 'PRT-M', '货品管理', '#', '0', '0', '0', '货品管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', 'fa-truck', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('7', 'SET-M', '设置管理', '#', '0', '0', '0', '设置管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', 'fa-wrench', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('8', 'MSG-M', '消息管理', '#', '0', '0', '0', '消息管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('15', 'SYS-M-MENU-M', '菜单管理', '/pages/bracket/sys/menu-list.jsp', '2', '0', '0', '菜单管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('16', 'SET-M-CONF-S', '表格配置', '/pages/bracket/sys/sys-table-list.jsp', '7', '0', '0', '表格配置', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('17', 'SET-M-CONF-M', '配置管理', '/pages/bracket/sys/table-config-list.jsp', '7', '0', '0', '配置管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for `beauty_resource`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_resource`;
CREATE TABLE `beauty_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(100) NOT NULL DEFAULT '',
  `url` varchar(200) NOT NULL DEFAULT '',
  `group_id` bigint(20) NOT NULL DEFAULT '0',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， 0：无效',
  `def1` varchar(50) NOT NULL DEFAULT '',
  `def2` varchar(50) NOT NULL DEFAULT '',
  `def3` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Records of beauty_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_role`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_role`;
CREATE TABLE `beauty_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(100) NOT NULL DEFAULT '',
  `group_id` bigint(20) NOT NULL DEFAULT '0',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， 0：无效',
  `def1` varchar(50) NOT NULL DEFAULT '',
  `def2` varchar(50) NOT NULL DEFAULT '',
  `def3` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of beauty_role
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_role_authority`;
CREATE TABLE `beauty_role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `authority_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个角色可以拥有多个权限';

-- ----------------------------
-- Records of beauty_role_authority
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_table_class`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_table_class`;
CREATE TABLE `beauty_table_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表名',
  `class_path` varchar(200) NOT NULL DEFAULT '' COMMENT '类全路径',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表与类对应关系表';

-- ----------------------------
-- Records of beauty_table_class
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_table_config`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_table_config`;
CREATE TABLE `beauty_table_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `table_name` varchar(50) NOT NULL DEFAULT '' COMMENT '表名',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '表头',
  `data` varchar(50) NOT NULL DEFAULT '' COMMENT '类属性名（页面展示使用）',
  `column_name` varchar(50) NOT NULL DEFAULT '' COMMENT '对应列名',
  `orderable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否排序，1 是  -1否',
  `width` int(11) NOT NULL DEFAULT '1' COMMENT '宽',
  `class_name` varchar(50) NOT NULL DEFAULT '' COMMENT '类名，样式',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '列显示顺序',
  `render` varchar(500) NOT NULL DEFAULT '',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， -1：无效',
  `def1` varchar(50) NOT NULL DEFAULT '',
  `def2` varchar(50) NOT NULL DEFAULT '',
  `def3` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  KEY `idx_table_name_uqe` (`table_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8 COMMENT='配置表头与列对应关系表';

-- ----------------------------
-- Records of beauty_table_config
-- ----------------------------
INSERT INTO `beauty_table_config` VALUES ('1', 'BEAUTY_MENU', '菜单名称', 'name', 'name', '1', '150', '', '1', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('3', 'BEAUTY_MENU', '菜单编码', 'code', 'code', '1', '200', '', '2', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('4', 'BEAUTY_MENU', '菜单备注', 'remark', 'remark', '1', '200', '', '3', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('5', 'TABLES', '表名称', 'tableName', 'table_name', '1', '200', '', '1', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('6', 'TABLES', '表描述', 'tableComment', 'table_comment', '1', '400', '', '2', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('7', 'COLUMNS', '列名称', 'columnName', 'column_name', '1', '150', '', '2', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('8', 'COLUMNS', '列类型', 'columnType', 'column_type', '1', '150', 'hide', '3', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('9', 'COLUMNS', '列描述', 'columnComment', 'column_comment', '1', '300', 'hide', '4', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('101', 'BEAUTY_TABLE_CONFIG', '标识列', 'id', 'id', '1', '50', 'hide', '0', '', 'id', '2015-08-15 19:43:27', 'admin', '2015-08-15 19:43:27', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('103', 'BEAUTY_TABLE_CONFIG', '列名', 'title', 'title', '1', '50', '', '2', '', 'title', '2015-08-15 19:43:27', 'admin', '2015-08-15 19:43:27', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('104', 'BEAUTY_TABLE_CONFIG', '类字段', 'data', 'data', '1', '50', '', '3', '', 'data', '2015-08-15 19:43:27', 'admin', '2015-08-15 19:43:27', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('105', 'BEAUTY_TABLE_CONFIG', '数据库字段', 'columnName', 'column_name', '1', '80', '', '4', '', 'column_name', '2015-08-15 19:43:27', 'admin', '2015-08-15 19:43:27', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('106', 'BEAUTY_TABLE_CONFIG', '排序', 'orderable', 'orderable', '1', '50', '', '5', '', 'orderable', '2015-08-15 19:43:28', 'admin', '2015-08-15 19:43:28', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('107', 'BEAUTY_TABLE_CONFIG', '宽', 'width', 'width', '1', '50', '', '6', '', 'width', '2015-08-15 19:43:28', 'admin', '2015-08-15 19:43:28', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('108', 'BEAUTY_TABLE_CONFIG', '样式', 'className', 'class_name', '1', '50', '', '7', '', 'class_name', '2015-08-15 19:43:28', 'admin', '2015-08-15 19:43:28', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('109', 'BEAUTY_TABLE_CONFIG', '序号', 'sequence', 'sequence', '1', '50', '', '8', '', 'sequence', '2015-08-15 19:43:28', 'admin', '2015-08-15 19:43:28', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('120', 'BEAUTY_TABLE_CONFIG', '表名', 'tableName', 'table_name', '1', '150', '', '1', '', 'table_name', '2015-08-15 20:18:03', 'admin', '2015-08-15 20:18:03', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('124', 'BEAUTY_TABLE_CONFIGED', '列名', 'columnName', 'column_name', '1', '150', '', '1', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('125', 'BEAUTY_TABLE_CONFIGED', '类属性', 'data', '', '1', '150', '', '2', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('126', 'BEAUTY_TABLE_CONFIGED', '标识列', 'id', 'id', '1', '50', 'hide', '0', '', 'id', '2015-08-15 19:43:27', 'admin', '2015-08-15 19:43:27', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('132', 'BEAUTY_USER', '用户名', 'name', 'name', '1', '50', '', '0', '', 'name', '2015-08-23 21:33:02', 'admin', '2015-08-23 21:33:02', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('133', 'BEAUTY_USER', '标识列', 'id', 'id', '1', '50', '', '1', '', 'id', '2015-08-23 21:33:02', 'admin', '2015-08-23 21:33:02', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('134', 'BEAUTY_USER', '性别', 'gender', 'gender', '1', '50', '', '0', '', 'gender', '2015-08-23 21:33:20', 'admin', '2015-08-23 21:33:20', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('135', 'BEAUTY_USER', '帐号', 'account', 'account', '1', '50', '', '0', '', 'account', '2015-08-23 21:33:24', 'admin', '2015-08-23 21:33:24', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('139', 'BEAUTY_ROLE', '', '', 'id', '1', '50', '', '0', '', 'id', '2015-08-23 22:17:09', 'admin', '2015-08-23 22:17:09', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('140', 'BEAUTY_ROLE', '', '', 'code', '1', '50', '', '1', '', 'code', '2015-08-23 22:17:09', 'admin', '2015-08-23 22:17:09', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('141', 'BEAUTY_ROLE', '', '', 'name', '1', '50', '', '2', '', 'name', '2015-08-23 22:17:09', 'admin', '2015-08-23 22:17:09', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('142', 'BEAUTY_ROLE', '', '', 'group_id', '1', '50', '', '3', '', 'group_id', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('143', 'BEAUTY_ROLE', '', '', 'remark', '1', '50', '', '4', '', 'remark', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('144', 'BEAUTY_ROLE', '', '', 'create_time', '1', '50', '', '5', '', 'create_time', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('145', 'BEAUTY_ROLE', '', '', 'creater', '1', '50', '', '6', '', 'creater', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('146', 'BEAUTY_ROLE', '', '', 'last_update_time', '1', '50', '', '7', '', 'last_update_time', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('147', 'BEAUTY_ROLE', '', '', 'modifier', '1', '50', '', '8', '', 'modifier', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('148', 'BEAUTY_ROLE', '', '', 'is_deleted', '1', '50', '', '9', '', 'is_deleted', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('149', 'BEAUTY_ROLE', '', '', 'def1', '1', '50', '', '10', '', 'def1', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('150', 'BEAUTY_ROLE', '', '', 'def2', '1', '50', '', '11', '', 'def2', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_config` VALUES ('151', 'BEAUTY_ROLE', '', '', 'def3', '1', '50', '', '12', '', 'def3', '2015-08-23 22:17:10', 'admin', '2015-08-23 22:17:10', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for `beauty_user`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_user`;
CREATE TABLE `beauty_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:保密，1:男，2:女',
  `mobile` varchar(20) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， 0：无效',
  `def1` varchar(50) NOT NULL DEFAULT '',
  `def2` varchar(50) NOT NULL DEFAULT '',
  `def3` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of beauty_user
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_user_extra`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_user_extra`;
CREATE TABLE `beauty_user_extra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `qq` varchar(20) NOT NULL DEFAULT '',
  `wx_no` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  `favor` varchar(50) NOT NULL DEFAULT '',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， 0：无效',
  `def1` varchar(50) NOT NULL DEFAULT '',
  `def2` varchar(50) NOT NULL DEFAULT '',
  `def3` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of beauty_user_extra
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_user_role`;
CREATE TABLE `beauty_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个用户对应多个角色';

-- ----------------------------
-- Records of beauty_user_role
-- ----------------------------
