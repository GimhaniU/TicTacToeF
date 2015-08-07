Drop database TicTacToe;
CREATE database TicTacToe;

use TicTacToe;

CREATE TABLE Player(
        Player_id INT(4) NOT NULL AUTO_INCREMENT,
	Name VARCHAR(30) NOT NULL,
	PlayType VARCHAR(20),
	PlayedDate VARCHAR(30) NOT NULL,
	Won INT(1),
	CONSTRAINT PRIMARY KEY (Player_id)
);

INSERT INTO Player(1,'Gimhani','Easy','2015-02-30',1);