drop database if exists fishstory;
create database if not exists fishstory;
use fishstory;

drop table if exists fish;

create table if not exists fish (
	id bigint auto_increment,
    type varchar(20) not null,
    weight float not null,
    is_gutted boolean not null,
    primary key (id)
);

insert into fish (type, weight, is_gutted)
	values ("Salmon", 5.5, false);

select * from fish