drop database CANTEEN;
create DATABASE CANTEEN  DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;

use CANTEEN;



drop table if EXISTS dish;

-- 商家配置 或者 用户新增
-- 基本是不变数据
create table dish(
                     id                   int(11) not null auto_increment comment 'ID',
                     dish_id              varchar(44) comment 'dishes id' default '0',
                     dish_name					  varchar(100) comment 'dishes名称' default '番茄炒蛋',
                     source               int(11) comment '商家配置 0 用户配置 1' default 0,
                     category 						varchar(100) comment '一级类目' default 'Meal',
                     canteen              varchar(500) comment '食堂名称' default 'XueYi',
                     indegrent 						varchar(500) comment '原材料' default '番茄',
                     calories 						int(11) comment '卡路里kcal/100g' default 132,
                     price 								int(11) comment '价格 单位分' default 100,
                     flavor 							varchar(100) comment '口味' default 'Spicy',

                     create_date          timestamp comment '创建时间' DEFAULT CURRENT_TIMESTAMP,
                     update_date          timestamp comment '修改时间' DEFAULT CURRENT_TIMESTAMP,
                     state                int(11) default 1 comment '状态 0:删除 1：正常',
                     primary key (id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;



insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('1','一道番肴','["辣椒","蔬菜"]',100,'Sour');
insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('2','番茄炒蛋','["番茄"]',200,'Sweet');
insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('3','番薯炒蛋','["辣椒"]',300,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('4','番茄炒番茄','辣椒',400,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('5','一番炒蛋','蛋',900,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('6','蛋炒番茄','茄子',90,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('7','番茄小炒','辣椒',20,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('8','小炒番茄','辣椒',1000,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('9','大炒番茄','辣椒',100,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('10','幼女番','辣椒',100,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('11','恋爱番','辣椒',80,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('12','番鼠','辣椒',50,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('13','番鼠炒蛋','辣椒',200,'Sour');
-- insert into dish (dish_id, dish_name,indegrent,calories,flavor) values ('14','番茄大炒','辣椒',600,'Sour');
--
select * from dish;



-- dish:review = 1:n 主要记录一些统计数据
-- 第一次增加菜品也会增加review
drop table if EXISTS review;
create table review(
                       id                   int(11) not null auto_increment comment 'ID',
                       dish_id            varchar(44) comment 'dishes id' default '0',
                       review_id					varchar(44)  comment 'review id' default '0',
                       user_id             varchar(50) comment '评论者微信昵称，商家则为 商家' default '商家',
                       description					varchar(2000) comment '详细描述' default '一道菜肴，我很喜欢',
                       rate 								int(11) comment '评分' default 3,
                       flavor 							varchar(100) comment '评论口味' default 'Spicy',
                       wait_time 						int(11) comment '等待时间 单位分钟' default 10,
                       price 								int(11) comment '评论价格 单位分' default 100,

                       create_date          timestamp comment '创建时间' DEFAULT CURRENT_TIMESTAMP,
                       update_date          timestamp comment '修改时间' DEFAULT CURRENT_TIMESTAMP,
                       state                int(11) default 1 comment '状态 0:删除 1：正常',
                       primary key (id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;


select * from review;

- insert into review (dish_id, review_id, user_id) values ('1','1','小明');
select * from review;

-- 并不关心是谁上传了啥图片，只关心list展示用啥图片，勉强记录一下review_id表示来过
drop table if EXISTS dish_picture;
create table dish_picture(
                             id                   int(11) not null auto_increment comment 'ID',
                             dish_id            varchar(44) comment 'dishes id' default '0',
                             picture_url        varchar(50) comment '照片url指向static目录' default '',
                             review_id					varchar(44) comment 'review id' default '0',
                             create_date          timestamp comment '创建时间' DEFAULT CURRENT_TIMESTAMP,
                             update_date          timestamp comment '修改时间' DEFAULT CURRENT_TIMESTAMP,
                             state                int(11) default 1 comment '状态 0:删除 1：正常',
                             primary key (id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;

select * from dish_picture;


