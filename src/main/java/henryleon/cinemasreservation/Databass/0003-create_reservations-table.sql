create table reservations
(
    id bigint auto_increment,
    date date not null,
    time time not null,
    status boolean default true not null,
    created_at datetime default now() null,
    updated_at datetime default now() null,
    constraint reservations_pk
        primary key (id)
);

