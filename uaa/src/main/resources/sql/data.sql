


-------- 菜单
insert into menu (id, name, url) values (1,'根路径','ROOT');
insert into menu (id, name, url, icon, sequence, parent_id) values (2,'主页', '/index', '', 101, 1);
insert into menu (id, name, url, icon, sequence, parent_id) values (3,'用户页面', '/user', '', 102, 1);
insert into menu (id, name, url, icon, sequence, parent_id) values (4,'权限页面', '/power', '', 103, 1);



-------- 文件
insert into file (id, name, path) values (1, '/file/xxx.txt', '测试文件');




-------- 权限
insert into power (id, type) values (1, '菜单');
insert into power (id, type) values (2, '文件');






-------- 角色
insert into role (id, name) values (1, '超级管理员');
insert into role (id, name) values (2, '管理员');
insert into role (id, name) values (3, '版主');
insert into role (id, name) values (4, '副版主');
insert into role (id, name) values (5, '小版主');
insert into role (id, name) values (6, 'SVIP超级用户');
insert into role (id, name) values (7, 'VIP高级用户');
insert into role (id, name) values (8, 'user普通用户');
insert into role (id, name) values (9, '游客');


-------- 用户组
insert into user_group (id, name) values (1, '超级管理员组');
insert into user_group (id, name) values (2, '管理员组');
insert into user_group (id, name) values (3, '版主组');
insert into user_group (id, name) values (4, '副版主组');
insert into user_group (id, name) values (5, '小版主组');
insert into user_group (id, name) values (6, 'SVIP超级用户组');
insert into user_group (id, name) values (7, 'VIP高级用户组');
insert into user_group (id, name) values (8, 'user普通用户组');
insert into user_group (id, name) values (9, '游客组');



-------- 操作
insert into operation (id, name) values (1, '预留根操作');

insert into operation (id, name, code, block_url, parent_id) values (2, '页面操作', 1000, '/', 1);
insert into operation (id, name, code, block_url, parent_id) values (3, '文件操作', 2000, '/', 1);



insert into operation (id, name, code, block_url, parent_id) values (4, '访问主页操作', 1001, '/index', 2);
insert into operation (id, name, code, block_url, parent_id) values (5, '访问测试文件操作', 2001, '/file/test', 3);



-------- 权限-资源 关联
insert into power_menu (power_id, menu_id) values (1, 2);
insert into power_file (power_id, file_id) values (1, 1);





-------- 权限-操作 关联
insert into role_power (role_id, power_id) values (1, 2);
insert into role_power (role_id, power_id) values (2, 3);








-------- 角色-权限 关联

--- 超级管理员
insert into role_power (role_id, power_id) values (1, 1);
insert into role_power (role_id, power_id) values (1, 2);

--- 管理员
insert into role_power (role_id, power_id) values (2, 2);

--- 版主
insert into role_power (role_id, power_id) values (3, 2);

--- 副版主
insert into role_power (role_id, power_id) values (4, 2);

--- 小版主
insert into role_power (role_id, power_id) values (5, 2);
insert into role_power (role_id, power_id) values (5, 1);

--- SVIP超级用户组
insert into role_power (role_id, power_id) values (6, 1);

--- VIP高级用户组
insert into role_power (role_id, power_id) values (7, 1);

--- user普通用户
insert into role_power (role_id, power_id) values (8, 1);

--- 游客
insert into role_power (role_id, power_id) values (9, 1);




-------- 用户组-角色 关联

--- 管理员组
insert into user_group_role (user_group_id, role_id) values (1, 1);
insert into user_group_role (user_group_id, role_id) values (2, 2);

--- 版主组
insert into user_group_role (user_group_id, role_id) values (3, 3);
insert into user_group_role (user_group_id, role_id) values (4, 4);
insert into user_group_role (user_group_id, role_id) values (5, 5);

--- VIP用户组
insert into user_group_role (user_group_id, role_id) values (6, 6);
insert into user_group_role (user_group_id, role_id) values (7, 7);

--- 普通用户组
insert into user_group_role (user_group_id, role_id) values (8, 8);

--- 游客组
insert into user_group_role (user_group_id, role_id) values (9, 9);








-------- 用户

--- root(超级管理员)
insert into user_status (username, password) values ('root', 'root');
insert into user_info(username, name, gender, email, phone, id_card) values ('root', 'Root', 1, 'root@qq.com', '15596888888', '111111111111116161');
-- insert into user_status_role (username, role_id) values ('root', 1);
insert into user_group_user_status (username, user_group_id) values ('root', 1);

--- admin(管理员)
insert into user_status (username, password) values ('admin', 'admin');
insert into user_info(username, name, gender, email, phone, id_card) values ('admin', 'Admin', 1, 'admin@admin.com', '18888888888', '215566551236521232');

-- insert into user_status_role (username, role_id) values ('admin', 2);
insert into user_group_user_status (username, user_group_id) values ('admin', 2);


--- q593883272(版主)
insert into user_status (username, password) values ('q593883272', '88888888');
insert into user_info(username, name, gender, email, phone, id_card) values ('q593883272', 'Fen丿Raven', 1, '593883272@qq.com', '15529692821', '610104199112250899');
insert into user_status_role (username, role_id) values ('q593883272', 1);
insert into user_status_role (username, role_id) values ('q593883272', 6);
insert into user_group_user_status (username, user_group_id) values ('q593883272', 3);


--- q651260511(SVIP超级用户)
insert into user_status (username, password) values ('q651260511', '666666666');
insert into user_info(username, name, gender, email, phone, id_card) values ('q651260511', '使战丿斗气势', 0, '651260511@qq.com', '15698556636', '210106200110150802');
-- insert into user_status_role (username, role_id) values ('q651260511', 6);
insert into user_group_user_status (username, user_group_id) values ('q651260511', 6);
insert into user_group_user_status (username, user_group_id) values ('q651260511', 4);


--- user(普通用户)
insert into user_status (username, password) values ('user', 'user');
insert into user_info(username, name, gender, email, phone, id_card) values ('user', '测试普通用户', 1, 'ppttcsz@qq.com', '16698569965', '365998856321125');
-- insert into user_status_role (username, role_id) values ('user', 8);
insert into user_group_user_status (username, user_group_id) values ('user', 8);


--- xxx(游客)
insert into user_status (username, password) values ('xxx', 'xxx');
insert into user_info(username, name, gender, email, phone, id_card) values ('xxx', '测试游客', 1, 'ykykwww@qq.com', '16698555556', '363251233655896542');
-- insert into user_status_role (username, role_id) values ('xxx', 9);
insert into user_group_user_status (username, user_group_id) values ('xxx', 9);













