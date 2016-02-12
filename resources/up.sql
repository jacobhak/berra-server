create table player (
       id serial primary key,
       name text
);

create table game (
       id serial primary key,
       name text
);

create table round (
       id serial primary key,
       game integer references game(id),
       date date
);

create table score (
       player integer references player(id),
       round integer references round(id),
       score integer
);
