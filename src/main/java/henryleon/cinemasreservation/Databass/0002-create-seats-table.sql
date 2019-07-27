create table seats
(
	id bigint auto_increment,
	room_id bigint not null,
	col int not null,
	row int not null,
	status boolean default true not null,
	created_at datetime default now() null,
	updated_at datetime default now() null,
	constraint seats_pk
		primary key (id),
	constraint seats_rooms_id_fk
		foreign key (room_id) references rooms (id)
			on update cascade on delete cascade
);

