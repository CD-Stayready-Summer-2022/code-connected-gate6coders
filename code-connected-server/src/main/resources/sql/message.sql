CREATE TABLE IF NOT EXISTS `message`(
    `message_id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `message_content` VARCHAR(500),
    `date_sent` TIMESTAMP
);
