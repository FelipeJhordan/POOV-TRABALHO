CREATE DATABASE  IF NOT EXISTS `bdtrabalho` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdtrabalho`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: bdtrabalho
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aluno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ra` bigint(13) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `curso` varchar(45) NOT NULL,
  `turma` varchar(45) NOT NULL,
  `email` varchar(120) NOT NULL,
  PRIMARY KEY (`id`,`ra`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `ra_UNIQUE` (`ra`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,312321,'Felipe Jhordan','pORTUGUES','azul','felipejordan@hotmail.com'),(13,111,'3','4','fefe','fefe'),(14,3,'mariana','letras','1b','mariana@gmail.com');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alunotrabalho`
--

DROP TABLE IF EXISTS `alunotrabalho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alunotrabalho` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aluno` int(11) NOT NULL,
  `trabalho` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_aluno_alunotrabalho_idx` (`aluno`),
  KEY `fk_trabalho_alunotrabalho_idx` (`trabalho`),
  CONSTRAINT `fk_aluno_alunotrabalho` FOREIGN KEY (`aluno`) REFERENCES `aluno` (`id`),
  CONSTRAINT `fk_trabalho_alunotrabalho` FOREIGN KEY (`trabalho`) REFERENCES `trabalho` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunotrabalho`
--

LOCK TABLES `alunotrabalho` WRITE;
/*!40000 ALTER TABLE `alunotrabalho` DISABLE KEYS */;
/*!40000 ALTER TABLE `alunotrabalho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `avaliacao` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `avaliador` int(11) NOT NULL,
  `trabalho` int(11) NOT NULL,
  `notaCriterio1` decimal(4,2) NOT NULL,
  `notaCriterio2` decimal(4,2) NOT NULL,
  `notaCriterio3` decimal(4,2) NOT NULL,
  `notaCriterio4` decimal(4,2) NOT NULL,
  `notaCriterio5` decimal(4,2) NOT NULL,
  `notaCriterio6` decimal(4,2) NOT NULL,
  `notaCriterio7` decimal(4,2) NOT NULL,
  `notaCriterio8` decimal(4,2) NOT NULL,
  `notaCriterio9` decimal(4,2) NOT NULL,
  `notaCriterio10` decimal(4,2) NOT NULL,
  `notaCriterio11` decimal(4,2) NOT NULL,
  `notaCriterio12` decimal(4,2) NOT NULL,
  `notaCriterio13` decimal(4,2) NOT NULL,
  `notaCriterio14` decimal(4,2) NOT NULL,
  `data` date NOT NULL,
  `periodo` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_avaliadortrabalho_avaliador_idx` (`avaliador`),
  KEY `fk_trabalho_trabalho_idx` (`trabalho`),
  CONSTRAINT `fk_avaliadortrabalho_avaliador` FOREIGN KEY (`avaliador`) REFERENCES `avaliadortrabalho` (`pessoa`),
  CONSTRAINT `fk_trabalho_trabalho` FOREIGN KEY (`trabalho`) REFERENCES `trabalho` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (32,13,6,2.00,3.00,1.00,2.00,2.00,1.00,3.00,2.00,2.00,3.00,1.00,2.00,2.00,1.00,'2000-11-11','manha');
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliadortrabalho`
--

DROP TABLE IF EXISTS `avaliadortrabalho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `avaliadortrabalho` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pessoa` int(11) NOT NULL,
  `trabalho` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_pessoa_avaliadortrabalho_idx` (`pessoa`),
  KEY `fk_trabalho_avaliadortrabalho_idx` (`trabalho`),
  CONSTRAINT `fk_pessoa_avaliadortrabalho` FOREIGN KEY (`pessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `fk_trabalho_avaliadortrabalho` FOREIGN KEY (`trabalho`) REFERENCES `trabalho` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliadortrabalho`
--

LOCK TABLES `avaliadortrabalho` WRITE;
/*!40000 ALTER TABLE `avaliadortrabalho` DISABLE KEYS */;
INSERT INTO `avaliadortrabalho` VALUES (7,13,6);
/*!40000 ALTER TABLE `avaliadortrabalho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criterio`
--

DROP TABLE IF EXISTS `criterio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `criterio` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(70) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criterio`
--

LOCK TABLES `criterio` WRITE;
/*!40000 ALTER TABLE `criterio` DISABLE KEYS */;
/*!40000 ALTER TABLE `criterio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` smallint(5) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataTermino` date NOT NULL,
  `nome` varchar(80) NOT NULL,
  `quantidadeMinimaTrabalho` smallint(3) NOT NULL,
  `quantidadeMaximaTrabalho` smallint(3) NOT NULL,
  `notaAtribuida` decimal(4,2) NOT NULL,
  `numeroDeAvaliadores` smallint(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,2000,'2000-02-03','2000-03-04','aler',2,3,4.00,4);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penalizacao`
--

DROP TABLE IF EXISTS `penalizacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `penalizacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razao` varchar(45) NOT NULL,
  `aluno` int(11) NOT NULL,
  `evento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_aluno_aluno_idx` (`aluno`),
  KEY `fk_evento_evento_idx` (`evento`),
  CONSTRAINT `fk_aluno_aluno` FOREIGN KEY (`aluno`) REFERENCES `aluno` (`id`),
  CONSTRAINT `fk_evento_evento` FOREIGN KEY (`evento`) REFERENCES `evento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penalizacao`
--

LOCK TABLES `penalizacao` WRITE;
/*!40000 ALTER TABLE `penalizacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `penalizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `siape` bigint(13) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `email` varchar(120) NOT NULL,
  `login` varchar(34) NOT NULL,
  `senha` varchar(70) NOT NULL,
  PRIMARY KEY (`id`,`siape`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `siape_UNIQUE` (`siape`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,1111,'EDUARDO SILVESTRE','eduardosilvestre@gmail.com','admin','A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3'),(13,111111,'felps','321321','312321','5BD29D071C90BA120BA72B7B3E866D1D7A87ADEB7FB0397D463B4A8F4FE75EBC');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabalho`
--

DROP TABLE IF EXISTS `trabalho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trabalho` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alunoLider` int(11) NOT NULL,
  `orientador` int(11) NOT NULL,
  `coorientador` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `resumo` varchar(120) NOT NULL,
  `equipamentos` varchar(100) NOT NULL,
  `eventoTrabalho` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_aluno_alunoLider_idx` (`alunoLider`),
  KEY `fk_pessoa_orientador_idx` (`orientador`),
  KEY `fk_pessoa_coorientador_idx` (`coorientador`),
  KEY `fk_evento_eventoTrabalho_idx` (`eventoTrabalho`),
  CONSTRAINT `fk_aluno_alunoLider` FOREIGN KEY (`alunoLider`) REFERENCES `aluno` (`id`),
  CONSTRAINT `fk_evento_eventoTrabalho` FOREIGN KEY (`eventoTrabalho`) REFERENCES `evento` (`id`),
  CONSTRAINT `fk_pessoa_coorientador` FOREIGN KEY (`coorientador`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `fk_pessoa_orientador` FOREIGN KEY (`orientador`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabalho`
--

LOCK TABLES `trabalho` WRITE;
/*!40000 ALTER TABLE `trabalho` DISABLE KEYS */;
INSERT INTO `trabalho` VALUES (6,1,1,13,'fe','31232','312',1),(11,1,13,1,'feferda','fddcfdfd','xcaxas',1),(12,13,1,1,'fef','32','e32',1);
/*!40000 ALTER TABLE `trabalho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdtrabalho'
--

--
-- Dumping routines for database 'bdtrabalho'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-01 11:03:57
