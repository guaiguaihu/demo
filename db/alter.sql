alter table aub_order add column route varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci;
alter table aub_order add column contact_tel varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci;
alter table aub_order_bus change recId ord_bus_id int;

alter table aub_order_bus add column bus_no varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '���ƺ�';
alter table aub_order_bus add column driver varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '��ʻԱ';
alter table aub_order_bus add column tel varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '��ʻԱ�绰';
alter table aub_order_bus add column bus_model varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '����';
alter table aub_order_bus add column delete_flag int(11) COMMENT 'ɾ����ǣ�0δɾ����1��ɾ��';
