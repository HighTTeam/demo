-- auto Generated on 2017-03-19 14:50:29 
-- DROP TABLE IF EXISTS `user`; 
CREATE TABLE `user`(
    `id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_name` VARCHAR (64) NOT NULL DEFAULT '' COMMENT 'userName',
    `password` VARCHAR (256) NOT NULL DEFAULT '' COMMENT 'password',
    `enabled` INT (11) NOT NULL DEFAULT 0 COMMENT 'enabled',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    INDEX(user_name),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user`';
