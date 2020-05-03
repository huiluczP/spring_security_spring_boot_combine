/*
 Navicat Premium Data Transfer

 Source Server         : localconnect
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 03/05/2020 12:45:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_type
-- ----------------------------
DROP TABLE IF EXISTS `role_type`;
CREATE TABLE `role_type`  (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_type
-- ----------------------------
INSERT INTO `role_type` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role_type` VALUES (2, 'ROLE_COMMON_USER');
INSERT INTO `role_type` VALUES (3, 'ROLE_VIP_USER');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES (1, 'mage', '123456', 'test1@qq.com');
INSERT INTO `role_user` VALUES (2, 'xqt', '123456', 'test2@qq.com');
INSERT INTO `role_user` VALUES (3, 'zg', '123456', 'test3@qq.com');

-- ----------------------------
-- Table structure for role_user_role
-- ----------------------------
DROP TABLE IF EXISTS `role_user_role`;
CREATE TABLE `role_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_user_role
-- ----------------------------
INSERT INTO `role_user_role` VALUES (1, 1, 1);
INSERT INTO `role_user_role` VALUES (2, 2, 2);
INSERT INTO `role_user_role` VALUES (3, 3, 3);
INSERT INTO `role_user_role` VALUES (4, 1, 3);

SET FOREIGN_KEY_CHECKS = 1;
