CREATE TABLE IF NOT EXISTS Computer (
question_id integer PRIMARY KEY,
question_text TEXT NOT NULL,
question_answer integer NOT NULL,
question_complement Text null
);

INSERT INTO Computer VALUES(null,'Wurde Apple II im Jahr 1977 veröffentlicht?',1,null);
INSERT INTO Computer VALUES(null,'Wurde im Jahr 1981 der erste Personal Computer vorgestellt?',1,null);
INSERT INTO Computer VALUES(null,'Hat Konrad Zuse den ersten vollelektronischen Computer entwickelt?',0,'Falsch!
Konrad Zuse verwendete
Relais. Damit war der
Computer noch nicht
vollelektrisch.'
);
INSERT INTO Computer VALUES(null,'War Pong von Atari das erste
Spiel der Welt?',1,null);
INSERT INTO Computer VALUES(null,'Die erste Xbox ist im Jahr
1998 erschienen.',0,'Falsch!
Die erste Xbox ist im Jahr
2001 in den USA erschienen.');