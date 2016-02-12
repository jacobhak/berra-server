-- name: all-rounds
select round.id, game.name, round.date, player.name, score.score
from round inner join game on game.id = round.game
inner join score on round.id = score.round
inner join player on score.player = player.id;
