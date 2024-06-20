/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80400
 Source Host           : localhost:3306
 Source Schema         : insomniadb

 Target Server Type    : MySQL
 Target Server Version : 80400
 File Encoding         : 65001

 Date: 19/06/2024 18:01:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dif_bee_settings
-- ----------------------------
DROP TABLE IF EXISTS `dif_bee_settings`;
CREATE TABLE `dif_bee_settings`  (
  `ID` int NOT NULL,
  `Hostility` tinyint(1) NULL DEFAULT NULL,
  `Strength` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dif_bee_settings
-- ----------------------------
INSERT INTO `dif_bee_settings` VALUES (1, 0, 0);
INSERT INTO `dif_bee_settings` VALUES (2, 0, 0);
INSERT INTO `dif_bee_settings` VALUES (3, 0, 0);
INSERT INTO `dif_bee_settings` VALUES (4, 0, 0);
INSERT INTO `dif_bee_settings` VALUES (5, 0, 0);
INSERT INTO `dif_bee_settings` VALUES (6, 0, 0);
INSERT INTO `dif_bee_settings` VALUES (7, 0, 0);
INSERT INTO `dif_bee_settings` VALUES (8, 0, 5);
INSERT INTO `dif_bee_settings` VALUES (9, 0, 5);
INSERT INTO `dif_bee_settings` VALUES (10, 1, 5);

-- ----------------------------
-- Table structure for diff_blaze_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_blaze_settings`;
CREATE TABLE `diff_blaze_settings`  (
  `ID` int NOT NULL,
  `Invulnerability` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_blaze_settings
-- ----------------------------
INSERT INTO `diff_blaze_settings` VALUES (1, 0);
INSERT INTO `diff_blaze_settings` VALUES (2, 0);
INSERT INTO `diff_blaze_settings` VALUES (3, 0);
INSERT INTO `diff_blaze_settings` VALUES (4, 0);
INSERT INTO `diff_blaze_settings` VALUES (5, 0);
INSERT INTO `diff_blaze_settings` VALUES (6, 0);
INSERT INTO `diff_blaze_settings` VALUES (7, 1);
INSERT INTO `diff_blaze_settings` VALUES (8, 1);
INSERT INTO `diff_blaze_settings` VALUES (9, 1);
INSERT INTO `diff_blaze_settings` VALUES (10, 1);

-- ----------------------------
-- Table structure for diff_creeper_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_creeper_settings`;
CREATE TABLE `diff_creeper_settings`  (
  `ID` int NOT NULL,
  `Fuse` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_creeper_settings
-- ----------------------------
INSERT INTO `diff_creeper_settings` VALUES (1, 0);
INSERT INTO `diff_creeper_settings` VALUES (2, 0);
INSERT INTO `diff_creeper_settings` VALUES (3, 0);
INSERT INTO `diff_creeper_settings` VALUES (4, 0);
INSERT INTO `diff_creeper_settings` VALUES (5, 0);
INSERT INTO `diff_creeper_settings` VALUES (6, 0);
INSERT INTO `diff_creeper_settings` VALUES (7, 5);
INSERT INTO `diff_creeper_settings` VALUES (8, 5);
INSERT INTO `diff_creeper_settings` VALUES (9, 5);
INSERT INTO `diff_creeper_settings` VALUES (10, 5);

-- ----------------------------
-- Table structure for diff_drowned_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_drowned_settings`;
CREATE TABLE `diff_drowned_settings`  (
  `ID` int NOT NULL,
  `Trident` tinyint(1) NULL DEFAULT NULL,
  `Channeling` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_drowned_settings
-- ----------------------------
INSERT INTO `diff_drowned_settings` VALUES (1, 0, 0);
INSERT INTO `diff_drowned_settings` VALUES (2, 0, 0);
INSERT INTO `diff_drowned_settings` VALUES (3, 0, 0);
INSERT INTO `diff_drowned_settings` VALUES (4, 0, 0);
INSERT INTO `diff_drowned_settings` VALUES (5, 0, 0);
INSERT INTO `diff_drowned_settings` VALUES (6, 0, 0);
INSERT INTO `diff_drowned_settings` VALUES (7, 1, 1);
INSERT INTO `diff_drowned_settings` VALUES (8, 1, 1);
INSERT INTO `diff_drowned_settings` VALUES (9, 1, 1);
INSERT INTO `diff_drowned_settings` VALUES (10, 1, 1);

-- ----------------------------
-- Table structure for diff_elderguardian_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_elderguardian_settings`;
CREATE TABLE `diff_elderguardian_settings`  (
  `ID` int NOT NULL,
  `Resistance` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_elderguardian_settings
-- ----------------------------
INSERT INTO `diff_elderguardian_settings` VALUES (1, 0);
INSERT INTO `diff_elderguardian_settings` VALUES (2, 0);
INSERT INTO `diff_elderguardian_settings` VALUES (3, 0);
INSERT INTO `diff_elderguardian_settings` VALUES (4, 0);
INSERT INTO `diff_elderguardian_settings` VALUES (5, 0);
INSERT INTO `diff_elderguardian_settings` VALUES (6, 0);
INSERT INTO `diff_elderguardian_settings` VALUES (7, 0);
INSERT INTO `diff_elderguardian_settings` VALUES (8, 2);
INSERT INTO `diff_elderguardian_settings` VALUES (9, 2);
INSERT INTO `diff_elderguardian_settings` VALUES (10, 2);

-- ----------------------------
-- Table structure for diff_enderman_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_enderman_settings`;
CREATE TABLE `diff_enderman_settings`  (
  `ID` int NOT NULL,
  `Speed` int NULL DEFAULT NULL,
  `Strength` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_enderman_settings
-- ----------------------------
INSERT INTO `diff_enderman_settings` VALUES (1, 0, 0);
INSERT INTO `diff_enderman_settings` VALUES (2, 0, 0);
INSERT INTO `diff_enderman_settings` VALUES (3, 0, 0);
INSERT INTO `diff_enderman_settings` VALUES (4, 0, 0);
INSERT INTO `diff_enderman_settings` VALUES (5, 0, 0);
INSERT INTO `diff_enderman_settings` VALUES (6, 0, 0);
INSERT INTO `diff_enderman_settings` VALUES (7, 0, 0);
INSERT INTO `diff_enderman_settings` VALUES (8, 0, 0);
INSERT INTO `diff_enderman_settings` VALUES (9, 1, 2);
INSERT INTO `diff_enderman_settings` VALUES (10, 1, 2);

-- ----------------------------
-- Table structure for diff_endermite_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_endermite_settings`;
CREATE TABLE `diff_endermite_settings`  (
  `ID` int NOT NULL,
  `Invulnerability` tinyint(1) NULL DEFAULT NULL,
  `Strength` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_endermite_settings
-- ----------------------------
INSERT INTO `diff_endermite_settings` VALUES (1, 0, 0);
INSERT INTO `diff_endermite_settings` VALUES (2, 0, 0);
INSERT INTO `diff_endermite_settings` VALUES (3, 0, 0);
INSERT INTO `diff_endermite_settings` VALUES (4, 0, 0);
INSERT INTO `diff_endermite_settings` VALUES (5, 0, 0);
INSERT INTO `diff_endermite_settings` VALUES (6, 0, 0);
INSERT INTO `diff_endermite_settings` VALUES (7, 0, 0);
INSERT INTO `diff_endermite_settings` VALUES (8, 1, 2);
INSERT INTO `diff_endermite_settings` VALUES (9, 1, 2);
INSERT INTO `diff_endermite_settings` VALUES (10, 1, 2);

-- ----------------------------
-- Table structure for diff_ghast_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_ghast_settings`;
CREATE TABLE `diff_ghast_settings`  (
  `ID` int NOT NULL,
  `ExplosionPower` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_ghast_settings
-- ----------------------------
INSERT INTO `diff_ghast_settings` VALUES (1, 0);
INSERT INTO `diff_ghast_settings` VALUES (2, 0);
INSERT INTO `diff_ghast_settings` VALUES (3, 0);
INSERT INTO `diff_ghast_settings` VALUES (4, 0);
INSERT INTO `diff_ghast_settings` VALUES (5, 0);
INSERT INTO `diff_ghast_settings` VALUES (6, 0);
INSERT INTO `diff_ghast_settings` VALUES (7, 1);
INSERT INTO `diff_ghast_settings` VALUES (8, 2);
INSERT INTO `diff_ghast_settings` VALUES (9, 3);
INSERT INTO `diff_ghast_settings` VALUES (10, 4);

-- ----------------------------
-- Table structure for diff_guardian_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_guardian_settings`;
CREATE TABLE `diff_guardian_settings`  (
  `ID` int NOT NULL,
  `Resistance` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_guardian_settings
-- ----------------------------
INSERT INTO `diff_guardian_settings` VALUES (1, 0);
INSERT INTO `diff_guardian_settings` VALUES (2, 0);
INSERT INTO `diff_guardian_settings` VALUES (3, 0);
INSERT INTO `diff_guardian_settings` VALUES (4, 0);
INSERT INTO `diff_guardian_settings` VALUES (5, 0);
INSERT INTO `diff_guardian_settings` VALUES (6, 0);
INSERT INTO `diff_guardian_settings` VALUES (7, 0);
INSERT INTO `diff_guardian_settings` VALUES (8, 2);
INSERT INTO `diff_guardian_settings` VALUES (9, 2);
INSERT INTO `diff_guardian_settings` VALUES (10, 2);

-- ----------------------------
-- Table structure for diff_hoglin_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_hoglin_settings`;
CREATE TABLE `diff_hoglin_settings`  (
  `ID` int NOT NULL,
  `Punch` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_hoglin_settings
-- ----------------------------
INSERT INTO `diff_hoglin_settings` VALUES (1, 0);
INSERT INTO `diff_hoglin_settings` VALUES (2, 0);
INSERT INTO `diff_hoglin_settings` VALUES (3, 0);
INSERT INTO `diff_hoglin_settings` VALUES (4, 0);
INSERT INTO `diff_hoglin_settings` VALUES (5, 0);
INSERT INTO `diff_hoglin_settings` VALUES (6, 0);
INSERT INTO `diff_hoglin_settings` VALUES (7, 0);
INSERT INTO `diff_hoglin_settings` VALUES (8, 2);
INSERT INTO `diff_hoglin_settings` VALUES (9, 2);
INSERT INTO `diff_hoglin_settings` VALUES (10, 2);

-- ----------------------------
-- Table structure for diff_husk_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_husk_settings`;
CREATE TABLE `diff_husk_settings`  (
  `ID` int NOT NULL,
  `AxeMaterial` int NULL DEFAULT NULL,
  `Sharpness` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_husk_settings
-- ----------------------------
INSERT INTO `diff_husk_settings` VALUES (1, 0, 0);
INSERT INTO `diff_husk_settings` VALUES (2, 0, 0);
INSERT INTO `diff_husk_settings` VALUES (3, 0, 0);
INSERT INTO `diff_husk_settings` VALUES (4, 0, 0);
INSERT INTO `diff_husk_settings` VALUES (5, 0, 0);
INSERT INTO `diff_husk_settings` VALUES (6, 0, 0);
INSERT INTO `diff_husk_settings` VALUES (7, 0, 0);
INSERT INTO `diff_husk_settings` VALUES (8, 4, 2);
INSERT INTO `diff_husk_settings` VALUES (9, 4, 2);
INSERT INTO `diff_husk_settings` VALUES (10, 4, 2);

-- ----------------------------
-- Table structure for diff_irongolem_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_irongolem_settings`;
CREATE TABLE `diff_irongolem_settings`  (
  `ID` int NOT NULL,
  `FireResistance` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_irongolem_settings
-- ----------------------------
INSERT INTO `diff_irongolem_settings` VALUES (1, 0);
INSERT INTO `diff_irongolem_settings` VALUES (2, 0);
INSERT INTO `diff_irongolem_settings` VALUES (3, 0);
INSERT INTO `diff_irongolem_settings` VALUES (4, 0);
INSERT INTO `diff_irongolem_settings` VALUES (5, 0);
INSERT INTO `diff_irongolem_settings` VALUES (6, 0);
INSERT INTO `diff_irongolem_settings` VALUES (7, 1);
INSERT INTO `diff_irongolem_settings` VALUES (8, 1);
INSERT INTO `diff_irongolem_settings` VALUES (9, 1);
INSERT INTO `diff_irongolem_settings` VALUES (10, 1);

-- ----------------------------
-- Table structure for diff_magmacube_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_magmacube_settings`;
CREATE TABLE `diff_magmacube_settings`  (
  `ID` int NOT NULL,
  `Punch` int NULL DEFAULT NULL,
  `Strength` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_magmacube_settings
-- ----------------------------
INSERT INTO `diff_magmacube_settings` VALUES (1, 0, 0);
INSERT INTO `diff_magmacube_settings` VALUES (2, 0, 0);
INSERT INTO `diff_magmacube_settings` VALUES (3, 0, 0);
INSERT INTO `diff_magmacube_settings` VALUES (4, 0, 0);
INSERT INTO `diff_magmacube_settings` VALUES (5, 0, 0);
INSERT INTO `diff_magmacube_settings` VALUES (6, 0, 0);
INSERT INTO `diff_magmacube_settings` VALUES (7, 3, 0);
INSERT INTO `diff_magmacube_settings` VALUES (8, 3, 0);
INSERT INTO `diff_magmacube_settings` VALUES (9, 3, 2);
INSERT INTO `diff_magmacube_settings` VALUES (10, 3, 2);

-- ----------------------------
-- Table structure for diff_phantom_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_phantom_settings`;
CREATE TABLE `diff_phantom_settings`  (
  `ID` int NOT NULL,
  `Size` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_phantom_settings
-- ----------------------------
INSERT INTO `diff_phantom_settings` VALUES (1, 0);
INSERT INTO `diff_phantom_settings` VALUES (2, 0);
INSERT INTO `diff_phantom_settings` VALUES (3, 0);
INSERT INTO `diff_phantom_settings` VALUES (4, 0);
INSERT INTO `diff_phantom_settings` VALUES (5, 0);
INSERT INTO `diff_phantom_settings` VALUES (6, 0);
INSERT INTO `diff_phantom_settings` VALUES (7, 0);
INSERT INTO `diff_phantom_settings` VALUES (8, 0);
INSERT INTO `diff_phantom_settings` VALUES (9, 0);
INSERT INTO `diff_phantom_settings` VALUES (10, 10);

-- ----------------------------
-- Table structure for diff_piglin_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_piglin_settings`;
CREATE TABLE `diff_piglin_settings`  (
  `ID` int NOT NULL,
  `SwordMaterial` int NULL DEFAULT NULL,
  `QuickCharge` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  CONSTRAINT `diff_piglin_settings_chk_1` CHECK (`SwordMaterial` between 0 and 6),
  CONSTRAINT `diff_piglin_settings_chk_2` CHECK (`QuickCharge` between 0 and 3)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_piglin_settings
-- ----------------------------
INSERT INTO `diff_piglin_settings` VALUES (1, 0, 0);
INSERT INTO `diff_piglin_settings` VALUES (2, 0, 0);
INSERT INTO `diff_piglin_settings` VALUES (3, 0, 0);
INSERT INTO `diff_piglin_settings` VALUES (4, 0, 0);
INSERT INTO `diff_piglin_settings` VALUES (5, 0, 0);
INSERT INTO `diff_piglin_settings` VALUES (6, 0, 0);
INSERT INTO `diff_piglin_settings` VALUES (7, 0, 0);
INSERT INTO `diff_piglin_settings` VALUES (8, 6, 3);
INSERT INTO `diff_piglin_settings` VALUES (9, 6, 3);
INSERT INTO `diff_piglin_settings` VALUES (10, 6, 3);

-- ----------------------------
-- Table structure for diff_piglinbrute_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_piglinbrute_settings`;
CREATE TABLE `diff_piglinbrute_settings`  (
  `ID` int NOT NULL,
  `SpawnQuantity` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  CONSTRAINT `diff_piglinbrute_settings_chk_1` CHECK (`SpawnQuantity` between 0 and 3)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_piglinbrute_settings
-- ----------------------------
INSERT INTO `diff_piglinbrute_settings` VALUES (1, 0);
INSERT INTO `diff_piglinbrute_settings` VALUES (2, 0);
INSERT INTO `diff_piglinbrute_settings` VALUES (3, 0);
INSERT INTO `diff_piglinbrute_settings` VALUES (4, 0);
INSERT INTO `diff_piglinbrute_settings` VALUES (5, 0);
INSERT INTO `diff_piglinbrute_settings` VALUES (6, 0);
INSERT INTO `diff_piglinbrute_settings` VALUES (7, 0);
INSERT INTO `diff_piglinbrute_settings` VALUES (8, 2);
INSERT INTO `diff_piglinbrute_settings` VALUES (9, 2);
INSERT INTO `diff_piglinbrute_settings` VALUES (10, 2);

-- ----------------------------
-- Table structure for diff_pillager_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_pillager_settings`;
CREATE TABLE `diff_pillager_settings`  (
  `ID` int NOT NULL,
  `DoubleDamage` tinyint(1) NULL DEFAULT NULL,
  `CriticPercentage` int NULL DEFAULT NULL,
  `ArrowEffectInstantDamage` tinyint(1) NULL DEFAULT NULL,
  `ArrowTier` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  CONSTRAINT `diff_pillager_settings_chk_1` CHECK (`CriticPercentage` between 0 and 100),
  CONSTRAINT `diff_pillager_settings_chk_2` CHECK (`ArrowTier` between 0 and 5)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_pillager_settings
-- ----------------------------
INSERT INTO `diff_pillager_settings` VALUES (1, 0, 0, 0, 0);
INSERT INTO `diff_pillager_settings` VALUES (2, 0, 0, 0, 0);
INSERT INTO `diff_pillager_settings` VALUES (3, 0, 0, 0, 0);
INSERT INTO `diff_pillager_settings` VALUES (4, 0, 0, 0, 0);
INSERT INTO `diff_pillager_settings` VALUES (5, 0, 0, 0, 0);
INSERT INTO `diff_pillager_settings` VALUES (6, 0, 0, 0, 0);
INSERT INTO `diff_pillager_settings` VALUES (7, 2, 100, 1, 2);
INSERT INTO `diff_pillager_settings` VALUES (8, 2, 100, 1, 2);
INSERT INTO `diff_pillager_settings` VALUES (9, 2, 100, 1, 2);
INSERT INTO `diff_pillager_settings` VALUES (10, 2, 100, 1, 2);

-- ----------------------------
-- Table structure for diff_ravager_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_ravager_settings`;
CREATE TABLE `diff_ravager_settings`  (
  `ID` int NOT NULL,
  `Resistance` int NULL DEFAULT NULL,
  `Strength` int NULL DEFAULT NULL,
  `Speed` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  CONSTRAINT `diff_ravager_settings_chk_1` CHECK (`Resistance` between 0 and 5),
  CONSTRAINT `diff_ravager_settings_chk_2` CHECK (`Strength` between 0 and 5),
  CONSTRAINT `diff_ravager_settings_chk_3` CHECK (`Speed` between 0 and 5)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_ravager_settings
-- ----------------------------
INSERT INTO `diff_ravager_settings` VALUES (1, 0, 0, 0);
INSERT INTO `diff_ravager_settings` VALUES (2, 0, 0, 0);
INSERT INTO `diff_ravager_settings` VALUES (3, 0, 0, 0);
INSERT INTO `diff_ravager_settings` VALUES (4, 0, 0, 0);
INSERT INTO `diff_ravager_settings` VALUES (5, 0, 0, 0);
INSERT INTO `diff_ravager_settings` VALUES (6, 0, 0, 0);
INSERT INTO `diff_ravager_settings` VALUES (7, 0, 0, 0);
INSERT INTO `diff_ravager_settings` VALUES (8, 0, 0, 0);
INSERT INTO `diff_ravager_settings` VALUES (9, 1, 1, 2);
INSERT INTO `diff_ravager_settings` VALUES (10, 1, 1, 3);

-- ----------------------------
-- Table structure for diff_silverfish_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_silverfish_settings`;
CREATE TABLE `diff_silverfish_settings`  (
  `ID` int NOT NULL,
  `TripleSpawn` tinyint(1) NULL DEFAULT NULL,
  `Resistance` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  CONSTRAINT `diff_silverfish_settings_chk_1` CHECK (`Resistance` between 0 and 5)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_silverfish_settings
-- ----------------------------
INSERT INTO `diff_silverfish_settings` VALUES (1, 0, 0);
INSERT INTO `diff_silverfish_settings` VALUES (2, 0, 0);
INSERT INTO `diff_silverfish_settings` VALUES (3, 0, 0);
INSERT INTO `diff_silverfish_settings` VALUES (4, 0, 0);
INSERT INTO `diff_silverfish_settings` VALUES (5, 0, 0);
INSERT INTO `diff_silverfish_settings` VALUES (6, 0, 0);
INSERT INTO `diff_silverfish_settings` VALUES (7, 0, 0);
INSERT INTO `diff_silverfish_settings` VALUES (8, 1, 4);
INSERT INTO `diff_silverfish_settings` VALUES (9, 1, 4);
INSERT INTO `diff_silverfish_settings` VALUES (10, 1, 4);

-- ----------------------------
-- Table structure for diff_skeleton_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_skeleton_settings`;
CREATE TABLE `diff_skeleton_settings`  (
  `ID` int NOT NULL,
  `PowerBow` int NULL DEFAULT NULL,
  `ArrowEffectInstantDamage` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_skeleton_settings
-- ----------------------------
INSERT INTO `diff_skeleton_settings` VALUES (1, 0, 0);
INSERT INTO `diff_skeleton_settings` VALUES (2, 0, 0);
INSERT INTO `diff_skeleton_settings` VALUES (3, 0, 0);
INSERT INTO `diff_skeleton_settings` VALUES (4, 0, 0);
INSERT INTO `diff_skeleton_settings` VALUES (5, 0, 0);
INSERT INTO `diff_skeleton_settings` VALUES (6, 0, 0);
INSERT INTO `diff_skeleton_settings` VALUES (7, 2, 2);
INSERT INTO `diff_skeleton_settings` VALUES (8, 2, 2);
INSERT INTO `diff_skeleton_settings` VALUES (9, 2, 2);
INSERT INTO `diff_skeleton_settings` VALUES (10, 2, 4);

-- ----------------------------
-- Table structure for diff_slime_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_slime_settings`;
CREATE TABLE `diff_slime_settings`  (
  `ID` int NOT NULL,
  `Punch` int NULL DEFAULT NULL,
  `Strength` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_slime_settings
-- ----------------------------
INSERT INTO `diff_slime_settings` VALUES (1, 0, 0);
INSERT INTO `diff_slime_settings` VALUES (2, 0, 0);
INSERT INTO `diff_slime_settings` VALUES (3, 0, 0);
INSERT INTO `diff_slime_settings` VALUES (4, 0, 0);
INSERT INTO `diff_slime_settings` VALUES (5, 0, 0);
INSERT INTO `diff_slime_settings` VALUES (6, 0, 0);
INSERT INTO `diff_slime_settings` VALUES (7, 3, 0);
INSERT INTO `diff_slime_settings` VALUES (8, 3, 0);
INSERT INTO `diff_slime_settings` VALUES (9, 3, 2);
INSERT INTO `diff_slime_settings` VALUES (10, 3, 2);

-- ----------------------------
-- Table structure for diff_stray_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_stray_settings`;
CREATE TABLE `diff_stray_settings`  (
  `ID` int NOT NULL,
  `BowPower` int NULL DEFAULT NULL,
  `ArrowEffectSlowness` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_stray_settings
-- ----------------------------
INSERT INTO `diff_stray_settings` VALUES (1, 0, 0);
INSERT INTO `diff_stray_settings` VALUES (2, 0, 0);
INSERT INTO `diff_stray_settings` VALUES (3, 0, 0);
INSERT INTO `diff_stray_settings` VALUES (4, 0, 0);
INSERT INTO `diff_stray_settings` VALUES (5, 0, 0);
INSERT INTO `diff_stray_settings` VALUES (6, 0, 0);
INSERT INTO `diff_stray_settings` VALUES (7, 2, 5);
INSERT INTO `diff_stray_settings` VALUES (8, 2, 5);
INSERT INTO `diff_stray_settings` VALUES (9, 2, 5);
INSERT INTO `diff_stray_settings` VALUES (10, 2, 5);

-- ----------------------------
-- Table structure for diff_vex_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_vex_settings`;
CREATE TABLE `diff_vex_settings`  (
  `ID` int NOT NULL,
  `SwordMaterial` int NULL DEFAULT NULL,
  `Sharpness` int NULL DEFAULT NULL,
  `Flame` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_vex_settings
-- ----------------------------
INSERT INTO `diff_vex_settings` VALUES (1, 0, 0, 0);
INSERT INTO `diff_vex_settings` VALUES (2, 0, 0, 0);
INSERT INTO `diff_vex_settings` VALUES (3, 0, 0, 0);
INSERT INTO `diff_vex_settings` VALUES (4, 0, 0, 0);
INSERT INTO `diff_vex_settings` VALUES (5, 0, 0, 0);
INSERT INTO `diff_vex_settings` VALUES (6, 0, 0, 0);
INSERT INTO `diff_vex_settings` VALUES (7, 5, 2, 2);
INSERT INTO `diff_vex_settings` VALUES (8, 5, 2, 2);
INSERT INTO `diff_vex_settings` VALUES (9, 5, 2, 2);
INSERT INTO `diff_vex_settings` VALUES (10, 5, 2, 2);

-- ----------------------------
-- Table structure for diff_vindicator_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_vindicator_settings`;
CREATE TABLE `diff_vindicator_settings`  (
  `ID` int NOT NULL,
  `AxeMaterial` int NULL DEFAULT NULL,
  `Sharpness` int NULL DEFAULT NULL,
  `FireAspect` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_vindicator_settings
-- ----------------------------
INSERT INTO `diff_vindicator_settings` VALUES (1, 0, 0, 0);
INSERT INTO `diff_vindicator_settings` VALUES (2, 0, 0, 0);
INSERT INTO `diff_vindicator_settings` VALUES (3, 0, 0, 0);
INSERT INTO `diff_vindicator_settings` VALUES (4, 0, 0, 0);
INSERT INTO `diff_vindicator_settings` VALUES (5, 0, 0, 0);
INSERT INTO `diff_vindicator_settings` VALUES (6, 0, 0, 0);
INSERT INTO `diff_vindicator_settings` VALUES (7, 6, 1, 3);
INSERT INTO `diff_vindicator_settings` VALUES (8, 6, 1, 3);
INSERT INTO `diff_vindicator_settings` VALUES (9, 6, 1, 3);
INSERT INTO `diff_vindicator_settings` VALUES (10, 6, 1, 3);

-- ----------------------------
-- Table structure for diff_witch_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_witch_settings`;
CREATE TABLE `diff_witch_settings`  (
  `ID` int NOT NULL,
  `Regeneration` int NULL DEFAULT NULL,
  `Resistance` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_witch_settings
-- ----------------------------
INSERT INTO `diff_witch_settings` VALUES (1, 0, 0);
INSERT INTO `diff_witch_settings` VALUES (2, 0, 0);
INSERT INTO `diff_witch_settings` VALUES (3, 0, 0);
INSERT INTO `diff_witch_settings` VALUES (4, 0, 0);
INSERT INTO `diff_witch_settings` VALUES (5, 0, 0);
INSERT INTO `diff_witch_settings` VALUES (6, 0, 0);
INSERT INTO `diff_witch_settings` VALUES (7, 2, 0);
INSERT INTO `diff_witch_settings` VALUES (8, 2, 0);
INSERT INTO `diff_witch_settings` VALUES (9, 2, 2);
INSERT INTO `diff_witch_settings` VALUES (10, 2, 2);

-- ----------------------------
-- Table structure for diff_witherskeleton_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_witherskeleton_settings`;
CREATE TABLE `diff_witherskeleton_settings`  (
  `ID` int NOT NULL,
  `AxeMaterial` int NULL DEFAULT NULL,
  `Sharpness` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_witherskeleton_settings
-- ----------------------------
INSERT INTO `diff_witherskeleton_settings` VALUES (1, 0, 0);
INSERT INTO `diff_witherskeleton_settings` VALUES (2, 0, 0);
INSERT INTO `diff_witherskeleton_settings` VALUES (3, 0, 0);
INSERT INTO `diff_witherskeleton_settings` VALUES (4, 0, 0);
INSERT INTO `diff_witherskeleton_settings` VALUES (5, 0, 0);
INSERT INTO `diff_witherskeleton_settings` VALUES (6, 0, 0);
INSERT INTO `diff_witherskeleton_settings` VALUES (7, 6, 5);
INSERT INTO `diff_witherskeleton_settings` VALUES (8, 6, 5);
INSERT INTO `diff_witherskeleton_settings` VALUES (9, 6, 5);
INSERT INTO `diff_witherskeleton_settings` VALUES (10, 6, 5);

-- ----------------------------
-- Table structure for diff_zoglin_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_zoglin_settings`;
CREATE TABLE `diff_zoglin_settings`  (
  `ID` int NOT NULL,
  `DoubleDamage` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_zoglin_settings
-- ----------------------------
INSERT INTO `diff_zoglin_settings` VALUES (1, 0);
INSERT INTO `diff_zoglin_settings` VALUES (2, 0);
INSERT INTO `diff_zoglin_settings` VALUES (3, 0);
INSERT INTO `diff_zoglin_settings` VALUES (4, 0);
INSERT INTO `diff_zoglin_settings` VALUES (5, 0);
INSERT INTO `diff_zoglin_settings` VALUES (6, 0);
INSERT INTO `diff_zoglin_settings` VALUES (7, 0);
INSERT INTO `diff_zoglin_settings` VALUES (8, 0);
INSERT INTO `diff_zoglin_settings` VALUES (9, 2);
INSERT INTO `diff_zoglin_settings` VALUES (10, 2);

-- ----------------------------
-- Table structure for diff_zombie_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_zombie_settings`;
CREATE TABLE `diff_zombie_settings`  (
  `ID` int NOT NULL,
  `SwordMaterial` int NULL DEFAULT NULL,
  `Sharpness` int NULL DEFAULT NULL,
  `AxeMaterial` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_zombie_settings
-- ----------------------------
INSERT INTO `diff_zombie_settings` VALUES (1, 0, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (2, 0, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (3, 0, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (4, 0, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (5, 0, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (6, 0, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (7, 4, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (8, 4, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (9, 4, 0, NULL);
INSERT INTO `diff_zombie_settings` VALUES (10, 4, 2, NULL);

-- ----------------------------
-- Table structure for diff_zombievillager_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_zombievillager_settings`;
CREATE TABLE `diff_zombievillager_settings`  (
  `ID` int NOT NULL,
  `AxeMaterial` int NULL DEFAULT NULL,
  `Sharpness` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_zombievillager_settings
-- ----------------------------
INSERT INTO `diff_zombievillager_settings` VALUES (1, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (2, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (3, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (4, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (5, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (6, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (7, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (8, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (9, 0, 0);
INSERT INTO `diff_zombievillager_settings` VALUES (10, 4, 2);

-- ----------------------------
-- Table structure for diff_zombifiedpiglin_settings
-- ----------------------------
DROP TABLE IF EXISTS `diff_zombifiedpiglin_settings`;
CREATE TABLE `diff_zombifiedpiglin_settings`  (
  `ID` int NOT NULL,
  `Speed` int NULL DEFAULT NULL,
  `FireAspect` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diff_zombifiedpiglin_settings
-- ----------------------------
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (1, 0, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (2, 0, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (3, 0, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (4, 0, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (5, 0, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (6, 0, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (7, 2, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (8, 2, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (9, 2, 0);
INSERT INTO `diff_zombifiedpiglin_settings` VALUES (10, 2, 10);

-- ----------------------------
-- Table structure for player_inventories
-- ----------------------------
DROP TABLE IF EXISTS `player_inventories`;
CREATE TABLE `player_inventories`  (
  `player_uuid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `inventory` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`player_uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of player_inventories
-- ----------------------------
INSERT INTO `player_inventories` VALUES ('990b0f82-bd20-4dfc-a8c1-a9961378c1d6', 'rO0ABXcEAAAACXNyABpvcmcuYnVra2l0LnV0aWwuaW8uV3JhcHBlcvJQR+zxEm8FAgABTAADbWFw\r\ndAAPTGphdmEvdXRpbC9NYXA7eHBzcgA1Y29tLmdvb2dsZS5jb21tb24uY29sbGVjdC5JbW11dGFi\r\nbGVNYXAkU2VyaWFsaXplZEZvcm0AAAAAAAAAAAIAAkwABGtleXN0ABJMamF2YS9sYW5nL09iamVj\r\ndDtMAAZ2YWx1ZXNxAH4ABHhwdXIAE1tMamF2YS5sYW5nLk9iamVjdDuQzlifEHMpbAIAAHhwAAAA\r\nA3QAAj09dAABdnQABHR5cGV1cQB+AAYAAAADdAAeb3JnLmJ1a2tpdC5pbnZlbnRvcnkuSXRlbVN0\r\nYWNrc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcu\r\nTnVtYmVyhqyVHQuU4IsCAAB4cAAADnR0ABBaT01CSUVfU1BBV05fRUdHcHBwc3EAfgAAc3EAfgAD\r\ndXEAfgAGAAAAA3EAfgAIcQB+AAlxAH4ACnVxAH4ABgAAAANxAH4ADHNxAH4ADQAADnRxAH4AEHBz\r\ncQB+AABzcQB+AAN1cQB+AAYAAAAEcQB+AAhxAH4ACXEAfgAKdAAEbWV0YXVxAH4ABgAAAARxAH4A\r\nDHNxAH4ADQAADnR0ABhXQVJQRURfRlVOR1VTX09OX0FfU1RJQ0tzcQB+AABzcQB+AAN1cQB+AAYA\r\nAAAGcQB+AAh0AAltZXRhLXR5cGV0AAxkaXNwbGF5LW5hbWV0AARsb3JldAARY3VzdG9tLW1vZGVs\r\nLWRhdGF0AAlJdGVtRmxhZ3N1cQB+AAYAAAAGdAAISXRlbU1ldGF0AApVTlNQRUNJRklDdACYeyJ0\r\nZXh0IjoiIiwiZXh0cmEiOlt7InRleHQiOiJCcmF6byBwdXRyZWZhY3RvIiwib2JmdXNjYXRlZCI6\r\nZmFsc2UsIml0YWxpYyI6ZmFsc2UsInVuZGVybGluZWQiOmZhbHNlLCJzdHJpa2V0aHJvdWdoIjpm\r\nYWxzZSwiY29sb3IiOiJncmVlbiIsImJvbGQiOnRydWV9XX1zcgA2Y29tLmdvb2dsZS5jb21tb24u\r\nY29sbGVjdC5JbW11dGFibGVMaXN0JFNlcmlhbGl6ZWRGb3JtAAAAAAAAAAACAAFbAAhlbGVtZW50\r\nc3QAE1tMamF2YS9sYW5nL09iamVjdDt4cHVxAH4ABgAAAAJ0ALp7InRleHQiOiIiLCJleHRyYSI6\r\nW3sidGV4dCI6IlR1cyBhdGFxdWVzIGLDoXNpY29zIHJlYWxpemFuICsx4p2kIGEgbG9zIHpvbWJp\r\nZXMiLCJvYmZ1c2NhdGVkIjpmYWxzZSwiaXRhbGljIjpmYWxzZSwidW5kZXJsaW5lZCI6ZmFsc2Us\r\nInN0cmlrZXRocm91Z2giOmZhbHNlLCJjb2xvciI6ImdyZWVuIiwiYm9sZCI6ZmFsc2V9XX10AJx7\r\nInRleHQiOiIiLCJleHRyYSI6W3sidGV4dCI6IlNsb3Q6IE1hbm8gc2VjdW5kYXJpYSIsIm9iZnVz\r\nY2F0ZWQiOmZhbHNlLCJpdGFsaWMiOmZhbHNlLCJ1bmRlcmxpbmVkIjpmYWxzZSwic3RyaWtldGhy\r\nb3VnaCI6ZmFsc2UsImNvbG9yIjoiZ29sZCIsImJvbGQiOnRydWV9XX1zcQB+AA0AAAABc3IAE2ph\r\ndmEudXRpbC5BcnJheUxpc3R4gdIdmcdhnQMAAUkABHNpemV4cAAAAAF3BAAAAAF0AA9ISURFX0FU\r\nVFJJQlVURVN4c3EAfgAAc3EAfgADdXEAfgAGAAAABHEAfgAIcQB+AAlxAH4ACnEAfgAZdXEAfgAG\r\nAAAABHEAfgAMc3EAfgANAAAOdHEAfgAcc3EAfgAAc3EAfgADdXEAfgAGAAAAB3EAfgAIcQB+ACBx\r\nAH4AIXEAfgAicQB+ACN0AAhlbmNoYW50c3EAfgAkdXEAfgAGAAAAB3EAfgAmcQB+ACd0AJ57InRl\r\neHQiOiIiLCJleHRyYSI6W3sidGV4dCI6IkJyYXpvIHB1dHJlZmFjdG8gZG9yYWRvIiwib2JmdXNj\r\nYXRlZCI6ZmFsc2UsIml0YWxpYyI6ZmFsc2UsInVuZGVybGluZWQiOmZhbHNlLCJzdHJpa2V0aHJv\r\ndWdoIjpmYWxzZSwiY29sb3IiOiJnb2xkIiwiYm9sZCI6dHJ1ZX1dfXNxAH4AKXVxAH4ABgAAAAJ0\r\nALp7InRleHQiOiIiLCJleHRyYSI6W3sidGV4dCI6IlR1cyBhdGFxdWVzIGLDoXNpY29zIHJlYWxp\r\nemFuICsy4p2kIGEgbG9zIHpvbWJpZXMiLCJvYmZ1c2NhdGVkIjpmYWxzZSwiaXRhbGljIjpmYWxz\r\nZSwidW5kZXJsaW5lZCI6ZmFsc2UsInN0cmlrZXRocm91Z2giOmZhbHNlLCJjb2xvciI6ImdyZWVu\r\nIiwiYm9sZCI6ZmFsc2V9XX10AJx7InRleHQiOiIiLCJleHRyYSI6W3sidGV4dCI6IlNsb3Q6IE1h\r\nbm8gc2VjdW5kYXJpYSIsIm9iZnVzY2F0ZWQiOmZhbHNlLCJpdGFsaWMiOmZhbHNlLCJ1bmRlcmxp\r\nbmVkIjpmYWxzZSwic3RyaWtldGhyb3VnaCI6ZmFsc2UsImNvbG9yIjoiZ29sZCIsImJvbGQiOnRy\r\ndWV9XX1zcQB+AA0AAAACc3IAN2NvbS5nb29nbGUuY29tbW9uLmNvbGxlY3QuSW1tdXRhYmxlQmlN\r\nYXAkU2VyaWFsaXplZEZvcm0AAAAAAAAAAAIAAHhxAH4AA3VxAH4ABgAAAAF0AApEVVJBQklMSVRZ\r\ndXEAfgAGAAAAAXEAfgAvc3EAfgAwAAAAAncEAAAAAnQADUhJREVfRU5DSEFOVFNxAH4AMnhw\r\n');

-- ----------------------------
-- Table structure for settings
-- ----------------------------
DROP TABLE IF EXISTS `settings`;
CREATE TABLE `settings`  (
  `ID` int NOT NULL,
  `Dia Actual` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of settings
-- ----------------------------
INSERT INTO `settings` VALUES (1, 10);

-- ----------------------------
-- Table structure for stormsettings
-- ----------------------------
DROP TABLE IF EXISTS `stormsettings`;
CREATE TABLE `stormsettings`  (
  `ID` int NOT NULL,
  `StormTime` int NULL DEFAULT NULL,
  `BaseStormTime` int NULL DEFAULT NULL,
  `StormActive` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of stormsettings
-- ----------------------------
INSERT INTO `stormsettings` VALUES (1, 0, 600, 1);

-- ----------------------------
-- Table structure for totemsettings
-- ----------------------------
DROP TABLE IF EXISTS `totemsettings`;
CREATE TABLE `totemsettings`  (
  `ID` int NOT NULL,
  `FailPorcentage` int NULL DEFAULT NULL,
  `Status` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of totemsettings
-- ----------------------------
INSERT INTO `totemsettings` VALUES (1, 1, 0);

-- ----------------------------
-- Table structure for tri_count_settings
-- ----------------------------
DROP TABLE IF EXISTS `tri_count_settings`;
CREATE TABLE `tri_count_settings`  (
  `ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Trinket` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `CountNormal` int NULL DEFAULT NULL,
  `CountGold` int NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tri_count_settings
-- ----------------------------
INSERT INTO `tri_count_settings` VALUES ('1', 'Descalcificador', 6, 10);
INSERT INTO `tri_count_settings` VALUES ('2', 'MAD', 7, 10);
INSERT INTO `tri_count_settings` VALUES ('3', 'Warmog', 4, 10);
INSERT INTO `tri_count_settings` VALUES ('4', 'ZombArm', 8, 11);

SET FOREIGN_KEY_CHECKS = 1;
