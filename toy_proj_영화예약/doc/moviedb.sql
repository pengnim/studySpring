drop table mvtable;
drop table resistermv;

create table mvtable(
	mvname varchar(20) primary key,
    remainingseat int not null default 25
);
create table resistermv(
	no int auto_increment primary key,
    mvname varchar(20) not null,
    sno int not null,
    FOREIGN KEY (`mvname`) REFERENCES `mvtable` (`mvname`)
);


insert into mvtable values("spider",25);
insert into mvtable values("kingsman",25);
insert into mvtable values("eternals",25);