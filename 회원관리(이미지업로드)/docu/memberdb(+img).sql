-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema memberdb
-- -----------------------------------------------------
Drop database IF EXISTS memberdb2;
-- -----------------------------------------------------
-- Schema memberdb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `memberdb2` DEFAULT CHARACTER SET utf8 ;
USE `memberdb2` ;

-- -----------------------------------------------------
-- Table `memberdb2`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `memberdb2`.`member` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NULL,
  `profile` LONGBLOB NULL,
  `tel` VARCHAR(20) NULL,
  `post` CHAR(5) NULL,
  `address` VARCHAR(45) NULL,
  `detailaddress` VARCHAR(45) NULL,
  `id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `state` CHAR(1) NULL,
  `rdate` TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (`no`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
