alter table aub_order add column route varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci;
alter table aub_order add column contact_tel varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci;
alter table aub_order_bus change recId ord_bus_id int;

alter table aub_order_bus add column bus_no varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '车牌号';
alter table aub_order_bus add column driver varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '驾驶员';
alter table aub_order_bus add column tel varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '驾驶员电话';
alter table aub_order_bus add column bus_model varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '车型';
alter table aub_order_bus add column delete_flag int(11) COMMENT '删除标记：0未删除，1已删除';
