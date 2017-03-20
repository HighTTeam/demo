-- auto Generated on 2017-03-19 14:52:15 
-- DROP TABLE IF EXISTS `user_role`; 
CREATE TABLE `user_role`(
    `id` BIGINT (21) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` BIGINT (21) NOT NULL DEFAULT -1 COMMENT 'userId',
    `role_id` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'roleId',
    INDEX(user_id),
    INDEX(role_id),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user_role`';
