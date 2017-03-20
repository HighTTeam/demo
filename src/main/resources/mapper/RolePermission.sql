-- auto Generated on 2017-03-19 14:53:18 
-- DROP TABLE IF EXISTS `role_permission`; 
CREATE TABLE `role_permission`(
    `id` BIGINT (21) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `role_id` BIGINT (21) NOT NULL DEFAULT -1 COMMENT 'roleId',
    `permission_id` BIGINT (21) NOT NULL DEFAULT -1 COMMENT 'permissionId',
    INDEX(role_id),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`role_permission`';
