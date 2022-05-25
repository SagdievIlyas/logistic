create table country (
    id      serial          not null,
    name    varchar (255)   not null
);

alter table country add constraint pk_country primary key (id);


create table users (
    id          serial          not null,
    email       varchar (255)   not null,
    password    varchar (255)   not null
);

alter table users add constraint pk_users primary key (id);


create table role (
    id      serial      not null,
    name    varchar     not null
);

alter table role add constraint pk_role primary key (id);


create table user_role (
    id          serial      not null,
    user_id     integer     not null,
    role_id     integer     not null
);

alter table user_role add constraint pk_user_role primary key (id);
alter table user_role add constraint fk_user_role_users foreign key (user_id) references users (id);
alter table user_role add constraint fk_user_role_role foreign key (user_id) references role (id);


create table rate (
    id          serial              not null,
    rate        numeric (19, 2)     not null,
    start_date  timestamp           not null,
    end_date    timestamp           not null,
    min_weight  numeric (19, 2)     not null,
    max_weight  numeric (19, 2)     not null
);

alter table rate add constraint pk_rates primary key (id);


create table calculation (
    id                  serial              not null,
    user_id             integer             not null,
    weight              numeric (19, 2)     not null,
    from_country_id     integer             not null,
    to_country_id       integer             not null,
    date_time           timestamp           not null,
    sum_price           numeric (19, 2)     not null
);

alter table calculation add constraint pk_calculation primary key (id);
alter table calculation add constraint fk_calculation_users foreign key (user_id) references users (id);
alter table calculation add constraint fk_calculation_country_from foreign key (from_country_id) references country (id);
alter table calculation add constraint fk_calculation_country_to foreign key (to_country_id) references country (id);