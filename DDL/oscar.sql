drop table votes

CREATE TABLE votes (
userid varchar(255),
bestPicture varchar(255),
bestActorinaLeadingRole varchar(255),
bestActressinaLeadingRole varchar(255),
bestActorinaSupportingRole varchar(255),
bestActressinaSupportingRole varchar(255),
bestAnimatedFeature varchar(255),
bestCinematography varchar(255),
bestCostumeDesign varchar(255),
bestDirector varchar(255),
bestDocumentaryFeature varchar(255),
bestDocumentaryShort varchar(255),
bestFilmEditing varchar(255),
bestForeignLanguageFilm varchar(255),
bestMakeupandHairstyling varchar(255),
bestOriginalScore varchar(255),
bestOriginalSong varchar(255),
bestProductionDesign varchar(255),
bestAnimatedShortFilm varchar(255),
bestLiveActionShortFilm varchar(255),
bestSoundEditing varchar(255),
bestSoundMixing varchar(255),
bestVisualEffects varchar(255),
bestAdaptedScreenplay varchar(255),
bestOriginalScreenplay varchar(255)
);


drop table config;

CREATE TABLE config (
name varchar(255),
value varchar(255)
);


insert into config (name, value) values ('voting', 'on')
update config set value = 'off' where name = 'voting'
update config set value = 'on' where name = 'voting'
select * from config 

SELECT * FROM votes
SELECT * FROM votes
GRANT ALL ON votes to PUBLIC;

update votes set userid = 'winner' where userid = 'xwinner'
update votes set userid = 'xwinner' where userid = 'winner'
update votes set userid = 'xgeorge' where userid = 'george'

SELECT * FROM VOTEs WHERE BESTACTORINALEADINGROLE like 'Leo%'

delete from votes WHERE BESTACTORINALEADINGROLE like 'Leo%'


SELECT bestPicture, COUNT(1) AS counter FROM votes where USERID <> 'winner' GROUP BY bestPicture;
