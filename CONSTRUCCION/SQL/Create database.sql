-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema quinta_categoria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema quinta_categoria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `quinta_categoria` DEFAULT CHARACTER SET utf8mb3 ;
USE `quinta_categoria` ;

-- -----------------------------------------------------
-- Table `quinta_categoria`.`colaborador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quinta_categoria`.`colaborador` (
  `id_colaborador` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `apellido_paterno` VARCHAR(45) NOT NULL,
  `apellido_materno` VARCHAR(45) NOT NULL,
  `numero_documento` BIGINT NOT NULL,
  `codigo_modular` BIGINT NOT NULL,
  `codigo_secuencial` BIGINT NOT NULL,
  PRIMARY KEY (`id_colaborador`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `quinta_categoria`.`planilla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quinta_categoria`.`planilla` (
  `id_planilla` INT NOT NULL AUTO_INCREMENT,
  `tipo_planilla` VARCHAR(50) NOT NULL,
  `periodo` VARCHAR(20) NOT NULL,
  `codigo_ugel` CHAR(2) NOT NULL,
  `fecha_registro` DATETIME NOT NULL,
  `fecha_modificacion` DATETIME NULL,
  PRIMARY KEY (`id_planilla`))
ENGINE = InnoDB
AUTO_INCREMENT = 8015
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quinta_categoria`.`planilla_colaborador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quinta_categoria`.`planilla_colaborador` (
  `id_planilla_colaborador` INT NOT NULL AUTO_INCREMENT,
  `id_planilla` INT NOT NULL,
  `id_colaborador` INT NOT NULL,
  `total_haber` DECIMAL(10,2) NOT NULL,
  `total_descuento` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_planilla_colaborador`),
  INDEX `id_planilla` (`id_planilla` ASC) VISIBLE,
  INDEX `id_colaborador` (`id_colaborador` ASC) VISIBLE,
  CONSTRAINT `planilla_colaborador_ibfk_1`
    FOREIGN KEY (`id_planilla`)
    REFERENCES `quinta_categoria`.`planilla` (`id_planilla`),
  CONSTRAINT `planilla_colaborador_ibfk_2`
    FOREIGN KEY (`id_colaborador`)
    REFERENCES `quinta_categoria`.`colaborador` (`id_colaborador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `quinta_categoria`.`descuento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quinta_categoria`.`descuento` (
  `id_descuento` INT NOT NULL AUTO_INCREMENT,
  `D0001` DECIMAL(10,2) NOT NULL,
  `D0002` DECIMAL(10,2) NOT NULL,
  `D0004` DECIMAL(10,2) NOT NULL,
  `D0005` DECIMAL(10,2) NOT NULL,
  `D0006` DECIMAL(10,2) NOT NULL,
  `D0008` DECIMAL(10,2) NOT NULL,
  `D0009` DECIMAL(10,2) NOT NULL,
  `D0015` DECIMAL(10,2) NOT NULL,
  `D0021` DECIMAL(10,2) NOT NULL,
  `D0023` DECIMAL(10,2) NOT NULL,
  `D0026` DECIMAL(10,2) NOT NULL,
  `D0054` DECIMAL(10,2) NOT NULL,
  `D0109` DECIMAL(10,2) NOT NULL,
  `D0113` DECIMAL(10,2) NOT NULL,
  `D0115` DECIMAL(10,2) NOT NULL,
  `D0118` DECIMAL(10,2) NOT NULL,
  `D0121` DECIMAL(10,2) NOT NULL,
  `D0130` DECIMAL(10,2) NOT NULL,
  `D0139` DECIMAL(10,2) NOT NULL,
  `D0140` DECIMAL(10,2) NOT NULL,
  `D0143` DECIMAL(10,2) NOT NULL,
  `D0151` DECIMAL(10,2) NOT NULL,
  `D0190` DECIMAL(10,2) NOT NULL,
  `D0417` DECIMAL(10,2) NOT NULL,
  `D0418` DECIMAL(10,2) NOT NULL,
  `D0856` DECIMAL(10,2) NOT NULL,
  `D1010` DECIMAL(10,2) NOT NULL,
  `D1145` DECIMAL(10,2) NOT NULL,
  `D1146` DECIMAL(10,2) NOT NULL,
  `D1723` DECIMAL(10,2) NOT NULL,
  `D1763` DECIMAL(10,2) NOT NULL,
  `D1784` DECIMAL(10,2) NOT NULL,
  `D1819` DECIMAL(10,2) NOT NULL,
  `D1829` DECIMAL(10,2) NOT NULL,
  `id_planilla_colaborador` INT NOT NULL,
  PRIMARY KEY (`id_descuento`),
  INDEX `fk_descuento_planilla_colaborador1_idx` (`id_planilla_colaborador` ASC) VISIBLE,
  CONSTRAINT `fk_descuento_planilla_colaborador1`
    FOREIGN KEY (`id_planilla_colaborador`)
    REFERENCES `quinta_categoria`.`planilla_colaborador` (`id_planilla_colaborador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quinta_categoria`.`haber`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quinta_categoria`.`haber` (
  `id_haber` INT NOT NULL AUTO_INCREMENT,
  `H001` DECIMAL(10,2) NOT NULL,
  `H002` DECIMAL(10,2) NOT NULL,
  `H003` DECIMAL(10,2) NOT NULL,
  `H004` DECIMAL(10,2) NOT NULL,
  `H006` DECIMAL(10,2) NOT NULL,
  `H008` DECIMAL(10,2) NOT NULL,
  `H009` DECIMAL(10,2) NOT NULL,
  `H010` DECIMAL(10,2) NOT NULL,
  `H012` DECIMAL(10,2) NOT NULL,
  `H014` DECIMAL(10,2) NOT NULL,
  `H017` DECIMAL(10,2) NOT NULL,
  `H023` DECIMAL(10,2) NOT NULL,
  `H024` DECIMAL(10,2) NOT NULL,
  `H025` DECIMAL(10,2) NOT NULL,
  `H026` DECIMAL(10,2) NOT NULL,
  `H033` DECIMAL(10,2) NOT NULL,
  `H079` DECIMAL(10,2) NOT NULL,
  `H080` DECIMAL(10,2) NOT NULL,
  `H082` DECIMAL(10,2) NOT NULL,
  `H090` DECIMAL(10,2) NOT NULL,
  `H092` DECIMAL(10,2) NOT NULL,
  `H099` DECIMAL(10,2) NOT NULL,
  `H100` DECIMAL(10,2) NOT NULL,
  `H136` DECIMAL(10,2) NOT NULL,
  `H150` DECIMAL(10,2) NOT NULL,
  `H162` DECIMAL(10,2) NOT NULL,
  `H170` DECIMAL(10,2) NOT NULL,
  `H177` DECIMAL(10,2) NOT NULL,
  `H178` DECIMAL(10,2) NOT NULL,
  `H181` DECIMAL(10,2) NOT NULL,
  `H185` DECIMAL(10,2) NOT NULL,
  `H206` DECIMAL(10,2) NOT NULL,
  `H231` DECIMAL(10,2) NOT NULL,
  `H244` DECIMAL(10,2) NOT NULL,
  `H259` DECIMAL(10,2) NOT NULL,
  `H261` DECIMAL(10,2) NOT NULL,
  `H263` DECIMAL(10,2) NOT NULL,
  `H264` DECIMAL(10,2) NOT NULL,
  `H271` DECIMAL(10,2) NOT NULL,
  `H277` DECIMAL(10,2) NOT NULL,
  `H288` DECIMAL(10,2) NOT NULL,
  `H303` DECIMAL(10,2) NOT NULL,
  `H309` DECIMAL(10,2) NOT NULL,
  `H310` DECIMAL(10,2) NOT NULL,
  `id_planilla_colaborador` INT NOT NULL,
  PRIMARY KEY (`id_haber`),
  INDEX `fk_haber_planilla_colaborador1_idx` (`id_planilla_colaborador` ASC) VISIBLE,
  CONSTRAINT `fk_haber_planilla_colaborador1`
    FOREIGN KEY (`id_planilla_colaborador`)
    REFERENCES `quinta_categoria`.`planilla_colaborador` (`id_planilla_colaborador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quinta_categoria`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quinta_categoria`.`rol` (
  `id_rol` INT NOT NULL AUTO_INCREMENT,
  `tipo_rol` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quinta_categoria`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quinta_categoria`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido_paterno` VARCHAR(100) NOT NULL,
  `apellido_materno` VARCHAR(100) NOT NULL,
  `dni` VARCHAR(8) NOT NULL,
  `fecha_nacimiento` VARCHAR(40) NOT NULL,
  `telefono` VARCHAR(12) NOT NULL,
  `imagen` VARCHAR(200) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `contrasenia` VARCHAR(100) NOT NULL,
  `id_rol` INT NOT NULL,
  `estado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  INDEX `id_rol` (`id_rol` ASC) VISIBLE,
  CONSTRAINT `usuario_ibfk_1`
    FOREIGN KEY (`id_rol`)
    REFERENCES `quinta_categoria`.`rol` (`id_rol`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
