DROP database IF EXISTS smart_library_v1;
create database smart_library_v1
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_bin;
use smart_library_v1;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 用户信息表
-- ----------------------------
DROP TABLE IF EXISTS `lib_user`;
CREATE TABLE `lib_user` (
   `id`              bigint(20)     NOT NULL    AUTO_INCREMENT    COMMENT '用户ID',
   `dept_id`         bigint(20)              DEFAULT NULL COMMENT '部门ID',
   `username`        varchar(100)   NOT NULL             COMMENT '用户名',
   `password`        varchar(100)   NOT NULL             COMMENT '密码',
   `email`           varchar(50)             DEFAULT ''  COMMENT '用户邮箱',
   `phonenumber`     varchar(11)    NOT NULL DEFAULT ''  COMMENT '手机号码',
   `sex`             int            NOT NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
   `avatar`          varchar(100)            DEFAULT ''  COMMENT '头像地址',
   `status`          int                     DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
   `login_date`      datetime                DEFAULT NULL COMMENT '最后登录时间',
   `create_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `update_time`     datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   `last_password_reset_time`  datetime  DEFAULT NULL COMMENT '最后修改密码的日期',
   `remark`      varchar(500)            DEFAULT NULL COMMENT '备注',
   PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT='用户表';

-- ----------------------------
-- 部门表
-- ----------------------------
DROP TABLE IF EXISTS `lib_dept`;
CREATE TABLE `lib_dept` (
   `dept_id`           bigint(20)      NOT NULL auto_increment    comment '部门id',
   `parent_id`         bigint(20)      DEFAULT 0                  comment '父部门id',
   `ancestors`         varchar(50)     DEFAULT ''                 comment '祖级列表',
   `dept_name`         varchar(30)     DEFAULT ''                 comment '部门名称',
   `order_num`         int(4)          DEFAULT 0                  comment '显示顺序',
   `leader`            varchar(20)     DEFAULT null               comment '负责人',
   `phone`             varchar(11)     DEFAULT null               comment '联系电话',
   `email`             varchar(50)     DEFAULT null               comment '邮箱',
   `status`            int             DEFAULT '0'                comment '部门状态（0正常 1停用）',
   `create_by`         varchar(64)     DEFAULT ''                 comment '创建者',
   `create_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `update_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (`dept_id`)
) ENGINE = InnoDB COMMENT = '部门表';


-- ----------------------------
-- 角色信息表
-- ----------------------------
DROP TABLE IF EXISTS `lib_role`;
CREATE TABLE `lib_role`(
    `id`          bigint          NOT NULL AUTO_INCREMENT COMMENT '角色主键ID',
    `name`        varchar(30)     DEFAULT NULL COMMENT '角色名称',
    `code`        varchar(100)    DEFAULT NULL COMMENT '角色权限字符串',
    `status`      int             NOT NULL     COMMENT '角色状态（0正常 1停用）',
    `create_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `remark`      varchar(500)    DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 COMMENT='角色信息表';


-- ----------------------------
-- 菜单权限表
-- ----------------------------
DROP TABLE IF EXISTS `lib_menu`;
CREATE TABLE `lib_menu`  (
   `id`            bigint(0)         NOT NULL AUTO_INCREMENT COMMENT '菜单主键ID',
   `name`          varchar(50)       DEFAULT NULL COMMENT '菜单名称',
   `icon`          varchar(100)      DEFAULT '#' COMMENT '菜单图标',
   `parent_id`     bigint(0)         DEFAULT NULL COMMENT '父菜单ID',
   `order_num`     int(0)            DEFAULT 0 COMMENT '显示顺序',
   `path`          varchar(200)      DEFAULT '' COMMENT '路由地址',
   `component`     varchar(255)      DEFAULT NULL COMMENT '组件路径',
   `menu_type`     int               DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
   `perms`         varchar(100)      DEFAULT '' COMMENT '权限标识',
   `create_time`   datetime          NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `update_time`   datetime          NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   `remark`        varchar(500)      DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 ROW_FORMAT = Dynamic COMMENT='菜单权限表';


-- ----------------------------
-- 用户和角色关联表
-- ----------------------------
DROP TABLE IF EXISTS `lib_user_role`;
CREATE TABLE `lib_user_role` (
   `id`         bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '用户角色主键ID',
   `user_id`    bigint(20)    DEFAULT NULL            COMMENT '用户ID',
   `role_id`    bigint(20)    DEFAULT NULL            COMMENT '角色ID',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  ROW_FORMAT = Dynamic
  COMMENT='用户和角色关联表';

-- ----------------------------
-- 角色和菜单关联表
-- ----------------------------
DROP TABLE IF EXISTS `lib_role_menu`;
CREATE TABLE `lib_role_menu`  (
   `id`         bigint(20)       NOT NULL AUTO_INCREMENT COMMENT '角色菜单主键ID',
   `role_id`    bigint(20)       DEFAULT NULL    COMMENT '角色ID',
   `menu_id`    bigint(20)       DEFAULT NULL    COMMENT '菜单ID',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ROW_FORMAT = Dynamic COMMENT='角色和菜单关联表';
