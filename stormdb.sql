/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80400
 Source Host           : localhost:3306
 Source Schema         : stormdb

 Target Server Type    : MySQL
 Target Server Version : 80400
 File Encoding         : 65001

 Date: 26/06/2024 18:40:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stormsettings
-- ----------------------------
DROP TABLE IF EXISTS `stormsettings`;
CREATE TABLE `stormsettings`  (
  `ID` int NOT NULL,
  `RemainingStormTime` int NULL DEFAULT NULL,
  `DefaultStormTime` int NULL DEFAULT NULL,
  `StormActive` tinyint(1) NULL DEFAULT NULL,
  `PlayerDeathCounter` int NULL DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stormsettings
-- ----------------------------
INSERT INTO `stormsettings` VALUES (1, 0, 600, 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
