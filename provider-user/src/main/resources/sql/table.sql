

create table user
(
    id       integer auto_increment not null primary key,
    username varchar(64)            not null,
    name     varchar(255)           not null
);