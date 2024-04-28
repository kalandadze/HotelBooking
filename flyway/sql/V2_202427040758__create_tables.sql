CREATE TABLE `booking`.`rooms` (
  `roomId` INT NOT NULL,
  `booked` TINYINT NULL,
  `roomNum` INT NULL,
  `hotel_id` INT NULL,
  PRIMARY KEY (`roomId`));

CREATE TABLE `booking`.`hotel` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));