create table token(
    id          serial         not null,
    user_id     integer         not null,
    token       varchar (255)   not null,
    date_start  timestamp       not null,
    date_end    timestamp       not null
);

alter table token add constraint pk_token primary key (id);
alter table token add constraint fk_token_users foreign key (user_id) references users (id);