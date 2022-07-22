CREATE TABLE IF NOT EXISTS `comment` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `content` VARCHAR(500),
    `date_posted` TIMESTAMP,
    `post_id` INTEGER
);