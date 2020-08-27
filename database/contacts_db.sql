-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_contacts
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_contacts
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_contacts` DEFAULT CHARACTER SET utf8 ;
USE `db_contacts` ;

-- -----------------------------------------------------
-- Table `db_contacts`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_contacts`.`company` (
  `company_id` INT NOT NULL AUTO_INCREMENT,
  `nip` BIGINT NOT NULL,
  `regon` BIGINT NOT NULL,
  `krs` INT NOT NULL,
  `legal_form` VARCHAR(45) NOT NULL,
  `other_legal_form` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`company_id`),
  UNIQUE INDEX `company_id_UNIQUE` (`company_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_contacts`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_contacts`.`person` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `pesel` BIGINT NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE INDEX `person_id_UNIQUE` (`person_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_contacts`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_contacts`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `phone` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `other_info` MEDIUMTEXT NULL DEFAULT NULL,
  `how_find` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(10) NOT NULL,
  `person_person_id` INT NULL DEFAULT NULL,
  `company_company_id` INT NULL DEFAULT NULL,
  `recommender` VARCHAR(45) NULL DEFAULT NULL,
  `conference` VARCHAR(45) NULL DEFAULT NULL,
  `media` VARCHAR(45) NULL DEFAULT NULL,
  `inneMedia` VARCHAR(45) NULL DEFAULT NULL,
  `inne_media` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `p_id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_contact_person1_idx` (`person_person_id` ASC) VISIBLE,
  INDEX `fk_contact_company1_idx` (`company_company_id` ASC) VISIBLE,
  CONSTRAINT `fk_contact_company1`
    FOREIGN KEY (`company_company_id`)
    REFERENCES `db_contacts`.`company` (`company_id`),
  CONSTRAINT `fk_contact_person1`
    FOREIGN KEY (`person_person_id`)
    REFERENCES `db_contacts`.`person` (`person_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_contacts`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_contacts`.`address` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `address_type` VARCHAR(64) NULL DEFAULT NULL,
  `address_street` VARCHAR(64) NULL DEFAULT NULL,
  `address_home` VARCHAR(10) NULL DEFAULT NULL,
  `address_apartment` VARCHAR(10) NULL DEFAULT NULL,
  `address_postal_code` VARCHAR(6) NULL DEFAULT NULL,
  `address_city` VARCHAR(255) NULL DEFAULT NULL,
  `contact_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  UNIQUE INDEX `address_id_UNIQUE` (`address_id` ASC) VISIBLE,
  INDEX `fk_address_company1_idx` (`contact_id` ASC) VISIBLE,
  CONSTRAINT `fk_address_company1`
    FOREIGN KEY (`contact_id`)
    REFERENCES `db_contacts`.`contact` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_contacts`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_contacts`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `employee_name` VARCHAR(45) NULL DEFAULT NULL,
  `employee_surname` VARCHAR(45) NULL DEFAULT NULL,
  `employee_position` VARCHAR(45) NULL DEFAULT NULL,
  `employee_phone` VARCHAR(20) NULL DEFAULT NULL,
  `employee_status` TINYINT(1) NULL DEFAULT NULL,
  `company_company_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE INDEX `employer_id_UNIQUE` (`employee_id` ASC) VISIBLE,
  INDEX `fk_employee_company1_idx` (`company_company_id` ASC) VISIBLE,
  CONSTRAINT `fk_employee_company1`
    FOREIGN KEY (`company_company_id`)
    REFERENCES `db_contacts`.`company` (`company_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
