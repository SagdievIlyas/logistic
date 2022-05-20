create table country (
    id      serial         not null,
    name    varchar (255)   not null
);

alter table country add constraint pk_country primary key (id);

create table users (
    id          serial         not null,
    email       varchar (255)   not null,
    password    varchar (255)   not null
);

alter table users add constraint pk_users primary key (id);

create table rates (
    id          serial             not null,
    rate        numeric (19, 2)     not null,
    start_date  timestamp           not null,
    end_date    timestamp           not null,
    min_weight  numeric (19, 2)     not null,
    max_weight  numeric (19, 2)     not null
);

alter table rates add constraint pk_rates primary key (id);

create table calculations_history (
    id                  serial             not null,
    user_id             integer             not null,
    weight              numeric (19, 2)     not null,
    from_country_id     integer             not null,
    to_country_id       integer             not null,
    date_time           timestamp           not null,
    sum_price           numeric (19, 2)     not null
);

alter table calculations_history add constraint pk_calculations_history primary key (id);
alter table calculations_history add constraint fk_calculations_history_users foreign key (user_id) references users (id);
alter table calculations_history add constraint fk_calculations_history_country_from foreign key (from_country_id) references country (id);
alter table calculations_history add constraint fk_calculations_history_country_to foreign key (to_country_id) references country (id);