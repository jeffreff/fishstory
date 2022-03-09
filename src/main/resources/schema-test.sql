drop table if exists fish;

create table if not exists fish (id bigint generated by default as identity, type varchar(20) not null, weight float not null, is_gutted boolean not null, primary key (id));