-- name: all-rounds
select round.id, game.name as game, round.date, player.name as player_name, score.score
from round inner join game on game.id = round.game
inner join score on round.id = score.round
inner join player on score.player = player.id;

-- name: insert-player!
insert into player (name) values (:name);

-- name: get-players
select * from player;

-- name: insert-game!
insert into game (name) values (:name);

-- name: get-games
select * from game;

-- name: insert-round<!
insert into round (game, date) values (:game, :date);

-- name: insert-score!
insert into score values (:player, :round, :score);

-- name: scores-for-round
select player.name, score from score inner join player on score.player = player.id
where round = :round order by score;

-- name: get-rounds
select round.id, round.date, game.name as game
from round inner join game on game.id = round.game order by round.date;
