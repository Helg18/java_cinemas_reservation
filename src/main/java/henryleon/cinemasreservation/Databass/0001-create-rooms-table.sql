create table rooms
(
	id BIGINT auto_increment,
	name varchar(300) not null,
	status boolean default TRUE not null,
    created_at datetime default now() null,
    updated_at datetime default now() null,
	constraint rooms_pk
		primary key (id)
);

