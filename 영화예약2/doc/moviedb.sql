-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema moviedb2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `moviedb2` ;

-- -----------------------------------------------------
-- Schema moviedb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviedb2` DEFAULT CHARACTER SET utf8 ;
USE `moviedb2` ;

-- -----------------------------------------------------
-- Table `moviedb2`.`member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moviedb2`.`member` ;

CREATE TABLE IF NOT EXISTS `moviedb2`.`member` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(20) NOT NULL,
  `pw` VARCHAR(20) NOT NULL,
  `regdate` TIMESTAMP NULL,
  PRIMARY KEY (`no`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moviedb2`.`movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moviedb2`.`movie` ;

CREATE TABLE IF NOT EXISTS `moviedb2`.`movie` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `mvname` VARCHAR(45) NOT NULL,
  `remainingseat` INT NOT NULL,
  `img` LONGBLOB NOT NULL,
  PRIMARY KEY (`no`),
  UNIQUE INDEX `mvname_UNIQUE` (`mvname` ASC) VISIBLE)
ENGINE = InnoDB
KEY_BLOCK_SIZE = 16;


-- -----------------------------------------------------
-- Table `moviedb2`.`resister`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moviedb2`.`resister` ;

CREATE TABLE IF NOT EXISTS `moviedb2`.`resister` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(20) NOT NULL,
  `mvname` VARCHAR(45) NOT NULL,
  `seatno` INT NOT NULL,
  INDEX `fk_member_has_movie_movie1_idx` (`mvname` ASC) VISIBLE,
  INDEX `fk_member_has_movie_member_idx` (`id` ASC) INVISIBLE,
  PRIMARY KEY (`no`),
  CONSTRAINT `fk_member_has_movie_member`
    FOREIGN KEY (`id`)
    REFERENCES `moviedb2`.`member` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_member_has_movie_movie1`
    FOREIGN KEY (`mvname`)
    REFERENCES `moviedb2`.`movie` (`mvname`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
