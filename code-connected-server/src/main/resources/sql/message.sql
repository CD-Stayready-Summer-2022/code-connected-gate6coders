CREATE TABLE IF NOT EXISTS `message`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `message_content` VARCHAR(500),
    `date_sent` TIMESTAMP
);
