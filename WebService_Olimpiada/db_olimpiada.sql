/*
Navicat MySQL Data Transfer

Source Server         : ConexaoTeste
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : db_olimpiada

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-12-07 06:48:36
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_cadastro_modalidade`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cadastro_modalidade`;
CREATE TABLE `tb_cadastro_modalidade` (
  `idModalidade` int(11) NOT NULL,
  `Descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`idModalidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_cadastro_modalidade
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_competicao`
-- ----------------------------
DROP TABLE IF EXISTS `tb_competicao`;
CREATE TABLE `tb_competicao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Modalidade` varchar(100) NOT NULL,
  `Local` varchar(100) NOT NULL,
  `Data_Hora_Inicio` varchar(16) NOT NULL DEFAULT '',
  `Data_Hora_Termino` varchar(16) NOT NULL,
  `Competidor1` varchar(50) NOT NULL,
  `Competidor2` varchar(50) NOT NULL,
  `Etapa` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_competicao
-- ----------------------------
INSERT INTO `tb_competicao` VALUES ('1', 'FUTEBOL', 'ESTADIO 1', '07/12/2017 10:00', '07/12/2017 11:00', 'ARGENTINA', 'ITALIA', 'ELIMINATORA');

-- ----------------------------
-- Table structure for `tb_competicao_controle`
-- ----------------------------
DROP TABLE IF EXISTS `tb_competicao_controle`;
CREATE TABLE `tb_competicao_controle` (
  `id` int(11) NOT NULL,
  `idModalidade` int(11) NOT NULL,
  `idLocal` int(11) NOT NULL,
  `idCompetidor1` int(11) NOT NULL,
  `idCompetidor2` int(11) NOT NULL,
  `dt_hr_inicio` datetime NOT NULL,
  `dt_hr_fim` datetime NOT NULL,
  `idEtapa` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_competicao_controle
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_competicao_local`
-- ----------------------------
DROP TABLE IF EXISTS `tb_competicao_local`;
CREATE TABLE `tb_competicao_local` (
  `idLocal` int(11) NOT NULL AUTO_INCREMENT,
  `Descicao` varchar(100) NOT NULL,
  PRIMARY KEY (`idLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_competicao_local
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_competidor`
-- ----------------------------
DROP TABLE IF EXISTS `tb_competidor`;
CREATE TABLE `tb_competidor` (
  `idCompetidor` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  PRIMARY KEY (`idCompetidor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_competidor
-- ----------------------------
