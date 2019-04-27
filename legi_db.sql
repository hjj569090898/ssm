/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : legi_db

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 27/04/2019 22:26:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for finance
-- ----------------------------
DROP TABLE IF EXISTS `finance`;
CREATE TABLE `finance`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `admin` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descs` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(60, 0) NOT NULL DEFAULT 0,
  `linked` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of finance
-- ----------------------------
INSERT INTO `finance` VALUES (1, 'hjj123', 'wu', -10086, '1', '2019/3/17');
INSERT INTO `finance` VALUES (2, 'admin', 'asd', 200, '3', '2019/3/18');
INSERT INTO `finance` VALUES (3, 'hjj123', '11', -10086, '1', '2019/3/17');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  `units` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '铁丝', 100, '米', 1);
INSERT INTO `goods` VALUES (2, '砖头', 3000, '块', 1);
INSERT INTO `goods` VALUES (3, '木头', 200, '米', 1);
INSERT INTO `goods` VALUES (4, '石头', 400, '块', 1);
INSERT INTO `goods` VALUES (5, '碎石', 200, '吨', 1);
INSERT INTO `goods` VALUES (6, '沙子', 400, '吨', 1);
INSERT INTO `goods` VALUES (8, '钢筋', 100, '米', 1);
INSERT INTO `goods` VALUES (9, '电线', 4000, '米', 1);
INSERT INTO `goods` VALUES (10, '混泥土', 3000, '吨', 1);
INSERT INTO `goods` VALUES (11, '小型货车2t', 30, '辆', 2);
INSERT INTO `goods` VALUES (19, '1', 1, '1', 1);
INSERT INTO `goods` VALUES (20, '2', 2, '2', 2);
INSERT INTO `goods` VALUES (21, '啥子', 101, 'dw', 1);
INSERT INTO `goods` VALUES (22, '4', 4, '4', 4);
INSERT INTO `goods` VALUES (23, '123', 0, '12', 2);
INSERT INTO `goods` VALUES (24, '123', 1000, '12', 2);
INSERT INTO `goods` VALUES (25, '123', 1000, '12', 2);
INSERT INTO `goods` VALUES (26, '123', 1000, '12', 2);
INSERT INTO `goods` VALUES (27, '123', 1000, '12', 2);

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `groupname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (1, '行政部');
INSERT INTO `group` VALUES (2, '人事部');
INSERT INTO `group` VALUES (3, '仓储部');
INSERT INTO `group` VALUES (4, '财务部');
INSERT INTO `group` VALUES (5, '计划部');
INSERT INTO `group` VALUES (6, '生产部');

-- ----------------------------
-- Table structure for grouppermission
-- ----------------------------
DROP TABLE IF EXISTS `grouppermission`;
CREATE TABLE `grouppermission`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `groupid` int(20) NOT NULL,
  `permission` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grouppermission
-- ----------------------------
INSERT INTO `grouppermission` VALUES (1, 1, 'goods');
INSERT INTO `grouppermission` VALUES (2, 1, 'stockin');
INSERT INTO `grouppermission` VALUES (3, 1, 'stockout');
INSERT INTO `grouppermission` VALUES (4, 1, 'work');
INSERT INTO `grouppermission` VALUES (5, 3, 'goods');
INSERT INTO `grouppermission` VALUES (6, 2, 'user');
INSERT INTO `grouppermission` VALUES (7, 2, 'goods');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` int(20) NOT NULL,
  `permission` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 1, 'goods');
INSERT INTO `permission` VALUES (2, 1, 'finance');
INSERT INTO `permission` VALUES (3, 1, 'qeeq');
INSERT INTO `permission` VALUES (4, 2, '1312');
INSERT INTO `permission` VALUES (5, 2, 'goods');
INSERT INTO `permission` VALUES (6, 3, '112');
INSERT INTO `permission` VALUES (7, 4, '231a');
INSERT INTO `permission` VALUES (8, 3, '2sad');

-- ----------------------------
-- Table structure for progress
-- ----------------------------
DROP TABLE IF EXISTS `progress`;
CREATE TABLE `progress`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `plan_start` datetime(6) NOT NULL,
  `plan_end` datetime(6) NULL DEFAULT NULL,
  `actual_start` datetime(6) NULL DEFAULT NULL,
  `actual_end` datetime(6) NULL DEFAULT NULL,
  `plan_cost` double NULL DEFAULT NULL,
  `actual_cost` double NULL DEFAULT NULL,
  `plan_working` double NULL DEFAULT NULL,
  `actual_working` double NULL DEFAULT NULL,
  `subcontract_cost` double NOT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `project_id` int(11) NOT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `work_progress_project_id_64fd8a30_fk_work_project_project_id`(`project_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of progress
-- ----------------------------
INSERT INTO `progress` VALUES (1, '外部粉刷', '2019-04-15 22:00:26.000000', '2019-04-15 22:00:30.000000', '2019-04-15 22:00:33.000000', '2019-04-15 22:00:35.000000', 1, 1, 1, 1, 1, '1', 1, '1', '1');

-- ----------------------------
-- Table structure for progressgoods
-- ----------------------------
DROP TABLE IF EXISTS `progressgoods`;
CREATE TABLE `progressgoods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `plan_num` int(11) NOT NULL,
  `actual_num` int(11) NOT NULL,
  `progress_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `progressid`(`progress_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pjname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `plan_start` datetime(6) NOT NULL,
  `plan_end` datetime(6) NOT NULL,
  `actual_start` datetime(6) NOT NULL,
  `actual_end` datetime(6) NOT NULL,
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '信息楼外墙维修', '未开工', '2019-05-01 00:00:00.000000', '2019-07-10 00:00:00.000000', '2019-04-23 00:00:00.000000', '2019-06-29 00:00:00.000000', '负责人x');

-- ----------------------------
-- Table structure for stockin
-- ----------------------------
DROP TABLE IF EXISTS `stockin`;
CREATE TABLE `stockin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `price` double NOT NULL,
  `allprice` double NOT NULL,
  `state` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` int(11) NOT NULL,
  `applicant` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stockin
-- ----------------------------
INSERT INTO `stockin` VALUES (1, 100, 50, 5000, '审核中', '财务部', 4, 'admin', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (2, 300, 20, 6000, '申请通过', '财务部', 3, 'hjj', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (3, 300, 20, 6000, '审核中', '财务部', 4, 'admin', '2019-03-03 17:19:55.493733', 'hjjtetstd');
INSERT INTO `stockin` VALUES (4, 100, 22, 2200, '申请通过', '财务部', 8, 'admin', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (5, 300, 20, 6000, '申请失败', '财务部', 1, 'hjj', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (6, 300, 30, 9000, '审核中', '财务部', 9, 'liudehua', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (7, 300, 20, 6000, '申请失败', '财务部', 3, 'admin', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (8, 10, 10, 100, '审核通过', '财务部', 11, 'hjj', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (9, 12, 12, 144, '审核中', '财务部', 5, 'liudehua', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (10, 1, 1, 1, '审核中', '财务部', 1, 'admin2', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (11, 97, 1, 99, '审核中', '财务部', 3, '', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (12, 30, 30, 900, '申请通过', '财务部', 4, '', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (13, 18, 23, 400, '申请失败', '财务部', 8, '', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (16, 10, 44, 440, '审核中', '财务部', 4, '123', '2019-03-07 17:19:55.493733', 'nothing');
INSERT INTO `stockin` VALUES (17, 10, 44, 440, '审核中', '财务部', 4, '123', '2019-03-07 17:19:55.493733', 'nothing');
INSERT INTO `stockin` VALUES (18, 4, 4, 7, '审核中', '财务部', 12, 'hjj', '23点14分', '123asdadd sa d');
INSERT INTO `stockin` VALUES (19, 4, 4, 7, '审核中', '刘德华', 12, 'hjj', '23点14分', '123asdadd sa d');
INSERT INTO `stockin` VALUES (20, 4, 4, 7, NULL, NULL, 12, 'hjj', '23点14分', '123asdadd sa d');
INSERT INTO `stockin` VALUES (21, 10, 10, 10, 'sd', 'sa', 10, 'sad', 'sa', 'asd');
INSERT INTO `stockin` VALUES (22, 10, 10, 10, NULL, NULL, 10, 'sad', 'sa', 'asd');
INSERT INTO `stockin` VALUES (23, 1, 1, 1, '审核中', '管理员', 23, 'hjj', '2019-03-03 17:19:55.493733', '11');
INSERT INTO `stockin` VALUES (24, 1, 1, 1, '审核中', '管理员', 23, 'hjj', '2019-03-03 17:19:55.493733', '11');

-- ----------------------------
-- Table structure for stockout
-- ----------------------------
DROP TABLE IF EXISTS `stockout`;
CREATE TABLE `stockout`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `time` datetime(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodsid` int(11) NOT NULL,
  `progressid` int(11) NULL DEFAULT NULL,
  `projectid` int(11) NOT NULL,
  `applicant` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reason` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goods_stockout_goods_id_9ad80a12_fk_goods_goods_id`(`goodsid`) USING BTREE,
  INDEX `progress`(`progressid`) USING BTREE,
  INDEX `project`(`projectid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stockout
-- ----------------------------
INSERT INTO `stockout` VALUES (1, 100, '2019-04-16 00:00:00.000000', '请求中', '仓储部', 1, 1, 1, '项目负责人', '描述');
INSERT INTO `stockout` VALUES (2, 123, '2019-04-16 00:00:00.000000', '请求中', '仓储部', 3, 1, 2, '项目负责人1', '使用描述');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `groupid` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `username_2`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'A4823A92CB4E699F5822BF6711B163618913067D84534F18', 'hjj', NULL, NULL, NULL, '5690@qq.com', 'hjj1', 1);
INSERT INTO `user` VALUES (2, '977103368E6BF13F4A698298F9480012D73BD5BB59704C0B', 'liudehua', '7', '12', 'hjj', '23点14分', '123asdadd sa d', 2);
INSERT INTO `user` VALUES (3, '83010540897E14664B008599497C22B16A0AF16C87172753', '569090898', '7', '12', 'hjj', '23点14分', '123asdadd sa d', 2);
INSERT INTO `user` VALUES (5, 'E6CE6B098B6507DA23A8C36CE7A51C52005E229723E0A10C', '', NULL, '', 'qqqq', 'qqqq@qqqq.com', 'qqqq', 3);

SET FOREIGN_KEY_CHECKS = 1;
