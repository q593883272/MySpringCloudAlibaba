---------------------------------------------------------------------------------------------------------------------------------------
-------- ------------------------------------------------------ H2 ------------------------------------------------------- --------
---------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------
-- 用户表(user)
-- ----------------------------
drop table if exists user_status;
create table user_status
(
  -- 账号
  username                text primary key not null,
  -- 密码
  password                text             not null,
  -- 用户名称
  name                    text(32)         not null,
  -- 性别
  gender                  integer(1)       not null default -1,
  -- 身份证
  id_card                 text(20) unique,
  -- 电话Z
  phone                   varchar(11) unique,
  -- 邮箱
  email                   varchar(64) unique,
  -- 帐户是否未过期
  account_non_expired     integer(1)       NOT NULL default 1,
  -- 帐户是否未锁定
  account_non_locked      integer(1)       NOT NULL default 1,
  -- 凭证是否未过期
  credentials_non_expired integer(1)       NOT NULL default 1,
  -- 帐户是否启用
  enabled                 integer(1)       NOT NULL default 0
);

-- ----------------------------
-- 角色表(role)
-- ----------------------------
drop table if exists role;
create table role
(
  -- 角色标识
  role_mark integer primary key not null,
  -- 角色名称
  role_name text             not null
);



-- ----------------------------
-- 用户组表(user_group)
-- ----------------------------
drop table if exists user_group;
create table user_group
(
  --主键
  user_group_id   text primary key not null,
  --名称用户组名称
  user_group_name text             not null

);

-- ----------------------------
-- 用户组-用户状态 中间表(user_group_user_status)
-- ----------------------------
drop table if exists user_group_user_status;
create table user_group_user_status
(
  -- 主键
  id             integer primary key,
  -- 用户组表ID
  user_group_id  text not null,
  -- 用户状态表ID
  user_status_id text not null
);


-- ----------------------------
-- 用户组-角色 中间表(user_group_role)
-- ----------------------------
drop table if exists user_group_role;
create table user_group_role
(
  -- 主键
  id            integer primary key,
  -- 用户组表ID
  user_group_id text not null,
  -- 用户状态表ID
  role_id       text not null
);

-- ----------------------------
-- 用户角色表(user_role)
-- ----------------------------
drop table if exists user_status_role;
create table user_status_role
(
  -- 主键
  id       integer primary key AUTO_INCREMENT not null,
  -- 用户账号
  username integer                           not null,
  -- 角色ID
  role_id  integer                           not null
);


-- ----------------------------
-- 权限表(permission)
-- ----------------------------
drop table if exists permission;
create table permission
(
  -- 权限ID
  permission_id   integer primary key not null,
  -- 权限名称
  permission_name text                not null
);

-- ----------------------------
-- 角色权限表(role_permission)
-- ----------------------------
drop table if exists role_permission;
create table role_permission
(
  -- 主键
  id            integer primary key AUTO_INCREMENT not null,
  -- 角色
  role_mark     integer                           not null,
  -- 角色权限
  permission_id integer                           not null
);


-- ----------------------------
-- 菜单表(menu)
-- ----------------------------
drop table if exists menu;
create table menu
(
  -- 菜单ID(主键)
  menu_id        integer primary key AUTO_INCREMENT not null,
  -- 菜单URL
  menu_url       text(32)                          not null,
  -- 菜单名称
  menu_name      text(32)                          not null,
  -- 菜单名称
  menu_icon      text,
  -- 菜单显示顺序
  menu_sequence  integer,
  -- 父菜单ID
  parent_menu_id integer
);

insert into menu(menu_id, menu_url, menu_name)
values (1, 'ROOT', 'ROOT');

-- ----------------------------
-- 操作日志表(operation_log)
-- ----------------------------
-- drop table if exists operation_log;
-- create table operation_log(
--
-- );

-- ----------------------------
-- 操作日志表(operation_log)
-- ----------------------------
drop table if exists operation_log;
create table operation_log
(
  -- 主键
  id                integer primary key AUTO_INCREMENT not null,
  -- 操作类型ID
  operation_type_id integer                           not null,
  -- 操作内容
  operation_content text(32)                          not null default '',
  -- 操作用户
  operation_user    text(32)                          not null default '',
  -- 操作时间
  operation_time    datetime                           not null default now()
);

--   -- 版本
--   version     integer          NOT NULL default 1,
--   -- 修改人
--   update_user text(32)         not null default 'admin',
--   -- 修改时间
--   update_date numeric          not null default (datetime('now', 'localtime')),
--   -- 创建人
--   create_user text(32)         not null default 'admin',
--   -- 创建时间
--   create_date numeric          not null default (datetime('now', 'localtime'))






























