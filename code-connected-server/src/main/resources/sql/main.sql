CREATE DATABASE `code_connected`;

use `code_connected`;

CREATE TABLE IF NOT EXISTS `profile`(
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50),
    `email` VARCHAR(50),
    `user_name` VARCHAR(50),
    `password` VARCHAR(50),
    `sender_id` INTEGER,
    `receiver_id` INTEGER,
    `about_id` INTEGER,
    `group_id` INTEGER,
    `admin_id` INTEGER
);


CREATE TABLE IF NOT EXISTS `about_user`(
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `about` VARCHAR(50),
    `profile_headline` VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS `skills`(
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `skill` VARCHAR(50),
    `about_id` INTEGER
);

CREATE TABLE IF NOT EXISTS `experience`(
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(50),
    `experience_status` ENUM('FULL_TIME', 'PART_TIME', 'CONTRACT', 'SELF_EMPLOYEED', 'INTERNSHIP'),
    `company_name` VARCHAR(50),
    `start_date` VARCHAR(50),
    `end_date` VARCHAR(50),
    `industry` VARCHAR(50),
    `description` VARCHAR(50),
    `about_id` INTEGER
);

CREATE TABLE IF NOT EXISTS `education`(
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `start_date` VARCHAR(50),
    `end_date` VARCHAR(50),
    `school` VARCHAR(50),
    `degree` VARCHAR(50),
    `field_of_study` VARCHAR(50),
    `about_id` INTEGER
);