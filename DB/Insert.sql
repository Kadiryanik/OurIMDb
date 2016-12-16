INSERT INTO Movie(mTitle,mYear,mCountry,mTime,mLanguage,mRating,mRatingCount,mDescription,mUrlLink)
	VALUES('The Shawshank Redemption', '1994-10-14', 'United States', '142', 'English', '9.3', 1738596,
		'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.',
			'https://www.youtube.com/embed/6hB3S9bIaco');
 
INSERT INTO People(pTitle, pFirstName, pLastName, pBirthday, pBirthPlace, pGender, pDescription) 
	VALUES('Tim Robbins', 'Tim', 'Robbins', '1958-10-16', 'West Covina, California, USA','M'
        ,'Born in West Covina, California, but raised in New York City, Tim Robbins is the son of former The Highwaymen singer Gil Robbins and actress Mary Robbins (née Bledsoe). Robbins studied drama at UCLA, where he graduated with honors in 1981. That same year, he formed the Actors Gang theater group, an experimental ensemble that expressed radical political observations through the European avant-garde form of theater. He started film work in television movies in 1983, but hit the big time in 1988 with his portrayal of dimwitted fastball pitcher "Nuke" Laloosh in Boga takimi (1988). Tall with baby-faced looks, he has the ability to play naive and obtuse (Cadillac Man (1990) and The Hudsucker Proxy (1994)) or slick and shrewd (Oyuncular (1992) and Bob Roberts (1992)).'); 

INSERT INTO People(pTitle, pFirstName, pLastName, pBirthday, pBirthPlace, pGender, pDescription) 
		VALUES('Morgan Freeman', 'Morgan', 'Freeman', '1958-06-01', 'Memphis, Tennessee, USA' ,'M',
			'With an authoritative voice and calm demeanor, this ever popular American actor has grown into one of the most respected figures in modern US cinema. Morgan was born on June 1, 1937 in Memphis, Tennessee, to Mayme Edna (Revere), a teacher, and Morgan Porterfield Freeman, a barber. The young Freeman attended Los Angeles City College before serving several years in the US Air Force as a mechanic between 1955 and 1959. His first dramatic arts exposure was on the stage including appearing in an all-African American production of the exuberant musical Hello, Dolly!.');
        
INSERT INTO People(pTitle, pFirstName, pLastName, pBirthday, pBirthPlace, pGender, pDescription) 
		VALUES('Frank Darabont', 'Frank', 'Darabont', '1959-01-28', 'Montbéliard, Doubs, France' ,'M',
			'Three-time Oscar nominee Frank Darabont was born in a refugee camp in 1959 in Montbeliard, France, the son of Hungarian parents who had fled Budapest during the failed 1956 Hungarian revolution. Brought to America as an infant, he settled with his family in Los Angeles and attended Hollywood High School. His first job in movies was as a production assistant on the 1981 low-budget film, Hell Night (1981), starring Linda Blair. He spent the next six years working in the art department as a set dresser and in set construction while struggling to establish himself as a writer.');

INSERT INTO People(pTitle, pFirstName, pLastName, pBirthday, pBirthPlace, pGender, pDescription) 
		VALUES('Stephen King', 'Stephen', 'King', '1947,09,21', 'Portland, Maine, USA' ,'M',
			'Stephen Edwin King was born on September 21, 1947, at the Maine General Hospital in Portland. His parents were Nellie Ruth (Pillsbury), who worked as a caregiver at a mental institute, and Donald Edwin King, a merchant seaman. His father was born under the surname "Pollock", but used the last name "King", under which Stephen was born. He has an older brother, David. The Kings were a typical family until one night, when Donald said he was stepping out for cigarettes and was never heard from again. Ruth took over raising the family with help from relatives. They traveled throughout many states over several years, finally moving back to Durham, Maine, in 1958.');

INSERT INTO MoviePeople(fkMovieId,fkPeopleId,castName,actorFlag) values(1,1,'Andy Dufresne','Y');
INSERT INTO MoviePeople(fkMovieId,fkPeopleId,castName,actorFlag) values(1,2,'Ellis Boyd \'Red\' Redding','Y');
INSERT INTO MoviePeople(fkMovieId,fkPeopleId,directorFlag) values(1,3,'Y');
INSERT INTO MoviePeople(fkMovieId,fkPeopleId,writerFlag) values(1,4,'Y');

INSERT INTO Genre values ('Crime',1);
INSERT INTO Genre values ('Drama',1);


INSERT INTO Movie(mTitle,mYear,mCountry,mTime,mLanguage,mRating,mRatingCount,mDescription,mUrlLink)
	VALUES('The Godfather', '1972-03-24', 'United States', '175', 'English,Italian,Latin', '9.2', 1186027,
		'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.',
			'https://www.youtube.com/embed/sY1S34973zA');

INSERT INTO People(pTitle, pFirstName, pLastName, pBirthday, pBirthPlace, pGender, pDescription) 
	VALUES('Marlon Brando', 'Marlon', 'Brando', '1924-04-03', 'Los Angeles, California, USA','M',
		'Marlon Brando is widely considered the greatest movie actor of all time, rivaled only by the more theatrically oriented Laurence Olivier in terms of esteem. Unlike Olivier, who preferred the stage to the screen, Brando concentrated his talents on movies after bidding the Broadway stage adieu in 1949, a decision for which he was severely criticized when his star began to dim in the 1960s and he was excoriated for squandering his talents. No actor ever exerted such a profound influence on succeeding generations of actors as did Brando.');

INSERT INTO People(pTitle, pFirstName, pLastName, pBirthday, pBirthPlace, pGender, pDescription) 
	VALUES('Al Pacino', 'Al', 'Pacino', '1940-04-25', 'Manhattan, New York, USA','M',
		'One of the greatest actors in all of film history, Al Pacino established himself during one of film\'s greatest decades, the 1970s, and has become an enduring and iconic figure in the world of American movies.');

INSERT INTO People(pTitle, pFirstName, pLastName, pBirthday, pBirthPlace, pGender, pDescription) 
	VALUES('Francis Ford Coppola', 'Francis Ford', 'Coppola', '1939-04-07', 'Detroit, Michigan, USA','M',
		'Francis Ford Coppola was born in 1939 in Detroit, Michigan, but grew up in a New York suburb in a creative, supportive Italian-American family. His father, Carmine Coppola, was a composer and musician. His mother, Italia Coppola (née Pennino), had been an actress. Francis Ford Coppola graduated with a degree in drama from Hofstra University, and did graduate work at UCLA in filmmaking. He was training as assistant with filmmaker Roger Corman, working in such capacities as sound-man, dialogue director, associate producer and, eventually, director of Dementia 13 (1963), Coppola\'s first feature film.');
            
INSERT INTO MoviePeople(fkMovieId,fkPeopleId,castName,actorFlag) values(2,5,'Don Vito Corleone','Y');
INSERT INTO MoviePeople(fkMovieId,fkPeopleId,castName,actorFlag) values(2,6,'Michael Corleone','Y');   
INSERT INTO MoviePeople(fkMovieId,fkPeopleId,directorFlag) values(2,7,'Y');         
            
INSERT INTO Genre values ('Crime',2);
INSERT INTO Genre values ('Drama',2);
            
            