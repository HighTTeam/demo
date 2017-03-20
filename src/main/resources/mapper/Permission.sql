-- auto Generated on 2017-03-19 14:56:15 
-- DROP TABLE IF EXISTS `permission`; 
CREATE TABLE `permission`(
    `id` BIGINT (21) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (128) NOT NULL DEFAULT '' COMMENT 'name',
    `desc` VARCHAR (128) DEFAULT '' COMMENT 'desc',
    `url` VARCHAR (1024) NOT NULL DEFAULT '' COMMENT 'url',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`permission`';
