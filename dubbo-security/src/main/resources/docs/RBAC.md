#### sql_scripts  

```sql
drop database sercurty_auth;
create database sercurty_auth charset=utf8;
use sercurty_auth;
create table tb_user(
	user_id bigint unsigned auto_increment comment '用户id,unsigned:无符号整数即取消负数范围',
	user_name varchar(64) not null comment '用户姓名',
	user_gender tinyint not null default 0 comment '用户性别默认0',
	user_age int null comment '年龄',
	user_mobile char(11) not null comment '手机号',
	user_img varchar(128) null comment '头像',
	user_password varchar(128) not null comment '密码',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
    user_not_enable tinyint not null default 0 comment '是否禁用',
	primary key (user_id),
	unique (user_mobile) -- 指定唯一，unique也做了 key (user_mobile)操作
) engine=InnoDB default charset=utf8 comment '用户表';

create table tb_role(
	role_id bigint unsigned auto_increment comment '角色id,unsigned:无符号整数即取消负数范围',
	role_name varchar(64) not null comment '角色名称',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
    role_not_enable tinyint not null default 0 comment '是否禁用',
	primary key (role_id)
) engine=InnoDB default charset=utf8 comment '角色表';

create table tb_user_role(
	user_role_id bigint unsigned auto_increment comment 'id,unsigned:无符号整数即取消负数范围',
	role_id bigint not null comment '角色ID',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
    user_id bigint not null  comment '用户ID',
	primary key (user_role_id)
) engine=InnoDB default charset=utf8 comment '用户角色关联表';

create table tb_permission(
	permission_id bigint unsigned auto_increment comment 'id,unsigned:无符号整数即取消负数范围',
	permission_type int not null comment '权限类型',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
	primary key (permission_id)
) engine=InnoDB default charset=utf8 comment '权限表';

create table tb_menu(
	menu_id bigint unsigned auto_increment comment 'id,unsigned:无符号整数即取消负数范围',
	menu_name varchar(32) not null comment '菜单名称',
    menu_url varchar(128) not null comment '菜单url',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
	primary key (menu_id)
) engine=InnoDB default charset=utf8 comment '菜单权限';

create table tb_action(
	action_id bigint unsigned auto_increment comment 'id,unsigned:无符号整数即取消负数范围',
	action_name varchar(32) not null comment '功能名称',
    action_url varchar(128) not null comment '功能url',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
	primary key (action_id)
) engine=InnoDB default charset=utf8 comment '功能权限';

create table tb_permission_action(
	permission_action_id bigint unsigned auto_increment comment 'id,unsigned:无符号整数即取消负数范围',
	permission_id bigint not null comment '权限ID',
    action_id bigint not null comment '功能ID',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
	primary key (permission_action_id)
) engine=InnoDB default charset=utf8 comment '权限功能关联表';

create table tb_permission_menu(
	permission_menu_id bigint unsigned auto_increment comment 'id,unsigned:无符号整数即取消负数范围',
	permission_id bigint not null comment '权限ID',
    menu_id bigint not null comment '菜单ID',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
	primary key (permission_menu_id)
) engine=InnoDB default charset=utf8 comment '权限菜单关联表';

create table tb_role_permission(
	role_permission_id bigint unsigned auto_increment comment 'id,unsigned:无符号整数即取消负数范围',
	permission_id bigint not null comment '权限ID',
    role_id bigint not null comment '角色ID',
	create_time datetime default current_timestamp comment '创建时间',
	update_time datetime default current_timestamp on update current_timestamp comment '更新时间',
	primary key (role_permission_id)
) engine=InnoDB default charset=utf8 comment '角色权限表';
```  
