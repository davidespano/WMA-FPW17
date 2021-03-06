create table film (
    id integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    titolo varchar(256),
    riassunto varchar(1024)
);

insert into film (id, titolo, riassunto)
values 
(default, 'Imitation Game',  'The Imitation Game è un film del 2014 
diretto da Morten Tyldum, con protagonista Benedict Cumberbatch nei panni del 
matematico e crittoanalista Alan Turing. La pellicola è l''adattamento 
cinematografico della biografia Alan Turing. Una biografia (Alan Turing: 
The Enigma), pubblicata dopo l''uscita del film anche col titolo Alan Turing. 
Storia di un enigma, scritta da Andrew Hodges[1] nel 1983.'),

(default, 'Titanic', 'Titanic è un film colossal del 1997 scritto, 
diretto e co-montato da James Cameron, con protagonisti Leonardo DiCaprio 
e Kate Winslet nei ruoli di Jack e Rose, membri di differenti classi sociali 
che s''innamorano durante il tragico viaggio inaugurale del RMS Titanic.

È, ad oggi, il secondo film con il maggiore incasso nella 
storia mondiale del cinema (il primo è Avatar (2009), sempre diretto 
da Cameron), nonché uno dei film a detenere il record di più nomination 
agli Oscar (14 candidature) ed uno di quelli con più vittorie in assoluto 
della prestigiosa statuetta d''oro (11 vittorie ai Premi Oscar 1998), insieme 
a Il Signore degli Anelli - Il ritorno del re e Ben-Hur.)'),

(default, 'Armageddon', 'Armageddon - Giudizio finale (Armageddon) è un film 
del 1998 diretto da Michael Bay. Negli Stati uniti uscì il 1 luglio del 1998, 
mentre nelle sale Italiane arrivò il 4 settembre dello stesso anno.');

(default, 'Le ali della libertà', 'Two imprisoned men bond over a number of years, 
finding solace and eventual redemption through acts of common decency.'),

(default, 'Il padrino', 'The aging patriarch of an organized crime dynasty 
transfers control of his clandestine empire to his reluctant son.'),

(default, 'Il cavaliere oscuro', 'When the menace known as the Joker emerges 
from his mysterious past, he wreaks havoc and chaos on the people of Gotham, 
the Dark Knight must accept one 
of the greatest psychological and physical tests of his ability to fight injustice.'),

(default, 'Schindler''s List ', 'In German-occupied Poland during World War II, 
Oskar Schindler gradually becomes concerned for his Jewish workforce after 
witnessing their persecution by the Nazi Germans.');



create table users (
    id integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username varchar(128),
    password varchar(128),
    uType integer
);

insert into users (id, username, password, uType)
values 
(default, 'davide', 'ciao', 0),
(default, 'topolino', 'minnie', 0),
(default, 'pippo', 'senzapassword', 0),
(default, 'admin', 'admin', 1);
 

