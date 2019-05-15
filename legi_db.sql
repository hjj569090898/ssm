/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : legi_db

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 15/05/2019 18:05:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attence
-- ----------------------------
DROP TABLE IF EXISTS `attence`;
CREATE TABLE `attence`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(255) NULL DEFAULT NULL,
  `Mattence` int(3) NULL DEFAULT NULL,
  `Rattence` int(3) NULL DEFAULT NULL,
  `leave` double NULL DEFAULT NULL,
  `outwork` double NULL DEFAULT NULL,
  `month` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ispay` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auditing
-- ----------------------------
DROP TABLE IF EXISTS `auditing`;
CREATE TABLE `auditing`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `linked` int(20) NULL DEFAULT 0,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(50, 0) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `applicant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auditing
-- ----------------------------
INSERT INTO `auditing` VALUES (1, 33, '', 5000, '仓储入库', '2019-03-03 17:19:55.493733', '通过', 'admin', '2019/5/7 上午9:52:44', 'hjj', '无建议');
INSERT INTO `auditing` VALUES (2, 34, '', 50001, '仓储入库', '2019-03-03', '不通过', 'admin1', '2019/5/13 下午3:50:57', 'hjj', '无建议12');
INSERT INTO `auditing` VALUES (3, 35, '1231312321', 3, '仓储入库', '2019-03-03 17:19:55.493733', '通过', 'hjj', '2019-05-07-09:45', 'hjj', '122121');
INSERT INTO `auditing` VALUES (4, 36, '520', 520520, '仓储入库', '2019-05-05 ', '通过', 'hjj', '2019/5/7 下午5:14:44', 'hjj', '通过1');
INSERT INTO `auditing` VALUES (8, 9, '999', 999, '个人', '2019-05-10', '通过', 'liudehua', '2019/5/10 下午3:46:21', 'liudehua', '无建议');
INSERT INTO `auditing` VALUES (9, 10, '888', 888, '个人', '2019-05-10', '不通过', 'liudehua', '2019/5/10 下午3:42:10', 'liudehua', 'undefined');
INSERT INTO `auditing` VALUES (10, 11, '1', 1, '个人', '2019-05-10', '通过', 'liudehua', '2019/5/10 下午3:47:24', 'liudehua', '无');
INSERT INTO `auditing` VALUES (11, 12, '56', 56, '个人', '2019-05-10', '通过', 'liudehua', '2019/5/10 下午3:51:20', 'liudehua', 'undefined');
INSERT INTO `auditing` VALUES (12, 13, '车费报销', 15, '个人', '2019-05-11', '通过', 'hjj', '2019/5/11 下午3:18:50', 'hjj', '通过');
INSERT INTO `auditing` VALUES (13, 37, '买货车', 3600, '仓储入库', '2019-05-05 ', '通过', 'hjj', '2019/5/11 下午3:20:16', 'hjj', '通过');
INSERT INTO `auditing` VALUES (14, 1, '512', 152, '工程', '2019-09-09', '审核中', 'qq', '2019sda', NULL, NULL);
INSERT INTO `auditing` VALUES (15, 14, '没原因', 55, '个人', '2019-05-15', '审核中', 'hjj', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `stuff` double(50, 0) NULL DEFAULT NULL,
  `outstuff` double(50, 0) NULL DEFAULT NULL,
  `work` double(50, 0) NULL DEFAULT NULL,
  `outwork` double(50, 0) NULL DEFAULT NULL,
  `others` double(50, 0) NULL DEFAULT NULL,
  `pjstate` double(50, 0) NULL DEFAULT NULL,
  `ctstate` double(50, 0) NULL DEFAULT NULL,
  `allmoney` double(50, 0) NULL DEFAULT NULL,
  `admin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for finance
-- ----------------------------
DROP TABLE IF EXISTS `finance`;
CREATE TABLE `finance`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `admin` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(60, 0) NOT NULL DEFAULT 0,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of finance
-- ----------------------------
INSERT INTO `finance` VALUES (4, 'hjj', ' 建议 无建议12', 5000, '合同结算', '2019-03-03 17:19:55.493733');
INSERT INTO `finance` VALUES (8, 'hjj', '原因 建议 无建议12', 50001, '仓储入库', '2019-03-03');
INSERT INTO `finance` VALUES (9, 'hjj', '原因 建议 无建议12', 50001, '仓储入库', '2019-03-03');
INSERT INTO `finance` VALUES (11, 'hjj', '原因1231312321 建议 122121', 3, '仓储入库', '2019-03-03 17:19:55.493733');
INSERT INTO `finance` VALUES (13, 'hjj', '申请原因:520', 520520, '仓储入库', '2019/5/7 下午4:53:15');
INSERT INTO `finance` VALUES (14, 'hjj', '申请原因:520', 520520, '仓储入库', '2019/5/7 下午5:14:44');
INSERT INTO `finance` VALUES (15, '1', '1', 1, '1', '1');
INSERT INTO `finance` VALUES (16, 'liudehua', '申请原因:56', 56, '个人', '2019/5/10 下午3:51:20');
INSERT INTO `finance` VALUES (17, 'hjj', '申请原因:车费报销', 15, '个人', '2019/5/11 下午3:18:50');
INSERT INTO `finance` VALUES (18, 'hjj', '申请原因:买货车', 3600, '仓储入库', '2019/5/11 下午3:20:16');
INSERT INTO `finance` VALUES (19, 'JJJJane', '工程编号：1的验收结算', 1, '合同结算', '2019-05-13 17:19');
INSERT INTO `finance` VALUES (20, '负责人x', '工程编号：4的验收结算', 1000, '合同结算', '2019-05-15 10:09');
INSERT INTO `finance` VALUES (25, 'hjj', '任务编号：7的总支出', 2050, '工程支出', '2019-05-15 13:28');
INSERT INTO `finance` VALUES (26, 'hjj', '购买铁丝:(130*15.0)', -1950, '仓储', '2019-05-15 16:20');
INSERT INTO `finance` VALUES (27, 'hjj', '购买123:(3*1.0)', -3, '仓储', '2019-05-15 16:42');
INSERT INTO `finance` VALUES (28, 'hjj', '购买库存流水测试:(55*55.0)', 3025, '仓储', '2019-05-15 16:49');

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
  `latelynum` int(20) NULL DEFAULT NULL,
  `latelydate` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '铁丝', 130, '米', 1, 50, '2019-05-14 14:21', 'hjj');
INSERT INTO `goods` VALUES (2, '砖头', 3000, '块', 1, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (3, '木头', 200, '米', 1, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (4, '石头', 600, '块', 1, 100, '2019/5/7 上午9:52:44', 'admin');
INSERT INTO `goods` VALUES (5, '碎石', 200, '吨', 1, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (6, '沙子', 403, '吨', 1, 3, '2019-05-07-09:45', 'hjj');
INSERT INTO `goods` VALUES (8, '钢筋', 100, '米', 1, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (9, '电线', 4000, '米', 1, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (10, '混泥土', 3000, '吨', 1, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (11, '小型货车2t', -10, '辆', 2, -100, '2019/5/12 下午5:12:20', 'hjj');
INSERT INTO `goods` VALUES (19, '1', 1, '1', 1, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (20, '2', 2, '2', 2, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (21, '啥子', 205, 'dw', 1, 52, '2019/5/7 下午5:14:44', 'hjj');
INSERT INTO `goods` VALUES (22, '4', 4, '4', 4, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (23, '123', 0, '12', 2, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (24, '123', 1000, '12', 2, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (25, '123', 1000, '12', 2, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (26, '123', 1000, '12', 2, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (27, '123', 1000, '12', 2, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (28, '铁丝', 130, '米', 1, 130, '2019-05-15 16:20', 'hjj');
INSERT INTO `goods` VALUES (29, '123', 3, '个', 1, 3, '2019-05-15 16:42', 'hjj');
INSERT INTO `goods` VALUES (30, '库存流水测试', 55, '个', 1, 55, '2019-05-15 16:49', 'hjj');

-- ----------------------------
-- Table structure for goodsapply
-- ----------------------------
DROP TABLE IF EXISTS `goodsapply`;
CREATE TABLE `goodsapply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NULL DEFAULT NULL,
  `applynum` int(11) NULL DEFAULT NULL,
  `projectid` int(11) NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `progoodsid` int(11) NULL DEFAULT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsapply
-- ----------------------------
INSERT INTO `goodsapply` VALUES (1, 1, 50, 1, '工程计划所需', '通过', '2019-05-09', 1, '1');
INSERT INTO `goodsapply` VALUES (2, 1, 50, 1, '工程计划所需', '通过', '2019-05-09', 4, 'liudehua');
INSERT INTO `goodsapply` VALUES (3, 4, 20, 1, '工程计划所需', '不通过', '', 5, 'liudehua');
INSERT INTO `goodsapply` VALUES (4, 11, 100, 3, '工程计划所需', '通过', '2019-05-12 17:11', 6, 'hjj');
INSERT INTO `goodsapply` VALUES (5, 1, 60, 1, '需求新增', '不通过', '2019-05-13', 4, 'hjj');
INSERT INTO `goodsapply` VALUES (6, 1, 10, 1, '需求新增', '通过', '2019-05-13 17:38', 1, 'hjj');
INSERT INTO `goodsapply` VALUES (7, 1, 10, 1, '需求新增', '通过', '2019-05-14 09:57', 1, 'hjj');

-- ----------------------------
-- Table structure for goodsflow
-- ----------------------------
DROP TABLE IF EXISTS `goodsflow`;
CREATE TABLE `goodsflow`  (
  `id` int(60) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsflow
-- ----------------------------
INSERT INTO `goodsflow` VALUES (1, 1, -100, '1', '1', '1');
INSERT INTO `goodsflow` VALUES (2, 21, 52, '2019/5/7 下午5:14:44', 'hjj', '52');
INSERT INTO `goodsflow` VALUES (3, 11, 60, '2019/5/11 下午3:20:16', 'hjj', '买货车');
INSERT INTO `goodsflow` VALUES (4, 1, -50, '2019-05-09', '1', '工程计划所需');
INSERT INTO `goodsflow` VALUES (5, 11, -100, '2019/5/12 下午5:12:20', 'hjj', '工程计划所需');
INSERT INTO `goodsflow` VALUES (6, 1, 50, '2019-05-13', 'super', '工程退料');
INSERT INTO `goodsflow` VALUES (7, 1, 50, '2019-05-13', 'super', '工程退料');
INSERT INTO `goodsflow` VALUES (8, 1, -10, '2019/5/13 下午5:39:29', 'hjj', '需求新增');
INSERT INTO `goodsflow` VALUES (9, 1, -10, '2019/5/14 上午9:57:34', 'hjj', '需求新增');
INSERT INTO `goodsflow` VALUES (10, 1, -50, '2019/5/14 上午10:03:08', 'liudehua', '工程计划所需');
INSERT INTO `goodsflow` VALUES (11, 1, 1, '1', '1', '1');
INSERT INTO `goodsflow` VALUES (12, 1, 50, '2019-05-14 14:21', 'hjj', '工程退料');
INSERT INTO `goodsflow` VALUES (13, 30, 55, '2019-05-15 16:49', 'hjj', '商品入仓');

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
INSERT INTO `group` VALUES (5, '工程部');
INSERT INTO `group` VALUES (6, '其他');

-- ----------------------------
-- Table structure for grouppermission
-- ----------------------------
DROP TABLE IF EXISTS `grouppermission`;
CREATE TABLE `grouppermission`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `groupid` int(20) NOT NULL,
  `permission` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grouppermission
-- ----------------------------
INSERT INTO `grouppermission` VALUES (1, 1, 'auditing');
INSERT INTO `grouppermission` VALUES (2, 1, 'finance');
INSERT INTO `grouppermission` VALUES (3, 1, 'goods');
INSERT INTO `grouppermission` VALUES (4, 1, 'stockin');
INSERT INTO `grouppermission` VALUES (5, 1, 'goodsapply');
INSERT INTO `grouppermission` VALUES (6, 1, 'goodsflow');
INSERT INTO `grouppermission` VALUES (7, 1, 'project');
INSERT INTO `grouppermission` VALUES (8, 1, 'progress');
INSERT INTO `grouppermission` VALUES (9, 1, 'getuser');
INSERT INTO `grouppermission` VALUES (10, 1, 'register');
INSERT INTO `grouppermission` VALUES (11, 1, 'deleteuser');
INSERT INTO `grouppermission` VALUES (12, 1, 'addpermission');
INSERT INTO `grouppermission` VALUES (13, 2, 'getuser');
INSERT INTO `grouppermission` VALUES (14, 2, 'register');
INSERT INTO `grouppermission` VALUES (15, 2, 'deleteuser');
INSERT INTO `grouppermission` VALUES (16, 2, 'addpermission');
INSERT INTO `grouppermission` VALUES (17, 3, 'goods');
INSERT INTO `grouppermission` VALUES (18, 3, 'stockin');
INSERT INTO `grouppermission` VALUES (19, 3, 'goodsapply');
INSERT INTO `grouppermission` VALUES (20, 3, 'goodsflow');
INSERT INTO `grouppermission` VALUES (21, 4, 'auditing');
INSERT INTO `grouppermission` VALUES (22, 4, 'finance');
INSERT INTO `grouppermission` VALUES (23, 5, 'project');
INSERT INTO `grouppermission` VALUES (24, 5, 'progress');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` int(20) NOT NULL,
  `permission` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 2, 'auditing');
INSERT INTO `permission` VALUES (38, 1226, 'project');
INSERT INTO `permission` VALUES (39, 1226, 'progress');
INSERT INTO `permission` VALUES (40, 1227, 'getuser');
INSERT INTO `permission` VALUES (41, 1227, 'register');
INSERT INTO `permission` VALUES (42, 1227, 'deleteuser');
INSERT INTO `permission` VALUES (43, 1227, 'addpermission');

-- ----------------------------
-- Table structure for permissioninfo
-- ----------------------------
DROP TABLE IF EXISTS `permissioninfo`;
CREATE TABLE `permissioninfo`  (
  `id` int(40) NOT NULL,
  `permiss` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissioninfo
-- ----------------------------
INSERT INTO `permissioninfo` VALUES (1, 'goods', '库存管理');
INSERT INTO `permissioninfo` VALUES (2, 'stockin', '入库管理');
INSERT INTO `permissioninfo` VALUES (3, 'goodsapply', '出库管理');
INSERT INTO `permissioninfo` VALUES (4, 'goodsflow', '库存流水');
INSERT INTO `permissioninfo` VALUES (5, 'project', '工程管理');
INSERT INTO `permissioninfo` VALUES (6, 'progress', '任务管理');
INSERT INTO `permissioninfo` VALUES (7, 'getuser', '人员查看');
INSERT INTO `permissioninfo` VALUES (8, 'register', '注册功能');
INSERT INTO `permissioninfo` VALUES (9, 'deleteuser', '账户删除');
INSERT INTO `permissioninfo` VALUES (10, 'addpermission', '用户权限修改');
INSERT INTO `permissioninfo` VALUES (11, 'finance', '财务流水');
INSERT INTO `permissioninfo` VALUES (12, 'auditing', '财务审核');

-- ----------------------------
-- Table structure for pimage
-- ----------------------------
DROP TABLE IF EXISTS `pimage`;
CREATE TABLE `pimage`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `projectid` int(30) NOT NULL,
  `imageurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pimage
-- ----------------------------
INSERT INTO `pimage` VALUES (5, 1, './static/image/1-201905111535-da4e2f18.png');
INSERT INTO `pimage` VALUES (8, 1, './static/image/1-201905141402-38393be1.jpg');
INSERT INTO `pimage` VALUES (10, 1, './static/image/1-201905141403-cbd3d20c.jpg');
INSERT INTO `pimage` VALUES (12, 1, './static/image/1-201905151331-496eef8c.png');
INSERT INTO `pimage` VALUES (14, 1, './static/image/1-201905151334-469fc775.png');

-- ----------------------------
-- Table structure for progress
-- ----------------------------
DROP TABLE IF EXISTS `progress`;
CREATE TABLE `progress`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `planstart` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `planend` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `actualstart` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `actualend` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plancost` double NULL DEFAULT NULL,
  `actualcost` double NULL DEFAULT NULL,
  `planworking` double NULL DEFAULT NULL,
  `actualworking` double NULL DEFAULT NULL,
  `subcontractcost` double NULL DEFAULT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `projectid` int(11) NOT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `percent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `work_progress_project_id_64fd8a30_fk_work_project_project_id`(`projectid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of progress
-- ----------------------------
INSERT INTO `progress` VALUES (1, '外部粉刷', '2019-04-15', '2019-04-15 22:00:30.000000', '2019-04-15 22:00:33.000000', '2019-04-15 22:00:35.000000', 100, 60, 100, 50, 1, '已完工', 1, '1', '1', '30');
INSERT INTO `progress` VALUES (2, 'ads', 'asda', 'asda', 'asda', 'dasd', 150, 60, 100, 100, 1, '1', 1, '1', '1', '50');
INSERT INTO `progress` VALUES (3, '3', '3', '3', '3', '3', 3, 3, 30, 30, 3, '3', 3, '3', '3', '50');
INSERT INTO `progress` VALUES (5, '外部粉刷', '2019-04-15', '2019-05-15 ', '2019-04-15 ', '2019-05-15', 100, 60, 100, 50, 1, '1', 2, '1', '1', '30');
INSERT INTO `progress` VALUES (6, '测试', '2019-05-09', '2019-05-16', '2019-05-10', '2019-05-24', 100, 101, 102, 103, 104, '未开工', 1, 'hjj', '1', '10');
INSERT INTO `progress` VALUES (7, '测试', '2019-05-09', '2019-05-16', '2019-05-10', '2019-05-24', 1000, 1010, 1020, 1030, 1040, '已完工', 1, 'hjj', '2019-05-15 13:28', '10');
INSERT INTO `progress` VALUES (8, '5-10', '2019-05-23', '2019-07-19', '2019-05-15', '2019-05-28', 1, 2, 3, 4, 5, '施工中', 1, 'liudehua', '2019-05-10', '7');
INSERT INTO `progress` VALUES (9, '测试第二', '2019-05-14', '2019-05-24', '2019-05-15', '2019-05-24', 10, NULL, 50, NULL, NULL, '未开工', 1, 'hjj', '2019-05-15 13:30', '0');

-- ----------------------------
-- Table structure for progressgoods
-- ----------------------------
DROP TABLE IF EXISTS `progressgoods`;
CREATE TABLE `progressgoods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NOT NULL,
  `plannum` int(11) NOT NULL,
  `actualnum` int(11) NOT NULL,
  `projectid` int(11) NOT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `applynum` int(55) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `progressid`(`projectid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of progressgoods
-- ----------------------------
INSERT INTO `progressgoods` VALUES (1, 1, 150, 90, 1, '2019-05-14 09:57', 100);
INSERT INTO `progressgoods` VALUES (3, 1, 150, 60, 1, '2019-05-09', 50);
INSERT INTO `progressgoods` VALUES (4, 1, 150, 100, 1, '2019-05-14 14:21', 0);
INSERT INTO `progressgoods` VALUES (5, 4, 100, 200, 1, '', 0);
INSERT INTO `progressgoods` VALUES (6, 11, 500, 100, 3, '2019-05-12 17:11', 0);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pjname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `planstart` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `planend` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `actualstart` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `actualend` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` float(255, 0) NULL DEFAULT NULL,
  `pnow` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '信息楼外墙维修1', '延期', '2019-05-09', '2019-06-28', '2019-04-19', '2019-06-29', 'JJJJane', 1, '已验收');
INSERT INTO `project` VALUES (2, '1', '2', '3', '3', NULL, NULL, '5', 600, '7');
INSERT INTO `project` VALUES (3, '1', '2', '2019-05-01', '2019-05-01', NULL, NULL, '5', 6, '7');
INSERT INTO `project` VALUES (4, '信息楼外墙维修', '正常', '2019-05-01', '2019-05-01', '2019-08-07', '2019-05-07', '负责人x', 1000, '已验收');
INSERT INTO `project` VALUES (5, '测试', '提前', '2019-05-07', '2019-05-24', '2019-05-06', '2019-06-05', '我', 0, '施工中');
INSERT INTO `project` VALUES (6, '测试', '正常', '2019-05-09', '2019-05-17', '2019-05-14', NULL, '我', 1, '施工中');

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
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stockin
-- ----------------------------
INSERT INTO `stockin` VALUES (1, 100, 45, 5000, '审核中', '财务部', 4, 'admin', '2019-05-06 ', '');
INSERT INTO `stockin` VALUES (2, 300, 20, 6000, '申请通过', '财务部', 3, 'hjj', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (3, 300, 20, 6000, '审核中', '财务部', 4, 'admin', '2019-03-03 17:19:55.493733', 'hjjtetstd');
INSERT INTO `stockin` VALUES (4, 100, 22, 2200, '申请通过', '财务部', 8, 'admin', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (5, 300, 20, 6000, '申请失败', '财务部', 1, 'hjj', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (6, 300, 30, 9000, '审核中', '财务部', 9, 'liudehua', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (7, 301, 20, 6000, '申请失败', '财务部', 3, 'admin', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (8, 10, 10, 100, '申请通过', '财务部', 11, 'hjj', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (9, 12, 12, 144, '审核中', '财务部', 5, 'liudehua', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (10, 1, 1, 1, '审核中', '财务部', 1, 'admin2', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (11, 97, 1, 99, '审核中', '财务部', 3, '', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (12, 30, 30, 900, '申请通过', '财务部', 4, '', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (13, 18, 23, 400, '申请失败', '财务部', 8, '', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (16, 10, 44, 440, '审核中', '财务部', 4, '123', '2019-03-07 17:19:55.493733', 'nothing');
INSERT INTO `stockin` VALUES (17, 10, 44, 440, '审核中', '财务部', 4, '123', '2019-03-07 17:19:55.493733', 'nothing');
INSERT INTO `stockin` VALUES (18, 4, 4, 7, '审核中', '财务部', 12, 'hjj', '23点14分', '123asdadd sa d');
INSERT INTO `stockin` VALUES (19, 4, 4, 7, '审核中', '刘德华', 12, 'hjj', '23点14分', '123asdadd sa d');
INSERT INTO `stockin` VALUES (20, 4, 4, 7, '申请通过', NULL, 12, 'hjj', '23点14分', '123asdadd sa d');
INSERT INTO `stockin` VALUES (21, 10, 10, 10, '申请通过', 'sa', 10, 'sad', 'sa', 'asd');
INSERT INTO `stockin` VALUES (22, 10, 10, 10, '申请通过', NULL, 10, 'sad', 'sa', 'asd');
INSERT INTO `stockin` VALUES (23, 1, 1, 1, '审核中', '管理员', 23, 'hjj', '2019-03-03 17:19:55.493733', '11');
INSERT INTO `stockin` VALUES (33, 100, 50, 5000, '申请通过', '财务部', 4, 'admin', '2019-03-03 17:19:55.493733', '');
INSERT INTO `stockin` VALUES (34, 100, 50, 50001, '申请失败', '财务部', 4, 'admin1', '2019-03-03', '');
INSERT INTO `stockin` VALUES (35, 3, 3, 3, '申请通过', '管理员', 6, 'hjj', '2019-03-03 17:19:55.493733', '1231312321');
INSERT INTO `stockin` VALUES (36, 52, 52, 5252, '申请通过', '管理员', 21, 'hjj', '2019-05-05 ', '52');
INSERT INTO `stockin` VALUES (37, 60, 60, 3600, '申请通过', '管理员', 11, 'hjj', '2019-05-05 ', '买货车');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1229 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'A4823A92CB4E699F5822BF6711B163618913067D84534F18', 'hjj', '96-09-25', '44142119961234567X', '13112345678', '5690@qq.com', 'JJJJJJane', 1);
INSERT INTO `user` VALUES (2, '977103368E6BF13F4A698298F9480012D73BD5BB59704C0B', 'liudehua', '97-01-02', '123456789987654321', '010-123456', 'zz@qq.com', '刘德华', 2);
INSERT INTO `user` VALUES (3, 'A4823A92CB4E699F5822BF6711B163618913067D84534F18', '569090898', '90-05-05', '123456789123456789', '13800138000', 'qq@qq.com', '无名', 3);
INSERT INTO `user` VALUES (1227, '78C093682E88130660040045198603F8D92168BD81543651', 'cxk', '1991-2-2', 'adsa', '1311265535', '123456@11.com', 'adsa', 4);
INSERT INTO `user` VALUES (1228, '47F832A6131ED05A5548F64A86EA3594465BC1DC16F68D63', 'liudehua112321', NULL, '21321', '122131', '123@qq.com', '21321', 3);

-- ----------------------------
-- Table structure for userapply
-- ----------------------------
DROP TABLE IF EXISTS `userapply`;
CREATE TABLE `userapply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `money` int(11) NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audidate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userapply
-- ----------------------------
INSERT INTO `userapply` VALUES (1, 1, 100, '审核中', '100', '100', NULL);
INSERT INTO `userapply` VALUES (2, 2, 501, '审核中', '2019-5-111', '报销车费1', NULL);
INSERT INTO `userapply` VALUES (3, 2, 500, '审核中', NULL, '200', NULL);
INSERT INTO `userapply` VALUES (4, 2, 500, '审核中', NULL, '600', NULL);
INSERT INTO `userapply` VALUES (5, 2, 111, '审核中', NULL, '111', NULL);
INSERT INTO `userapply` VALUES (6, 2, 666, '审核中', '2019-05-10', '666', NULL);
INSERT INTO `userapply` VALUES (7, 2, 600, '审核中', '2019-05-10', '600', NULL);
INSERT INTO `userapply` VALUES (8, 2, 777, '审核中', '2019-05-10', '777', NULL);
INSERT INTO `userapply` VALUES (9, 2, 999, '审核中', '2019-05-10', '999', NULL);
INSERT INTO `userapply` VALUES (10, 2, 888, '审核中', '2019-05-10', '888', NULL);
INSERT INTO `userapply` VALUES (11, 2, 1, '审核中', '2019-05-10', '1', NULL);
INSERT INTO `userapply` VALUES (12, 2, 56, '通过', '2019-05-10', '56', '2019-05-10');
INSERT INTO `userapply` VALUES (13, 1, 15, '通过', '2019-05-11', '车费报销', '2019-05-11');
INSERT INTO `userapply` VALUES (14, 1, 55, '审核中', '2019-05-15', '没原因', '');

SET FOREIGN_KEY_CHECKS = 1;
