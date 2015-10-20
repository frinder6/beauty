/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : beauty

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-10-21 00:23:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for beauty_authority
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code_uqe` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of beauty_authority
-- ----------------------------
INSERT INTO `beauty_authority` VALUES ('1', 'SYS-ACCESS', '系统访问', '114381', '2', '系统访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:40:55', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('7', 'MENU-SYS-MNG-ACCESS', '系统管理访问', '114381', '1', '系统管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:05', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('8', 'MENU-MENU-MNG-ACCESS', '菜单管理访问', '3347807', '1', '菜单管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:06', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('9', 'RES-MENU-ADD', '新增菜单', '3347807', '2', '新增菜单', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:08', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('10', 'RES-MENU-DEL', '移除菜单', '3347807', '2', '移除菜单', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:09', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('11', 'MENU-RESOUCE-MNG-ACCESS', '资源管理访问', '341064690', '1', '资源管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('12', 'RES-RESOURCE-ADD', '新增资源', '341064690', '2', '新增资源', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:17', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('13', 'RES-RESOURCE-DEL', '移除资源', '341064690', '2', '移除资源', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:17', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('14', 'RES-MENU-UPD', '更新菜单', '3347807', '2', '更新菜单', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('15', 'RES-RESOURCE-UPD', '更新资源', '341064690', '2', '更新资源', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('16', 'RES-RESOURCE-CONF', '资源配置', '3059492', '2', '资源配置', '1980-01-01 00:00:00', 'admin', '2015-10-06 11:25:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('17', 'RES-AUTH-MNG', '权限管理', '3005864', '2', '权限管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('18', 'RES-AUTH-ADD', '新增权限', '3005864', '2', '新增权限', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('19', 'RES-AUTH-DEL', '移除权限', '3005864', '2', '移除权限', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('20', 'RES-AUTH-UPD', '更新权限', '3005864', '2', '更新权限', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('21', 'RES-AUTH-CONF', '权限配置', '3005864', '2', '权限配置', '1980-01-01 00:00:00', 'admin', '2015-10-06 11:25:29', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('54', 'MENU-MAIN-PAGE-ACCESS', '主页访问', '1233099618', '1', '主页访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('55', 'MENU-EMP-MNG-ACCESS', '员工管理访问', '0', '1', '员工管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('56', 'MENU-VIP-MNG-ACCESS', '会员管理访问', '0', '1', '会员管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('57', 'MENU-CHECK-MNG-ACCESS', '考勤管理访问', '94627080', '1', '考勤管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('58', 'MENU-PRT-MNG-ACCESS', '货品管理访问', '111282', '1', '货品管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('59', 'MENU-SETTINGS-MNG-ACCESS', '设置管理访问', '113762', '1', '设置管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('60', 'MENU-MSG-MNG-ACCESS', '消息管理访问', '108417', '1', '消息管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('61', 'MENU-TABLE-CONF-ACCESS', '表格配置访问', '3059492', '1', '表格配置访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('62', 'MENU-CONF-MNG-ACCESS', '配置管理访问', '3059492', '1', '配置管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('63', 'MENU-URL-MNG-ACCESS', 'URL管理访问', '0', '1', 'URL管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('64', 'MENU-AUTH-MNG-ACCESS', '权限管理访问', '3005864', '1', '权限管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:20', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('65', 'MENU-ROLE-MNG-ACCESS', '角色管理访问', '3506294', '1', '角色管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:20', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('66', 'MENU-EMP-INFO-ACCESS', '员工信息访问', '0', '1', '员工信息访问', '1980-01-01 00:00:00', 'admin', '2015-10-03 22:41:20', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('69', 'MENU-USER-MNG-ACCESS', '用户管理访问', '0', '1', '用户管理访问', '1980-01-01 00:00:00', 'admin', '2015-10-06 02:56:13', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('70', 'RES-MENU-MNG', '菜单管理', '0', '2', '菜单管理', '1980-01-01 00:00:00', 'admin', '2015-10-18 00:36:37', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('71', 'RES-MAIN-PAGE-SHOW', '主页展示', '1233099618', '2', '主页展示', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('72', 'RES-URL-DEL', 'URL移除', '0', '2', 'URL移除', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('73', 'RES-URL-MARK', 'URL标记', '0', '2', 'URL标记', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('74', 'RES-URL-MNG', 'URL管理', '0', '2', 'URL管理', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_authority_resource
-- ----------------------------
DROP TABLE IF EXISTS `beauty_authority_resource`;
CREATE TABLE `beauty_authority_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority_id` bigint(20) NOT NULL COMMENT '权限id',
  `resource_id` bigint(20) NOT NULL COMMENT '菜单/资源id',
  `type` tinyint(4) NOT NULL DEFAULT '2' COMMENT '资源类型 1菜单 2资源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COMMENT='一个权限可以对应多个菜单或资源';

-- ----------------------------
-- Records of beauty_authority_resource
-- ----------------------------
INSERT INTO `beauty_authority_resource` VALUES ('2', '1', '8', '2');
INSERT INTO `beauty_authority_resource` VALUES ('3', '1', '28', '2');
INSERT INTO `beauty_authority_resource` VALUES ('4', '1', '29', '2');
INSERT INTO `beauty_authority_resource` VALUES ('5', '1', '24', '2');
INSERT INTO `beauty_authority_resource` VALUES ('6', '9', '33', '2');
INSERT INTO `beauty_authority_resource` VALUES ('9', '9', '30', '2');
INSERT INTO `beauty_authority_resource` VALUES ('13', '10', '36', '2');
INSERT INTO `beauty_authority_resource` VALUES ('16', '12', '39', '2');
INSERT INTO `beauty_authority_resource` VALUES ('17', '12', '41', '2');
INSERT INTO `beauty_authority_resource` VALUES ('18', '13', '38', '2');
INSERT INTO `beauty_authority_resource` VALUES ('19', '14', '45', '2');
INSERT INTO `beauty_authority_resource` VALUES ('20', '14', '42', '2');
INSERT INTO `beauty_authority_resource` VALUES ('21', '14', '43', '2');
INSERT INTO `beauty_authority_resource` VALUES ('23', '15', '27', '2');
INSERT INTO `beauty_authority_resource` VALUES ('24', '15', '14', '2');
INSERT INTO `beauty_authority_resource` VALUES ('25', '16', '9', '2');
INSERT INTO `beauty_authority_resource` VALUES ('26', '17', '7', '2');
INSERT INTO `beauty_authority_resource` VALUES ('27', '17', '22', '2');
INSERT INTO `beauty_authority_resource` VALUES ('28', '18', '32', '2');
INSERT INTO `beauty_authority_resource` VALUES ('29', '18', '35', '2');
INSERT INTO `beauty_authority_resource` VALUES ('30', '19', '47', '2');
INSERT INTO `beauty_authority_resource` VALUES ('31', '20', '31', '2');
INSERT INTO `beauty_authority_resource` VALUES ('32', '20', '34', '2');
INSERT INTO `beauty_authority_resource` VALUES ('33', '20', '25', '2');
INSERT INTO `beauty_authority_resource` VALUES ('34', '21', '26', '2');
INSERT INTO `beauty_authority_resource` VALUES ('35', '21', '15', '2');
INSERT INTO `beauty_authority_resource` VALUES ('36', '21', '16', '2');
INSERT INTO `beauty_authority_resource` VALUES ('40', '7', '2', '1');
INSERT INTO `beauty_authority_resource` VALUES ('41', '8', '15', '1');
INSERT INTO `beauty_authority_resource` VALUES ('42', '11', '29', '1');
INSERT INTO `beauty_authority_resource` VALUES ('43', '54', '1', '1');
INSERT INTO `beauty_authority_resource` VALUES ('44', '55', '3', '1');
INSERT INTO `beauty_authority_resource` VALUES ('45', '56', '4', '1');
INSERT INTO `beauty_authority_resource` VALUES ('46', '57', '5', '1');
INSERT INTO `beauty_authority_resource` VALUES ('47', '58', '6', '1');
INSERT INTO `beauty_authority_resource` VALUES ('48', '59', '7', '1');
INSERT INTO `beauty_authority_resource` VALUES ('49', '60', '8', '1');
INSERT INTO `beauty_authority_resource` VALUES ('50', '61', '16', '1');
INSERT INTO `beauty_authority_resource` VALUES ('51', '62', '17', '1');
INSERT INTO `beauty_authority_resource` VALUES ('52', '63', '21', '1');
INSERT INTO `beauty_authority_resource` VALUES ('53', '64', '30', '1');
INSERT INTO `beauty_authority_resource` VALUES ('54', '65', '31', '1');
INSERT INTO `beauty_authority_resource` VALUES ('55', '66', '38', '1');
INSERT INTO `beauty_authority_resource` VALUES ('56', '69', '45', '1');
INSERT INTO `beauty_authority_resource` VALUES ('58', '70', '21', '2');
INSERT INTO `beauty_authority_resource` VALUES ('59', '70', '6', '2');
INSERT INTO `beauty_authority_resource` VALUES ('60', '1', '84', '2');
INSERT INTO `beauty_authority_resource` VALUES ('61', '1', '80', '2');
INSERT INTO `beauty_authority_resource` VALUES ('67', '1', '88', '2');
INSERT INTO `beauty_authority_resource` VALUES ('68', '71', '24', '2');
INSERT INTO `beauty_authority_resource` VALUES ('69', '72', '93', '2');
INSERT INTO `beauty_authority_resource` VALUES ('70', '73', '92', '2');
INSERT INTO `beauty_authority_resource` VALUES ('71', '74', '1', '2');
INSERT INTO `beauty_authority_resource` VALUES ('72', '74', '17', '2');
INSERT INTO `beauty_authority_resource` VALUES ('73', '1', '94', '2');

-- ----------------------------
-- Table structure for beauty_dict
-- ----------------------------
DROP TABLE IF EXISTS `beauty_dict`;
CREATE TABLE `beauty_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dict_key` varchar(50) NOT NULL DEFAULT '',
  `dict_value` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_key_uqe` (`dict_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of beauty_dict
-- ----------------------------
INSERT INTO `beauty_dict` VALUES ('1', 'schema', 'beauty');

-- ----------------------------
-- Table structure for beauty_menu
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of beauty_menu
-- ----------------------------
INSERT INTO `beauty_menu` VALUES ('0', '6666CD76F96956469E7BE39D750CC7D9', '/', '/', '-1', '0', '0', '/', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('1', 'B04EC75CDEAA52470E063D6734D14A95', '主页', '#', '0', '0', '0', '主页', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:30:29', 'admin', '1', 'current', 'fa-home', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('2', '4D85AC125077E6D217238D0FF835730B', '系统管理', '#', '0', '0', '0', '系统管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:31:02', 'admin', '1', '', 'fa-laptop', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('3', 'B33603085D6CE90FB020236FE4557A62', '员工管理', '#', '0', '0', '0', '员工管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:30:46', 'admin', '1', '', 'fa-user', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('4', '24735FBE94183D03D5BBFC5A24BF51D6', '会员管理', '#', '0', '0', '0', '会员管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:30:34', 'admin', '1', '', 'fa-users', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('5', '2A2338AE334FF471E10D022802FE45C4', '考勤管理', '#', '0', '0', '0', '考勤管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:31:07', 'admin', '1', '', 'fa-calendar', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('6', 'E789DD5D7D12DDAD6C0C0585C54263D5', '货品管理', '#', '0', '0', '0', '货品管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:31:44', 'admin', '1', '', 'fa-truck', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('7', '19727698EBA65643F662C728CEE3B7B4', '设置管理', '#', '0', '0', '0', '设置管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:31:39', 'admin', '1', '', 'fa-wrench', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('8', '69BD9A18C21712FF5517ABF8FDCC6864', '消息管理', '#', '0', '0', '0', '消息管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:30:56', 'admin', '1', '', 'fa-envelope-o', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('15', 'D41D8CD98F00B204E9800998ECF8427E', '菜单管理', '/pages/bracket/sys/menu-list.jsp', '2', '0', '0', '菜单管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:34:03', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('16', 'E6C48956D47CC117AE9D33AF995E8EE3', '表格配置', '/pages/bracket/sys/sys-table-list.jsp', '7', '0', '0', '表格配置', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:31:28', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('17', '837D8A6473195B8B5E85D58A72CB9C7E', '配置管理', '/pages/bracket/sys/columns-list.jsp', '7', '0', '0', '配置管理', '1980-01-01 00:00:00', 'admin', '2015-10-18 00:43:24', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('21', 'DA04BD30A2390A23F3E7E51189036C34', 'URL管理', '/pages/bracket/sys/url-list.jsp', '2', '0', '0', 'URL管理', '2015-09-07 21:03:11', 'admin', '2015-10-03 19:30:24', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('29', '6478FCBD694068CA53F7B830CDEE4568', '资源管理', '/pages/bracket/sys/resource-list.jsp', '2', '0', '0', '资源管理', '2015-09-07 21:56:10', 'admin', '2015-10-18 00:42:54', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('30', '23BBDD59D0B1D94621FC98E7F533AD9F', '权限管理', '/pages/bracket/sys/auth-list.jsp', '2', '0', '0', '权限管理', '2015-09-07 21:59:15', 'admin', '2015-10-03 19:30:51', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('31', '3F856EC241D67B94402699ED313D714F', '角色管理', '/pages/bracket/sys/role-list.jsp', '2', '0', '0', '角色管理', '2015-09-07 22:04:29', 'admin', '2015-10-03 19:31:33', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('38', 'EFCDB314517586B39478DC159B926C66', '员工信息', '/', '3', '0', '0', '员工信息管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:30:40', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('45', '7D94DE1CDBA7512A76FD42D71F537BFD', '用户管理', '/pages/bracket/sys/user-list.jsp', '2', '0', '0', '用户管理', '1980-01-01 00:00:00', 'admin', '2015-10-03 23:08:49', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_menu` VALUES ('46', '7FC56270E7A70FA81A5935B72EACBE29', 'A', 'a', '1', '0', '0', 'A', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_resource
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code_uqe` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Records of beauty_resource
-- ----------------------------
INSERT INTO `beauty_resource` VALUES ('1', '40B8DFB599737E0076D19BBCFCD840D1', '1111', '/url/load/page.action', '116079', '111', '1980-01-01 00:00:00', 'admin', '2015-09-30 22:52:35', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('2', '5D42381B2387F45F9DC3AE462224753B', '', '/table/load/table/config.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('3', '3648488A3DDF0FB378A340BFE2EC6393', '', '/table/load/schema/tables.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('4', 'D2345D2590EE63B2A24635C38D6134B7', '', '/table/load/config.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('5', '744979BD15858C80271E70ED97C89210', '', '/resource/load/page.action', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('6', '6C8B6219B2BC9A4EC320D74F5362A621', '', '/menu/load/page.action', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('7', 'EB7BDB3A8531EC2265F3106F3C14992C', '', '/auth/load/page.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('9', 'E1FAFFB3E614E6C2FBA74296962386B7', 'AAA', '/resource/config.action', '341064690', 'AAA', '1980-01-01 00:00:00', 'admin', '2015-10-18 00:48:40', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('10', '5C00CAD595BBB19FE9BBFF81E3FCDE10', '', '/table/remove/config.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('11', 'EC46944324167A40E11D6E9A13803682', '', '/table/modify/config.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('12', '4559491DC7472BF7B75B7CF7099BA7E4', '', '/table/load/table/columns.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('13', 'D8DADA27565067B7B3562E572D489121', '', '/table/inline.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('14', 'ACF12748DB6A367491D90D79192FAF22', '', '/resource/load/id.action', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('15', '40C80174CFB1EC5E8A0499D87ED710CA', '', '/ar/load/page.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('16', '95400785C42C8AB30730326191362922', '', '/ar/add.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('17', '988DAA61EE649E6A299A24532F763606', '', '/pages/bracket/sys/url-list.jsp', '116079', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('18', '1CCE23673544A8CED68D8BCACA4A31AE', '', '/pages/bracket/sys/table-config-list.jsp', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('19', '13BB70C78B8B0D65B265E76112CF4447', '', '/pages/bracket/sys/sys-table-list.jsp', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('20', '353760515A443F56B237DCC7F5794C81', '', '/pages/bracket/sys/resource-list.jsp', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('21', 'BB33C6AA3B3A84D0EEC1E0FAA80BD227', '', '/pages/bracket/sys/menu-list.jsp', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('22', 'AFCA0DF15DBCEDCB065449B9137ABEC0', '', '/pages/bracket/sys/auth-list.jsp', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('23', 'B88FEFD84EA671B2D9148D59C447D6A8', '', '/pages/bracket/sys/auth-conf.jsp', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('24', '60BEB95F5978A2C74BC42D814D84BA98', '', '/pages/bracket/content.jsp', '0', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('25', '192A24325AF197CE51AB25DF11BD6BA4', '', '/auth/load/id.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('26', 'E2826D5031874B63DC629AF96517017B', '', '/ar/remove.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('27', 'A95C3944DEC3609C2EC4EC1A0E972018', '', '/pages/bracket/sys/resource-update.jsp', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('30', 'AB1712966475DDE74E7223B78E46DCC4', '', '/pages/bracket/sys/menu-add.jsp', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('31', '2A377771DBDB23F8EB2CA515A70B3305', '', '/pages/bracket/sys/auth-update.jsp', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('32', '607D1288A9FBEC8611E6752CB175C783', '', '/pages/bracket/sys/auth-add.jsp', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('33', '16AF5388ED51C415DC8F96037F207293', '', '/menu/add.action', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('34', '9BCF0BAD086B9A04B2DE2357FD2B37E4', '', '/auth/update.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('35', 'ABDA052C772DF00C25125805A76FBFE0', '', '/auth/add.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('36', '84E01B1E30A29412B7D18DFF07D9B0F7', '', '/menu/remove.action', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('38', '308D1DCBDE7D6C1EF526A8C55A7040DE', '', '/resource/remove.action', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('39', '88F14A67F5D3C92A1280C12EE28071CA', '', '/resource/add.action', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('41', '0B365FBA6966CFA3DCA057349B1590E9', '', '/pages/bracket/sys/resource-add.jsp', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('42', 'ACFACDD810FC2DA10BF2346EC8DA5140', '', '/pages/bracket/sys/menu-update.jsp', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('43', 'F34CDFCFDF3C7D02A54CE97CD9F143C5', '', '/menu/update.action', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('44', 'FFDCD19541D8B3931ED972C886768FAF', '', '/menu/select.action', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('45', '28FB41EF135799B1C93E7D9A39734DFE', '', '/menu/load/id.action', '3347807', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('46', 'D0F83E3A885C3267EF27640F81DECCC3', '', '/resource/update.action', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('47', '658A4D77C650FBB2B0F6FD685B487373', '', '/auth/remove.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('48', '97DB623308AF869382BF55642B3F9080', '', '/role/update.action', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('49', '6756331C94788AE2F7CFBD8E20F01948', '', '/pages/bracket/sys/role-conf.jsp', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('50', 'C919515EAEE898F654C4A159EA7AC396', '', '/role/remove.action', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('51', 'CF628EC141B6E9F191DE73B54F31C86C', '', '/role/load/id.action', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('52', 'A409A9CF882C26E329D0B38BDBC4DCC9', '', '/pages/bracket/sys/role-update.jsp', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('53', 'BF97F75B9E2F9B956046347B056051CA', '', '/role/add.action', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('54', '2DF8DA56A33059A2306E0A0ABA28AD5B', '', '/pages/bracket/sys/role-add.jsp', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('55', 'E758D1D4E256331369D967CF09721415', '', '/role/load/page.action', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('56', '4233BB4B7D03E05F4B79874E864B2845', '', '/pages/bracket/sys/role-list.jsp', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('57', 'C01352EED594B218CEC0F50D2D136A2C', '', '/pages/bracket/sys/user-conf.jsp', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('58', 'DC437D3F34C1928A465728E1F1E21198', '', '/user/remove.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('59', '024F24EAB3B0FA3A2019D60265CE1523', '', '/user/update.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('60', '21B8828301B2292B4B0858A684B491E1', '', '/user/load/id.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('61', '09611AD60E062AC4958BE2D35CA84AA0', '', '/pages/bracket/sys/user-update.jsp', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('62', 'CC6B08ED5B09A3928893641232178333', '', '/user/add.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('63', 'FB3ECC8874FF2380B45A4381BA06E3E5', '', '/pages/bracket/sys/user-add.jsp', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('64', '74F8A9E9ED978CCF6F7955957C571A57', '', '/user/load/page.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('65', 'E46206D0D54FAA90989E2B94DBDB5886', '', '/pages/bracket/sys/user-list.jsp', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('66', '04F7F901E3B7EBA8C8F90603C87C2B5E', '', '/table/copy.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('67', '8EBA896286F16C1A915AA128FE9B4B3B', '', '/table/copy/config.action', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('68', 'D47C319C161440B35B777442D87B3958', '', '/resource/group.action', '341064690', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('69', 'D5E4AD302D4C6121374B726395E36EEB', '', '/ur/add.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('70', '0FD20A62998AFC2B6B2CBB31061A3D95', '', '/ur/remove.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('71', '450852E781651E6534BDD981B9962CF1', '', '/ur/load/page.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('72', '12257BF0FB13C0F2C6D5E553DC43F41F', '', '/pages/errors/sessionTimeout.html', '0', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('73', 'E505CC6A63DACED123329AD0B7838B35', '', '/ra/remove.action', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('74', 'C4B11A942298AA577A8EEF6392EA608B', '', '/ra/add.action', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('75', 'BD6FD17EF6C5C39C1BE61D3A2EDEB08C', '', '/ra/load/page.action', '3506294', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('76', 'B36234CFF73681FA1E3DBBA48EDB6C4B', '', '/pages/bracket/sys/sys-column-list.jsp', '110115790', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('79', '1EC505635DE7E71C5FE62F3657D1AB38', '', '/pages/bracket/sys/url-dialog-list.jsp', '116079', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('80', 'FE53E39279C2690B120738A6134ACDB0', '', '/redirect/redirect/pages.bracket.index/jsp.action', '0', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('83', 'E0CAD902EE08438BC7AF23107AFC6457', '', '/auth/group.action', '3005864', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('84', '2C23EFA0EFF697DB0511A1E1FCA3C2A2', '', '/pages/bracket/index.jsp', '0', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('85', '246D324892A3FCB12F1B8A9A1A2C0314', '', '/j_spring_security_check', '0', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('92', '8A42D69EB6B12EC06EB85B4C115D8351', '', '/url/mark.action', '116079', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('93', '572947655834FF3E89902CF0E3B4FD30', '', '/url/remove.action', '116079', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('94', 'C1FFB0E21115A564E48625B5D0BC355B', '', '/user/auths.action', '3599307', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('95', '48D96F02D7F5600A2B05AA88272A3867', '', '/schema/load/page.action', '0', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('96', '8511052F5E14587780AEF50BDA4205BA', '', '/pages/bracket/sys/columns-list.jsp', '949721053', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('97', '28EE0F125C2C018E7732A60A0CD2C76E', '', '/pages/bracket/sys/columns-conf.jsp', '949721053', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('99', '02AC2C79790A4B71DB3F3BB1FFC4D303', '', '/j_spring_security_logout', '0', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('100', 'E2CD2C938A8365CB57DC53CC1D3EA051', '', '/columns/update.action', '949721053', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('101', 'FA833D63E226445513C5343DBF44D844', '', '/columns/remove.action', '949721053', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('102', '472258B6CBC687F065BF339BB256D88C', '', '/columns/load/page.action', '949721053', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('103', '53FEDB816FF4C0FAA4D29DD002E9FA33', '', '/columns/load/columns.action', '949721053', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('104', '69C72BED74526D41A96F1BDED0BA082D', '', '/columns/copy.action', '949721053', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_resource` VALUES ('105', '76E953CDEFDC011AEC5694488E62E1E0', '', '/columns/conf.action', '0', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_role
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code_uqe` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of beauty_role
-- ----------------------------
INSERT INTO `beauty_role` VALUES ('1', '302FF00DDB9CB45C970A316E5212BB34', '超级管理员', '0', '超级管理员', '1980-01-01 00:00:00', 'admin', '2015-10-18 00:51:38', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_role` VALUES ('2', 'B1DAE9BC5CABBC13E4BEE21AF11CDB8D', '管理员', '0', '管理员', '1980-01-01 00:00:00', 'admin', '2015-10-03 23:02:34', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `beauty_role_authority`;
CREATE TABLE `beauty_role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `authority_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='一个角色可以拥有多个权限';

-- ----------------------------
-- Records of beauty_role_authority
-- ----------------------------
INSERT INTO `beauty_role_authority` VALUES ('1', '1', '1');
INSERT INTO `beauty_role_authority` VALUES ('2', '1', '7');
INSERT INTO `beauty_role_authority` VALUES ('4', '1', '9');
INSERT INTO `beauty_role_authority` VALUES ('5', '1', '10');
INSERT INTO `beauty_role_authority` VALUES ('6', '1', '11');
INSERT INTO `beauty_role_authority` VALUES ('7', '1', '12');
INSERT INTO `beauty_role_authority` VALUES ('8', '1', '13');
INSERT INTO `beauty_role_authority` VALUES ('9', '1', '14');
INSERT INTO `beauty_role_authority` VALUES ('10', '1', '15');
INSERT INTO `beauty_role_authority` VALUES ('11', '1', '16');
INSERT INTO `beauty_role_authority` VALUES ('12', '1', '17');
INSERT INTO `beauty_role_authority` VALUES ('13', '1', '18');
INSERT INTO `beauty_role_authority` VALUES ('14', '1', '8');
INSERT INTO `beauty_role_authority` VALUES ('15', '1', '19');
INSERT INTO `beauty_role_authority` VALUES ('16', '1', '20');
INSERT INTO `beauty_role_authority` VALUES ('17', '1', '21');
INSERT INTO `beauty_role_authority` VALUES ('21', '1', '64');
INSERT INTO `beauty_role_authority` VALUES ('22', '1', '65');
INSERT INTO `beauty_role_authority` VALUES ('23', '1', '66');
INSERT INTO `beauty_role_authority` VALUES ('24', '1', '54');
INSERT INTO `beauty_role_authority` VALUES ('25', '1', '55');
INSERT INTO `beauty_role_authority` VALUES ('26', '1', '56');
INSERT INTO `beauty_role_authority` VALUES ('27', '1', '57');
INSERT INTO `beauty_role_authority` VALUES ('28', '1', '58');
INSERT INTO `beauty_role_authority` VALUES ('29', '1', '59');
INSERT INTO `beauty_role_authority` VALUES ('30', '1', '60');
INSERT INTO `beauty_role_authority` VALUES ('31', '1', '61');
INSERT INTO `beauty_role_authority` VALUES ('32', '1', '62');
INSERT INTO `beauty_role_authority` VALUES ('33', '1', '63');
INSERT INTO `beauty_role_authority` VALUES ('43', '1', '69');
INSERT INTO `beauty_role_authority` VALUES ('44', '2', '54');
INSERT INTO `beauty_role_authority` VALUES ('45', '2', '7');
INSERT INTO `beauty_role_authority` VALUES ('46', '2', '8');
INSERT INTO `beauty_role_authority` VALUES ('47', '2', '64');
INSERT INTO `beauty_role_authority` VALUES ('48', '1', '70');
INSERT INTO `beauty_role_authority` VALUES ('49', '2', '70');
INSERT INTO `beauty_role_authority` VALUES ('50', '1', '71');
INSERT INTO `beauty_role_authority` VALUES ('51', '2', '71');
INSERT INTO `beauty_role_authority` VALUES ('52', '2', '1');
INSERT INTO `beauty_role_authority` VALUES ('53', '1', '73');
INSERT INTO `beauty_role_authority` VALUES ('54', '1', '74');
INSERT INTO `beauty_role_authority` VALUES ('55', '1', '72');
INSERT INTO `beauty_role_authority` VALUES ('56', '2', '9');

-- ----------------------------
-- Table structure for beauty_schema_columns
-- ----------------------------
DROP TABLE IF EXISTS `beauty_schema_columns`;
CREATE TABLE `beauty_schema_columns` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` varchar(50) NOT NULL DEFAULT '',
  `column_name` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(50) NOT NULL DEFAULT '',
  `remark` varchar(200) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `creater` varchar(50) NOT NULL DEFAULT 'admin',
  `last_update_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifier` varchar(50) NOT NULL DEFAULT 'admin',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效，1：有效， -1：无效',
  `def1` varchar(50) NOT NULL DEFAULT '',
  `def2` varchar(50) NOT NULL DEFAULT '',
  `def3` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of beauty_schema_columns
-- ----------------------------
INSERT INTO `beauty_schema_columns` VALUES ('1', 'id', 'id', '操作', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('2', 'code', 'code', '编码', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('3', 'name', 'name', '名称', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('4', 'groupId', 'group_id', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('5', 'type', 'type', '类型', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('6', 'remark', 'remark', '备注', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('7', 'createTime', 'create_time', '创建时间', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('8', 'creater', 'creater', '创建者', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('9', 'lastUpdateTime', 'last_update_time', '修改时间', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('10', 'modifier', 'modifier', '修改者', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('11', 'isDeleted', 'is_deleted', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('12', 'def1', 'def1', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('13', 'def2', 'def2', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('14', 'def3', 'def3', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('15', 'authorityId', 'authority_id', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('16', 'resourceId', 'resource_id', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('17', 'url', 'url', 'URL', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('18', 'parentId', 'parent_id', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('19', 'level', 'level', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('20', 'roleId', 'role_id', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('21', 'tableName', 'table_name', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('22', 'classPath', 'class_path', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('23', 'gridName', 'grid_name', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('24', 'columnId', 'column_id', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('25', 'title', 'title', '标题', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('26', 'data', 'data', '属性', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('27', 'columnName', 'column_name', '列名', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('28', 'orderable', 'orderable', '排序', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('29', 'width', 'width', '宽度', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('30', 'className', 'class_name', '样式', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('31', 'sequence', 'sequence', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('32', 'render', 'render', '渲染', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('33', 'account', 'account', '帐号', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('34', 'password', 'password', '密码', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('35', 'gender', 'gender', '性别', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('36', 'mobile', 'mobile', '手机', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('37', 'email', 'email', '邮箱', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('38', 'userId', 'user_id', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('39', 'qq', 'qq', 'QQ', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('40', 'wxNo', 'wx_no', '微信', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('41', 'address', 'address', '地址', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('42', 'favor', 'favor', '喜好', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('43', 'username', 'username', '用户名', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('44', 'series', 'series', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('45', 'token', 'token', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('46', 'lastUsed', 'last_used', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('64', 'cell_type', 'cell_type', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('65', 'default_content', 'default_content', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('66', 'searchable', 'searchable', '搜索', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('67', 'visible', 'visible', '可用', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('68', 'targets', 'targets', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('71', 'dict_key', 'dict_key', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('72', 'dict_value', 'dict_value', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_schema_columns` VALUES ('74', 'editable', 'editable', '编辑', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_table_columns
-- ----------------------------
DROP TABLE IF EXISTS `beauty_table_columns`;
CREATE TABLE `beauty_table_columns` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `column_id` bigint(20) NOT NULL COMMENT 'schema列id',
  `table_name` varchar(50) NOT NULL DEFAULT '' COMMENT '表名',
  `cell_type` varchar(50) NOT NULL DEFAULT '',
  `class_name` varchar(50) NOT NULL DEFAULT '' COMMENT '类名，样式',
  `data` varchar(50) NOT NULL DEFAULT '' COMMENT '类属性名（页面展示使用）',
  `column_name` varchar(50) NOT NULL DEFAULT '' COMMENT '对应列名',
  `default_content` varchar(200) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `type` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '表头',
  `width` int(11) NOT NULL DEFAULT '150' COMMENT '宽',
  `render` varchar(500) DEFAULT NULL,
  `orderable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否排序，1 是  -1否',
  `searchable` tinyint(4) NOT NULL DEFAULT '1',
  `visible` tinyint(4) NOT NULL DEFAULT '1',
  `editable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '可编辑',
  `targets` varchar(200) NOT NULL DEFAULT '',
  `sequence` int(11) NOT NULL DEFAULT '1' COMMENT '列显示顺序',
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
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='配置表头与列对应关系表';

-- ----------------------------
-- Records of beauty_table_columns
-- ----------------------------
INSERT INTO `beauty_table_columns` VALUES ('1', '1', 'BEAUTY_TABLE_COLUMNS', '', 'hide', 'id', 'id', '', '', '', '操作', '50', '', '0', '0', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('2', '21', 'BEAUTY_TABLE_COLUMNS', '', '', 'tableName', 'table_name', '', '', '', '表名', '150', null, '1', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('3', '25', 'BEAUTY_TABLE_COLUMNS', '', '', 'title', 'title', '', '', '', '标题', '80', null, '0', '1', '1', '1', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('4', '26', 'BEAUTY_TABLE_COLUMNS', '', '', 'data', 'data', '', '', '', '属性', '80', null, '1', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('5', '27', 'BEAUTY_TABLE_COLUMNS', '', '', 'columnName', 'column_name', '', '', '', '列名', '80', null, '1', '1', '1', '0', '', '5', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('6', '28', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'orderable', 'orderable', '', '', '', '排序', '50', '_RENDER_BOOLEAN', '0', '1', '1', '1', '', '6', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('7', '29', 'BEAUTY_TABLE_COLUMNS', '', '', 'width', 'width', '', '', '', '宽度', '50', null, '0', '1', '1', '1', '', '7', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('8', '30', 'BEAUTY_TABLE_COLUMNS', '', '', 'className', 'class_name', '', '', '', '样式', '100', null, '0', '1', '1', '1', '', '8', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('9', '31', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'sequence', 'sequence', '', '', '', '序列', '50', null, '0', '1', '1', '1', '', '9', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('10', '32', 'BEAUTY_TABLE_COLUMNS', '', '', 'render', 'render', '', '', '', '渲染', '150', null, '0', '1', '1', '1', '', '10', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('11', '66', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'searchable', 'searchable', '', '', '', '搜索', '50', '_RENDER_BOOLEAN', '0', '1', '1', '1', '', '11', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('12', '67', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'visible', 'visible', '', '', '', '可用', '50', '_RENDER_BOOLEAN', '0', '1', '1', '1', '', '12', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('13', '74', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'editable', 'editable', '', '', '', '编辑', '50', '_RENDER_BOOLEAN', '0', '1', '1', '0', '', '13', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('16', '21', 'TABLES', '', '', 'tableName', 'table_name', '', '', '', '表名称', '0', null, '1', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('17', '0', 'TABLES', '', '', 'tableComment', 'table_comment', '', '', '', '表描述', '0', null, '1', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('18', '0', 'TABLES', '', 'table-action', 'tableSchema', 'table_schema', '', '', '', '操作', '0', '_RENDER_OPER', '0', '0', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('19', '1', 'BEAUTY_SCHEMA_COLUMNS', '', 'hide', 'id', 'id', '', '', '', '操作', '0', null, '0', '0', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('20', '25', 'BEAUTY_SCHEMA_COLUMNS', '', '', 'title', 'title', '', '', '', '标题', '0', null, '0', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('21', '26', 'BEAUTY_SCHEMA_COLUMNS', '', '', 'data', 'data', '', '', '', '属性', '0', null, '1', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('22', '27', 'BEAUTY_SCHEMA_COLUMNS', '', '', 'columnName', 'column_name', '', '', '', '列名', '0', null, '0', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('23', '1', 'BEAUTY_TABLE_COLUMNS_2', '', 'hide', 'id', 'id', '', '', '', '操作', '0', null, '0', '0', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('24', '25', 'BEAUTY_TABLE_COLUMNS_2', '', '', 'title', 'title', '', '', '', '标题', '0', null, '0', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('25', '26', 'BEAUTY_TABLE_COLUMNS_2', '', '', 'data', 'data', '', '', '', '属性', '0', null, '1', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('26', '27', 'BEAUTY_TABLE_COLUMNS_2', '', '', 'columnName', 'column_name', '', '', '', '列名', '0', null, '0', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('28', '2', 'BEAUTY_AUTHORITY', '', '', 'code', 'code', '', '', '', '编码', '0', null, '1', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('29', '3', 'BEAUTY_AUTHORITY', '', '', 'name', 'name', '', '', '', '名称', '0', null, '1', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('30', '5', 'BEAUTY_AUTHORITY', '', '', 'type', 'type', '', '', '', '类型', '0', '_RENDER_TYPE', '0', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('31', '6', 'BEAUTY_AUTHORITY', '', '', 'remark', 'remark', '', '', '', '备注', '0', null, '0', '1', '1', '0', '', '5', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('42', '1', 'BEAUTY_AUTHORITY', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', '_RENDER_OPER', '0', '0', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('43', '1', 'BEAUTY_TABLE_COLUMNS_COPY', '', 'hide', 'id', 'id', '', '', '', '操作', '50', '', '0', '0', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('45', '1', 'BEAUTY_MENU', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', '_RENDER_OPER', '0', '1', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('46', '2', 'BEAUTY_MENU', '', '', 'code', 'code', '', '', '', '编码', '0', null, '1', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('47', '3', 'BEAUTY_MENU', '', '', 'name', 'name', '', '', '', '名称', '0', null, '1', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('48', '6', 'BEAUTY_MENU', '', '', 'remark', 'remark', '', '', '', '备注', '0', null, '0', '1', '1', '0', '', '5', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('52', '17', 'BEAUTY_MENU', '', '', 'url', 'url', '', '', '', 'URL', '0', null, '0', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('53', '1', 'BEAUTY_URL', '', 'hide', 'id', 'id', '', '', '', '操作', '0', null, '0', '1', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('54', '6', 'BEAUTY_URL', '', '', 'remark', 'remark', '', '', '', '备注', '0', null, '0', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('56', '17', 'BEAUTY_URL', '', '', 'url', 'url', '', '', '', 'URL', '0', null, '1', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('57', '11', 'BEAUTY_URL', '', 'table-action', 'isDeleted', 'is_deleted', '', '', '', '有效', '50', '_RENDER_BOOLEAN', '0', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('58', '1', 'BEAUTY_RESOURCE', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', '_RENDER_OPER', '0', '1', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('59', '2', 'BEAUTY_RESOURCE', '', '', 'code', 'code', '', '', '', '编码', '0', null, '1', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('60', '3', 'BEAUTY_RESOURCE', '', '', 'name', 'name', '', '', '', '名称', '0', null, '1', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('61', '6', 'BEAUTY_RESOURCE', '', '', 'remark', 'remark', '', '', '', '备注', '0', null, '0', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('65', '17', 'BEAUTY_RESOURCE', '', '', 'url', 'url', '', '', '', 'URL', '0', null, '0', '1', '1', '0', '', '5', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('66', '1', 'BEAUTY_ROLE', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', '_RENDER_OPER', '0', '1', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('67', '2', 'BEAUTY_ROLE', '', '', 'code', 'code', '', '', '', '编码', '0', null, '1', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('68', '3', 'BEAUTY_ROLE', '', '', 'name', 'name', '', '', '', '名称', '0', null, '1', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('69', '6', 'BEAUTY_ROLE', '', '', 'remark', 'remark', '', '', '', '备注', '0', null, '0', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('73', '1', 'BEAUTY_USER', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', '_RENDER_OPER', '0', '1', '1', '0', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('74', '3', 'BEAUTY_USER', '', '', 'name', 'name', '', '', '', '名称', '0', null, '1', '1', '1', '0', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('75', '6', 'BEAUTY_USER', '', '', 'remark', 'remark', '', '', '', '备注', '0', null, '0', '1', '1', '0', '', '8', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('76', '33', 'BEAUTY_USER', '', '', 'account', 'account', '', '', '', '帐号', '0', null, '1', '1', '1', '0', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('77', '34', 'BEAUTY_USER', '', '', 'password', 'password', '', '', '', '密码', '0', null, '0', '1', '1', '0', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('79', '35', 'BEAUTY_USER', '', 'table-action', 'gender', 'gender', '', '', '', '性别', '0', '_RENDER_SEX', '0', '1', '1', '0', '', '5', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('80', '36', 'BEAUTY_USER', '', '', 'mobile', 'mobile', '', '', '', '手机', '0', null, '0', '1', '1', '0', '', '6', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns` VALUES ('82', '37', 'BEAUTY_USER', '', '', 'email', 'email', '', '', '', '邮箱', '0', null, '0', '1', '1', '0', '', '7', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_table_columns_copy
-- ----------------------------
DROP TABLE IF EXISTS `beauty_table_columns_copy`;
CREATE TABLE `beauty_table_columns_copy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `table_name` varchar(50) NOT NULL DEFAULT '' COMMENT '表名',
  `cell_type` varchar(50) NOT NULL DEFAULT '',
  `class_name` varchar(50) NOT NULL DEFAULT '' COMMENT '类名，样式',
  `data` varchar(50) NOT NULL DEFAULT '' COMMENT '类属性名（页面展示使用）',
  `column_name` varchar(50) NOT NULL DEFAULT '' COMMENT '对应列名',
  `default_content` varchar(200) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `type` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '表头',
  `width` int(11) NOT NULL DEFAULT '150' COMMENT '宽',
  `render` varchar(500) DEFAULT NULL,
  `orderable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否排序，1 是  -1否',
  `searchable` tinyint(4) NOT NULL DEFAULT '1',
  `visible` tinyint(4) NOT NULL DEFAULT '1',
  `targets` varchar(200) NOT NULL DEFAULT '',
  `sequence` int(11) NOT NULL DEFAULT '1' COMMENT '列显示顺序',
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
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8 COMMENT='配置表头与列对应关系表';

-- ----------------------------
-- Records of beauty_table_columns_copy
-- ----------------------------
INSERT INTO `beauty_table_columns_copy` VALUES ('1', 'BEAUTY_MENU', '', '', 'name', 'name', '', '', '', '菜单名称', '100', null, '1', '1', '1', '', '1', '', '1980-01-01 00:00:00', 'admin', '2015-10-07 18:00:12', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('3', 'BEAUTY_MENU', '', '', 'code', 'code', '', '', '', '菜单编码', '300', null, '1', '1', '1', '', '2', '', '1980-01-01 00:00:00', 'admin', '2015-10-07 18:00:30', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('4', 'BEAUTY_MENU', '', '', 'remark', 'remark', '', '', '', '菜单备注', '150', null, '1', '1', '1', '', '3', '', '1980-01-01 00:00:00', 'admin', '2015-10-03 19:42:40', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('5', 'TABLES', '', '', 'tableName', 'table_name', '', '', '', '表名称', '300', null, '1', '1', '1', '', '1', '', '1980-01-01 00:00:00', 'admin', '2015-09-30 21:28:52', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('6', 'TABLES', '', '', 'tableComment', 'table_comment', '', '', '', '表描述', '780', null, '1', '1', '1', '', '2', '', '1980-01-01 00:00:00', 'admin', '2015-10-06 18:33:05', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('7', 'COLUMNS', '', '', 'columnName', 'column_name', '', '', '', '列名称', '450', null, '1', '1', '1', '', '2', '', '1980-01-01 00:00:00', 'admin', '2015-09-30 21:32:29', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('8', 'COLUMNS', '', 'hide', 'columnType', 'column_type', '', '', '', '列类型', '150', null, '1', '1', '1', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('9', 'COLUMNS', '', 'hide', 'columnComment', 'column_comment', '', '', '', '列描述', '150', null, '1', '1', '1', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('124', 'BEAUTY_TABLE_CONFIGED', '', '', 'columnName', 'column_name', '', '', '', '列名称', '450', null, '1', '1', '1', '', '1', '', '1980-01-01 00:00:00', 'admin', '2015-09-30 21:32:48', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('126', 'BEAUTY_TABLE_CONFIGED', '', 'hide', 'id', 'id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-08-15 19:43:27', 'admin', '2015-09-12 21:19:29', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('132', 'BEAUTY_USER', '', '', 'name', 'name', '', '', '', '用户名', '150', null, '1', '1', '1', '', '1', 'name', '2015-08-23 21:33:02', 'admin', '2015-10-04 00:06:35', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('133', 'BEAUTY_USER', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', null, '0', '1', '1', '', '0', 'id', '2015-08-23 21:33:02', 'admin', '2015-10-05 00:24:09', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('134', 'BEAUTY_USER', '', '', 'gender', 'gender', '', '', '', '性别', '50', null, '1', '1', '1', '', '4', 'gender', '2015-08-23 21:33:20', 'admin', '2015-10-04 00:08:07', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('135', 'BEAUTY_USER', '', '', 'account', 'account', '', '', '', '帐号', '150', null, '1', '1', '1', '', '2', 'account', '2015-08-23 21:33:24', 'admin', '2015-10-04 00:06:39', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('152', 'BEAUTY_MENU', '', '', 'url', 'url', '', '', '', '菜单路径', '380', null, '1', '1', '1', '', '4', 'url', '2015-08-30 16:23:33', 'admin', '2015-10-07 18:00:49', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('156', 'BEAUTY_URL', '', '', 'url', 'url', '', '', '', 'URL', '1180', null, '1', '1', '1', '', '0', 'url', '2015-09-07 21:08:13', 'admin', '2015-10-06 14:06:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('157', 'BEAUTY_URL', '', 'hide', 'remark', 'remark', '', '', '', '备注', '300', null, '2', '1', '1', '', '1', 'remark', '2015-09-07 21:08:13', 'admin', '2015-09-12 21:19:34', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('158', 'BEAUTY_URL', '', 'hide', 'id', 'id', '', '', '', '标识列', '50', null, '0', '1', '1', '', '2', 'id', '2015-09-07 21:08:13', 'admin', '2015-09-12 21:19:46', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('159', 'BEAUTY_RESOURCE', '', '', 'url', 'url', '', '', '', 'BEAUTY_RESOURCE', '380', null, '1', '1', '1', '', '2', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-05 17:46:37', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('160', 'BEAUTY_RESOURCE', '', '', 'remark', 'remark', '', '', '', '备注', '300', null, '1', '1', '1', '', '3', 'remark', '2015-09-07 22:36:07', 'admin', '2015-10-05 17:46:14', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('161', 'BEAUTY_RESOURCE', '', 'hide', 'name', 'name', '', '', '', '资源名称', '150', null, '1', '1', '1', '', '5', 'name', '2015-09-07 22:36:07', 'admin', '2015-10-05 17:46:06', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('162', 'BEAUTY_RESOURCE', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', null, '0', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-10-05 16:43:32', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('163', 'BEAUTY_RESOURCE', '', '', 'code', 'code', '', '', '', '资源编码', '300', null, '1', '1', '1', '', '1', 'code', '2015-09-07 22:36:17', 'admin', '2015-10-05 17:45:53', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('173', 'BEAUTY_AUTHORITY', '', 'table-action', 'type', 'type', '', '', '', '类型', '80', null, '1', '1', '1', '', '3', 'type', '2015-09-12 20:19:30', 'admin', '2015-10-05 22:05:41', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('174', 'BEAUTY_AUTHORITY', '', '', 'remark', 'remark', '', '', '', '备注', '350', null, '1', '1', '1', '', '4', 'remark', '2015-09-12 20:19:30', 'admin', '2015-10-05 22:05:10', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('175', 'BEAUTY_AUTHORITY', '', '', 'name', 'name', '', '', '', '权限名称', '150', null, '1', '1', '1', '', '1', 'name', '2015-09-12 20:19:31', 'admin', '2015-10-05 22:04:43', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('176', 'BEAUTY_AUTHORITY', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', null, '0', '1', '1', '', '0', 'id', '2015-09-12 20:19:31', 'admin', '2015-10-05 01:58:07', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('177', 'BEAUTY_AUTHORITY', '', '', 'code', 'code', '', '', '', '权限编码', '350', null, '1', '1', '1', '', '2', 'code', '2015-09-12 20:22:13', 'admin', '2015-10-05 22:04:54', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('182', 'BEAUTY_A_R', '', 'hide', 'code', 'code', '', '', '', '资源编码', '50', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-09-18 20:08:38', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('183', 'BEAUTY_A_R', '', '', 'url', 'url', '', '', '', '资源URL', '400', null, '1', '1', '1', '', '1', 'name', '2015-09-07 22:36:07', 'admin', '2015-10-03 01:29:48', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('184', 'BEAUTY_A_R', '', 'hide', 'resourceId', 'resource_id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-09-17 22:11:18', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('185', 'BEAUTY_A_R_CONFIGED', '', 'hide', 'code', 'code', '', '', '', '资源编码', '50', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-09-17 22:48:22', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('186', 'BEAUTY_A_R_CONFIGED', '', '', 'url', 'url', '', '', '', '资源URL', '400', null, '1', '1', '1', '', '1', 'name', '2015-09-07 22:36:07', 'admin', '2015-10-03 01:30:09', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('187', 'BEAUTY_A_R_CONFIGED', '', 'hide', 'id', 'id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-09-16 22:09:21', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('188', 'BEAUTY_ROLE', '', '', 'name', 'name', '', '', '', '角色名称', '200', null, '1', '1', '1', '', '1', '', '1980-01-01 00:00:00', 'admin', '2015-10-03 23:03:01', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('189', 'BEAUTY_ROLE', '', '', 'code', 'code', '', '', '', '角色编码', '300', null, '1', '1', '1', '', '2', '', '1980-01-01 00:00:00', 'admin', '2015-10-03 23:03:52', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('190', 'BEAUTY_ROLE', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', null, '0', '1', '1', '', '0', '', '1980-01-01 00:00:00', 'admin', '2015-10-05 02:00:59', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('215', 'BEAUTY_R_A', '', '', 'code', 'code', '', '', '', '权限编码', '150', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-03 01:50:20', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('216', 'BEAUTY_R_A', '', 'hide', 'id', 'id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-10-03 01:47:30', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('218', 'BEAUTY_R_A_CONFIGED', '', '', 'code', 'code', '', '', '', '权限编码', '150', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-03 01:50:31', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('219', 'BEAUTY_R_A_CONFIGED', '', 'hide', 'authorityId', 'authority_id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-10-03 01:47:09', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('221', 'BEAUTY_R_A', '', '', 'name', 'name', '', '', '', '权限名称', '200', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-03 01:50:26', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('222', 'BEAUTY_R_A_CONFIGED', '', '', 'name', 'name', '', '', '', '权限名称', '200', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-03 01:50:37', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('223', 'BEAUTY_A_R_M', '', '', 'code', 'code', '', '', '', '菜单编码', '250', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-03 12:45:19', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('224', 'BEAUTY_A_R_M', '', '', 'name', 'name', '', '', '', '菜单名称', '200', null, '1', '1', '1', '', '1', 'name', '2015-09-07 22:36:07', 'admin', '2015-10-03 12:45:06', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('225', 'BEAUTY_A_R_M', '', 'hide', 'resourceId', 'resource_id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-10-03 12:45:09', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('226', 'BEAUTY_A_R_M_CONFIGED', '', '', 'code', 'code', '', '', '', '菜单编码', '250', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-03 12:45:16', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('227', 'BEAUTY_A_R_M_CONFIGED', '', '', 'name', 'name', '', '', '', '菜单名称', '200', null, '1', '1', '1', '', '1', 'name', '2015-09-07 22:36:07', 'admin', '2015-10-03 12:44:12', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('228', 'BEAUTY_A_R_M_CONFIGED', '', 'hide', 'id', 'id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-10-03 12:44:15', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('230', 'BEAUTY_MENU_DIALOG', '', '', 'name', 'name', '', '', '', '菜单名称', '200', null, '1', '1', '1', '', '1', '', '1980-01-01 00:00:00', 'admin', '2015-10-03 17:56:58', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('231', 'BEAUTY_MENU_DIALOG', '', '', 'code', 'code', '', '', '', '菜单编码', '200', null, '1', '1', '1', '', '2', '', '1980-01-01 00:00:00', 'admin', '2015-10-03 17:57:01', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('234', 'BEAUTY_ROLE', '', '', 'remark', 'remark', '', '', '', '备注', '300', null, '1', '1', '1', '', '3', '', '1980-01-01 00:00:00', 'admin', '2015-10-03 23:03:58', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('235', 'BEAUTY_USER', '', '', 'remark', 'remark', '', '', '', '备注', '200', null, '1', '1', '1', '', '7', '', '1980-01-01 00:00:00', 'admin', '2015-10-04 00:08:14', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('236', 'BEAUTY_USER', '', '', 'password', 'password', '', '', '', '密码', '150', null, '1', '1', '1', '', '3', '', '1980-01-01 00:00:00', 'admin', '2015-10-04 00:06:42', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('237', 'BEAUTY_USER', '', '', 'mobile', 'mobile', '', '', '', '手机', '150', null, '1', '1', '1', '', '5', '', '1980-01-01 00:00:00', 'admin', '2015-10-04 00:07:14', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('238', 'BEAUTY_USER', '', '', 'email', 'email', '', '', '', '邮箱', '150', null, '1', '1', '1', '', '6', '', '1980-01-01 00:00:00', 'admin', '2015-10-04 00:07:17', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('239', 'BEAUTY_U_R', '', 'hide', 'id', 'id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-10-04 23:06:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('240', 'BEAUTY_U_R_CONFIGED', '', 'hide', 'roleId', 'role_id', '', '', '', '标识列', '50', null, '1', '1', '1', '', '0', 'id', '2015-09-07 22:36:09', 'admin', '2015-10-04 23:07:06', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('241', 'BEAUTY_U_R', '', '', 'name', 'name', '', '', '', '角色名称', '200', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-04 23:06:20', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('242', 'BEAUTY_U_R_CONFIGED', '', '', 'name', 'name', '', '', '', '角色名称', '200', null, '1', '1', '1', '', '4', 'url', '2015-09-07 22:36:07', 'admin', '2015-10-04 23:06:43', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('248', 'BEAUTY_MENU', '', 'table-action', 'id', 'id', '', '', '', '操作', '50', '', '0', '1', '1', '', '0', '', '1980-01-01 00:00:00', 'admin', '2015-10-05 16:46:30', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('249', 'TABLES', '', 'table-action', 'tableSchema', 'table_schema', '', '', '', '操作', '50', '_RENDER_OPER', '0', '0', '1', '', '0', '', '1980-01-01 00:00:00', 'admin', '2015-10-06 18:33:47', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('250', 'BEAUTY_TABLE_COLUMNS', '', 'hide', 'id', 'id', '', '', '', '操作', '0', null, '1', '1', '1', '', '1', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('251', 'BEAUTY_TABLE_COLUMNS', '', '', 'tableName', 'table_name', '', '', '', '表名', '0', null, '1', '1', '1', '', '2', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('252', 'BEAUTY_TABLE_COLUMNS', '', '', 'title', 'title', '', '', '', '标题', '0', null, '1', '1', '1', '', '3', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('253', 'BEAUTY_TABLE_COLUMNS', '', '', 'data', 'data', '', '', '', '属性', '0', null, '1', '1', '1', '', '4', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('254', 'BEAUTY_TABLE_COLUMNS', '', '', 'columnName', 'column_name', '', '', '', '列名', '0', null, '1', '1', '1', '', '5', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('255', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'orderable', 'orderable', '', '', '', '排序', '0', null, '1', '1', '1', '', '9', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('256', 'BEAUTY_TABLE_COLUMNS', '', '', 'width', 'width', '', '', '', '宽度', '0', null, '1', '1', '1', '', '6', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('257', 'BEAUTY_TABLE_COLUMNS', '', '', 'className', 'class_name', '', '', '', '样式', '0', null, '1', '1', '1', '', '7', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('258', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'sequence', 'sequence', '', '', '', '排序', '0', null, '1', '1', '1', '', '10', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('259', 'BEAUTY_TABLE_COLUMNS', '', '', 'render', 'render', '', '', '', '渲染', '0', null, '1', '1', '1', '', '8', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('260', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'searchable', 'searchable', '', '', '', '搜索', '0', null, '1', '1', '1', '', '11', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_table_columns_copy` VALUES ('261', 'BEAUTY_TABLE_COLUMNS', '', 'table-action', 'visible', 'visible', '', '', '', '可用', '0', null, '1', '1', '1', '', '12', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_url
-- ----------------------------
DROP TABLE IF EXISTS `beauty_url`;
CREATE TABLE `beauty_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) NOT NULL DEFAULT '',
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
  UNIQUE KEY `idx_uqe_url` (`url`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of beauty_url
-- ----------------------------
INSERT INTO `beauty_url` VALUES ('1', '/table/load/table/config.action', '/table/load/table/config.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('2', '/menu/load/page.action', '/menu/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('3', '/url/load/page.action', '/url/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('4', '/resource/load/page.action', '/resource/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('5', '/auth/load/page.action', '/auth/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('6', '/', '/', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('7', '/table/load/schema/tables.action', '/table/load/schema/tables.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('8', '/table/load/config.action', '/table/load/config.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('9', '/resource/config.action', '/resource/config.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('10', '/resource/load/id.action', '/resource/load/id.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('11', '/table/inline.action', '/table/inline.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('12', '/ar/load/page.action', '/ar/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('13', '/ar/add.action', '/ar/add.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('14', '/table/load/table/columns.action', '/table/load/table/columns.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('15', '/table/modify/config.action', '/table/modify/config.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('16', '/table/remove/config.action', '/table/remove/config.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('17', '/auth/load/id.action', '/auth/load/id.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('18', '/ar/remove.action', '/ar/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('19', '/pages/bracket/content.jsp', '/pages/bracket/content.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('20', '/pages/bracket/sys/menu-list.jsp', '/pages/bracket/sys/menu-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('21', '/pages/bracket/sys/url-list.jsp', '/pages/bracket/sys/url-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('22', '/pages/bracket/sys/resource-list.jsp', '/pages/bracket/sys/resource-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('23', '/pages/bracket/sys/auth-list.jsp', '/pages/bracket/sys/auth-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('24', '/pages/bracket/sys/sys-table-list.jsp', '/pages/bracket/sys/sys-table-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('25', '/pages/bracket/sys/table-config-list.jsp', '/pages/bracket/sys/table-config-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('26', '/pages/bracket/sys/auth-conf.jsp', '/pages/bracket/sys/auth-conf.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('27', '/pages/bracket/sys/resource-update.jsp', '/pages/bracket/sys/resource-update.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('28', '/pages/bracket', '/pages/bracket', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('29', '/pages/bracket/', '/pages/bracket/', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('30', '/pages/bracket/sys/auth-add.jsp', '/pages/bracket/sys/auth-add.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('31', '/auth/add.action', '/auth/add.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('32', '/pages/Chinese.json', '/pages/Chinese.json', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('33', '/pages/bracket/sys/auth-update.jsp', '/pages/bracket/sys/auth-update.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('34', '/auth/update.action', '/auth/update.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('35', '/pages/bracket/sys/menu-add.jsp', '/pages/bracket/sys/menu-add.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('36', '/menu/add.action', '/menu/add.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('37', '/menu/remove.action', '/menu/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('38', '/pages/bracket/sys/resource-add.jsp', '/pages/bracket/sys/resource-add.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('39', '/resource/add.action', '/resource/add.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('40', '/resource/remove.action', '/resource/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('41', '/pages/bracket/sys/menu-update.jsp', '/pages/bracket/sys/menu-update.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('42', '/menu/load/id.action', '/menu/load/id.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('43', '/menu/select.action', '/menu/select.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('44', '/menu/update.action', '/menu/update.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('45', '/resource/update.action', '/resource/update.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('46', '/auth/remove.action', '/auth/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('51', '/pages', '/pages', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('52', '/pages/', '/pages/', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('54', '/pages/bracket/sys/role-list.jsp', '/pages/bracket/sys/role-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('55', '/role/load/page.action', '/role/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('56', '/pages/bracket/sys/sys-column-list.jsp', '/pages/bracket/sys/sys-column-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('57', '/table/copy/config.action', '/table/copy/config.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('58', '/pages/bracket/sys/role-add.jsp', '/pages/bracket/sys/role-add.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('59', '/role/add.action', '/role/add.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('60', '/pages/bracket/sys/role-update.jsp', '/pages/bracket/sys/role-update.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('61', '/role/load/id.action', '/role/load/id.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('62', '/role/remove.action', '/role/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('63', '/pages/bracket/sys/role-conf.jsp', '/pages/bracket/sys/role-conf.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('64', '/table/copy.action', '/table/copy.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('65', '/ra/load/page.action', '/ra/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('66', '/ra/add.action', '/ra/add.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('67', '/ra/remove.action', '/ra/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('68', '/pages/errors/sessionTimeout.html', '/pages/errors/sessionTimeout.html', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('69', '/role/update.action', '/role/update.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('70', '/pages/bracket/sys/user-list.jsp', '/pages/bracket/sys/user-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('71', '/user/load/page.action', '/user/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('72', '/pages/bracket/sys/user-add.jsp', '/pages/bracket/sys/user-add.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('73', '/user/add.action', '/user/add.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('74', '/pages/bracket/sys/user-update.jsp', '/pages/bracket/sys/user-update.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('75', '/user/load/id.action', '/user/load/id.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('76', '/user/update.action', '/user/update.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('77', '/user/remove.action', '/user/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('78', '/pages/bracket/sys/user-conf.jsp', '/pages/bracket/sys/user-conf.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('79', '/ur/load/page.action', '/ur/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('80', '/ur/remove.action', '/ur/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('81', '/ur/add.action', '/ur/add.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('82', '/resource/group.action', '/resource/group.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('83', '/pages/bracket/sys/url-dialog-list.jsp', '/pages/bracket/sys/url-dialog-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('84', '/auth/group.action', '/auth/group.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('85', '/j_spring_security_check', '/j_spring_security_check', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('89', '/redirect/redirect/pages.bracket.index/jsp.action', '/redirect/redirect/pages.bracket.index/jsp.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('90', '/pages/bracket/index.jsp', '/pages/bracket/index.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('91', '/url/mark.action', '/url/mark.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('92', '/url/remove.action', '/url/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('93', '/pages/index.jsp', '/pages/index.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('94', '/errors/sessionTimeout.html', '/errors/sessionTimeout.html', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('95', '/index.jsp', '/index.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('96', '/user/auths.action', '/user/auths.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('99', '/pages/bracket/Chinese.json', '/pages/bracket/Chinese.json', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('101', '/j_spring_security_logout', '/j_spring_security_logout', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('102', '/errors/secondLogin.html', '/errors/secondLogin.html', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '0', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('103', '/pages/bracket/sys/columns-list.jsp', '/pages/bracket/sys/columns-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('105', '/columns/load/page.action', '/columns/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('106', '/columns/load/columns.action', '/columns/load/columns.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('107', '/pages/bracket/column-list.jsp', '/pages/bracket/column-list.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('108', '/pages/bracket/sys/columns-conf.jsp', '/pages/bracket/sys/columns-conf.jsp', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('110', '/schema/load/page.action', '/schema/load/page.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('111', '/columns/conf.action', '/columns/conf.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('112', '/columns/remove.action', '/columns/remove.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('113', '/columns/update.action', '/columns/update.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_url` VALUES ('114', '/columns/copy.action', '/columns/copy.action', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_user
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code_uqe` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of beauty_user
-- ----------------------------
INSERT INTO `beauty_user` VALUES ('1', 'admin', 'admin', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '18888888888', 'admin@163.com', 'I am super admin!', '1980-01-01 00:00:00', 'admin', '2015-10-04 00:31:32', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_user` VALUES ('2', 'frinder', 'frinder', '123456', '0', '18666666666', 'frinder_liu@163.com', 'I am admin!', '1980-01-01 00:00:00', 'admin', '2015-10-18 00:54:30', 'admin', '1', '', '', '1980-01-01 00:00:00');
INSERT INTO `beauty_user` VALUES ('4', 'scott', 'scott', '4QrcOUm6Wau+VuBX8g+IPg==', '0', '', '', '', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00', 'admin', '1', '', '', '1980-01-01 00:00:00');

-- ----------------------------
-- Table structure for beauty_user_extra
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
-- Table structure for beauty_user_role
-- ----------------------------
DROP TABLE IF EXISTS `beauty_user_role`;
CREATE TABLE `beauty_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='一个用户对应多个角色';

-- ----------------------------
-- Records of beauty_user_role
-- ----------------------------
INSERT INTO `beauty_user_role` VALUES ('2', '2', '2');
INSERT INTO `beauty_user_role` VALUES ('3', '1', '1');
INSERT INTO `beauty_user_role` VALUES ('5', '4', '2');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('admin', 'HsaRc4PQuc0v06kdtBhSEQ==', '2C8llEBoc5UsCWfvK0P8tQ==', '2015-10-20 23:16:30');
