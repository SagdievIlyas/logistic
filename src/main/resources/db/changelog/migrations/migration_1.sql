create table tokens(
    id          serial         not null,
    user_id     integer         not null,
    token       varchar (255)   not null,
    date_start  timestamp       not null,
    date_end    timestamp       not null
);

alter table tokens add constraint pk_tokens primary key (id);
alter table tokens add constraint fk_tokens_users foreign key (user_id) references users (id);