alter table aub_order add column route varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci;
alter table aub_order add column contact_tel varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci;
alter table aub_order_bus change recId ord_bus_id int; 