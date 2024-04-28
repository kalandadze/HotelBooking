CREATE TABLE `booking`.`hotel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rooms` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `booking`.`rooms` (
  `roomId` INT NOT NULL AUTO_INCREMENT,
  `booked` TINYINT NULL,
  `roomNum` INT NULL,
  PRIMARY KEY (`roomId`));