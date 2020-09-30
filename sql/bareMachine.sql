CREATE TABLE `ry`.`baremachine` (
  `id_bareMachine` INT NOT NULL AUTO_INCREMENT,
  `bareM_classes` VARCHAR(10) NOT NULL,
  `bareM_type` VARCHAR(20) NOT NULL,
  `bareM_ModelNo` VARCHAR(30) NOT NULL,
  `bareM_price_1` DOUBLE NOT NULL,
  `bareM_price_2` DOUBLE NOT NULL,
  `bareM_price_3` DOUBLE NOT NULL,
  `bareM_price_4` DOUBLE NOT NULL,
  `bareM_describe` VARCHAR(100) NOT NULL,
  `bareM_cost` DOUBLE NOT NULL,
  `bareM_costIncludeTax` FLOAT NOT NULL,
  `bareM_cpu` VARCHAR(20) NOT NULL,
  `bareM_chipGroup` VARCHAR(20) NOT NULL,
  `bareM_under` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_bareMachine`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;